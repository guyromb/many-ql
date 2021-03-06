package nl.uva.se.ql.gui.validators;

import nl.uva.se.ql.evaluation.value.Value;

public class IntegerValidator extends Validator<String>{
	
	@Override
	public boolean isValid(String input) {
		if (input.matches("-?\\d+?")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid(Value value) {		
		if(value.getValue().getClass() == Integer.class){
			return true;
		}
		return false;
	}	
}
