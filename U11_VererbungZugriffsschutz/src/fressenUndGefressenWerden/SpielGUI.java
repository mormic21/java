package fressenUndGefressenWerden;
import javax.swing.*;					// Wegen JFrame
import java.awt.*;						// Wegen Container, Graphics, usw.
import java.awt.event.*;

public class SpielGUI extends JFrame {
	
	private final int ANZAHL_UNBEWEGLICHE_OBJEKTE = 12;
	private final int ANZAHL_GUTER_OBJEKTE = 5;
	private final int ANZAHL_BOESER_OBJEKTE = 3;
	private JTextField gewonnen_t = null;
	private JTextField punkte_t = null;
	private JTextField punkte_t2 = null;
	private JButton b = null;
	/**
	 * Konstruktor
	 */
	public SpielGUI() {
		super("Fressen und gefressen werden");
		setBounds(10,10,400,400);
		setResizable(false);
		
		// Oberfl�che des Fensters auf welcher die Objekte platziert werden sollen
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		setVisible(true);
		// Positioniert Objekte
		for (int i = 0; i < ANZAHL_UNBEWEGLICHE_OBJEKTE; i++) {
			Mauer m = new Mauer();
			contentPane.add(m);
			int x = 0;
			int y = 0;
			do {
				x = (int)(Math.random()*400);
				y = (int)(Math.random()*400);
			} while (m.getObjektBei(x,y) != null);
			m.setLocation(x,y);
		}
		for (int i = 0; i < ANZAHL_GUTER_OBJEKTE; i++) {
			Sandwich s = new Sandwich();
			contentPane.add(s);
			int x = 0;
			int y = 0;
			do {
				x = (int)(Math.random()*400);
				y = (int)(Math.random()*400);
			} while (s.getObjektBei(x,y) != null);
			s.setLocation(x,y);
		}
		for (int i = 0; i < ANZAHL_BOESER_OBJEKTE; i++) {
			Bombe b = new Bombe();
			contentPane.add(b);
			int x = 0;
			int y = 0;
			do {
				x = (int)(Math.random()*400);
				y = (int)(Math.random()*400);
			} while (b.getObjektBei(x,y) != null);
			b.setLocation(x,y);
		}
		Hund hund = new Hund();
		contentPane.add(hund);
		int x = 0;
		int y = 0;
		do {
			x = (int)(Math.random()*400);
			y = (int)(Math.random()*400);
		} while (hund.getObjektBei(x,y) != null);
		hund.setLocation(x,y);
		
    // Registrieren des Fenster-Schlie�en-Abh�rers der das Fenster und folglich das
		// Programm beendet
		addWindowListener(
 			new WindowAdapter() {
 				public void windowClosing(WindowEvent e) {
 				  setVisible(false);
 				  dispose();
 				  System.exit(0);
 				}
 			}
 		);
		
    // Registrieren des Tastatur-Abh�rers der die Richtung des Verschiebens bestimmen l�sst
    addKeyListener(
     	new KeyAdapter() {
     		public void keyPressed(KeyEvent e) {
     			switch (e.getKeyCode()) {
 	  				case 37: {
 	  					// Links
 	  					hund.setxRichtung(-1);
 	  					break;
 	  				}
 	  				case 38: {
 	  					//oben
 	  					hund.setyRichtung(-1);
 	  					break;
 	  				}
    				case 39: {
    					// Rechts
    					hund.setxRichtung(1);
    					break;
    				}
    				case 40: {
    					//unten
    					hund.setyRichtung(1);
    					break;
    				}
    			}
    		}
    	}
    );
	}
	
