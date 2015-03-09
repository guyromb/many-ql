from . import Checker, Message
from .Identifier import typeOfIdentifier
from .Cast import effectiveTypes

from .. import TypeRules, CustomTypes

from ..ast import Nodes


class Checker(Checker.FullChecker):
    def __init__(self, ast):
        super().__init__(ast)
        self._operatorTable = TypeRules.OperatorTable()

        # Type of the last checked expression or None if it could
        # not be determined (which means there was a type error).
        self._typeOfLastExpression = None

    def _visitIfStatement(self, node):
        self.visit(node.expr)

        if self._typeOfLastExpression is not None:
            self._allowExpression(
                [bool],
                self._typeOfLastExpression,
                node.expr
            )

        for n in node.getChildren():
            self.visit(n)

    def _visitQuestionStatement(self, node):
        if node.expr is not None:
            self.visit(node.expr)

            if self._typeOfLastExpression is not None:
                self._allowExpression(
                    [typeOfIdentifier(node.identifier, node)],
                    self._typeOfLastExpression,
                    node.expr
                ) 
        
    def _visitIdentifier(self, node):
        self._typeOfLastExpression = typeOfIdentifier(
            node,
            self._ast.root
        )

        if self._typeOfLastExpression is None:
            self._result = self._result.withMessage(
                Message.Error(
                    'undeclared identifier '+node,
                    node
                )
            )
        
    def _visitStr(self, node):
        self._typeOfLastExpression = str

    def _visitInt(self, node):
        self._typeOfLastExpression = int

    def _visitMoney(self, node):
        self._typeOfLastExpression = CustomTypes.Money

    def _visitBool(self, node):
        self._typeOfLastExpression = bool

    def _visitUnaryExpression(self, node):
        self.visit(node.right)

        if self._typeOfLastExpression is None:
            return

        self._typeOfLastExpression = \
            self._operatorTable.unaryOperationType(
                node.op,
                self._typeOfLastExpression
            )

        if self._typeOfLastExpression is None:
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to unary operator `'+node.op\
                   +'`: '+str(node.right),
                   node
                )
            )

    def _visitBinaryExpression(self, node):
        self.visit(node.left)
        if self._typeOfLastExpression is None:
            return

        leftType = self._typeOfLastExpression

        self.visit(node.right)
        if self._typeOfLastExpression is None:
            return

        rightType = self._typeOfLastExpression

        self._typeOfLastExpression = \
            self._operatorTable.binaryOperationType(
                node.op,
                leftType,
                rightType
            )

        if self._typeOfLastExpression is None: 
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to binary operator `'+node.op\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )


    def _allowExpression(self, allowedTypes, exprType, node):
        allowedEffectiveTypeExists = any(map(
            lambda t: t in allowedTypes,
            effectiveTypes(exprType)
        ))
        if not allowedEffectiveTypeExists:
            self._result = self._result.withMessage(
                Message.Error(
                    'got an expression of type `'+str(exprType)\
                   +'` which is not castable to any of the '\
                   +'following types which are allowed here '\
                   +'here: '+str(allowedTypes),
                   node
                )
            )