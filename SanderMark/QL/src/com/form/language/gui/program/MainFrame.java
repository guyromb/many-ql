package com.form.language.gui.program;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.form.Form;
import com.form.language.memory.Context;

public class MainFrame {	
	private static final int frameWeight = 500;
	private static final int frameHeight = 500;

	private static final int textFieldWeight = 460;
	private static final int textFieldHeight = 100;

	private static final int buttonWeight = 100;
	private static final int buttonHeight = 25;

	private JFrame frame;
	private JTextArea textArea_input;
	private JTextArea textArea_output;
	private JButton button_parse;
	private JButton button_createQuestionnaire;
	private Form form;

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		final Context context = new Context();
		createFrame();		
		createTextFields();
		createButtonParse(context);
		createButtonQuestionnaire(context);
	}

	private void createButtonQuestionnaire(final Context context) {
		button_createQuestionnaire = new JButton("Create Questionnaire");
		button_createQuestionnaire.setEnabled(false);
		button_createQuestionnaire.setBounds(216, 120, buttonWeight, buttonHeight);
		frame.getContentPane().add(button_createQuestionnaire);				
		button_createQuestionnaire.addMouseListener(buttonClickCreateQuestionnaire(context));
	}

	private MouseAdapter buttonClickCreateQuestionnaire(final Context context) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.initMemory(context);
				new QuestionnaireFrame(form, context);
			}
		};
	}

	private void createButtonParse(final Context context) {
		button_parse = new JButton("Parse");
		button_parse.setBounds(335, 120, buttonWeight, buttonHeight);
		frame.getContentPane().add(button_parse);		
		button_parse.addMouseListener(buttonClickParse(context));
	}

	private MouseAdapter buttonClickParse(final Context context) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CharStream charStream = new ANTLRInputStream(textArea_input.getText());
				GrammarLexer lexer = new GrammarLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				GrammarParser parser = new GrammarParser(tokenStream);

				form = parser.form().result;

				form.getTypes(context);

				if (context.hasErrors()) {
					textArea_output.setText(context.getErrors());
					System.out.println(context.getErrors());
				} else {
					button_createQuestionnaire.setEnabled(true);
				}
			}
		};
	}

	private void createTextFields() {
		textArea_input = new JTextArea();
		textArea_input.setBounds(10, 11, textFieldWeight, textFieldHeight);
		frame.getContentPane().add(textArea_input);

		textArea_output = new JTextArea();
		textArea_output.setBounds(10, 154, textFieldWeight, textFieldHeight);
		frame.getContentPane().add(textArea_output);
	}

	private void createFrame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(frameWeight, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
