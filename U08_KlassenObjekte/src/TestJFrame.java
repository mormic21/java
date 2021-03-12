import javax.swing.JFrame;

public class TestJFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Erste GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(420, 420);
		frame.setVisible(true);

	}

}
