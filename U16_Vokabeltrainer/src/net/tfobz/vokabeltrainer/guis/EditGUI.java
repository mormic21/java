package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.tfobz.vokabeltrainer.model.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

public class EditGUI extends JDialog {

	private JLabel title = null;
	private JLabel description = null;
	private JTextField text1 = null;
	private JPanel border = null;
	private JLabel first = null;
	private JTextField text2 = null;
	private JLabel second = null;
	private JTextField text3 = null;
	private JCheckBox checkBox1 = null;
	private JCheckBox checkBox2 = null;
	private JCheckBox checkBox3 = null;
	private JButton back = null;
	private JButton change = null;

	public EditGUI(JFrame owner) {

		super(owner);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 410);
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Vokabeltrainer: Lernkartei bearbeiten");

		this.getContentPane().setLayout(null);

		title = new JLabel();
		title.setBounds(20, 20, 300, 30);
		Font font = new Font("Sans Serif", Font.BOLD, 20);
		title.setFont(font);
		title.setText("Lernkartei bearbeiten");
		this.getContentPane().add(title);

		description = new JLabel();
		description.setBounds(20, 65, 100, 20);
		description.setText("Beschreibung:");
		this.getContentPane().add(description);

		text1 = new JTextField();
		text1.setBounds(20, 90, 450, 20);
		this.getContentPane().add(text1);

		first = new JLabel();
		first.setBounds(40, 155, 160, 20);
		first.setText("Beschreibung erstes Wort:");
		this.getContentPane().add(first);
		
		text2 = new JTextField();
		text2.setBounds(210, 155, 240, 20);
		this.getContentPane().add(text2);
		
		second = new JLabel();
		second.setBounds(40, 190, 160, 20);
		second.setText("Beschreibung zweites Wort:");
		this.getContentPane().add(second);
			
		text3 = new JTextField();
		text3.setBounds(210, 190, 240, 20);
		this.getContentPane().add(text3);
		
		border = new JPanel();
		border.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Wort"));
		border.setBounds(20, 130, 450, 100);
		this.getContentPane().add(border);
		
		checkBox1 = new JCheckBox();
		checkBox1.setBounds(20, 245, 450, 20);
		checkBox1.setText("Test");
		this.getContentPane().add(checkBox1);
		
		checkBox2 = new JCheckBox();
		checkBox2.setBounds(20, 270, 450, 20);
		checkBox2.setText("Test");
		this.getContentPane().add(checkBox2);
		
		checkBox3 = new JCheckBox();
		checkBox3.setBounds(20, 300, 450, 20);
		checkBox3.setText("Groß-/Kleinschreibung beachten");
		this.getContentPane().add(checkBox3);
		
		back = new JButton();
		back.setBounds(260, 335, 100, 25);
		back.setText("Abbrechen");
		back.addActionListener(new EditListener());
		this.getContentPane().add(back);
		
		change = new JButton();
		change.setBounds(370, 335, 100, 25);
		change.setText("Ändern");
		change.addActionListener(new EditListener());
		this.getContentPane().add(change);
		
	}
	
	private class EditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(back)) {
				setVisible(false);
			}
			if (e.getSource().equals(change)) {
				Lernkartei lk = new Lernkartei(text1.getText(), text2.getText(), text3.getText(), true, true);
				System.out.println(text1.getText());
				System.out.println(text2.getText());
				System.out.println(text3.getText());
				lk.validiere();
				VokabeltrainerDB.hinzufuegenLernkartei(lk);
				System.out.println("ok");
				List<Lernkartei> lernkarteien = VokabeltrainerDB.getLernkarteien();
				for (Lernkartei lernkartei: lernkarteien)
					System.out.println(lernkartei);
				VokabeltrainerDB.hinzufuegenKarte(lk.getNummer(), new Karte(0, "einwort^", "zweiwort", false, false));
				VokabeltrainerDB.hinzufuegenKarte(lk.getNummer(), new Karte(1, "einwt^", "zweighort", false, false));
				VokabeltrainerDB.hinzufuegenKarte(lk.getNummer(), new Karte(2, "einwdgfdfort^", "zweort", false, false));
				VokabeltrainerDB.hinzufuegenKarte(lk.getNummer(), new Karte(3, "eiffnwort^", "zweiwdfort", false, false));
				int ret = VokabeltrainerDB.exportierenKarten(lk.getNummer(), "C:\\Users\\Michael Morandell\\Downloads\\RohdateienJavaVok\\test.txt", false);
				System.out.println(ret);
			}
			
		}
		
	}

}