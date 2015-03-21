package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Identifier;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.operators.Operator;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.Optional;

public class Expression extends QLNode {
    private String text;
    private Optional<Operator> operator = Optional.empty();
    private Optional<Terminal> terminal = Optional.empty();
    private Result result;
    private Optional<Expression> leftHandSide = Optional.empty();
    private Optional<Expression> rightHandSide = Optional.empty();

    public Expression(int lineNumber, Optional<Token> operatorToken) {
        super(lineNumber, Expression.class);
        if (operatorToken.isPresent()) {
            for (Operator operatorType : Operator.operatorTypes) {
                if (operatorType.getOperatorString().equals(operatorToken.get().getText())) {
                    operator = Optional.of(operatorType.getNewOperatorOfThisType());
                }
            }
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Expression] " + text + " \n");
        for (QLNode n : getChildren()) {
            n.printDebug(i + 1);
        }
    }

    public void setText(String t) {
        this.text = t;
    }

    public Optional<Terminal> getTerminal() {
        return terminal;
    }

    public Optional<Operator> getOperator() {
        return operator;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = Optional.of(terminal);
    }


    //TODO: Create something that makes it obvious that this is postorder traversal
    @Override
    public void accept(NodeVisitor visitor) {
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
        visitor.visit(this);
    }

    public Optional<Expression> getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Optional<Expression> leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public void setRightHandSide(Optional<Expression>rightHandSide) {
        this.rightHandSide = rightHandSide;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return this.result;
    }

    public Result getLeftHandSideResult() {
        if(leftHandSide.isPresent()) {
            return leftHandSide.get().getResult();
        }
        else
        {return null;}

    }
    public Result getRightHandSideResult() {
        if(rightHandSide.isPresent()) {
            return rightHandSide.get().getResult();
        }
        else
        {return null;}

    }
}