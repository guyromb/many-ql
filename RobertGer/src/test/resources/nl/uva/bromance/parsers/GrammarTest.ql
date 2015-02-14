Name: "Tax" {
    Form: "default" {
        Question: "partner" {
			Text: "What is your marital status?"
			Answer: ["Single" || "Married" || "Cohabitation"]
        }
        Question: "age" {
            Text: "How old are you?"
            Answer: Integer
            Range: 0 - 150
        }
    }
    Form: "withConditional" {
    	Question: "income1" {
    		Text: "How much money did you earn through employer paid wages during 2014?"
    		Answer: Double
    		Range: >0
    	}
    	If: generic.partner == "Married" || generic.partner == "Cohabitation" && (iets == iets || iets >= iets ) {
        	Question: "income_partner" {
        		Text: "How much money did your partner earn through employer paid wages during 2014?"
        		Answer: double
        		Range: >0
        	}
        }
    }

        Form: "withCalculation" {
        	Question: "income1" {
        		Text: "How much money did you earn through employer paid wages during 2014?"
        		Answer: Double
        		Range: >0
        	}
            Calculation: "ttl_income_tax" {
                		If: generic.partner == "Married" || "Cohabitation" {
                			Input: (income_1 + income_partner) * 0.43
                		} Else: {
                			Input: income_1 * 0.43
                		}
                	}
        }

        Form: "withConditionalAndCalculation" {
        	Question: "income1" {
        		Text: "How much money did you earn through employer paid wages during 2014?"
        		Answer: Double
        		Range: >0
        	}
        	If: generic.partner == "Married" || generic.partner == "Cohabitation" && (iets == iets || iets >= iets ) {
            	Question: "income_partner" {
            		Text: "How much money did your partner earn through employer paid wages during 2014?"
            		Answer: double
            		Range: >0
            	}
            }
            Calculation: "ttl_income_tax" {
                		If: generic.partner == "Married" || "Cohabitation" {
                			Input: (income_1 + income_partner) * 0.43
                		} Else: {
                			Input: income_1 * 0.43
                		}
                	}
        }

           Form: "withIfElse" {
                Calculation: "ttl_taxes" {
                	// Deductables and prepaid tax aren't in this form yet, but you get the gist.
                	Input: income_work.total - deductables.total - prepaid.total
                }
                Label: "ttl_taxes" {
                	If: ttl_taxes > 0 {
                		Text: [ttl_taxes] euro in taxes are due, you will receive payment information through the regular mail.
                	} Else If: ttl_taxes < 0 {
                		Text: You will recieve [ttl_taxes] euro in return from the Tax Administration within two months.
                	} Else: {
                		Text: You have paid exactly the right amount of taxes in 2013, no actions remain.
                	}
                }
            }
}