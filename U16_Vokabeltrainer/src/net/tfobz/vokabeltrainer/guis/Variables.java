package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Variables
 * stellt eine Reihe von Variablen zur verf�gung, um diese f�r
 * Schriftarten, Farben, Borders und Mausabh�rer zu nutzen.
 * 
 * @author Michael Morandell - Elija Innerkofler
 * @version 1.2 - BOLD_FONT hinzugef�gt
 *
 */
public class Variables {

	// Der Font f�r die Titel
	public static final Font TITLE_FONT = new Font("Sans Serif", Font.BOLD, 25);

	// Der Font f�r die Untertitel
	public static final Font SUBTITLE_FONT = new Font("Sans Serif", Font.BOLD, 18);

	// Der standart Font
	public static final Font DEFAULT_FONT = new Font("Sans Serif", Font.PLAIN, 17);

	// Der fette Font
	public static final Font BOLD_FONT = new Font("Sans Serif", Font.BOLD, 16);
	
	// Der Font f�r das Men�
	public static final Font MENU_FONT = new Font("Sans Serif", Font.BOLD, 15);
	
	// Die standard Farbe f�r Kn�pfe
	public static final Color DEFAULT_COLOR = new Color(210, 210, 210);

	// Die Farbe f�r Kn�pfe, falls die Maus auf ihnen ist
	public static final Color ENTERED_COLOR = new Color(220, 220, 220);

	/*
	 * Die Border f�r Kn�pfe mit einer Abgerundeten Kante. Der Radius ist
	 * standartm��ig auf 11 gesetzt
	 */
	public static final RoundedBorder ROUNDED_BORDER = new RoundedBorder(11);

	// Die Border f�r Textfelder
	public static final LineBorder TEXTFIELD_BORDER = new LineBorder(Color.GRAY, 1);

	// Mouseabh�rer
	public static final MeinMouseHoverAbhoerer MOUSEABHOERER = new MeinMouseHoverAbhoerer();

	/*
	 * Methode die Border implementiert um Kn�pfe mit abgerundeten Kanten zu
	 * erstellen
	 */
	private static class RoundedBorder implements Border {

		private int radius;

		public RoundedBorder(int radius) {
			this.radius = radius;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
		}
	}

	/**
	 * Ermittelt den Knopf der die Klasse aufgerufen hat und setzt den Hintergrund
	 * des Knopfes auf eine andere Farbe
	 */
	private static class MeinMouseHoverAbhoerer extends MouseAdapter {

		public void mouseEntered(MouseEvent evt) {
			evt.getComponent().setBackground(ENTERED_COLOR);
		}

		public void mouseExited(MouseEvent evt) {
			evt.getComponent().setBackground(DEFAULT_COLOR);
		}

	}

}
