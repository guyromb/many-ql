﻿using AST.Nodes.FormObjects;
using System.Windows;
using Evaluation.Values;
using Evaluation;
using System.Windows.Controls;
using QLGui.ASTVisitors;
using QLGui.ValueVisitors;

namespace QLGui.FormObjects
{
    public class QuestionObject : FormObject
    {
        private Question questionNode;
        private SymbolTable symbolTable;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            symbolTable = new SymbolTable();
        }
        #endregion

        #region IFormObject
        public override UIElement ProcessFormObject(UIElement form)
        {
            Label questionLabel = new Label() { Content = questionNode.Label.Value };
            AddChild(questionLabel, form);

            Value widgetValue = Evaluate();
            
            ValueToUIElement valueToUIElement = new ValueToUIElement(questionNode.Identifier.Name, questionNode.Computation != null);
            valueToUIElement.EventUpdateValue += UpdateValue;

            AddChild(widgetValue.Accept(valueToUIElement), form);

            return form;
        }

        public Value Evaluate()
        {
            Value result;

            if (questionNode.Computation != null)
            {
                result = new Evaluator(symbolTable).Evaluate(questionNode.Computation);
            }
            else
            {
                result = symbolTable.GetValue(questionNode.Identifier);
            }

            return result;
        }

        #endregion

        private void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }

        public override SymbolTable Register(SymbolTable symbolTable)
        {
            TypeToValue visitor = new TypeToValue();
            symbolTable.AddValue(questionNode.Identifier, questionNode.RetrieveType().Accept(new TypeToValue()));

            this.symbolTable = symbolTable;
            
            return symbolTable;
        }
    }
}