package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseIfThenBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ElseIfThenBlockView;

public class ElseIfThenBlockViewController extends FormElementViewController 
{
	private ElseIfThenBlockView elseIfThenBlockView;
	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super(elseIfThenBlock);
		
		elseIfThenBlockView = new ElseIfThenBlockView(this);
		
		setView(elseIfThenBlockView);
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

}
