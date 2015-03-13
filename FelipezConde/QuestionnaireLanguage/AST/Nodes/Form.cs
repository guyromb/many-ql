﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Interfaces;
using AST.Representation;


namespace AST.Nodes
{
    public class Form : ASTNode, IFormObjectContainer
    {
        private List<IFormObject> body;

        public Form(List<IFormObject> body, PositionInText position)
            : base(position)
        {
            this.body = body;
        }
        
        public IList<IFormObject> GetBody() { return body; }

        //Visitor Methods
        public void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


    }

}
