package uva.ql.interpreter.typecheck.error;

public interface IssueType {
	 
	public enum ERROR{
		REFERENCE_UNDEFINED,
		DUPLICATE_SAME_TYPE,
		DUPLICATE_DIFFERENT_TYPE,
		CONDITION_NOT_BOOLEAN,
		INVALID_OPERANDS,
		INVALID_OPERANDS_LOGICAL,
		INVALID_OPERANDS_MATH,
		CYCLIC_DEPENDANCIES;
	}
	
	public enum WARNING {
		DUPLICATE_QUESTION_LABEL;
	}
	
}
