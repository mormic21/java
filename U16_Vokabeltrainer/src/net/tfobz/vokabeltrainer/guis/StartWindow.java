package net.tfobz.vokabeltrainer.guis;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Creates the Starting-Window
 * @author Michael Morandell
 *
 */
public class StartWindow extends JWindow {

	public static Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * StartWindow-Konstrukor erstellt das Start-Fenster
	 */
	public StartWindow() {
		// Neues Fenster
		JWindow window = new JWindow();
		// Layoutmanager null
		window.getContentPane().setLayout(null);
		// Groeﬂe setzen
		int height = 550;
		int width = 800;
		window.setBounds((screen_size.width - width) / 2, (screen_size.height - height) / 2, width, height);

		// ImageComponent zum Anzeigen des Bildes
		ImageComponent imgcomponent = new ImageComponent();
		imgcomponent.setBounds(0, 0, window.getWidth(), window.getHeight() - 60);
		try {
			imgcomponent.setImage("C:\\Users\\Michael Morandell\\Documents\\Schule\\Eclipse\\Info\\Work"
					+ "\\U16_Vokabeltrainer\\src\\net\\tfobz\\vokabeltrainer\\guis\\Vokabeln-lernen-TITEL.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// add picture to window
		window.add(imgcomponent);

		// new Button
		JButton button = new JButton();
		// set Button size
		button.setBounds((window.getWidth() - 300) / 2, window.getHeight() - 50, 300, 40);
		// Ecken mit Radius 15 abrunden
		button.setBorder(new Border() {
			private int r = 20;
			@Override
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				g.drawRoundRect(x, y, width - 1, height - 1, r, r);

			}
			@Override
			public Insets getBorderInsets(Component c) {
				return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
			}
			@Override
			public boolean isBorderOpaque() {
				return true;
			}
		});
		// text + font
		button.setText("Vokabeltrainer starten!");
		button.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
		// Farben
		button.setBackground(new Color(200, 212, 250));
		button.setForeground(Color.BLACK);
		// add actionListener
		button.addActionListener(new ActionListener() {
			/**
			 * Startet das Main-Fenster
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI mg = new MainGUI();
				mg.setVisible(true);
				// abschalten des StartFensters
				window.setVisible(false);
			}
		});
		// button wird hinzugefuegt
		window.getContentPane().add(button);
		// sichtbar machen
		window.setVisible(true);
	}
}
