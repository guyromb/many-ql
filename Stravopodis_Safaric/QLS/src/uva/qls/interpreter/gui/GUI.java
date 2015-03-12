package uva.qls.interpreter.gui;

import uva.qls.ast.ASTNode;
import uva.qls.ast.Prog;
import uva.qls.interpreter.gui.table.DefaultTable;
import uva.qls.interpreter.gui.table.QuestionValueTable;
import uva.qls.interpreter.gui.visitor.QuestionValueVisitor;
import uva.qls.interpreter.typecheck.TypeCheckQLS;

public class GUI {

	private TypeCheckQLS typeCheck;
	private QuestionValueVisitor visitor;
	public DefaultTable table;
	private QuestionValueTable questionValueTable;
	
	public GUI(ASTNode _ast){
		this.questionValueTable = new QuestionValueTable();
		this.table = new DefaultTable();
		
		this.typeCheck = new TypeCheckQLS(_ast);
		this.visitor = new QuestionValueVisitor(this);
		this.visitor.visitProg((Prog)_ast);
	}
	
	public QuestionValueTable getQuestionValueTable(){
		return this.questionValueTable;
	}
	
	public DefaultTable getTable(){
		return this.table;
	}
	
	public TypeCheckQLS getTypeCheck(){
		return this.typeCheck;
	}
}
