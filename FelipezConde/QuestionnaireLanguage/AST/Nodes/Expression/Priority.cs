﻿using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Expression
{
    public class Priority : IExpressionNode
    {
        private IList<IASTNode> children;

        public Priority()
        {
            children = new List<IASTNode>();
        }

        public void AddChild(IASTNode node)
        {
            children.Add(node);
        }

        public IList<IASTNode> GetChildren()
        {
            return children;
        }
    }
}