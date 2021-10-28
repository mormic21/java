package net.tfobz.eurorechner;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * EuroUmrechnerGUI
 * Realisiert eine GUI fuer das Programm EuroUmrechner.java
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
public class EuroUmrechnerGUI extends JFrame{
	//Labels
	private JLabel[] jLabels = null;
	//Textfelder
	private JTextField[] jTextFields = null;
	//Euro-Umrechner-Objekt
	private EuroUmrechner rechner = null;
	
	/**
	 * EuroUmrechnerGUI-Konstruktor
	 * Erstellt die GUI
	 */
	public EuroUmrechnerGUI() {
		//Exit on Close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Groesse und Position
		this.setBounds(700, 250, 520, 580);
		//Titel
		this.setTitle("Euroumrechner");
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		//Instanziierung der Objekt-Arrays
		this.jLabels = new JLabel[13];
		this.jTextFields = new JTextField[13];
		rechner = new EuroUmrechner();
		//Instanziierung des Listeners
		MeinTastaturAbhoerer listener = new MeinTastaturAbhoerer();
		
		//Euro
		//Label
		jLabels[0] = new JLabel();
		jLabels[0].setBounds(10, 10, (getWidth()/2)-20, 20);
		jLabels[0].setText("Euro:");
		jLabels[0].setFont(new Font(null, Font.BOLD, 17));
		jLabels[0].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds euro-label
		this.getContentPane().add(jLabels[0]);
		//Textfeld
		jTextFields[0] = new JTextField();
		jTextFields[0].setBounds((getWidth()/2), 10, (getWidth()/2)-20, 25);
		jTextFields[0].setFont(new Font(null, 0, 17));
		jTextFields[0].addKeyListener(listener);
		jTextFields[0].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds euro-textfield
		this.getContentPane().add(jTextFields[0]);
		
		//Oesterreicherische Schilling
		//Label
		jLabels[1] = new JLabel();
		jLabels[1].setBounds(10, 65, (getWidth()/2)-20, 20);
		jLabels[1].setText("Österreicherischer Schilling:");
		jLabels[1].setFont(new Font(null, Font.BOLD, 17));
		jLabels[1].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds schilling-Label
		this.getContentPane().add(jLabels[1]);
		//Textfeld
		jTextFields[1] = new JTextField();
		jTextFields[1].setBounds((getWidth()/2), 65, (getWidth()/2)-20, 25);
		jTextFields[1].setFont(new Font(null, 0, 17));
		jTextFields[1].addKeyListener(listener);
		jTextFields[1].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds schilling-Textfeld
		this.getContentPane().add(jTextFields[1]);
		
		//Belgische Franc
		//Label
		jLabels[2] = new JLabel();
		jLabels[2].setBounds(10, 105, (getWidth()/2)-20, 20);
		jLabels[2].setText("Belgische Franc:");
		jLabels[2].setFont(new Font(null, Font.BOLD, 17));
		jLabels[2].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds franc label
		this.getContentPane().add(jLabels[2]);
		//Textfeld
		jTextFields[2] = new JTextField();
		jTextFields[2].setBounds((getWidth()/2), 105, (getWidth()/2)-20, 25);
		jTextFields[2].setFont(new Font(null, 0, 17));
		jTextFields[2].addKeyListener(listener);
		jTextFields[2].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds franc Textfeld
		this.getContentPane().add(jTextFields[2]);
		
		//Deutsche Mark
		//Label
		jLabels[3] = new JLabel();
		jLabels[3].setBounds(10, 145, (getWidth()/2)-20, 20);
		jLabels[3].setText("Deutsche Mark:");
		jLabels[3].setFont(new Font(null, Font.BOLD, 17));
		jLabels[3].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds mark label
		this.getContentPane().add(jLabels[3]);
		//Textfeld
		jTextFields[3] = new JTextField();
		jTextFields[3].setBounds((getWidth()/2), 145, (getWidth()/2)-20, 25);
		jTextFields[3].setFont(new Font(null, 0, 17));
		jTextFields[3].addKeyListener(listener);
		jTextFields[3].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds mark Textfeld
		this.getContentPane().add(jTextFields[3]);
		
		//Spanische Peseten
		//Label
		jLabels[4] = new JLabel();
		jLabels[4].setBounds(10, 185, (getWidth()/2)-20, 20);
		jLabels[4].setText("Spanische Peseten:");
		jLabels[4].setFont(new Font(null, Font.BOLD, 17));
		jLabels[4].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds perseten label
		this.getContentPane().add(jLabels[4]);
		//textfeld
		jTextFields[4] = new JTextField();
		jTextFields[4].setBounds((getWidth()/2), 185, (getWidth()/2)-20, 25);
		jTextFields[4].setFont(new Font(null, 0, 17));
		jTextFields[4].addKeyListener(listener);
		jTextFields[4].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds perseten Textfeld
		this.getContentPane().add(jTextFields[4]);
		
		//Franzoesische Franc
		//Label
		jLabels[5] = new JLabel();
		jLabels[5].setBounds(10, 225, (getWidth()/2)-20, 20);
		jLabels[5].setText("Franzoesische Franc:");
		jLabels[5].setFont(new Font(null, Font.BOLD, 17));
		jLabels[5].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds franzoesische franc label
		this.getContentPane().add(jLabels[5]);
		//Textfeld
		jTextFields[5] = new JTextField();
		jTextFields[5].setBounds((getWidth()/2), 225, (getWidth()/2)-20, 25);
		jTextFields[5].setFont(new Font(null, 0, 17));
		jTextFields[5].addKeyListener(listener);
		jTextFields[5].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds franzoesische franc textfeld
		this.getContentPane().add(jTextFields[5]);
		
		//Irische Pfund
		//Label
		jLabels[6] = new JLabel();
		jLabels[6].setBounds(10, 265, (getWidth()/2)-20, 20);
		jLabels[6].setText("Irische Pfund:");
		jLabels[6].setFont(new Font(null, Font.BOLD, 17));
		jLabels[6].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds pfund label
		this.getContentPane().add(jLabels[6]);
		//Textfeld
		jTextFields[6] = new JTextField();
		jTextFields[6].setBounds((getWidth()/2), 265, (getWidth()/2)-20, 25);
		jTextFields[6].setFont(new Font(null, 0, 17));
		jTextFields[6].addKeyListener(listener);
		jTextFields[6].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds pfund textfeld
		this.getContentPane().add(jTextFields[6]);
		
		//Italienische Lire
		//Label
		jLabels[7] = new JLabel();
		jLabels[7].setBounds(10, 305, (getWidth()/2)-20, 20);
		jLabels[7].setText("Italienische Lire:");
		jLabels[7].setFont(new Font(null, Font.BOLD, 17));
		jLabels[7].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds lire label
		this.getContentPane().add(jLabels[7]);
		//Textfeld
		jTextFields[7] = new JTextField();
		jTextFields[7].setBounds((getWidth()/2), 305, (getWidth()/2)-20, 25);
		jTextFields[7].setFont(new Font(null, 0, 17));
		jTextFields[7].addKeyListener(listener);
		jTextFields[7].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds lire textfeld
		this.getContentPane().add(jTextFields[7]);
		
		//Luxenburgische Franc
		//Label
		jLabels[8] = new JLabel();
		jLabels[8].setBounds(10, 345, (getWidth()/2)-20, 20);
		jLabels[8].setText("Luxenburgische Franc:");
		jLabels[8].setFont(new Font(null, Font.BOLD, 17));
		jLabels[8].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds luxemburgische franc label
		this.getContentPane().add(jLabels[8]);
		//Textfeld
		jTextFields[8] = new JTextField();
		jTextFields[8].setBounds((getWidth()/2), 345, (getWidth()/2)-20, 25);
		jTextFields[8].setFont(new Font(null, 0, 17));
		jTextFields[8].addKeyListener(listener);
		jTextFields[8].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds luxemburgische franc textfeld
		this.getContentPane().add(jTextFields[8]);
		
		//Niederlaendische Gulden
		//Label
		jLabels[9] = new JLabel();
		jLabels[9].setBounds(10, 385, (getWidth()/2)-20, 20);
		jLabels[9].setText("Niederländische Gulden:");
		jLabels[9].setFont(new Font(null, Font.BOLD, 17));
		jLabels[9].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds Gulden label
		this.getContentPane().add(jLabels[9]);
		//Textfeld
		jTextFields[9] = new JTextField();
		jTextFields[9].setBounds((getWidth()/2), 385, (getWidth()/2)-20, 25);
		jTextFields[9].setFont(new Font(null, 0, 17));
		jTextFields[9].addKeyListener(listener);
		jTextFields[9].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds Gulden textfeld
		this.getContentPane().add(jTextFields[9]);
		
		//Portugiesische Escudos
		//Labels
		jLabels[10] = new JLabel();
		jLabels[10].setBounds(10, 425, (getWidth()/2)-20, 20);
		jLabels[10].setText("Portugiesische Escudos:");
		jLabels[10].setFont(new Font(null, Font.BOLD, 17));
		jLabels[10].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds escudos label
		this.getContentPane().add(jLabels[10]);
		//textfeld
		jTextFields[10] = new JTextField();
		jTextFields[10].setBounds((getWidth()/2), 425, (getWidth()/2)-20, 25);
		jTextFields[10].setFont(new Font(null, 0, 17));
		jTextFields[10].addKeyListener(listener);
		jTextFields[10].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds Escudos textfeld
		this.getContentPane().add(jTextFields[10]);
		
		//Finnmark
		//Label
		jLabels[11] = new JLabel();
		jLabels[11].setBounds(10, 465, (getWidth()/2)-20, 20);
		jLabels[11].setText("Finnmark:");
		jLabels[11].setFont(new Font(null, Font.BOLD, 17));
		jLabels[11].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds finnmark label
		this.getContentPane().add(jLabels[11]);
		//textfeld
		jTextFields[11] = new JTextField();
		jTextFields[11].setBounds((getWidth()/2), 465, (getWidth()/2)-20, 25);
		jTextFields[11].setFont(new Font(null, 0, 17));
		jTextFields[11].addKeyListener(listener);
		jTextFields[11].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds finnmark textfeld
		this.getContentPane().add(jTextFields[11]);
		
		//Griechische Drachmen
		//Label
		jLabels[12] = new JLabel();
		jLabels[12].setBounds(10, 505, (getWidth()/2)-20, 20);
		jLabels[12].setText("Griechische Drachmen:");
		jLabels[12].setFont(new Font(null, Font.BOLD, 17));
		jLabels[12].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds drachmen label
		this.getContentPane().add(jLabels[12]);
		//Textfeld
		jTextFields[12] = new JTextField();
		jTextFields[12].setBounds((getWidth()/2), 505, (getWidth()/2)-20, 25);
		jTextFields[12].setFont(new Font(null, 0, 17));
		jTextFields[12].addKeyListener(listener);
		jTextFields[12].setHorizontalAlignment(SwingConstants.RIGHT);
		//adds drachmen textfeld
		this.getContentPane().add(jTextFields[12]);
	}
	
