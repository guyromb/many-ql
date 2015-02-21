/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/draw"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/execute"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *event.Frontend
	receive      chan *event.Frontend
	execute      *visitor.Visitor
	draw         *visitor.Visitor
	symbols      *symboltable.SymbolTable
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *event.Frontend, chan *event.Frontend) {
	toFrontend := make(chan *event.Frontend)
	fromFrontend := make(chan *event.Frontend)
	symbolChan := make(chan *event.Symbol)
	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		execute:      execute.New(toFrontend, symbolChan),
		draw:         draw.New(toFrontend),
		symbols:      symboltable.New(symbolChan),
	}
	go v.loop()
	return toFrontend, fromFrontend
}

func (v *interpreter) loop() {
	v.send <- &event.Frontend{
		Type: event.ReadyP,
	}
walkLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case event.ReadyT:
				v.draw.Visit(v.questionaire)
				v.send <- &event.Frontend{Type: event.Flush}
				break walkLoop
			}
		}
	}

	ticker := time.Tick(100 * time.Millisecond)
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case event.Answers:
				for identifier, answer := range r.Answers {
					v.execute.Visit(v.questionaire)
					v.send <- &event.Frontend{Type: event.Flush}
					ret := make(chan *ast.QuestionNode)
					v.symbols.Events <- &event.Symbol{
						Command: event.SymbolRead,
						Name:    identifier,
						Ret:     ret,
					}

					q := <-ret
					q.Content().From(answer)
					v.symbols.Events <- &event.Symbol{
						Command: event.SymbolUpdate,
						Name:    q.Identifier(),
						Content: q,
					}
				}
				fallthrough

			case event.ReadyT:
				v.execute.Visit(v.questionaire)
				v.send <- &event.Frontend{Type: event.Flush}
			}

		case <-ticker:
			v.send <- &event.Frontend{Type: event.FetchAnswers}
		}
	}

}