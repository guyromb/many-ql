﻿using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class AndOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>, ITypeResolvableDirectly
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}