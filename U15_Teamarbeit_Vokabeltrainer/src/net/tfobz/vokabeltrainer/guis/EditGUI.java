package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import net.tfobz.vokabeltrainer.model.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * Edit-GUI realisiert ein Fenster zum Bearbeiten einer Lernkartei 
 * erbt von JDialog
 * @author Michael Morandell - Elija Innerkofler
 * @version 1.9 - Final Version
 */
@SuppressWarnings("serial")
public class EditGUI extends JDialog {

	// Membervariablen
	private JLabel title = null;
	private JLabel description = null;
	private JTextField text1 = null;
	private JPanel border1 = null;
	private JLabel first = null;
	private JTextField text2 = null;
	private JLabel second = null;
	private JTextField text3 = null;
	private JButton back = null;
	private JButton change = null;
	private JLabel fach = null;
	private JSpinner faecherSpinner = null;
	private JSpinner intervallSpinner = null;
	private JPanel border2 = null;
	private JLabel date = null;
	private JButton save = null;
	private JButton delete = null;

	// private Backend-Variable
	private int anzahlFaecher = VokabeltrainerDB
			.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).size();

	/**
	 * EditGUI-Konstruktor
	 * @param owner, JFrame
	 */
	public EditGUI(JFrame owner) {
		// Setzen Fensters
		super(owner);
		//Hide on Close
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
		//Modaler Dialog
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Vokabeltrainer: Lernkartei bearbeiten");

		// Ausschalten des Layoutmanagers
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		EditListener a = new EditListener();

		// Titel
		title = new JLabel();
		title.setBounds(45, 35, 300, 30);
		title.setText("Lernkartei bearbeiten");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Beschreibung
		description = new JLabel();
		description.setBounds(45, 95, 200, 25);
		description.setText("Beschreibung:");
		description.setFont(Variables.SUBTITLE_FONT);
		this.getContentPane().add(description);

		// Erstes Textfeld
		text1 = new JTextField();
		text1.setBounds(190, 95, 508, 30);
		//Beschreibung der Lernkartei
		text1.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getBeschreibung());
		text1.setFont(Variables.DEFAULT_FONT);
		text1.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text1);

		// Erste Wortbeschreibung
		first = new JLabel();
		first.setBounds(65, 193, 210, 20);
		first.setFont(Variables.DEFAULT_FONT);
		first.setText("Beschreibung erstes Wort:");
		this.getContentPane().add(first);

		// Zweites Textfeld
		text2 = new JTextField();
		text2.setBounds(280, 189, 400, 30);
		//Beschreibung des ersten Wortes
		text2.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung());
		text2.setFont(Variables.DEFAULT_FONT);
		text2.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text2);

		// Zweite Wortbeschreibung
		second = new JLabel();
		second.setBounds(65, 247, 210, 20);
		second.setFont(Variables.DEFAULT_FONT);
		second.setText("Beschreibung zweites Wort:");
		this.getContentPane().add(second);

		// Drittes Textfeld
		text3 = new JTextField();
		text3.setBounds(280, 243, 400, 30);
		//Beschreibung des zweiten Wortes
		text3.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung());
		text3.setFont(Variables.DEFAULT_FONT);
		text3.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text3);

		// Border 1
		border1 = new JPanel();
		TitledBorder border1Title = new TitledBorder(new LineBorder(Color.black, 1), "Wort");
		border1Title.setTitleFont(Variables.SUBTITLE_FONT);
		border1.setBorder(border1Title);
		border1.setBounds(45, 150, 660, 150);
		this.getContentPane().add(border1);

		// Fach
		fach = new JLabel();
		fach.setBounds(65, 395, 50, 25);
		fach.setFont(Variables.SUBTITLE_FONT);
		fach.setText("Fach:");
		this.getContentPane().add(fach);

		// Spinner
		SpinnerModel value = new SpinnerNumberModel(1, 1, anzahlFaecher, 1);
		faecherSpinner = new JSpinner(value);
		//Font
		faecherSpinner.setBounds(125, 394, 70, 30);
		faecherSpinner.setFont(Variables.DEFAULT_FONT);
		faecherSpinner.setBorder(Variables.TEXTFIELD_BORDER);
		faecherSpinner.addChangeListener(new UpdateListener());
		this.getContentPane().add(faecherSpinner);

		// Datum
		date = new JLabel();
		date.setBounds(240, 395, 190, 25);
		date.setFont(Variables.SUBTITLE_FONT);
		date.setText("Tage bis Erinnerung:");
		this.getContentPane().add(date);

		// Intervallspinner
		SpinnerModel value2 = new SpinnerNumberModel(1, 0, 2000, 1);
		intervallSpinner = new JSpinner(value2);
		//Intervall wird aus dem jeweiligen Fach geholt und gesetzt
		intervallSpinner.setValue(
				VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
						.get((int) faecherSpinner.getValue() - 1).getErinnerungsIntervall());
		//Font
		intervallSpinner.setBounds(440, 394, 70, 30);
		intervallSpinner.setFont(Variables.DEFAULT_FONT);
		intervallSpinner.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(intervallSpinner);

		// Save-Button
		save = new JButton();
		save.setBounds(550, 391, 120, 36);
		save.setText("Speichern");
		//Font
		save.setFont(Variables.DEFAULT_FONT);
		save.setBorder(Variables.ROUNDED_BORDER);
		save.setForeground(Color.BLACK);
		save.setBackground(Variables.DEFAULT_COLOR);
		//Listener
		save.addMouseListener(Variables.MOUSEABHOERER);
		save.addActionListener(a);
		this.getContentPane().add(save);

		// Border 2
		border2 = new JPanel();
		TitledBorder border2Title = new TitledBorder(new LineBorder(Color.black, 1), "Erinnerungsdatum");
		border2Title.setTitleFont(Variables.SUBTITLE_FONT);
		border2.setBorder(border2Title);
		border2.setBounds(45, 330, 660, 150);
		this.getContentPane().add(border2);

		// Delete
		delete = new JButton();
		delete.setBounds(55, 505, 150, 35);
		delete.setText("Löschen");
		//Font
		delete.setBorder(Variables.ROUNDED_BORDER);
		delete.setForeground(Color.BLACK);
		delete.setBackground(Variables.DEFAULT_COLOR);
		delete.setFont(Variables.DEFAULT_FONT);
		//Listener
		delete.addActionListener(a);
		delete.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(delete);

		// Abbrechen Knopf
		back = new JButton();
		back.setBounds(553, 505, 150, 35);
		back.setText("Abbrechen");
		//Font
		back.setBorder(Variables.ROUNDED_BORDER);
		back.setForeground(Color.BLACK);
		back.setBackground(Variables.DEFAULT_COLOR);
		back.setFont(Variables.DEFAULT_FONT);
		//Listener
		back.addActionListener(a);
		back.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(back);

		// Ändern Knopf
		change = new JButton();
		change.setBounds(375, 505, 150, 35);
		change.setText("Ändern");
		//Font
		change.setBorder(Variables.ROUNDED_BORDER);
		change.setForeground(Color.BLACK);
		change.setBackground(Variables.DEFAULT_COLOR);
		change.setFont(Variables.DEFAULT_FONT);
		//Listener
		change.addActionListener(a);
		change.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(change);

		// Default-Button
		this.getRootPane().setDefaultButton(change);

	}
	/**
	 * Hört auf Aenderungen im Spinner
	 * implementiert ChangeListener
	 * @author Michael Morandell, Elija Innerkofler
	 *
	 */
	private class UpdateListener implements ChangeListener {
		/**
		 * stateChanged
		 * @param e, ChangeEvent
		 */
		@Override
		public void stateChanged(ChangeEvent e) {
			//solange im sinnvollen Bereich
			if ((int) faecherSpinner.getValue() - 1 < anzahlFaecher) {
				//Intervall-Spinner
				intervallSpinner.setValue(VokabeltrainerDB
						.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
						.get((int) faecherSpinner.getValue() - 1).getErinnerungsIntervall());
			}
		}
	}

	/**
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt 
	 * implements ActionListener
	 * @author Michael Morandell, Elija Innerkofler
	 */
	private class EditListener implements ActionListener {
		/**
		 * actionPerfored
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Abbrechen-Knopf
			if (e.getSource().equals(back)) {
				setVisible(false);
			}
			// Löschen-Knopf
			if (e.getSource().equals(delete)) {
				//Abfrage
				if (JOptionPane.showConfirmDialog(EditGUI.this, "Wollen Sie diese Lernkartei wirklich löschen?",
						"Achtung!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					//Rückgabe
					int ret = VokabeltrainerDB.loeschenLernkartei(
							VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer());
					// Datenbankfehler
					if (ret == -1) {
						JOptionPane.showMessageDialog(EditGUI.this, "Ein Datenbankfehler ist aufgetreten", "Fehler!",
								JOptionPane.ERROR_MESSAGE);
					}
					// Kein Fehler
					if (ret == 0) {
						MainGUI.setAct_index(0);
						setVisible(false);
					}
				}
			}
			// Speichern-Knopf
			if (e.getSource().equals(save)) {
				// Speichern der Fachnummer
				int fachnummer = VokabeltrainerDB
						.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
						.get((int) faecherSpinner.getValue() - 1).getNummer();
				// Neues Fach erstellen
				Fach f = new Fach(fachnummer, String.valueOf(fachnummer), (int) intervallSpinner.getValue(),
						new Date());
				// Rückgabewert
				int ret = VokabeltrainerDB.aendernFach(f);
				switch (ret) {
					// Datenbankfehler
					case -1: {
						JOptionPane.showMessageDialog(EditGUI.this,
								"Dieses Fach exsistiert nicht in der Datenbank oder ein Datenbankfehler ist aufgetreten",
								"Fehler!", JOptionPane.ERROR_MESSAGE);
						break;
					}
					// Validierungsfehler
					case -2: {
						JOptionPane.showMessageDialog(EditGUI.this, "Es ist ein Validierungsfehler aufgetreten", "Fehler!",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
					// Kein Fehler
					case 0: {
						JOptionPane.showMessageDialog(EditGUI.this, "Intervall wurde erfolgreich abgespeichert",
								"Aktion erfolgreich", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			}
			// Bearbeiten-Button
			if (e.getSource().equals(change)) {
				// neue Lernkartei mit der Nummer der alten Lernkartei
				Lernkartei lk = new Lernkartei(
						VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(), text1.getText(),
						text2.getText(), text3.getText(), true, true);
				// neue Lernkartei ersetzt die alte
				int ret = VokabeltrainerDB.aendernLernkartei(lk);
				// Wenn aendernLernkartei -2 zurueck gibt, so wurde eine Eigenschaft nicht
				// richtig eingegeben
				if (ret == -2) {
					JOptionPane.showMessageDialog(EditGUI.this,
							"Validierungsfehler oder diese Lernkartei exsistiert bereits", "Fehler!",
							JOptionPane.ERROR_MESSAGE);
				}
				// Lernkartei existiert nicht oder Datenbankfehler
				if (ret == -1) {
					JOptionPane.showMessageDialog(EditGUI.this,
							"Lernkartei exsistiert nicht in Datenbank oder Datenbankfehler", "Fehler!",
							JOptionPane.ERROR_MESSAGE);
				}
				// Kein Fehler
				if (ret == 0) {
					setVisible(false);
				}
			}
		}
	}
}