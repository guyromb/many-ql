﻿using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class MinusOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>, ITypeResolvableByChildren
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }
      
    }
}