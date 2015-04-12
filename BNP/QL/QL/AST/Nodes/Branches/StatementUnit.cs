﻿using System.ComponentModel;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.AST.Nodes.Branches
{
    public class StatementUnit : UnitBase
    {
        private object _value;
        public Expression Expression;

        public StatementUnit(Identifier identifier, Expression expression, string unitText, IStaticReturnType dataType, SourceLocation sourceLocation)
            : base(identifier, dataType, unitText, sourceLocation)
        {
            Expression = expression;
        }

        public override object Value
        {
            get { return _value; }
            set
            {
                if (Equals(value, _value)) return;
                _value = value;
                OnPropertyChanged();
            }
        }
    }
}
