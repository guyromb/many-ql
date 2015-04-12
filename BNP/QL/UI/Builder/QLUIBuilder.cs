﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.AST;
using QL.AST.Nodes.Terminals;
using QL.UI.Collections;
using QL.UI.Controls;

namespace QL.UI.Builder
{
    public class QLUIBuilder : QLBuilder
    {
        public ObservableCollection<WidgetBase> ElementsToDisplay { get; protected set; } // used to be an observable collection
        
        public QLUIBuilder(string input) : base(input)
        {
            ElementsToDisplay = new ObservableCollection<WidgetBase>();
        }

        public QLUIBuilder(Stream input) : base(input)
        {
            ElementsToDisplay = new ObservableCollection<WidgetBase>();
        }

        public void RegisterGenericAndUIDataHandlers()
        {
            RegisterGenericDataHandlers();
            RegisterRenderer(new Renderer(ElementsToDisplay));       
        }
    }
}
