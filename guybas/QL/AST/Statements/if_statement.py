# AST for if_block
import QL.AST.Statements.statement as statement
import QL.AST.Expressions.Operations.not_op as not_operation
import QL.Grammar.constants as constants


class IfBlock(statement.IStatement):

    #
    # override methods of statement
    #

    # init
    def __init__(self, condition, statements):
        # not private as they are needed in IfElseBlock
        self.condition = condition
        self.statements = statements

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "If " + self.condition.string_presentation(0)
        for x in self.statements:
            s += "   " * level + x.string_presentation(level + 1)
        return s

    # return all ids in the statement
    def id_collection(self):
        ids = []
        for x in self.statements:
            ids += x.id_collection()
        return ids

    # return all labels in the statement
    def label_collection(self):
        labels = []
        for x in self.statements:
            labels += x.label_collection()
        return labels

    # if blocks are conditionals
    def is_conditional(self):
        return True

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        ids = self.id_collection()
        new_dep = self.condition.get_variables()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + new_dep
            else:
                dependencies[i] = new_dep
        for x in self.statements:
            dependencies = dict(list(dependencies.items()) + list(x.get_dependency_collection(dependencies).items()))
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        d = {}
        for s in self.statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        d = {}
        for s in self.statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    def valid_expression_message(self, td):
        message = []
        message.extend(self.condition.is_valid_expression_message(td))
        for x in self.statements:
            message.extend(x.valid_expression_message(td))

        if not self.condition.return_type_string(td) == constants.BOOL:
            message.append("the return type of the expression: " + self.condition.string_presentation() + " is not of type bool")
        return message

    #
    # Getters of the if statement
    #

    # get normal statements (if and else version)
    def get_c_statements(self):
        return self.statements

    def get_e_statements(self):
        return []  # empty as if statement has no else statements

    def get_condition(self):
        return self.condition

    def get_inverted_condition(self):
        return not_operation.Not(self.condition)

