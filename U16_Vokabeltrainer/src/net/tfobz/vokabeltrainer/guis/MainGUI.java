package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//import net.sourceforge.jdatepicker.impl.*;

public class MainGUI extends JFrame {

	private JLabel aktuelleKartei = null;
	private JLabel anzahlKarten = null;
	private JLabel datum = null;
	private JButton edit = null;
	private JButton datechange = null;
	private JButton start = null;
	private JMenuBar menu = null;
	private JMenu fil = null;
	private JMenuItem imp = null;
	private JMenuItem exp = null;
	private JMenuItem exi = null;

	/**
	 * MainGui-Konstruktor
	 */
	public MainGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Groeße setzen
		int height = 600;
		int width = 650;
		this.setBounds((StartWindow.screen_size.width - width) / 2, (StartWindow.screen_size.height - height) / 2,
				width, height);
		this.setTitle("Vokabeltrainer");
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		MeinKnopfAbhoerer a = new MeinKnopfAbhoerer();

		// aktuelle Kartei
		aktuelleKartei = new JLabel();
		aktuelleKartei.setBounds(60, 45, this.getWidth(), 30);
		aktuelleKartei.setText("Lernkartei: Deutsch - Englisch");
		aktuelleKartei.setFont(new Font("Sans Serif", Font.BOLD, 25));
		this.getContentPane().add(aktuelleKartei);

		// Anzahl der Lernkarten
		anzahlKarten = new JLabel();
		anzahlKarten.setBounds(60, 130, 200, 22);
		anzahlKarten.setText("Anzahl: 10 Lernkarten");
		anzahlKarten.setFont(new Font("Sans Serif", Font.BOLD, 18));
		this.getContentPane().add(anzahlKarten);

		// Ablaufdatum
		datum = new JLabel();
		datum.setBounds((this.getWidth() / 2), 130, 300, 22);
		datum.setText("Erinnerungsdatum: 01.01.1970");
		datum.setFont(new Font("Sans Serif", Font.BOLD, 18));
		this.getContentPane().add(datum);

		// edit
		edit = new JButton();
		edit.setBounds(60, 175, 220, 40);
		edit.setText("Lernkartei editieren");
		edit.setFont(new Font("Sans Serif", Font.BOLD, 18));
		edit.addActionListener(a);
		this.getContentPane().add(edit);

		// datechange
		datechange = new JButton();
		datechange.setBounds(this.getWidth() / 2, 175, 265, 40);
		datechange.setText("Datum ändern");
		datechange.setFont(new Font("Sans Serif", Font.BOLD, 18));
		datechange.addActionListener(a);
		this.getContentPane().add(datechange);

		// start
		start = new JButton();
		start.setBounds((this.getWidth() - 180) / 2, 350, 180, 100);
		start.setText("Lernen starten!");
		start.setFont(new Font("Sans Serif", Font.BOLD, 18));
		start.addActionListener(a);
		this.getContentPane().add(start);

		// Menü
		Border bo = new LineBorder(Color.LIGHT_GRAY);
		menu = new JMenuBar();
		fil = new JMenu("File");
		fil.setMnemonic(KeyEvent.VK_F);
		imp = new JMenuItem("Importieren");
		exp = new JMenuItem("Exportieren");
		exi = new JMenuItem("Exit");
		imp.addActionListener(a);
		exp.addActionListener(a);
		exi.addActionListener(a);
		menu.add(fil);
		fil.add(imp);
		fil.add(exp);
		fil.add(exi);
		menu.setBorder(bo);
		this.setJMenuBar(menu);
		
		//Datepicker
		/**
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(100, 500, 200, 50);
		this.getContentPane().add(datePicker);**/		
		
	}

	private class MeinKnopfAbhoerer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {

			if (evt.getSource() == edit) {
				EditGUI egui = new EditGUI(MainGUI.this);
				egui.setVisible(true);
				egui.dispose();
			}

			if (evt.getSource() == datechange) {
				System.out.println("datechange");
			}

			if (evt.getSource() == start) {
				System.out.println("start");
			}
			
			if (evt.getSource() == exp) {
				System.out.println("exp");
			}
			
			if (evt.getSource() == imp) {
				System.out.println("imp");
			}
			
			if (evt.getSource() == exi) {
				dispose();
				System.exit(0);
			}

		}

	}
	
}
