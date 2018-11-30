package melon;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Login2 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	public Login2 () {
		
		setSize(535, 410);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(306, 210, 126, 59);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setBounds(165, 279, 116, 23);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uCEA1\uCCD0\\025.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(106, 71, 133, 68);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 210, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 248, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uC815\uBCF4\uCC3E\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(306, 279, 126, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(96, 213, 57, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setBounds(96, 251, 57, 15);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uCEA1\uCCD0\\028.jpg"));
		lblNewLabel_1.setBounds(234, 72, 167, 67);
		getContentPane().add(lblNewLabel_1);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		Login2 log = new Login2();
	}
}