	/**
	 * privater Listener: MeinTatstaturAbhörer
	 * Reagiert auf das KeyReleased-Event
	 * erbt von KeyAdapter
	 * @author Michael Morandell
	 *
	 */
	private class MeinTastaturAbhoerer extends KeyAdapter {
		/**
		 * keyReleased-Event
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			//Das Textfeld wird gesucht, aus welchem das Event kommt
			for (int i = 0; i < jTextFields.length; i++) {
				//wenn gefunden
				if (e.getSource().equals(jTextFields[i])) {
					//wird im rechner die jeweilige Waehrung gesetzt
					rechner.setWaehrung(i);
				}
			}
			double betrag = 0;
			try {
				//der Betrag wird aus dem textfeld eingelesen und zu Double geparst
				betrag = Double.parseDouble(jTextFields[rechner.getWaehrung()].getText());
				//Betrag wird im Rechner gesetzt
				rechner.setBetrag(betrag);
				//Alle Felder werden durchgegangen
				for (int i = 0; i < jTextFields.length; i++) {
					//Fuer alle Felder, auser dem aufrufenden feld...
					if (i != rechner.getWaehrung()) {
						//... Wird der berechnete, auf 2 Stellen gerundete Double-Betrag, ins jeweilige Textfeld geschrieben
						jTextFields[i].setText(Double.toString(Math.round(rechner.getBetrag(i)*100.0)/100.0));
					}
				}
				//catch eventuellen Fehler, beim Double-Parsen, z.B. bei ungueltiger Eingabe
			} catch (NumberFormatException exc) {
			}
		}
	}
}
