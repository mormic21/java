package net.tfobz.ratenrechner;

import java.awt.*;
import javax.swing.*;

public class RatenRechnerGUI extends JFrame {
	ButtonGroup bgroup = null;
	JLabel[] jlabels = null;
	JRadioButton[] jradios = null;
	JTextField[] tfields = null;
	JButton[] jbuttons = null;
	JComboBox box = null;
	RatenRechner rechner = null;

	public RatenRechnerGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(700, 250, 620, 520);
		this.setTitle("Ratenrechner");
		this.setResizable(false);
		this.getContentPane().setLayout(null);

		jlabels = new JLabel[6];
		for (int i = 0; i < jlabels.length; i++) {
			jlabels[i] = new JLabel();
			jlabels[i].setHorizontalAlignment(SwingConstants.RIGHT);
			jlabels[i].setFont(new Font(null, Font.BOLD, 17));
		}
		System.out.println(this.getWidth());
		jlabels[0].setBounds((620 / 2) - 100, 20, 200, 32);
		jlabels[0].setText("Ratenrechner");
		jlabels[0].setFont(new Font(null, Font.BOLD, 30));

		bgroup = new ButtonGroup();
		jradios = new JRadioButton[2];
		jradios[0] = new JRadioButton("Vorschüssig", false);
		jradios[0].setBounds(150, 90, 125, 20);
		jradios[0].setFont(new Font(null, Font.BOLD, 17));
		jradios[1] = new JRadioButton("Nachschüssig", true);
		jradios[1].setBounds(325, 90, 150, 20);
		jradios[1].setFont(new Font(null, Font.BOLD, 17));
		bgroup.add(jradios[0]);
		bgroup.add(jradios[1]);

		tfields = new JTextField[4];
		for (int i = 0; i < tfields.length; i++) {
			tfields[i] = new JTextField();
			tfields[i].setHorizontalAlignment(SwingConstants.RIGHT);
			tfields[i].setFont(new Font(null, 0, 17));
		}
		jbuttons = new JButton[4];
		for (int i = 0; i < jbuttons.length; i++) {
			jbuttons[i] = new JButton();
			jbuttons[i].setFont(new Font(null, Font.BOLD, 17));
		}
		// --- barwert ---
		// label
		jlabels[1].setText("Barwert:");
		jlabels[1].setBounds(10, 150, 155, 20);
		// textfield
		tfields[0].setBounds(175, 146, 155, 30);
		// button
		jbuttons[0].setBounds(355, 146, 200, 30);
		jbuttons[0].setText("Berechne Barwert");

		// --- jahreszinssatz ---
		// label
		jlabels[2].setText("Jahreszinssatz:");
		jlabels[2].setBounds(10, 200, 155, 20);
		// textfield
		tfields[1].setBounds(175, 196, 155, 30);

		// ---laufzeit in jahren ---
		// label
		jlabels[3].setText("Laufzeit in Jahren:");
		jlabels[3].setBounds(10, 250, 155, 20);
		// textfield
		tfields[2].setBounds(175, 246, 155, 30);
		// button
		jbuttons[1].setBounds(355, 246, 200, 30);
		jbuttons[1].setText("Berechne Laufzeit");

		// --- raten pro jahr ---
		box = new JComboBox<>();
		// label
		jlabels[4].setText("Raten pro Jahr:");
		jlabels[4].setBounds(10, 300, 155, 20);
		//combo box
		box.setBounds(175, 296, 155, 30);
		box.addItem("12 Raten");
		box.addItem("6 Raten");
		box.addItem("4 Raten");
		box.addItem("1 Rate");
		box.setFont(new Font(null, Font.BOLD, 17));
		
		// --- rate ---
		jlabels[5].setText("Rate:");
		jlabels[5].setBounds(10, 350, 155, 20);
		// textfield
		tfields[3].setBounds(175, 346, 155, 30);
		// button
		jbuttons[2].setBounds(355, 346, 200, 30);
		jbuttons[2].setText("Berechne Rate");
		
		// --- zeige tilgungsplan ---
		jbuttons[3].setBounds(345, 420, 220, 50);
		jbuttons[3].setText("Zeige Tilgungsplan");
		jbuttons[3].setFont(new Font(null, Font.BOLD, 20));
		
		// add all
		Container pane = this.getContentPane();
		for (int i = 0; i < jlabels.length; i++) {
			pane.add(jlabels[i]);
		}
		for (int i = 0; i < jradios.length; i++) {
			pane.add(jradios[i]);
		}
		for (int i = 0; i < tfields.length; i++) {
			pane.add(tfields[i]);
		}
		for (int i = 0; i < jbuttons.length; i++) {
			pane.add(jbuttons[i]);
		}
		pane.add(box);
		

	}

}
