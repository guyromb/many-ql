form SalarySurvey{
	name: "What is your name?" Str
	age: "How old are you?" Int
	isMarried: "Are you married?" Bool	
	if(isMarried){
		employeeNr1: "What is your employee number?" Int
		if(age < 25){
			employeeNr1: "What is your employee number?" Int
		}
	}
	age: "How old are you?" Int
	isMarried: "Are you married?" Bool	
		
}
