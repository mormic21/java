package net.tfobz.vokabeltrainer.guis;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.tfobz.vokabeltrainer.model.VokabeltrainerDB;

/**
 * LearnSettingsGUI
 * realisiert eine GUI, welche Einstellungen fuer das Lernen ermoeglicht
 * @author Michael Morandell, Elija Innerkofler
 * @version 1.2 - Settings funktionieren jetzt
 */
public class LearnSettingsGUI extends JDialog {
	//Membervariablen
	private JLabel title = null;
	private JCheckBox [] boxes = null;
	private JButton ok = null;
	private JButton no = null;
	private boolean dialogApproved = false;
	
	/**
	 * LearnSettingsGUI - Konstruktor
	 * @param owner, JFrame
	 */
	public LearnSettingsGUI(JFrame owner) {
		super(owner);
		// Setzen des Fensters
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		int height = 400;
		int width = 550;
		this.setBounds(owner.getX() + ((owner.getWidth() - width) / 2),
				owner.getY() + ((owner.getHeight() - height) / 2), width, height);
		this.setTitle("Vokabeltrainer: ");
		this.setResizable(false);
		this.setModal(true);
		
		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);
	
		// Titel
		title = new JLabel();
		title.setBounds(50, 35, 400, 30);
		title.setText("Einstellungen f¸rs Lernen");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);
		
		//Checkboxes
		boxes = new JCheckBox[3];
		
		//Lernrichtung 1
		boxes[0] = new JCheckBox();
		boxes[0].setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung()
				+ " -> "+VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung());
		boxes[0].setFont(Variables.DEFAULT_FONT);
		boxes[0].setBounds(70, 120, 400, 30);
		this.getContentPane().add(boxes[0]);
		
		//Lernrichtung 2
		boxes[1] = new JCheckBox();
		boxes[1].setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung()
				+ " -> "+VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung());
		boxes[1].setFont(Variables.DEFAULT_FONT);
		boxes[1].setBounds(70, 160, 400, 30);
		this.getContentPane().add(boxes[1]);
		
		//Gross/Kleinschreibung
		boxes[2] = new JCheckBox();
		boxes[2].setText("Groﬂ-/Kleinschreibung beachten");
		boxes[2].setFont(Variables.DEFAULT_FONT);
		boxes[2].setBounds(70, 200, 400, 30);
		this.getContentPane().add(boxes[2]);
		
		// Ok Knopf
		ok = new JButton();
		ok.setBounds(160, 290, 150, 35);
		ok.setText("Lernen");
		ok.setBorder(Variables.ROUNDED_BORDER);
		ok.setForeground(Color.BLACK);
		ok.setBackground(Variables.DEFAULT_COLOR);
		ok.setFont(Variables.DEFAULT_FONT);
		ok.addActionListener(new ButtonListener());
		ok.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(ok);
				
		// Abbrechen Knopf
		no = new JButton();
		no.setBounds(340, 290, 150, 35);
		no.setText("Abbrechen");
		no.setBorder(Variables.ROUNDED_BORDER);
		no.setForeground(Color.BLACK);
		no.setBackground(Variables.DEFAULT_COLOR);
		no.setFont(Variables.DEFAULT_FONT);
		no.addActionListener(new ButtonListener());
		no.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(no);
	}

	/**
	 * @return the dialogApproved
	 */
	public boolean isDialogApproved() {
		return dialogApproved;
	}

	/**
	 * @param dialogApproved the dialogApproved to set
	 */
	public void setDialogApproved(boolean dialogApproved) {
		this.dialogApproved = dialogApproved;
	}

	/**
	 * ButtonListener
	 * reagiert auf das Druecken der Knoepfe "OK" und "Abbrechen"
	 * @author Michael Morandell, , Elija Innerkofler
	 * implementiert ActionListener
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Wenn Button "OK" gedrueckt wurde
			if (e.getSource().equals(ok)) {
				LearnGUI.grossklein = boxes[2].isSelected();
				LearnGUI.richtung = boxes[0].isSelected();
				setDialogApproved(true);
				setVisible(false);
			}
			//Wenn Button "Abbrechen" gedrueckt wurde
			if (e.getSource().equals(no)) {
				setDialogApproved(false);
				setVisible(false);
			}
		}
	}
}
