package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

/**
 * WithSubjects-GUI realisiert ein Fenster zum auswählen, ob man die Lernkartei
 * mit oder ohne Fächernummer exportieren will. Erbt von JDialog
 * 
 * @author Michael Morandel - Elija Innerkofler
 * @version 1.0.1 - ändernd des Textes
 */
public class WithSubjectsGUI extends JDialog {

	// Membervariablen
	private JLabel z1Meldung = null;
	private JButton yes = null;
	private JButton no = null;
	private boolean dialogApproved = false;

	public WithSubjectsGUI(JFrame owner) {
		super(owner);

		// Setzen des Fensters
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		int height = 200;
		int width = 550;
		this.setBounds(owner.getX() + ((owner.getWidth() - width) / 2),
				owner.getY() + ((owner.getHeight() - height) / 2), width, height);
		this.setTitle("Exportieren");
		this.setResizable(false);
		this.setModal(true);

		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		ButtonListener a = new ButtonListener();

		// Erste Zeile der Meldung
		z1Meldung = new JLabel();
		z1Meldung.setBounds(0, 40, width, 25);
		z1Meldung.setText("Mit Fächernummer exportieren?");
		z1Meldung.setFont(Variables.BOLD_FONT);
		z1Meldung.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(z1Meldung);

		// Ja - Knopf
		yes = new JButton();
		yes.setBounds(50, 105, 200, 35);
		yes.setText("Ja");
		yes.setBorder(Variables.ROUNDED_BORDER);
		yes.setForeground(Color.BLACK);
		yes.setBackground(Variables.DEFAULT_COLOR);
		yes.setFont(Variables.DEFAULT_FONT);
		yes.addActionListener(a);
		yes.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(yes);

		// Nein - Knopf
		no = new JButton();
		no.setBounds(300, 105, 200, 35);
		no.setText("Nein");
		no.setBorder(Variables.ROUNDED_BORDER);
		no.setForeground(Color.BLACK);
		no.setBackground(Variables.DEFAULT_COLOR);
		no.setFont(Variables.DEFAULT_FONT);
		no.addActionListener(a);
		no.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(no);

	}

	/**
	 * 
	 * @return the dialogApproved
	 */
	public boolean isDialogApproved() {
		return dialogApproved;
	}

	/**
	 * 
	 * @param dialogApproved
	 *            the dialogApproved to set
	 */
	public void setDialogApproved(boolean dialogApproved) {
		this.dialogApproved = dialogApproved;
	}

	/**
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {

			if (evt.getSource() == yes) {
				setDialogApproved(true);
				setVisible(false);
			}

			if (evt.getSource() == no) {
				setDialogApproved(false);
				setVisible(false);
			}

		}

	}

}