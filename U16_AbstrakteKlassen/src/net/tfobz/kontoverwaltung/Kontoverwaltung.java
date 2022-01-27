package net.tfobz.kontoverwaltung;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Kontoverwaltung
 * realisiert eine GUI zur Kontoverwaltung
 * dazu nutzt diese Klasse die Klassen Konto, Gehaltskonto und Sparrkonto
 * extends JFrame
 * @author Michael Morandell
 *
 */
@SuppressWarnings("serial")
public class Kontoverwaltung extends JFrame {
	//Membervariablen für Konten
	private static final int MAX_KONTEN = 100;
	private Konto[] konten = null;
	private static final double STARTZINSSATZ = 0.25;
	private static final double STARTUEBERZIEHUNG = -1000.0;
		
	//GUI-Membervariablen
	private JTextField[] konto1 = new JTextField[2];
	private JTextField[] konto2 = new JTextField[2];
	private JButton newGehaltkonto = null;
	private JButton newSparkonto = null;
	private JButton anzeigen = null;
	private JButton buchen = null;
	private JButton ueberweisen = null;
	private JLabel kontonummer1 = new JLabel();
	private JLabel kontonummer2 = new JLabel();
	private JScrollPane areaScrollPane = null;
	private JTextArea area = null;
	private Font default_font = new Font("Sans Serif", Font.PLAIN, 17);
	private Font bold_font = new Font("Sans Serif", Font.BOLD, 16);
	