	/**
	 * Diese Methode wird automatisch aufgerufen und zwar dann, wenn das Fenster neu 
	 * gezeichnet werden muss. Diese Methode ruft automatisch alle paint-Methoden jener
	 * Objekte auf, die dem contentPane des Formulars zugeordnet wurden. Am Ende dieser
	 * Methode wird f�r eine gewisse Zeit das Programm angehalten und dann �ber repaint()
	 * die Methode paint wieder rekursiv gestartet
	 */
	public void paint(Graphics g) {
		// Hole alle Objekte des contentPanes des Formulars durch
		Component[] komponenten = this.getContentPane().getComponents();
		Hund h = new Hund();
		if (komponenten != null && komponenten.length > 0) {
			for (int i = 0; i < komponenten.length; i = i + 1) {
				if (komponenten[i] instanceof Sandwich) {
					Sandwich s = (Sandwich)(komponenten[i]);
					s.bewege();
				}
				else if (komponenten[i] instanceof Hund) {
					h = (Hund)(komponenten[i]);
					h.bewege();
				}
				else if (komponenten[i] instanceof Bombe) {
					Bombe b = (Bombe)(komponenten[i]);
					b.bewege();
				}
			}
			//wenn hund gestorben
			if (h.getGestorben()) {
				for (int i = 0; i < komponenten.length; i++) {
					if (komponenten[i] instanceof UnbeweglichesObjekt) {
						UnbeweglichesObjekt u = (UnbeweglichesObjekt)komponenten[i];
						u.stirb();
					}
					if (komponenten[i] instanceof BeweglichesGutesObjekt) {
						BeweglichesGutesObjekt u = (BeweglichesGutesObjekt)komponenten[i];
						u.stirb();
					}
				}
				gewonnen_t = new JTextField();
				gewonnen_t.setBounds(15, 15, 360, 50);
				gewonnen_t.setFont(new Font(null, Font.BOLD, 40));
				gewonnen_t.setEditable(false);
				gewonnen_t.setVisible(true);
				gewonnen_t.setForeground(Color.red);
				gewonnen_t.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(gewonnen_t);
				gewonnen_t.setText("GAME OVER!");
				//punkte
				punkte_t = new JTextField();
				punkte_t.setBounds(15, 80, 360, 50);
				punkte_t.setFont(new Font(null, 0, 40));
				punkte_t.setEditable(false);
				punkte_t.setVisible(true);
				punkte_t.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(punkte_t);
				punkte_t.setText("Deine Punktezahl:");
				//punktezahl
				punkte_t2 = new JTextField();
				punkte_t2.setBounds(15, 150, 360, 140);
				punkte_t2.setFont(new Font(null, Font.BOLD, 140));
				punkte_t2.setEditable(false);
				punkte_t2.setVisible(true);
				punkte_t2.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(punkte_t2);
				punkte_t2.setText(String.valueOf(h.getPunkte()));
				System.out.println("Game over!");
				System.out.println("Erreichte Punktezahl: " + h.getPunkte());
				//ok-button
				b = new JButton();
				b.setBounds(15, 305, 360, 40);
				b.setText("OK");
				b.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
				this.getContentPane().add(b);
				b.addActionListener(new ActionListener() {
					// wenn action performed
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
			}
			//wenn alle Sandwiches gefressen
			if (h.getPunkte() == ANZAHL_GUTER_OBJEKTE) {
				for (int i = 0; i < komponenten.length; i++) {
					if (komponenten[i] instanceof UnbeweglichesObjekt) {
						UnbeweglichesObjekt u = (UnbeweglichesObjekt)komponenten[i];
						u.stirb();
					}
					if (komponenten[i] instanceof BeweglichesGutesObjekt) {
						BeweglichesGutesObjekt u = (BeweglichesGutesObjekt)komponenten[i];
						u.stirb();
					}
				}
				gewonnen_t = new JTextField();
				gewonnen_t.setBounds(15, 15, 360, 50);
				gewonnen_t.setFont(new Font(null, Font.BOLD, 40));
				gewonnen_t.setEditable(false);
				gewonnen_t.setVisible(true);
				gewonnen_t.setForeground(Color.GREEN);
				gewonnen_t.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(gewonnen_t);
				gewonnen_t.setText("GEWONNEN!");
				//punkte
				punkte_t = new JTextField();
				punkte_t.setBounds(15, 80, 360, 50);
				punkte_t.setFont(new Font(null, 0, 40));
				punkte_t.setEditable(false);
				punkte_t.setVisible(true);
				punkte_t.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(punkte_t);
				punkte_t.setText("Deine Punktezahl:");
				//punktezahl
				punkte_t2 = new JTextField();
				punkte_t2.setBounds(15, 150, 360, 140);
				punkte_t2.setFont(new Font(null, Font.BOLD, 140));
				punkte_t2.setEditable(false);
				punkte_t2.setVisible(true);
				punkte_t2.setHorizontalAlignment(JTextField.CENTER);
				this.getContentPane().add(punkte_t2);
				punkte_t2.setText(String.valueOf(h.getPunkte()));
				System.out.println("Game over!");
				System.out.println("Erreichte Punktezahl: " + h.getPunkte());
				//ok-button
				b = new JButton();
				b.setBounds(15, 305, 360, 40);
				b.setText("OK");
				b.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
				this.getContentPane().add(b);
				b.addActionListener(new ActionListener() {
					// wenn action performed
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
			}
		}
		
		// Dieser Aufruf bewirkt, dass die normale (geerbte) paint-Methode des Formulars 
		// aufgerufen wird, welche ihrerseits daf�r sorgt, dass f�r alle Objekte des 
		// contentPane des Formulars die paint-Methode gestartet wird
		super.paint(g);
		// Programm pausiert
		bremse(100);
		// Sorgt daf�r, dass paint wiederum aufgerufen wird
		repaint();
	}

	/**
	 * L�sst das Programm f�r die angegebene Anzahl von Millisekunden pausieren
	 * @param millis
	 */
	private void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}	
	}
}
