package net.tfobz;
import java.awt.*;
import javax.swing.*;

/**
 * Testprogramm, welches ein GUI-Fenster genau in der Mitte positioniert ist
 * @author Michael Morandell
 *
 */
public class Testprogramm extends JFrame{
	
	/**
	 * Main
	 * Instanziiert ein GUI-Fenster
	 * @param args
	 */
	public static void main(String[] args) {
		Testprogramm t = new Testprogramm();
		//sichtbar machen
		t.setVisible(true);
	}
	
	/**
	 * Testprogramm-GUI-Konstruktor
	 */
	public Testprogramm() {
		//defaultCloseOperation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//höhe und breite des Bildschirms
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		//Bounds werden gesetzt
		this.setBounds((width/2)-300, (height/2)-300, 600, 600);
		this.setTitle("Testprogramm");
	}

}