	/**
	 * Kontoverwaltung-Konstruktor
	 */
	public Kontoverwaltung() {
		//Exit on Close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Einstellen der Werte für das Fenster
		int height = 600;
		int width = 910;
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width - width) / 2, (screen_size.height - height) / 2, width, height);
		this.setTitle("Kontoverwaltung");
		this.setResizable(false);
		//Layoutmanager null
		this.getContentPane().setLayout(null);
		
		//ButtonListener
		ButtonListener listener = new ButtonListener();
		
		//konto1
		konto1[0] = new JTextField();
		konto1[0].setBounds(15, 20, 200, 25);
		konto1[0].setFont(default_font);
		this.getContentPane().add(konto1[0]);
		
		//kontonummer1
		kontonummer1.setBounds(15, 60, 200, 25);
		kontonummer1.setFont(bold_font);
		kontonummer1.setText("Kontonummer1: ");
		this.getContentPane().add(kontonummer1);
		
		//konto1
		konto1[1] = new JTextField();
		konto1[1].setBounds(15, 95, 200, 25);
		konto1[1].setFont(default_font);
		this.getContentPane().add(konto1[1]);

		//konto2
		konto2[0] = new JTextField();
		konto2[0].setBounds(240, 20, 200, 25);
		konto2[0].setFont(default_font);
		this.getContentPane().add(konto2[0]);
		
		//kontonummer2
		kontonummer2.setBounds(240, 60, 200, 25);
		kontonummer2.setFont(bold_font);
		kontonummer2.setText("Kontonummer2: ");
		this.getContentPane().add(kontonummer2);
		
		//konto2
		konto2[1] = new JTextField();
		konto2[1].setBounds(240, 95, 200, 25);
		konto2[1].setFont(default_font);
		this.getContentPane().add(konto2[1]);
		
		//neues Gehltskonto
		newGehaltkonto = new JButton();
		newGehaltkonto.setBounds(450, 5, 220, 40);
		newGehaltkonto.setFont(bold_font);
		newGehaltkonto.setText("Neues Gehaltskonto");
		newGehaltkonto.addActionListener(listener);
		this.getContentPane().add(newGehaltkonto);
		
		//neues Sparkonto
		newSparkonto = new JButton();
		newSparkonto.setBounds(673, 5, 220, 40);
		newSparkonto.setFont(bold_font);
		newSparkonto.setText("Neues Sparkonto");
		newSparkonto.addActionListener(listener);
		this.getContentPane().add(newSparkonto);
		
		//anzeigen
		anzeigen = new JButton();
		anzeigen.setBounds(450, 48, 443, 40);
		anzeigen.setFont(bold_font);
		anzeigen.setText("Anzeigen");
		anzeigen.addActionListener(listener);
		this.getContentPane().add(anzeigen);
		
		//buchen
		buchen = new JButton();
		buchen.setBounds(450, 91, 220, 40);
		buchen.setFont(bold_font);
		buchen.setText("Buchen");
		buchen.addActionListener(listener);
		this.getContentPane().add(buchen);
		
		//ueberweisen
		ueberweisen = new JButton();
		ueberweisen.setBounds(673, 91, 220, 40);
		ueberweisen.setFont(bold_font);
		ueberweisen.setText("Überweisen");
		ueberweisen.addActionListener(listener);
		this.getContentPane().add(ueberweisen);
		
		//textarea
		area = new JTextArea();
		area.setBounds(10, 140, 875, 405);
		area.setFont(default_font);
		area.setEditable(false);
		//automatische newline, wenn text zu lang
		area.setLineWrap(true);
		area.setWrapStyleWord(false);
		//scrollpane
		areaScrollPane = new JScrollPane(area);
		//vertikale scorllbar, wenn nötig
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//horinzontale scrollbar nie
		areaScrollPane.setHorizontalScrollBarPolicy(
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		areaScrollPane.setBounds(10, 140, 885, 415);
		this.getContentPane().add(areaScrollPane);
		
		//default Button
		this.getRootPane().setDefaultButton(anzeigen);
		
		//konten
		konten = new Konto[MAX_KONTEN];
		
		//Startzinssatz wird versucht zu setzen
		try {
			Konto.setStartzinssatz(STARTZINSSATZ);
			//Fehlermeldung bei KontoException
		} catch (KontoException e) {
			JOptionPane.showMessageDialog(Kontoverwaltung.this, e.getMessage(), "Konto-Fehler", JOptionPane.ERROR_MESSAGE);
			//Programm wird beendet
			System.exit(0);
		}
		//STartueberzeihung wird versucht zu setzen
		try {
			Gehaltskonto.setStartueberziehung(STARTUEBERZIEHUNG);
			//Fehlermeldung bei KontoException
		} catch (KontoException e) {
			JOptionPane.showMessageDialog(Kontoverwaltung.this, e.getMessage(), "Konto-Fehler", JOptionPane.ERROR_MESSAGE);
			//Programm wird beendet
			System.exit(0);
		}
	}
	
	/**
	 * ButtonListener
	 * reagiert auf das druecken der Buttons
	 * implements ActionListener
	 * @author Michael Morandell
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean erfolg = false;
			//neues Gehaltskonto
			if (e.getSource().equals(newGehaltkonto)) {
				//neues Gehaltskonto wird angelegt
				konten[Konto.naechsteKontonummer] = new Gehaltskonto();
				//Meldung wird an Textarea ausgegeben
				area.append("Neues Gehaltskonto: "+konten[Konto.naechsteKontonummer-1].toString() + "\n");
				//Aktion erfolgreich
				erfolg = true;
			}
			//neues Sparrkonto
			if (e.getSource().equals(newSparkonto)) {
				boolean ok = true;
				double ersteZahlung = 0.0;
				double sparrate = 0.0;
				//double-Zahl für erste ersteZahlung wird eingelesen
				try {
					ersteZahlung = Double.parseDouble(konto1[0].getText());
					//Fehler
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie einen gültigen Double-Wert für 'ersteZahlung' ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					ok = false;
				}
				//double-Zahl für sparrate wird eingelesen
				try {
					sparrate = Double.parseDouble(konto2[0].getText());
					//Fehlermeldung an Benutzer
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie einen gültigen Double-Wert für 'sparrate' ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					ok = false;
				}
				//Wenn bis jetzt keine Fehler aufgetreten sind
				if (ok) {
					try {
						//neues Sparkonto wird erstellt
						konten[Konto.naechsteKontonummer] = new Sparkonto(ersteZahlung, sparrate);
						//Text wird an Textarea ausgegeben
						area.append("Neues Sparkonto: "+konten[Konto.naechsteKontonummer-1].toString() + "\n");
						//Aktion war erfolgreich
						erfolg = true;
						//Fehlermeldung an den Benutzer
					} catch (KontoException err) {
						JOptionPane.showMessageDialog(Kontoverwaltung.this, 
								err.getMessage(), 
								"Konto-Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			//anzeigen
			if (e.getSource().equals(anzeigen)) {
				try {
					//wenn textfeld leer ist
					if (konto1[0].getText().equals("")) {
						//wenn textfeld leer ist
						if(konto1[1].getText().equals("")) {
							//wenn textfeld leer ist
							if(konto2[0].getText().equals("")) {
								//wenn textfeld leer ist
								if(konto2[1].getText().equals("")) {
									//Fehlermeldung an Benutzer
									JOptionPane.showMessageDialog(Kontoverwaltung.this, 
											"Bitte geben sie die Kontonummer in ein Textfeld ein", 
											"Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									//Wenn Kontonummer positiv ist
									if (Integer.parseInt(konto2[1].getText()) >= 0) {
										//Text wird an TextArea ausgegeben
										area.append("Anzeigen: "+konten[Integer.parseInt(konto2[1].getText())].toString() + "\n");
										erfolg = true;
									}
								}
							}
							else {
								//Wenn Kontonummer positiv ist
								if (Integer.parseInt(konto2[0].getText()) >= 0) {
									//Text wird an TextArea ausgegeben
									area.append("Anzeigen: "+konten[Integer.parseInt(konto2[0].getText())].toString() + "\n");
									erfolg = true;
								}
							}
						}
						else {
							//Wenn Kontonummer positiv ist
							if (Integer.parseInt(konto1[1].getText()) >= 0) {
								//Text wird an TextArea ausgegeben
								area.append("Anzeigen: "+konten[Integer.parseInt(konto1[1].getText())].toString() + "\n");
								erfolg = true;
							}
						}
					}
					else {
						//Wenn Kontonummer positiv ist
						if (Integer.parseInt(konto1[0].getText()) >= 0) {
							//Text wird an TextArea ausgegeben
							area.append("Anzeigen: "+konten[Integer.parseInt(konto1[0].getText())].toString() + "\n");
							erfolg = true;
						}
					}
					//Falsches Format der Zahl
				} catch (NumberFormatException err) {
					//Fehlermeldung an Benutzer
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie eine korrekte Kontonummer ins Textfeld ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					//Out of Bound + Null Pointer
				} catch (Exception err) {
					//Fehlermeldung an Benutzer
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Diese Kontonummer ist exsistiert nicht. Bitte geben sie eine korrekte Kontonummer ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			//buchen
			if (e.getSource().equals(buchen)) {
				try {
					//Betrag wird aufs Konto gebucht
					konten[Integer.parseInt(konto1[1].getText())].buchen(Double.parseDouble(konto1[0].getText()));
					//Text wird an TextArea ausgegeben
					area.append("Buchen: "+konten[Integer.parseInt(konto1[1].getText())].toString() + "\n");
					//erfolgreiche Aktion
					erfolg = true;
					//Falsches Zahlenformat
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie gültige Zahlen ein!", 
							"Error", JOptionPane.ERROR_MESSAGE);
					//Kontofehler
				} catch (KontoException err) {
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							err.getMessage(), 
							"Konto-Fehler", JOptionPane.ERROR_MESSAGE);
					//Fehler
				} catch (Exception err) {
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Diese Kontonummer ist exsistiert nicht. Bitte geben sie eine korrekte Kontonummer ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			//ueberweisen
			if (e.getSource().equals(ueberweisen)) {
				double betrag = 0.0;
				int konton1 = 0;
				int konton2 = 0;
				try {
					//betrag wird eingelesen
					betrag = Double.parseDouble(konto1[0].getText());
				} catch (NumberFormatException err) {
					//Fehlermeldung
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie einen gültigen Double-Betrag ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					//Kontonummer1 wird eingelesen
					konton1 = Integer.parseInt(konto1[1].getText());
				} catch (NumberFormatException err) {
					//Fehlermeldung
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie einen gültigen Wert für 'Kontonummer1' ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					//Kontonummer2 wird eingelesen
					konton2 = Integer.parseInt(konto2[1].getText());
				} catch (NumberFormatException err) {
					//Fehlermeldung
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie einen gültigen Wert für 'Kontonummer2' ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					//Überprüfung ob Kontonummern gueltig
					konten[konton1].toString();
					konten[konton2].toString();
				} catch (Exception err) {
					//Fehlermeldung
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							"Bitte geben sie gültige Kontonummern ein", 
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					//Betrag wird vom Konto abgebucht
					konten[konton1].buchen(-betrag);
					//Betrag wird auf Konto2 gebucht
					konten[konton2].buchen(betrag);
					//Ausgabe an TextArea
					area.append("Überweisen von Konto "+konton1+" nach Konto "+konton2+" Betrag "+betrag+ " erfolgreich \n");
					//erfolgreiche Aktion
					erfolg = true;
				} catch (KontoException err) {
					//Fehlermeldung
					JOptionPane.showMessageDialog(Kontoverwaltung.this, 
							err.getMessage(), 
							"Konto-Fehler", JOptionPane.ERROR_MESSAGE);
				}
			}
			//Wenn Aktion erfolgreich war
			if (erfolg) {
				//Textfelder werden geleert
				for (JTextField t : konto1) {
					t.setText("");
				}
				for (JTextField t : konto2) {
					t.setText("");
				}
			}
		}
	}
}