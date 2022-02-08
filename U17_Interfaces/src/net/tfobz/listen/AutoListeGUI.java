package net.tfobz.listen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * AutoListeGUI
 * realisiert eine GUI für die Autoliste
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
public class AutoListeGUI extends JFrame {
	//Membervariablen
	private MeineDefaultListe autoListe = new MeineDefaultListe();
	private MeinIterator autoIterator = autoListe.elemente();
	//GUI-Membervariablen
	private JLabel nameLabel = null;
	private JLabel zulassungLabel = null;
	private JTextField nameText = null;
	private JTextField zulassungText = null;
	private JButton nextb = null;
	private JButton newb = null;
	private JButton deleteb = null;
	private Font default_font = new Font("Sans Serif", Font.PLAIN, 17);
	private Font bold_font = new Font("Sans Serif", Font.BOLD, 17);
	
	/**
	 * AutoListeGUI-Konstruktor
	 */
	public AutoListeGUI() {
		//exit on close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//berechnung der bounds
		int height = 190;
		int width = 390;
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width - width) / 2, (screen_size.height - height) / 2, width, height);
		//nicht resizable
		this.setResizable(false);
		//titel
		this.setTitle("AutoListe");
		//layoutmanager null
		this.getContentPane().setLayout(null);
		
		//Name-Label
		nameLabel = new JLabel();
		nameLabel.setText("Name:");
		nameLabel.setFont(bold_font);
		nameLabel.setBounds(0, 30, 150, 20);
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_A);
		this.getContentPane().add(nameLabel);
		
		//erstzulassungs-label
		zulassungLabel = new JLabel();
		zulassungLabel.setText("Erstzulassung:");
		zulassungLabel.setFont(bold_font);
		zulassungLabel.setBounds(0, 60, 150, 20);
		zulassungLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		zulassungLabel.setDisplayedMnemonic(KeyEvent.VK_S);
		this.getContentPane().add(zulassungLabel);
		
		//Name Textfeld
		nameText = new JTextField();
		nameText.setFont(default_font);
		nameText.setBounds(160, 30, 200, 24);
		nameText.setHorizontalAlignment(SwingConstants.LEFT);
		this.getContentPane().add(nameText);
		nameLabel.setLabelFor(nameText);
		
		//Erstzulassungs-Textfeld
		zulassungText = new JTextField();
		zulassungText.setFont(default_font);
		zulassungText.setBounds(160, 60, 50, 24);
		zulassungText.setHorizontalAlignment(SwingConstants.LEFT);
		this.getContentPane().add(zulassungText);
		zulassungLabel.setLabelFor(zulassungText);
		
		//Listener
		ButtonListener listener = new ButtonListener();
		
		//Naechster Button
		nextb = new JButton();
		nextb.setText("Nächstes");
		nextb.setFont(bold_font);
		nextb.setBounds(30, 110, 120, 30);
		nextb.setMnemonic(KeyEvent.VK_N);
		nextb.addActionListener(listener);
		this.getContentPane().add(nextb);
		
		//New Button
		newb = new JButton();
		newb.setText("Neu");
		newb.setFont(bold_font);
		newb.setBounds(160, 110, 80, 30);
		newb.setMnemonic(KeyEvent.VK_E);
		newb.addActionListener(listener);
		this.getContentPane().add(newb);
		
		//Löschen Button
		deleteb = new JButton();
		deleteb.setText("Löschen");
		deleteb.setFont(bold_font);
		deleteb.setBounds(250, 110, 110, 30);
		deleteb.setMnemonic(KeyEvent.VK_L);
		deleteb.addActionListener(listener);
		this.getContentPane().add(deleteb);
		
		//Default-Button
		this.getRootPane().setDefaultButton(newb);
	}
	
	/**
	 * ButtonListener
	 * reagiert auf das druecken von Knöpfen
	 * implementiert ActionListener
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
			
			//Wenn naechster Button gedrueckt wurde
			if (e.getSource().equals(nextb)) {
				//wenn liste leer
				if (autoListe.istLeer()) {
					//Fehlermeldung an Benutzer
					JOptionPane.showMessageDialog(
							AutoListeGUI.this,
							"Kein nächstes Element vorhanden:\nListe ist leer",
							"Liste leer",
							JOptionPane.ERROR_MESSAGE);
				}
				//wenn liste nicht leer
				else {
					boolean weiter = true;
					try {
						//Eingaben werden eingelesen
						int zulassung = Integer.parseInt(zulassungText.getText());
						//Eingaben werden in ein Auto verwandelt
						Auto a = new Auto(nameText.getText(), zulassung);
						//Eigenschaften werden ins aktuelle Auto gesetzt
						autoIterator.setzenAktuellesElement(a);
						//bei ungueltigen Eingaben
					} catch (NumberFormatException err) {
						//Fehlermeldung an Benutzer
						JOptionPane.showMessageDialog(
								AutoListeGUI.this,
								"Bitte geben sie einen gültigen Wert für Erstzulassung ein!",
								"Ungültige Eingabe",
								JOptionPane.ERROR_MESSAGE);
						weiter = false;
					}
					//Wenn bisher erolgreich
					if (weiter) {
						//naechtes Element wird geholt
						Auto auto = (Auto) autoIterator.naechstesElement();
						//Ist dieses null, sind wir am ende der liste und wir holen uns das erste Element
						if (auto == null) {
							//Meldung an Benutzer
							JOptionPane.showMessageDialog(
									AutoListeGUI.this,
									"Sie haben das Ende der Liste erreicht!",
									"Ende der Liste",
									JOptionPane.INFORMATION_MESSAGE);
							//erstes Element
							auto = (Auto)autoIterator.naechstesElement();
						}
						//Ausgabe der Eigenschaften des Autos
						nameText.setText(auto.getName());
						zulassungText.setText(String.valueOf(auto.getErstzulassung()));
					}
				}
			}
			
			//Wenn Neu Button gedrueckt wurde
			if (e.getSource().equals(newb)) {
				boolean clear = true;
				//wenn liste leer
				if (autoListe.istLeer()) {
					//Erstes Element wird gesetzt, dadurch wird die Liste nicht-leer
					autoIterator.einfuegenElement(new Auto());
				}
				//wenn liste nicht leer
				else {
					try {
						//Eingaben werden eingelesen
						int zulassung = Integer.parseInt(zulassungText.getText());
						//Eingaben werden in ein Auto verwandelt
						Auto a = new Auto(nameText.getText(), zulassung);
						//Eigenschaften werden ins aktuelle Auto gesetzt
						autoIterator.setzenAktuellesElement(a);
						//Hier wird das neue Element eingefuegt
						autoIterator.einfuegenElement(new Auto());
						//bei ungueltigen Eingaben
					} catch (NumberFormatException err) {
						//Fehlermeldung an Benutzer
						JOptionPane.showMessageDialog(
								AutoListeGUI.this,
								"Bitte geben sie einen gültigen Wert für Erstzulassung ein!",
								"Ungültige Eingabe",
								JOptionPane.ERROR_MESSAGE);
						clear = false;
					}
				}
				//Wenn keine Falscheingaben, werden die Inhalte der Textfelder gelöscht
				if (clear) {
					nameText.setText("");
					zulassungText.setText("");
				}
			}
			
			//Wenn Löschen Knopf gedruekt wurde
			if (e.getSource().equals(deleteb)) {
				//wenn liste leer
				if (autoListe.istLeer()) {
					//Fehlermeldung an Benutzer
					JOptionPane.showMessageDialog(
							AutoListeGUI.this,
							"Löschen nicht möglich:\nListe ist leer",
							"Liste leer",
							JOptionPane.ERROR_MESSAGE);
				}
				//wenn liste nicht leer
				else {
					//aktuelles Element wird gelöscht
					autoIterator.loeschenAktuellesElement();
					//Textfelder werden gelöscht
					nameText.setText("");
					zulassungText.setText("");
					//Wenn Liste nach löschen leer
					if (autoListe.istLeer()) {
						//Info-Meldung an Benutzer
						JOptionPane.showMessageDialog(
								AutoListeGUI.this,
								"Die Liste ist jetzt leer",
								"Liste leer",
								JOptionPane.INFORMATION_MESSAGE);
					}
					//Wenn Liste nach löschen nicht leer
					else {
						//naechstes Auto wird geholt
						Auto auto = (Auto) autoIterator.naechstesElement();
						//Ist dieses null, sind wir am ende der liste und wir holen uns das erste Element
						if (auto == null) {
							//Meldung an Benutzer
							JOptionPane.showMessageDialog(
									AutoListeGUI.this,
									"Sie haben das Ende der Liste erreicht!",
									"Ende der Liste",
									JOptionPane.INFORMATION_MESSAGE);
							//erstes Element
							auto = (Auto)autoIterator.naechstesElement();
						}
						//Ausgabe der Eigenschaften des Autos
						nameText.setText(auto.getName());
						zulassungText.setText(String.valueOf(auto.getErstzulassung()));
					}
				}
			}
		}
	}
}