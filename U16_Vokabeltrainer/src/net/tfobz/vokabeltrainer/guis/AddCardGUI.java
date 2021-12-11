package net.tfobz.vokabeltrainer.guis;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.tfobz.vokabeltrainer.model.Karte;
import net.tfobz.vokabeltrainer.model.Lernkartei;
import net.tfobz.vokabeltrainer.model.VokabeltrainerDB;

import java.awt.*;
import java.awt.event.*;

/**
 * AddCard-GUI realisiert ein Fenster zum erstellen einer Karte für die
 * Lernkartei 
 * erbt von JDialog
 * @author Michael Morandell - Elija Innerkofler
 * @version 1.2.1 - Knopftext geändert
 * 
 */
public class AddCardGUI extends JDialog {

	private JLabel title = null;
	private JLabel firstDescTitle = null;
	private JLabel firstDesc = null;
	private JLabel firstWord = null;
	private JTextField firstText = null;
	private JPanel border1 = null;
	private JLabel secondDescTitle = null;
	private JLabel secondDesc = null;
	private JLabel secondWord = null;
	private JTextField secondText = null;
	private JPanel border2 = null;
	private JButton back = null;
	private JButton add = null;
	
	//private Backend-Variablen
	private Lernkartei act_lernkartei = null;

	public AddCardGUI(JFrame owner) {

		// Setzen des Fensters
		super(owner);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), owner.getWidth(), owner.getHeight());
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Vokabeltrainer: Karte hinzufügen");

		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		Buttonlistener a = new Buttonlistener();

		// Titel
		title = new JLabel();
		title.setBounds(45, 35, 300, 30);
		title.setText("Neue Karte hinzufügen");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Erster Beschreibungstitel
		firstDescTitle = new JLabel();
		firstDescTitle.setBounds(65, 155, 120, 20);
		firstDescTitle.setFont(Variables.BOLD_FONT);
		firstDescTitle.setText("Beschreibung:");
		this.getContentPane().add(firstDescTitle);

		// Erste Beschreibung
		firstDesc = new JLabel();
		firstDesc.setBounds(190, 155, 500, 20);
		firstDesc.setFont(Variables.DEFAULT_FONT);
		firstDesc.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung());
		this.getContentPane().add(firstDesc);

		// Erstes Wort JLabel
		firstWord = new JLabel();
		firstWord.setBounds(65, 205, 50, 20);
		firstWord.setFont(Variables.BOLD_FONT);
		firstWord.setText("Wort:");
		this.getContentPane().add(firstWord);

		// Erstes Wort JTextField
		firstText = new JTextField();
		firstText.setBounds(130, 202, 550, 30);
		firstText.setFont(Variables.DEFAULT_FONT);
		firstText.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(firstText);

		// Border 1
		border1 = new JPanel();
		TitledBorder border1Title = new TitledBorder(new LineBorder(Color.black, 1), "Erstes Wort");
		border1Title.setTitleFont(Variables.SUBTITLE_FONT);
		border1.setBorder(border1Title);
		border1.setBounds(45, 110, 660, 150);
		this.getContentPane().add(border1);

		// Zweiter Beschreibungstitel
		secondDescTitle = new JLabel();
		secondDescTitle.setBounds(65, 355, 620, 20);
		secondDescTitle.setFont(Variables.BOLD_FONT);
		secondDescTitle.setText("Beschreibung:");
		this.getContentPane().add(secondDescTitle);

		// Zweite Beschreibung
		secondDesc = new JLabel();
		secondDesc.setBounds(190, 355, 500, 20);
		secondDesc.setFont(Variables.DEFAULT_FONT);
		secondDesc.setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung());
		this.getContentPane().add(secondDesc);
		
		// Zweite Wort JLabel
		secondWord = new JLabel();
		secondWord.setBounds(65, 405, 50, 20);
		secondWord.setFont(Variables.BOLD_FONT);
		secondWord.setText("Wort:");
		this.getContentPane().add(secondWord);

		// Zweite Wort JTextField
		secondText = new JTextField();
		secondText.setBounds(130, 402, 550, 30);
		secondText.setFont(Variables.DEFAULT_FONT);
		secondText.setBorder(Variables.TEXTFIELD_BORDER);
		this.getContentPane().add(secondText);

		// Border 2
		border2 = new JPanel();
		TitledBorder border2Title = new TitledBorder(new LineBorder(Color.black, 1), "Zweites Wort");
		border2Title.setTitleFont(Variables.SUBTITLE_FONT);
		border2.setBorder(border2Title);
		border2.setBounds(45, 310, 660, 150);
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
		add = new JButton();
		add.setBounds(375, 505, 150, 35);
		add.setText("Hinzufügen");
		add.setBorder(Variables.ROUNDED_BORDER);
		add.setForeground(Color.BLACK);
		add.setBackground(Variables.DEFAULT_COLOR);
		add.setFont(Variables.DEFAULT_FONT);
		add.addActionListener(a);
		add.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(add);

	}

	/**
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt
	 */
	private class Buttonlistener implements ActionListener {
		
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
			//Add-Button
			if (e.getSource().equals(add)) {
				//aktuelle Lernkartei wird geholt
				act_lernkartei = VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index());
				//neue Karte mit Eigenschaften
				Karte k = new Karte();
				k.setWortEins(firstText.getText());
				k.setWortZwei(secondText.getText());
				//Karte wird geadded
				int ret = VokabeltrainerDB.hinzufuegenKarte(act_lernkartei.getNummer(), k);
				//Rueckgabewert
			    switch(ret) {
			    	case -1: {
			    		//Datenbankfehler
			    		JOptionPane.showMessageDialog(AddCardGUI.this, 
			    				"Ein Datenbankfehler ist aufgetreten", 
			    				"Fehler!", JOptionPane.ERROR_MESSAGE);
			    		break;
			    	}
			    	case -2: {
			    		//Eigenschaften fehlen
			    		JOptionPane.showMessageDialog(AddCardGUI.this, 
			    				"Bitte geben Sie alle nötigen Informationen ein!", 
			    				"Fehler!", JOptionPane.ERROR_MESSAGE);
			    		break;
			    	}
			    	case -5: {
			    		//Karte exsistiert bereits
			    		JOptionPane.showMessageDialog(AddCardGUI.this, 
			    				"Diese Karte exsistiert bereits in dieser Lernkartei!", 
			    				"Fehler!", JOptionPane.ERROR_MESSAGE);
			    		break;
			    	}
			    	case 0: {
			    		//hinzufuegen erfolgreich
			    		setVisible(false);
			    		break;
			    	}
			    }
			}
		}
	}
}