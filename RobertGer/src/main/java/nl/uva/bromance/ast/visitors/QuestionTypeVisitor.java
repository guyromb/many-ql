package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.questiontypes.BooleanType;
import nl.uva.bromance.ast.questiontypes.CustomType;
import nl.uva.bromance.ast.questiontypes.IntegerType;
import nl.uva.bromance.ast.questiontypes.StringType;

public interface QuestionTypeVisitor {

    void visit(BooleanType booleanType);

    void visit(StringType stringType);

    void visit(IntegerType integerType);

    void visit(CustomType customType);
}
