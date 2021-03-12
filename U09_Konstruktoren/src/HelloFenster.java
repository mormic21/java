import java.awt.*;
import javax.swing.*;

public class HelloFenster extends JFrame {
	private JTextField textField1;

	public HelloFenster() {
		setLayout(null);
		setSize(450, 300);
		setFont(new Font("Dialog", Font.BOLD, 20));
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setText("Hello World");
		textField1.setBounds(48, 24, 193, 49);
		textField1.setForeground(new Color(255));
		textField1.setBackground(new Color(12632256));
		add(textField1);
	}

}
