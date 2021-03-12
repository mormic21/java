import javax.swing.JFrame;

public class testclass {

	public static void main(String[] args) {
		HelloFenster j = new HelloFenster();
		j.setTitle("Hello");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setResizable(false);
		j.setVisible(true);
	}

}
