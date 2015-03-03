package uva.qls.ast.statements;

import uva.qls.ast.CodeLines;
import uva.qls.ast.component.Component;
import uva.qls.ast.literal.Identifier;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class Question extends Statement {

	private Identifier identifier;
	private Component component;
	
	public Question (Identifier _identifier, Component _component, CodeLines _codeLines){
		super(_codeLines);
		this.component=_component;
		this.identifier=_identifier;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public Component getComponent(){
		return this.component;
	}
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}
	@Override
	public String toString(){
		return "Question(" + this.identifier.toString() + "," + component.toString() + ")";
	}

	@Override
	public GenericValue<?> evaluate() {
	return null;
	}
	
}
