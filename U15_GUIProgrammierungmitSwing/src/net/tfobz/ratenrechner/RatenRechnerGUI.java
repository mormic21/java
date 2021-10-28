package net.tfobz.ratenrechner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * RatenRechnerGUI
 * realistiert eine GUI fuer die Klasse RatenRechner.java
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
public class RatenRechnerGUI extends JFrame {
	//Membervariablen fuer die GUI
	ButtonGroup bgroup = null;
	JLabel[] jlabels = null;
	JRadioButton[] jradios = null;
	JTextField[] tfields = null;
	JButton[] jbuttons = null;
	JComboBox box = null;
	//RatenRechner-Objekt
	RatenRechner rechner = null;
	
	/**
	 * RatenRechnerGUI-Konstruktor
	 * instannzieert die GUI
	 */
	public RatenRechnerGUI() {
		//Exit on close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(700, 250, 620, 520);
		//Titel
		this.setTitle("Ratenrechner");
		this.setResizable(false);
		//Layoutmanager off
		this.getContentPane().setLayout(null);
		
		//instanziieren der JLabels und setzen der Anfangseigenschaften
		jlabels = new JLabel[6];
		for (int i = 0; i < jlabels.length; i++) {
			jlabels[i] = new JLabel();
			jlabels[i].setHorizontalAlignment(SwingConstants.RIGHT);
			jlabels[i].setFont(new Font(null, Font.BOLD, 17));
		}
		//Titel-Label
		jlabels[0].setBounds((620 / 2) - 100, 20, 200, 32);
		jlabels[0].setText("Ratenrechner");
		jlabels[0].setFont(new Font(null, Font.BOLD, 30));
		
		//ButtonGroup
		bgroup = new ButtonGroup();
		jradios = new JRadioButton[2];
		//Vorschuessig-Radio-Button, default auf false
		jradios[0] = new JRadioButton("Vorschüssig", false);
		jradios[0].setBounds(150, 90, 125, 20);
		jradios[0].setFont(new Font(null, Font.BOLD, 17));
		//Nachschuessig-Radio-Button, default auf true
		jradios[1] = new JRadioButton("Nachschüssig", true);
		jradios[1].setBounds(325, 90, 150, 20);
		jradios[1].setFont(new Font(null, Font.BOLD, 17));
		//add radiobuttons to group
		bgroup.add(jradios[0]);
		bgroup.add(jradios[1]);
		
		//Instanziieren der Textfelder und setzen der Anfangseigenschaften
		tfields = new JTextField[4];
		for (int i = 0; i < tfields.length; i++) {
			tfields[i] = new JTextField();
			tfields[i].setHorizontalAlignment(SwingConstants.RIGHT);
			tfields[i].setFont(new Font(null, 0, 17));
		}
		
		//Instanziieren der Buttons und setzen der Anfangseigenschaften
		jbuttons = new JButton[4];
		for (int i = 0; i < jbuttons.length; i++) {
			jbuttons[i] = new JButton();
			jbuttons[i].setFont(new Font(null, Font.BOLD, 17));
		}
		// --- barwert ---
		// label
		jlabels[1].setText("Barwert:");
		jlabels[1].setBounds(10, 150, 155, 20);
		// textfield
		tfields[0].setBounds(175, 146, 155, 30);
		// button
		jbuttons[0].setBounds(355, 146, 200, 30);
		jbuttons[0].setText("Berechne Barwert");

		// --- jahreszinssatz ---
		// label
		jlabels[2].setText("Jahreszinssatz:");
		jlabels[2].setBounds(10, 200, 155, 20);
		// textfield
		tfields[1].setBounds(175, 196, 155, 30);

		// ---laufzeit in jahren ---
		// label
		jlabels[3].setText("Laufzeit in Jahren:");
		jlabels[3].setBounds(10, 250, 155, 20);
		// textfield
		tfields[2].setBounds(175, 246, 155, 30);
		// button
		jbuttons[1].setBounds(355, 246, 200, 30);
		jbuttons[1].setText("Berechne Laufzeit");

		// --- raten pro jahr ---
		box = new JComboBox<>();
		// label
		jlabels[4].setText("Raten pro Jahr:");
		jlabels[4].setBounds(10, 300, 155, 20);
		//combo box
		box.setBounds(175, 296, 155, 30);
		box.addItem("12 Raten");
		box.addItem("6 Raten");
		box.addItem("4 Raten");
		box.addItem("1 Rate");
		box.setFont(new Font(null, Font.BOLD, 17));
		
		// --- rate ---
		jlabels[5].setText("Rate:");
		jlabels[5].setBounds(10, 350, 155, 20);
		// textfield
		tfields[3].setBounds(175, 346, 155, 30);
		// button
		jbuttons[2].setBounds(355, 346, 200, 30);
		jbuttons[2].setText("Berechne Rate");
		
		// --- zeige tilgungsplan ---
		jbuttons[3].setBounds(345, 420, 220, 50);
		jbuttons[3].setText("Zeige Tilgungsplan");
		jbuttons[3].setFont(new Font(null, Font.BOLD, 20));
		
		//add the actionListener to all buttons
		ButtonListener bl = new ButtonListener();
		for (int i = 0; i < jbuttons.length; i++) {
			jbuttons[i].addActionListener(bl);
		}
		
		
		// add all to contentPane
		Container pane = this.getContentPane();
		for (int i = 0; i < jlabels.length; i++) {
			pane.add(jlabels[i]);
		}
		for (int i = 0; i < jradios.length; i++) {
			pane.add(jradios[i]);
		}
		for (int i = 0; i < tfields.length; i++) {
			pane.add(tfields[i]);
		}
		for (int i = 0; i < jbuttons.length; i++) {
			pane.add(jbuttons[i]);
		}
		pane.add(box);
		//Instanziieren des RatenRechnerObjekts
		rechner = new RatenRechner();
	}
	
