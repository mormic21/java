package net.tfobz.vokabeltrainer.guis;
import java.awt.*;
import java.awt.event.*;
import net.sourceforge.jdatepicker.impl.*;
import net.tfobz.vokabeltrainer.model.*;

import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Edit-GUI
 * realisiert ein Fenster zum Bearbeiten einer Lernkartei
 * erbt von JDialog
 * 
 * @author Michael Morandell - Elija Innerkofler
 * @version 1.5 - Erinnerungsintervall kann gesetzt werden
 */
public class EditGUI extends JDialog {

	// Membervariablen
	private int anzahlFaecher = VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).size();
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

	public EditGUI(JFrame owner) {

		// Setzen des modalen Fensters
		super(owner);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
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
		
		//intervallspinner
		SpinnerModel value2 = new SpinnerNumberModel(1, 0, 2000, 1);
		intervallSpinner = new JSpinner(value2);
		intervallSpinner.setValue(VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().
					get(MainGUI.getAct_index()).getNummer()).get((int)faecherSpinner.getValue()-1).getErinnerungsIntervall());
		intervallSpinner.setBounds(440, 394, 70, 30);
		intervallSpinner.setFont(Variables.DEFAULT_FONT);
		intervallSpinner.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(intervallSpinner);
		
		//save-Button
		save = new JButton();
		save.setBounds(550, 391, 120, 36);
		save.setText("Speichern");
		save.setFont(Variables.DEFAULT_FONT);
		save.setBorder(Variables.ROUNDED_BORDER);
		save.setForeground(Color.BLACK);
		save.setBackground(Variables.DEFAULT_COLOR);
		save.addMouseListener(Variables.MOUSEABHOERER);
		save.addActionListener(a);
		this.getContentPane().add(save);
		
		
		// Datepicker
//		UtilDateModel model = new UtilDateModel();
//		JDatePanelImpl datePanel = new JDatePanelImpl(model);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
//		datePicker.setBounds(450, 395, 200, 28);
//		datePicker.setBorder(Variables.TEXTFIELD_BORDER);
//		this.getContentPane().add(datePicker);

		// Border 2
		border2 = new JPanel();
		TitledBorder border2Title = new TitledBorder(new LineBorder(Color.black, 1), "Erinnerungsdatum");
		border2Title.setTitleFont(Variables.SUBTITLE_FONT);
		border2.setBorder(border2Title);
		border2.setBounds(45, 330, 660, 150);
		this.getContentPane().add(border2);

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
		change = new JButton();
		change.setBounds(375, 505, 150, 35);
		change.setText("Ändern");
		change.setBorder(Variables.ROUNDED_BORDER);
		change.setForeground(Color.BLACK);
		change.setBackground(Variables.DEFAULT_COLOR);
		change.setFont(Variables.DEFAULT_FONT);
		change.addActionListener(a);
		change.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(change);

	}
	
	/**
	 * Hoert auf Aenderungen im Spinner
	 * implementiert CangeListener
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
			if ((int)faecherSpinner.getValue()-1 < anzahlFaecher) {
				intervallSpinner.setValue(VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().
						get(MainGUI.getAct_index()).getNummer()).get((int)faecherSpinner.getValue()-1).getErinnerungsIntervall());
			}
		}
	}
	
	
	/**
	 * Wenn aufgerufen, wird ermittelt welcher Knopf gedrückt wurde und die
	 * jeweilige Funktion ausgeführt
	 */
	private class EditListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Abbrechen-Button
			if (e.getSource().equals(back)) {
				setVisible(false);
			}
			//save-Button
			if (e.getSource().equals(save)) {
				int fachnummer = VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer()).
						get((int)faecherSpinner.getValue()-1).getNummer();
				Fach f = new Fach(fachnummer, String.valueOf(fachnummer), (int)intervallSpinner.getValue(), VokabeltrainerDB.getDateOneDayBeforeToday());
				int ret = VokabeltrainerDB.aendernFach(f);
				System.out.println(ret);
			}
			//Edit-Button
			if (e.getSource().equals(change)) {
				//neue Lernkartei mit der Nummer der alten Lernkartei
				Lernkartei lk = new Lernkartei(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer(), 
						text1.getText(), 
						text2.getText(), 
						text3.getText(), 
						true, 
						true
				);
				//neue Lernkartei ersetzt die alte
				int ret = VokabeltrainerDB.aendernLernkartei(lk);
				//Wenn aendernLernkartei -2 zurueck gibt, so wurde eine Eigenschaft nicht richtig eingegeben
				if (ret == -2) {
					//Fehlermeldung wird geholt
					Enumeration<String> errors = lk.getFehler().keys();
					String errorOutput = "Bitte geben Sie folgende Daten ein:  \n\n";
					while (errors.hasMoreElements()) {
						errorOutput = errorOutput + " - "+errors.nextElement().toString() + "\n";
					}
					errorOutput = errorOutput + "\n";
					//Fehlerdialog wird angezeigt
					JOptionPane.showMessageDialog(EditGUI.this, errorOutput, "Fehler!", JOptionPane.ERROR_MESSAGE);
				}
				if (ret == 0) {
					setVisible(false);
				}
			}
		}
	}
}