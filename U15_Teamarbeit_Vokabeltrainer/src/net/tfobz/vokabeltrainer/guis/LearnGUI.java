package net.tfobz.vokabeltrainer.guis;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import net.tfobz.vokabeltrainer.model.*;

/**
 * LearnGUI 
 * realisiert eine GUI, die das Lernen der Lernkarten ermoeglicht 
 * erbt von JDialog
 * @author Michael Morandell, Elija Innerkofler
 * @version 1.7 - Final Version
 */
@SuppressWarnings("serial")
public class LearnGUI extends JDialog {

	// Membervariablen
	private JLabel question = null;
	private JLabel description = null;
	private JLabel answer = null;
	private JTextField text = null;
	private JLabel status = null;
	private JButton back = null;
	private JButton next = null;
	private JButton check = null;

	// Private Backend-Variablen
	private Karte act_karte = null;
	private int fachIndex = 0;

	// Public Backend-Variablen
	public static boolean grossklein = false;
	public static boolean richtung = false;

	/**
	 * LearnGUI-Konstruktor
	 * @param owner
	 */
	public LearnGUI(JFrame owner) {
		super(owner);
		//hide on close
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
		//modaler Dialog
		this.setModal(true);
		this.setResizable(false);
		//Titel
		this.setTitle("Lernen: " + VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getBeschreibung());
		this.getContentPane().setLayout(null);

		// Frage
		question = new JLabel();
		question.setBounds(45, 35, 660, 30);
		//Je nach Lernrichtung Beschreibung 1 oder 2
		if (richtung) {
			question.setText(
					VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung() + ":");
		} else {
			question.setText(
					VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung() + ":");
		}
		question.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(question);

		// Beschreibung
		description = new JLabel();
		description.setBounds(45, 95, 660, 25);
		//zum naechsten fach gehen
		while (VokabeltrainerDB
				.getZufaelligeKarte(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(),
						VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
								.get(fachIndex).getNummer()) == null) {
			fachIndex++;
		}
		act_karte = VokabeltrainerDB
				.getZufaelligeKarte(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(),
						VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
								.get(fachIndex).getNummer());
		// wort wird ausgegeben
		if (richtung) {
			description.setText(act_karte.getWortEins());
		} else {
			description.setText(act_karte.getWortZwei());
		}

		description.setFont(Variables.SUBTITLE_FONT);
		this.getContentPane().add(description);

		// Frage
		answer = new JLabel();
		answer.setBounds(45, 200, 660, 30);
		//Je nach Lernrichtung Beschreibung 1 oder 2
		if (richtung) {
			answer.setText(
					VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung() + ":");
		} else {
			answer.setText(
					VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung() + ":");
		}
		//Font
		answer.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(answer);

		// Eingabefeld
		text = new JTextField();
		text.setBounds(45, 260, 660, 30);
		text.setFont(Variables.DEFAULT_FONT);
		text.setBorder(Variables.TEXTFIELD_BORDER);
		// text in Textfield wird grau, wenn es disabeld ist
		text.setDisabledTextColor(Color.GRAY);
		this.getContentPane().add(text);

		// Status-Anzeige
		status = new JLabel();
		status.setBounds(45, 380, this.getWidth(), 30);
		status.setFont(Variables.TITLE_FONT);
		status.setText("Bitte geben Sie die Antwort in das Textfeld ein!");
		this.getContentPane().add(status);

		// Buttons
		ButtonListener a = new ButtonListener();

		// Zurueck Knopf
		back = new JButton();
		back.setBounds(50, 490, 150, 35);
		back.setText("Abbrechen");
		back.setBorder(Variables.ROUNDED_BORDER);
		back.setForeground(Color.BLACK);
		back.setBackground(Variables.DEFAULT_COLOR);
		back.setFont(Variables.DEFAULT_FONT);
		back.addActionListener(a);
		back.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(back);

		// Ueberpruefen Knopf
		check = new JButton();
		check.setBounds(420, 490, 150, 35);
		check.setText("Überprüfen");
		check.setBorder(Variables.ROUNDED_BORDER);
		check.setForeground(Color.BLACK);
		check.setBackground(Variables.DEFAULT_COLOR);
		check.setFont(Variables.DEFAULT_FONT);
		check.addActionListener(a);
		check.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(check);

		// Weiter Knopf
		next = new JButton();
		next.setBounds(600, 490, 75, 35);
		next.setText("Weiter");
		next.setBorder(Variables.ROUNDED_BORDER);
		next.setForeground(Color.BLACK);
		next.setBackground(Variables.DEFAULT_COLOR);
		next.setFont(Variables.DEFAULT_FONT);
		next.addActionListener(a);
		next.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(next);
		this.getRootPane().setDefaultButton(check);
		next.setEnabled(false);
	}

