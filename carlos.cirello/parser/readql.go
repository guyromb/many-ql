//go:generate -command yacc go tool yacc
//go:generate yacc -o parser.go -p "ql" parser.y

// Package parser uses native Go's yacc to parse the QL source code.
// Internally, it uses a customized lexer to walk throughout the tokens
// of the source code.
package parser

import (
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
)

// ReadQL generates a AST (*ast.Questionaire and children) out of source code.
func ReadQL(stream io.Reader, fn string) *ast.QuestionaireNode {
	finalQuestionaire = nil
	qlParse(newLexer(stream, fn))
	return finalQuestionaire
}
