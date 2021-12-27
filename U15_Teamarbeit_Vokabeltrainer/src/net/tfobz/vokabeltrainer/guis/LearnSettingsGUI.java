package net.tfobz.vokabeltrainer.guis;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import net.tfobz.vokabeltrainer.model.VokabeltrainerDB;

/**
 * LearnSettingsGUI 
 * realisiert eine GUI, welche Einstellungen fuer das Lernen ermoeglicht
 * erbt von JDialog
 * @author Michael Morandell, Elija Innerkofler
 * @version 1.5 - Final Version
 */
@SuppressWarnings("serial")
public class LearnSettingsGUI extends JDialog {

	// Membervariablen
	private JLabel title = null;
	private JCheckBox[] boxes = null;
	private JRadioButton[] rbutton = null;
	private JButton ok = null;
	private JButton no = null;
	private boolean dialogApproved = false;

	/**
	 * LearnSettingsGUI - Konstruktor
	 * @param owner, JFrame
	 */
	public LearnSettingsGUI(JFrame owner) {
		super(owner);
		//hide on close
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		int height = 400;
		int width = 550;
		this.setBounds(owner.getX() + ((owner.getWidth() - width) / 2),
				owner.getY() + ((owner.getHeight() - height) / 2), width, height);
		//titel
		this.setTitle("Vokabeltrainer: Lernen/Einstellungen");
		this.setResizable(false);
		//modaler Dialog
		this.setModal(true);

		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Titel
		title = new JLabel();
		title.setBounds(50, 35, 400, 30);
		title.setText("Einstellungen f¸rs Lernen");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Checkboxes
		boxes = new JCheckBox[3];
		rbutton = new JRadioButton[2];
		ButtonGroup rbuttonGroup = new ButtonGroup();

		// Lernrichtung 1
		rbutton[0] = new JRadioButton();
		//Beschreibungen der Lernkartei
		rbutton[0].setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung()
				+ " -> " + VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung());
		rbutton[0].setFont(Variables.DEFAULT_FONT);
		rbutton[0].setBounds(70, 120, 400, 30);
		rbuttonGroup.add(rbutton[0]);
		this.getContentPane().add(rbutton[0]);

		// Lernrichtung 2
		rbutton[1] = new JRadioButton();
		//Beschreibungen der Lernkartei
		rbutton[1].setText(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortZweiBeschreibung()
				+ " -> " + VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getWortEinsBeschreibung());
		rbutton[1].setFont(Variables.DEFAULT_FONT);
		rbutton[1].setBounds(70, 160, 400, 30);
		rbuttonGroup.add(rbutton[1]);
		this.getContentPane().add(rbutton[1]);

		// Gross/Kleinschreibung
		boxes[2] = new JCheckBox();
		boxes[2].setText("Groﬂ-/Kleinschreibung beachten");
		boxes[2].setFont(Variables.DEFAULT_FONT);
		boxes[2].setBounds(70, 200, 400, 30);
		this.getContentPane().add(boxes[2]);

		// Ok Knopf
		ok = new JButton();
		ok.setBounds(160, 290, 150, 35);
		ok.setText("Lernen");
		//Font
		ok.setBorder(Variables.ROUNDED_BORDER);
		ok.setForeground(Color.BLACK);
		ok.setBackground(Variables.DEFAULT_COLOR);
		ok.setFont(Variables.DEFAULT_FONT);
		//Listener
		ok.addActionListener(new ButtonListener());
		ok.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(ok);

		// Abbrechen Knopf
		no = new JButton();
		no.setBounds(340, 290, 150, 35);
		no.setText("Abbrechen");
		//Font
		no.setBorder(Variables.ROUNDED_BORDER);
		no.setForeground(Color.BLACK);
		no.setBackground(Variables.DEFAULT_COLOR);
		no.setFont(Variables.DEFAULT_FONT);
		//Listener
		no.addActionListener(new ButtonListener());
		no.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(no);

		// Default-Button
		this.getRootPane().setDefaultButton(ok);
	}

	/**
	 * isDialogApproved
	 * @return the dialogApproved
	 */
	public boolean isDialogApproved() {
		return dialogApproved;
	}

	/**
	 * setDialogApproved
	 * @param dialogApproved
	 *            the dialogApproved to set
	 */
	public void setDialogApproved(boolean dialogApproved) {
		this.dialogApproved = dialogApproved;
	}

	/**
	 * ButtonListener 
	 * reagiert auf das Druecken der Knoepfe "OK" und "Abbrechen"
	 * implementiert ActionListener
	 * @author Michael Morandell - Elija Innerkofler
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Wenn Button "OK" gedrueckt wurde
			if (e.getSource().equals(ok)) {
				//Einstellungen werden gesetzt
				LearnGUI.grossklein = boxes[2].isSelected();
				LearnGUI.richtung = rbutton[0].isSelected();
				setDialogApproved(true);
				setVisible(false);
			}
			// Wenn Button "Abbrechen" gedrueckt wurde
			if (e.getSource().equals(no)) {
				setDialogApproved(false);
				setVisible(false);
			}
		}
	}
}