	/**
	 * ButtonListener 
	 * realisiert einen Listener fuer die Buttons der GUI
	 * implementiert ActionListener
	 * @author Michael Morandell, Elija Innerkofler
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// wenn zureck -> dann zureck zur Home-Seite
			if (e.getSource().equals(back)) {
				setVisible(false);
			}
			// Ueberpruefen
			if (e.getSource().equals(check)) {
				// set Gelernt Am in Fach
				// VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).get(0).setGelerntAm(gelerntAm);
				// textfeld wird disabeld
				text.setEnabled(false);
				text.setFont(Variables.DEFAULT_FONT);
				// es wird geschaut ob antwort richtig its
				act_karte = new Karte(act_karte.getNummer(), act_karte.getWortEins(), act_karte.getWortZwei(), richtung,
						grossklein);
				if (act_karte.getRichtig(text.getText())) {
					// antwort richtig
					status.setText("Ihre Antwort ist Richtig! :)");
					status.setForeground(new Color(0, 163, 19));
					// Karte wird als richtig markiert
					VokabeltrainerDB.setKarteRichtig(act_karte);
				} else {
					String richtigesWort = null;
					if (richtung) {
						richtigesWort = act_karte.getWortZwei();
					} else {
						richtigesWort = act_karte.getWortEins();
					}
					// antwort falsch
					status.setText("Ihre Antwort war leider falsch! Richtige Antwort: " + richtigesWort);
					status.setForeground(new Color(173, 25, 5));
					// Karte wird als falsch makiert
					VokabeltrainerDB.setKarteFalsch(act_karte);
				}
				// default button
				getRootPane().setDefaultButton(next);
				check.setEnabled(false);
				next.setEnabled(true);
			}
			// Wenn Next-Button gedrueckt wurde
			if (e.getSource().equals(next)) {
				// neue zufaellige Karte wird geholt
				boolean abgelaufen = false;
				//in andere Faecher wechseln
				for (int i = 0; i < VokabeltrainerDB
						.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
						.size(); i++) {
					if (VokabeltrainerDB
							.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
							.get(i).getErinnerungFaellig()) {
						abgelaufen = true;
						fachIndex = i;
					}
					if (VokabeltrainerDB
							.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
							.get(i).getErinnerungsIntervall() == 0) {
						abgelaufen = true;
						fachIndex = i;
					}
					//wenn noch nicht abgelaufen
					if (abgelaufen
							&& VokabeltrainerDB.getZufaelligeKarte(
									VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(),
									VokabeltrainerDB.getFaecher(
											VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
											.get(fachIndex).getNummer()) != null) {
						break;
					} else {
						abgelaufen = false;
					}
				}
				if (!abgelaufen) {
					fachIndex = 0;
					boolean nextfach = false;
					while (VokabeltrainerDB.getZufaelligeKarte(
							VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(),
							VokabeltrainerDB
									.getFaecher(
											VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
									.get(fachIndex).getNummer()) == null) {
						nextfach = true;
						fachIndex++;
					}
					//Wen Meldung schon mal an Benutzer ausgegeben und akzeptiert wurde
					if (!MainGUI.expiredgui.isDialogApproved() && nextfach) {
						//ansonsten erfolgt Meldung
						DateExpiredGUI expiredgui = new DateExpiredGUI(MainGUI.owner);
						expiredgui.setVisible(true);
						if (!expiredgui.isDialogApproved()) {
							expiredgui.dispose();
							setVisible(false);
						}
					}
				}
				//neue zufaellige Karte
				act_karte = VokabeltrainerDB.getZufaelligeKarte(
						VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(),
						VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
								.get(fachIndex).getNummer());
				// ausgabe der neuen Karte ja nach richtung
				if (richtung) {
					description.setText(act_karte.getWortEins());
				} else {
					description.setText(act_karte.getWortZwei());
				}
				status.setText("Bitte geben Sie die Antwort in das Textfeld ein!");
				status.setForeground(Color.BLACK);
				// Buttons werden wieder richtig gestellt
				text.setText(null);
				text.setEnabled(true);
				check.setEnabled(true);
				//default-Button
				getRootPane().setDefaultButton(check);
				next.setEnabled(false);
			}
		}
	}
}
