package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.border.*;
import net.tfobz.vokabeltrainer.model.*;

/**
 * Create-GUI realisiert ein Fenster zum erstellen einer Lernkartei erbt von
 * JDialog
 * 
 * @author Michael Morandel - Elija Innerkofler
 * @version 1.4 - Erinnerungintervall default auf 0
 */
@SuppressWarnings("serial")
public class CreateGUI extends JDialog {

	private JLabel title = null;
	private JLabel description = null;
	private JTextField text1 = null;
	private JPanel border1 = null;
	private JLabel first = null;
	private JTextField text2 = null;
	private JLabel second = null;
	private JTextField text3 = null;
	private JLabel fach = null;
	private JSpinner spinner = null;
	private JButton back = null;
	private JButton create = null;

	public CreateGUI(JFrame owner) {

		// Setzen des Fensters
		super(owner);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Vokabeltrainer: Lernkartei erstellen");

		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		ButtonListener a = new ButtonListener();

		// Titel
		title = new JLabel();
		title.setBounds(45, 35, 300, 30);
		title.setText("Lernkartei erstellen");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Beschreibung
		description = new JLabel();
		description.setBounds(45, 100, 300, 25);
		description.setText("Beschreibung der Lernkartei:");
		description.setFont(Variables.SUBTITLE_FONT);
		this.getContentPane().add(description);

		// Erstes Textfeld
		text1 = new JTextField();
		text1.setBounds(45, 140, 468, 30);
		text1.setFont(Variables.DEFAULT_FONT);
		text1.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text1);

		// Erste Wortbeschreibung
		first = new JLabel();
		first.setBounds(65, 252, 210, 20);
		first.setFont(Variables.DEFAULT_FONT);
		first.setText("Beschreibung erstes Wort:");
		this.getContentPane().add(first);

		// Zweites Textfeld
		text2 = new JTextField();
		text2.setBounds(280, 249, 400, 30);
		text2.setFont(Variables.DEFAULT_FONT);
		text2.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text2);

		// Zweite Wortbeschreibung
		second = new JLabel();
		second.setBounds(65, 307, 210, 20);
		second.setFont(Variables.DEFAULT_FONT);
		second.setText("Beschreibung zweites Wort:");
		this.getContentPane().add(second);

		// Drittes Textfeld
		text3 = new JTextField();
		text3.setBounds(280, 303, 400, 30);
		text3.setFont(Variables.DEFAULT_FONT);
		text3.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(text3);

		// Border 1
		border1 = new JPanel();
		TitledBorder border1Title = new TitledBorder(new LineBorder(Color.black, 1), "Wort");
		border1Title.setTitleFont(Variables.SUBTITLE_FONT);
		border1.setBorder(border1Title);
		border1.setBounds(45, 210, 660, 150);
		this.getContentPane().add(border1);

		// Fach
		fach = new JLabel();
		fach.setBounds(45, 400, 400, 30);
		fach.setFont(Variables.SUBTITLE_FONT);
		fach.setText("Wie viele Fächer soll die Lernkartei haben?");
		this.getContentPane().add(fach);

		// Spinner
		SpinnerModel value = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		spinner = new JSpinner(value);
		spinner.setBounds(45, 440, 70, 30);
		spinner.setFont(Variables.DEFAULT_FONT);
		spinner.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(spinner);

		// Abbrechen Knopf
		back = new JButton();
		back.setBounds(553, 505, 150, 35);
		back.setText("Abbrechen");
		back.setBorder(Variables.ROUNDED_BORDER);
		back.setForeground(Color.BLACK);
		back.setBackground(Variables.DEFAULT_COLOR);
		back.setFont(Variables.DEFAULT_FONT);
		back.addActionListener(a);
		back.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(back);

		// Ändern Knopf
		create = new JButton();
		create.setBounds(375, 505, 150, 35);
		create.setText("Erstellen");
		create.setBorder(Variables.ROUNDED_BORDER);
		create.setForeground(Color.BLACK);
		create.setBackground(Variables.DEFAULT_COLOR);
		create.setFont(Variables.DEFAULT_FONT);
		create.addActionListener(a);
		create.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(create);

	}

	/**
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			//Abbrechen-Button
			if (evt.getSource().equals(back)) {
				setVisible(false);
			}
			//Create-Button
			if (evt.getSource().equals(create)) {
				Lernkartei lk = new Lernkartei(text1.getText(), text2.getText(), text3.getText(), true, true);
				int ret = VokabeltrainerDB.hinzufuegenLernkartei(lk);
				if (ret == -2) {
					//Fehlermeldung wird geholt
					Enumeration<String> errors = lk.getFehler().keys();
					String errorOutput = "Bitte geben Sie folgende Daten ein:  \n\n";
					while (errors.hasMoreElements()) {
						errorOutput = errorOutput + " - "+errors.nextElement().toString() + "\n";
					}
					errorOutput = errorOutput + "\n";
					//Fehlerdialog wird angezeigt
					JOptionPane.showMessageDialog(CreateGUI.this, errorOutput, "Fehler!", JOptionPane.ERROR_MESSAGE);
				}
				if (ret == 0) {
					//Faecher werden geadded
					for (int i = 0; i < (Integer) spinner.getValue(); i++) {
						Fach f = new Fach();
						f.setErinnerungsIntervall(0);
						VokabeltrainerDB.hinzufuegenFach(lk.getNummer(), f);
					}
					MainGUI.setAct_index(VokabeltrainerDB.getLernkarteien().size()-1);
					setVisible(false);
				}
			}
		}
	}
}