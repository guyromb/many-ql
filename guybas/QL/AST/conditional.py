# AST for if_block
from AST.statement import *


class IfBlock(IStatement):

    # Override
    def __init__(self, condition, statements):
        self.condition = condition
        self.statements = statements

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self.condition.pretty_print(0) + ")"
        for x in self.statements:
            s += "   " * level + x.pretty_print(level + 1)
        return s

    # Override
    def id_collection(self):
        ids = []
        for x in self.statements:
            ids += x.id_collection()
        return ids

    # Override
    def label_collection(self):
        labels = []
        for x in self.statements:
            labels += x.label_collection()
        return labels

    # Override
    def is_conditional(self):
        return True

    # Override
    def dependency_collection(self, dependencies): # TODO : change inefficiency
        ids = self.id_collection()
        for i in ids:
            if i in dependencies:
                dependencies[i] = dependencies[i] + self.condition.check()
            else:
                dependencies[i] = self.condition.check()
        for x in self.statements:
            dependencies = dict(list(dependencies.items()) + list(x.dependency_collection(dependencies).items()))
        return dependencies

    # Getters
    def get_c_statements(self):
        return self.statements

    def get_id(self):
        return None

    def get_condition(self):
        return self.condition.as_list()

    def get_e_statements(self):
        return []

    def set_parent_id(self, pid):
        self.parent_id = pid


class IfElseBlock(IfBlock):

    # Override
    def __init__(self, condition, statements, else_statements):
        self.condition = condition
        self.statements = statements
        self.else_statements = else_statements

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "If (" + self.condition.pretty_print(0) + ")"
        for x in self.statements:
            s += "   " * level + x.pretty_print(level+1)

        s += "   " * level + "else"
        for x in self.else_statements:
            s += "   " * level + x.pretty_print(level+1)
        return s

    # Override
    def id_collection(self):
        ids = []
        for x in self.statements:
            ids += x.id_collection()
        for x in self.else_statements:
            ids += x.id_collection()
        return ids

    # Override
    def label_collection(self):
        labels = []
        for x in self.statements:
            labels += x.label_collection()
        for x in self.else_statements:
            labels += x.label_collection()
        return labels

    def get_e_statements(self):
        return self.else_statements




