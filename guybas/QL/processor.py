from pyparsing import *
import collections


class Processor:
    def conditions_proc(self, expression):
        """
        This function will convert the expression identifiers into
        parameters and will check whether the expression is True or False
        :param str condition: the if expression
        :return: bool
        """
        # bind ids to values
        print(expression)
        # simplified_c = expression.replace()

        # process the expression, and return true/false
        result = eval(simplified_c)
        if result:
            return True
        return False

    def rlist2string(self, a):
        res = ''
        if isinstance(a, list):
            for item in a:
                res += str(self.rlist2string(item)) + ' '
        else:
            res = str(a)
        return res