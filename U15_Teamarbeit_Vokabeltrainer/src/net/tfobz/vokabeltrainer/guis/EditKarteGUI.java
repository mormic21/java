package net.tfobz.vokabeltrainer.guis;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import net.tfobz.vokabeltrainer.model.*;

/**
 * EditKarte-GUI realisiert ein Fenster zum Bearbeiten der Karten. 
 * Erbt von JDialog
 * @author Michael Morandell, Elija Innerkofler
 * @version 1.3 - Final Version
 *
 */
@SuppressWarnings("serial")
public class EditKarteGUI extends JDialog {

	// Membervariablen
	private JLabel title = null;
	private JLabel first = null;
	private JComboBox<String> jComboBox = null;
	private JLabel second = null;
	private JTextField text3 = null;
	private JButton back = null;
	private JButton change = null;
	private JButton load = null;
	private int selectedIndex = 0;
	private JButton delete = null;
	private List<Karte> lernkarten = new ArrayList<>();

	/**
	 * EditKarteGUI-Konstruktor
	 * @param owner, JFrame
	 */
	public EditKarteGUI(JFrame owner) {
		super(owner);
		//hide on close
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
		//modal
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Vokabeltrainer: Karte bearbeiten");

		// Ausschalten des Layoutmanagers
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		EditListener a = new EditListener();

		// Titel
		title = new JLabel();
		title.setBounds(45, 45, 300, 30);
		title.setText("Karte bearbeiten");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Erste Wortbeschreibung
		first = new JLabel();
		first.setBounds(65, 196, 210, 20);
		first.setFont(Variables.DEFAULT_FONT);
		//erste Beschreibung der Karte
		first.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung() + ":");
		this.getContentPane().add(first);

		// Stringvektor für ComboBox
		Vector<String> stringKarten = new Vector<>();
		//Alle Karten der Lernkartei werden geholt
		for (int i = 0; i < VokabeltrainerDB
				.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).size(); i++) {
			List<Karte> karten = VokabeltrainerDB.getKarten(VokabeltrainerDB
					.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).get(i)
					.getNummer());
			lernkarten.addAll(karten);
			for (int j = 0; j < karten.size(); j++) {
				stringKarten.add(karten.get(j).getWortEins());
			}
		}

		//ComboBox
		jComboBox = new JComboBox<>(stringKarten);
		jComboBox.setBounds(65, 223, 630, 30);
		jComboBox.setFont(Variables.DEFAULT_FONT);
		//erstes Wort wird gesetzt
		jComboBox.setSelectedItem(lernkarten.get(0).getWortEins());
		jComboBox.setEditable(true);
		jComboBox.setSelectedIndex(0);
		//Font
		jComboBox.setBorder(Variables.TEXTFIELD_BORDER);
		jComboBox.setBackground(Variables.DEFAULT_COLOR);
		this.getContentPane().add(jComboBox);

		// Zweite Wortbeschreibung
		second = new JLabel();
		second.setBounds(65, 276, 210, 20);
		second.setFont(Variables.DEFAULT_FONT);
		//Zweite Beschreibung des Wortes wird gesetzt
		second.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung() + ":");
		this.getContentPane().add(second);

		// Drittes Textfeld
		text3 = new JTextField();
		text3.setBounds(65, 302, 630, 30);
		//zweites Wort wird gesetzt
		text3.setText(lernkarten.get(0).getWortZwei());
		text3.setFont(Variables.DEFAULT_FONT);
		text3.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text3);

		// load
		load = new JButton();
		load.setBounds(300, 350, 200, 35);
		load.setText("Laden");
		//Font
		load.setBorder(Variables.ROUNDED_BORDER);
		load.setForeground(Color.BLACK);
		load.setBackground(Variables.DEFAULT_COLOR);
		load.setFont(Variables.DEFAULT_FONT);
		//Listener
		load.addActionListener(a);
		this.getContentPane().add(load);

		// Abbrechen Knopf
		delete = new JButton();
		delete.setBounds(50, 505, 150, 35);
		delete.setText("Karte löschen");
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
		this.getRootPane().setDefaultButton(load);
	}

	/**
	 * EditListener
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt
	 * implementiert ActionListener
	 * @author Michael Morandell, Elija Innerkofler
	 */
	private class EditListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Abbrechen-Knopf
			if (e.getSource().equals(back)) {
				setVisible(false);
			}
			// Laden-Knopf
			if (e.getSource().equals(load)) {
				//texte werden aktualisiert
				try {
					if (jComboBox.getSelectedIndex() >= 0) {
						selectedIndex = jComboBox.getSelectedIndex();
					}
					text3.setText(lernkarten.get(jComboBox.getSelectedIndex()).getWortZwei());
				} catch (ArrayIndexOutOfBoundsException err) {
				}

			}

			// Ändern-Knopf
			if (e.getSource().equals(change)) {
				//neue Karte mit Eigenschaften der alten karte, aber neuem text
				Karte k = new Karte(lernkarten.get(selectedIndex).getNummer(), jComboBox.getSelectedItem().toString(),
						text3.getText(), lernkarten.get(selectedIndex).getRichtung(),
						lernkarten.get(selectedIndex).getGrossKleinschreibung());
				//karte wird geaendert
				int ret = VokabeltrainerDB.aendernKarte(k);
				// Datenbankfehler
				if (ret == -1) {
					JOptionPane.showMessageDialog(EditKarteGUI.this,
							"Diese Karte exsistiert nicht in der Datenbank oder ein Datenbankfehler ist aufgetreten",
							"Fehler!", JOptionPane.ERROR_MESSAGE);
				}
				// Unvollständig
				if (ret == -2) {
					JOptionPane.showMessageDialog(EditKarteGUI.this,
							"Karte ist unvollständig - Bitte geben Sie alle Informationen ein!", "Fehler!",
							JOptionPane.ERROR_MESSAGE);
				}
				// Existiert bereits
				if (ret == -4) {
					JOptionPane.showMessageDialog(EditKarteGUI.this, "Diese Karte exsistiert bereits", "Fehler!",
							JOptionPane.ERROR_MESSAGE);
				}
				// Kein Fehler
				if (ret == 0) {
					setVisible(false);
				}
			}
			// Löschen-Knopf
			if (e.getSource().equals(delete)) {
				//Löschen-Sicherheitsabfrage
				if (JOptionPane.showConfirmDialog(EditKarteGUI.this, "Wollen Sie diese Karte wirklich löschen?",
						"Achtung!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					//Rueckgabe
					int ret = VokabeltrainerDB.loeschenKarte(lernkarten.get(selectedIndex).getNummer());
					//Datenbankfehler
					if (ret == -1) {
						JOptionPane.showMessageDialog(EditKarteGUI.this,
								"Karte konnte nich gefunden werden oder ein Datenbankfehler ist aufgetreten", "Fehler!",
								JOptionPane.ERROR_MESSAGE);
					}
					//Wenn Löschen funktioniert hat
					if (ret == 0) {
						setVisible(false);
					}
				}
			}
		}
	}
}
