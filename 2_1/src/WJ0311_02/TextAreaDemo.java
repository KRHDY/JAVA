package WJ0311_02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaDemo extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextArea textArea;
	
	public TextAreaDemo() {
		this.setTitle("Text Area Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField(30);
		textField.addActionListener(this);
		
		textArea	=	new JTextArea(10,30);
		textArea.setEditable(false);
		
		this.add(textField,BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextAreaDemo();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = textField.getText();
		textArea.append(text+"\n");
		
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

}
