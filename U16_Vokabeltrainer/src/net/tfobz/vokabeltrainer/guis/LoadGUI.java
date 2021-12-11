package net.tfobz.vokabeltrainer.guis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

import net.tfobz.vokabeltrainer.model.Lernkartei;
import net.tfobz.vokabeltrainer.model.VokabeltrainerDB;

/**
 * Load-GUI
 * realisiert das Laden einer Lernkartei aus der Datenbank
 * erbt von JDialog
 * 
 * @author Michael Morandell, Elija Innerkofler 
 * @version 1.5 - removed updateComboBox
 */
public class LoadGUI extends JDialog {
	
	// Membervariablen
	private JLabel title = null;
	private JComboBox<String> box = null;
	private JButton ok = null;
	private JButton no = null;
	
	private int selectedIndex;
	private boolean dialogApproved = false;
	private String[] karteien = null;

	/**
	 * Load-Konstruktor
	 * @param owner
	 */
	public LoadGUI(JFrame owner) {
		super(owner);
		// Setzen des Fensters
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		int height = 350;
		int width = 500;
		this.setBounds(owner.getX() + ((owner.getWidth() - width) / 2),
				owner.getY() + ((owner.getHeight() - height) / 2), width, height);
		this.setTitle("Vokabeltrainer: Load");
		this.setResizable(false);
		this.setModal(true);
		
		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Titel
		title = new JLabel();
		title.setBounds(50, 35, 300, 30);
		title.setText("Lernkartei auswählen:");
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Combo-Box
		karteien = new String[VokabeltrainerDB.getLernkarteien().size()];
		for (int i = 0; i < VokabeltrainerDB.getLernkarteien().size(); i++) {
			karteien[i] = VokabeltrainerDB.getLernkarteien().get(i).getBeschreibung();
		}
		box = new JComboBox(karteien);
		box.setFont(Variables.DEFAULT_FONT);
		box.setEditable(false);
		box.setSelectedIndex(0);
		box.setBorder(Variables.TEXTFIELD_BORDER);
		box.setBackground(Variables.DEFAULT_COLOR);
		box.setBounds(100, 100, 300, 30);
		this.getContentPane().add(box);

		// Ändern Knopf
		ok = new JButton();
		ok.setBounds(70, 250, 150, 35);
		ok.setText("OK");
		ok.setBorder(Variables.ROUNDED_BORDER);
		ok.setForeground(Color.BLACK);
		ok.setBackground(Variables.DEFAULT_COLOR);
		ok.setFont(Variables.DEFAULT_FONT);
		ok.addActionListener(new ButtonListener());
		ok.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(ok);
		
		// Ändern Knopf
		no = new JButton();
		no.setBounds(280, 250, 150, 35);
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
	 * @return the selectedIndex
	 */
	public int getSelectedIndex() {
		return selectedIndex;
	}
	/**
	 * @param selectedIndex the selectedIndex to set
	 */
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
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
				selectedIndex = box.getSelectedIndex();
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
