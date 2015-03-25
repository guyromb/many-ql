# AST for if_block
import QL.AST.Statements.statement as statement
import QL.AST.Expressions.Operations.Logical.not_op as not_operation
import QL.AST.Expressions.Types.bool_type as bool_type

class IfBlock(statement.IStatement):

    #
    # override methods of statement
    #

    # init
    def __init__(self, condition, statements):
        # not private as they are needed in IfElseBlock
        self._condition = condition
        self._statements = statements

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "If %s" % str(self._condition)
        for x in self._statements:
            s += "   " * level + x.string_presentation(level + 1)
        return s

    # return all ids in the statement
    def id_collection(self):
        ids = []
        for x in self._statements:
            ids.extend(x.id_collection())
        return ids

    # return all labels in the statement
    def label_collection(self):
        labels = []
        for x in self._statements:
            labels += x.label_collection()
        return labels

    # if blocks are conditionals
    def is_conditional(self):
        return True

    # return all the _dependencies in the statement of other _statements
    def dependency_collection(self, dependencies):
        ids = self.id_collection()
        new_dep = self._condition.get_variables()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + new_dep
            else:
                dependencies[i] = new_dep
        for x in self._statements:
            dependencies = dict(list(dependencies.items()) + list(x.dependency_collection(dependencies).items()))
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_id_type_collection().items()))
        return d

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        d = {}
        for s in self._statements:
            d = dict(list(d.items()) + list(s.get_statement_dict().items()))
        return d

    def valid_expression_messages(self, td):
        messages = []
        messages.extend(self._condition.is_valid_messages(td))
        for x in self._statements:
            messages.extend(x.valid_expression_messages(td))

        if not self._condition.return_type(td) == bool_type.Bool():
            messages.append("the return type of the expression: " + self._condition.__str__() + " is not of type bool")
        return messages

    #
    # Getters of the if statement
    #

    # get normal statements (if and else version)
    def get_if_statements(self):
        return self._statements

    def get_else_statements(self):
        # empty since an if statement has no else statements
        # needed so the caller doesn't have to know if it is an if or if-else statement
        return []

    def get_condition(self):
        return self._condition

    def get_inverted_condition(self):
        return not_operation.Not(self._condition)


