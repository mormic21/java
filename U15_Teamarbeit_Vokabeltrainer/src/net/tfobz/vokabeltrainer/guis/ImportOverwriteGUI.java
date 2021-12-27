package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ImportOverwriteGUI 
 * realisiert ein Fenster zum auswählen, ob man die
 * importierten Karten in eine neue Lernkartei speichern oder die aktuelle
 * Lernkartei überschreiben will
 * erbt von JDialog
 * @author Michael Morandel - Elija Innerkofler
 * @version 1.1 - Finale Version
 */
@SuppressWarnings("serial")
public class ImportOverwriteGUI extends JDialog {

	// Membervariablen
	private JLabel z1Meldung = null;
	private JLabel z2Meldung = null;
	private JLabel z3Meldung = null;
	private JButton yes = null;
	private JButton no = null;
	private boolean dialogApproved = false;

	/**
	 * ImportOverwriteGUI-Konstruktor
	 * @param owner, JFrame
	 */
	public ImportOverwriteGUI(JFrame owner) {
		super(owner);
		//hide on close
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		int height = 220;
		int width = 550;
		this.setBounds(owner.getX() + ((owner.getWidth() - width) / 2),
				owner.getY() + ((owner.getHeight() - height) / 2), width, height);
		this.setTitle("Importieren");
		this.setResizable(false);
		//modaler Dialog
		this.setModal(true);

		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);

		// Knopfabhörer
		ButtonListener a = new ButtonListener();

		// Erste Zeile der Meldung
		z1Meldung = new JLabel();
		z1Meldung.setBounds(0, 10, width, 25);
		z1Meldung.setText("Achtung!");
		z1Meldung.setFont(Variables.BOLD_FONT);
		z1Meldung.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(z1Meldung);

		// Zweite Zeile der Meldung
		z2Meldung = new JLabel();
		z2Meldung.setBounds(0, 45, width, 25);
		z2Meldung.setText("Die Karten und Fächer der aktuellen Lernkartei werden überschrieben.");
		z2Meldung.setFont(Variables.BOLD_FONT);
		z2Meldung.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(z2Meldung);

		// Dritte Zeile der Meldung
		z3Meldung = new JLabel();
		z3Meldung.setBounds(0, 80, width, 25);
		z3Meldung.setText("Fortfahren?");
		z3Meldung.setFont(Variables.BOLD_FONT);
		z3Meldung.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(z3Meldung);

		// Ja - Knopf
		yes = new JButton();
		yes.setBounds(50, 125, 200, 35);
		yes.setText("Ja");
		//Font
		yes.setBorder(Variables.ROUNDED_BORDER);
		yes.setForeground(Color.BLACK);
		yes.setBackground(Variables.DEFAULT_COLOR);
		yes.setFont(Variables.DEFAULT_FONT);
		//Listener
		yes.addActionListener(a);
		yes.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(yes);

		// Nein - Knopf
		no = new JButton();
		no.setBounds(300, 125, 200, 35);
		no.setText("Nein");
		//Font
		no.setBorder(Variables.ROUNDED_BORDER);
		no.setForeground(Color.BLACK);
		no.setBackground(Variables.DEFAULT_COLOR);
		no.setFont(Variables.DEFAULT_FONT);
		//Listener
		no.addActionListener(a);
		no.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(no);

		// DefaultButton setzen
		this.getRootPane().setDefaultButton(yes);
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
	 * Falls aufgerufen wird die zum Knopf gehöhrige Aufgabe ausgeführt 
	 * implements ActionListener
	 * @author Michael Morandell, Elija Innerkofler
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param evt, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent evt) {
			// Ja-Knopf
			if (evt.getSource() == yes) {
				setDialogApproved(true);
				//unsichtbar
				setVisible(false);
			}
			// Nein-Knopf
			if (evt.getSource() == no) {
				setDialogApproved(false);
				//unsichtbar
				setVisible(false);
			}
		}
	}
}