	/**
	 * ButtonListener
	 * Hoert die Buttons ab und reagiert darauf.
	 * Es werden verschiedene Berechnugen ausgeführt und an die GUI asugegeben.
	 * RatenRechnerExceptions werden aufgefangen und in Error-GUI-Meldungen umgew
	 * @author Michael Morandell
	 *
	 */
	private class ButtonListener implements ActionListener {
		
		/**
		 * getSelectedBox
		 * gibt den String mit der Nummer der gewaehlten Box RatenProJahr zurück
		 * @return ratenProJahr, als String
		 */
		private String getSelectedBox() {
			String ret = "";
			//getSelectedIndex
			int item = box.getSelectedIndex();
			switch(item) {
				case 0: {
					ret = "12";
					break;
				}
				case 1: {
					ret = "6";
					break;
				}
				case 2: {
					ret = "4";
					break;
				}
				case 3: {
					ret = "1";
					break;
				}
			}
			//return
			return ret;
		}
		
		/**
		 * actionPerformed
		 * wird ausgefuehrt, wenn ein Knopf gedrueckt wird
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Wenn "Berechne Barwert"-Knopf gedrueckt wird
			if (e.getSource().equals(jbuttons[0])) {
				try {
					//nachschuessig wird von GUI geholt und gesetzt
					if (jradios[1].isSelected()) {
						rechner.setNachschuessig(true);
					}
					else {
						rechner.setNachschuessig(false);
					}
					//jahreszinssatz wird von GUI geholt und gesetzt
					rechner.setJahreszinssatz(tfields[1].getText());
					//LaufzeitInJahren wird von GUI geholt und gesetzt
					rechner.setLaufzeitInJahren(tfields[2].getText());
					//RatenProJahr wird von GUI geholt und gesetzt
					rechner.setRatenProJahr(this.getSelectedBox());
					//Rate wird von GUI geholt und gesetzt
					rechner.setRate(tfields[3].getText());
					//Barwert wird berechnet und ans Textfeld ausgegeben
					tfields[0].setText(rechner.getBarwert());
					//Falls RatenRechnerException geworfen wird
				} catch (RatenRechnerException rre) {
					//Message Dialog
					JOptionPane.showMessageDialog(RatenRechnerGUI.this, rre.getMessage().toString(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
			//Wenn "Berechne Laufzeit in Jahren"-Knopf gedrueckt wird
			if (e.getSource().equals(jbuttons[1])) {
				try {
					//nachschuessig wird von GUI geholt und gesetzt
					if (jradios[1].isSelected()) {
						rechner.setNachschuessig(true);
					}
					else {
						rechner.setNachschuessig(false);
					}
					//barwert wird von GUI geholt und gesetzt
					rechner.setBarwert(tfields[0].getText());
					//jahreszinssatz wird von GUI geholt und gesetzt
					rechner.setJahreszinssatz(tfields[1].getText());
					//RatenProJahr wird von GUI geholt und gesetzt
					rechner.setRatenProJahr(this.getSelectedBox());
					//Rate wird von GUI geholt und gesetzt
					rechner.setRate(tfields[3].getText());
					//LaufzeitInJahren wird berechnet und ans Textfeld ausgegeben
					tfields[2].setText(rechner.getLaufzeitInJahren());
					//Falls RatenRechnerException geworfen wird
				} catch (RatenRechnerException rre) {
					//Message Dialog
					JOptionPane.showMessageDialog(RatenRechnerGUI.this, rre.getMessage().toString(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			//Wenn "Berechne Rate"-Knopf gedrueckt wird
			if (e.getSource().equals(jbuttons[2])) {
				try {
					//nachschuessig wird von GUI geholt und gesetzt
					if (jradios[1].isSelected()) {
						rechner.setNachschuessig(true);
					}
					else {
						rechner.setNachschuessig(false);
					}
					//barwert wird von GUI geholt und gesetzt
					rechner.setBarwert(tfields[0].getText());
					//jahreszinssatz wird von GUI geholt und gesetzt
					rechner.setJahreszinssatz(tfields[1].getText());
					//LaufzeitInJahren wird von GUI geholt und gesetzt
					rechner.setLaufzeitInJahren(tfields[2].getText());
					//RatenProJahr wird von GUI geholt und gesetzt
					rechner.setRatenProJahr(this.getSelectedBox());
					//Rate wird berechnet und ans Textfeld ausgegeben
					tfields[3].setText(rechner.getRate());
					//Falls RatenRechnerException geworfen wird
				} catch (RatenRechnerException rre) {
					//Message Dialog
					JOptionPane.showMessageDialog(RatenRechnerGUI.this, rre.getMessage().toString(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			//Wenn "Zeige Tilgungsplan"-Knopf gedrueckt wird
			if (e.getSource().equals(jbuttons[3])) {
				try {
					//nachschuessig wird von GUI geholt und gesetzt
					if (jradios[1].isSelected()) {
						rechner.setNachschuessig(true);
					}
					else {
						rechner.setNachschuessig(false);
					}
					//barwert wird von GUI geholt und gesetzt
					rechner.setBarwert(tfields[0].getText());
					//jahreszinssatz wird von GUI geholt und gesetzt
					rechner.setJahreszinssatz(tfields[1].getText());
					//LaufzeitInJahren wird von GUI geholt und gesetzt
					rechner.setLaufzeitInJahren(tfields[2].getText());
					//RatenProJahr wird von GUI geholt und gesetzt
					rechner.setRatenProJahr(this.getSelectedBox());
					//Rate wird von GUI geholt und gesetzt
					rechner.setRate(tfields[3].getText());
					//Tilgunsplan wird geholt
					String plan = rechner.getTilgungsplan();
					//TilgunsgplanGUI zur Darstellung des Tilgungsplanes wird gestartet
					TilgungsplanGUI tg = new TilgungsplanGUI(RatenRechnerGUI.this, plan);
					//wird auf visible gesetzt
					tg.setVisible(true);
					//wenn das modale Fenster geschlossen wird, wird der Speicher wieder freigegeben
					tg.dispose();
					//Falls RatenRechnerException geworfen wird
				} catch (RatenRechnerException rre) {
					//MessageDialog
					JOptionPane.showMessageDialog(RatenRechnerGUI.this, rre.getMessage().toString(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
