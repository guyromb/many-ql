package org.uva.ql.view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.component.ExprQuestionComponent;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;

public class FormFrame {

	private static final long serialVersionUID = 1L;
	private List<IfQuestionPanel> dependentQuestionPanels;
	private List<ExprQuestionComponent> dependentQuestionComponents;
	private final JFrame frame;

	public FormFrame() {
		frame = new JFrame("QL Form");
		frame.setSize(500, 800);
		frame.setLayout(new MigLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dependentQuestionPanels = new ArrayList<IfQuestionPanel>();
		this.dependentQuestionComponents = new ArrayList<ExprQuestionComponent>();
	}

	private void addWithConstraints(Component component) {
		frame.add(component, "wrap,push");
	}

	public void addQuestionPanel(Panel panel) {
		addWithConstraints(panel);
	}

	public void addIfQuestionPanel(IfQuestionPanel panel) {
		addWithConstraints(panel);
		dependentQuestionPanels.add(panel);
	}

	public void addExprQuestionPanel(ExprQuestionComponent panel) {
		addWithConstraints(panel);
		dependentQuestionComponents.add(panel);
	}

	public void addDoneButton(JButton button) {
		addWithConstraints(button);
	}

	public void notifyPanels(Evaluator evaluator) {
		for (ExprQuestionComponent exprQuestionComponent : dependentQuestionComponents) {
			exprQuestionComponent.evaluateAndChange(evaluator);
		}

		for (IfQuestionPanel ifQuestionPanel : dependentQuestionPanels) {
			ifQuestionPanel.evaluateAndShow(evaluator);
		}
	}
	
	public void setFrameVisible(boolean show){
		frame.setVisible(show);
	}
}
