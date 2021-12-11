package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.tfobz.vokabeltrainer.model.Lernkartei;
import net.tfobz.vokabeltrainer.model.VokabeltrainerDB;

/**
 * MainGUI realisiert das Haupfenster fuer den Vokabletrainer erbt von JFrame
 * 
 * @author Michael Morandell, Elija Innerkofler
 * @version 1.9.8 - Fehlermeldung beim Lernen, wenn keine Karten vorhanden + Updaten der Settings
 */
public class MainGUI extends JFrame {

	private JMenuBar menu = null;
	private JMenu fil = null;
	private JMenuItem imp = null;
	private JMenuItem exp = null;
	private JMenuItem exi = null;

	private JLabel title = null;
	private JPanel border = null;
	private JButton load = null;
	private JButton start = null;
	private JButton create = null;
	private JButton edit = null;
	private JButton add = null;
	private JFileChooser filechooser = null;

	private LearnSettingsGUI lsettinggui = null;
	private LearnGUI learngui = null;
	private CreateGUI creategui = null;
	private EditGUI editgui = null;
	private AddCardGUI addgui = null;
	private LoadGUI loadgui = null;
	public static DateExpiredGUI expiredgui = null;
	private WithSubjectsGUI subjectgui = null;
	// aktueller Index der Kartei
	private static int act_index = 0;
	public static JFrame owner = null;

	/**
	 * MainGui-Konstruktor
	 */
	public MainGUI() {

		// Einstellen der Werte für das Fenster
		int height = 600;
		int width = 750;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((StartWindow.screen_size.width - width) / 2, (StartWindow.screen_size.height - height) / 2,
				width, height);
		this.setTitle("Vokabeltrainer");
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		owner = MainGUI.this;
		// Setzen des Abhörers
		MeinKnopfAbhoerer a = new MeinKnopfAbhoerer();

		// Menu
		menu = new JMenuBar();
		fil = new JMenu("File");
		fil.setMnemonic(KeyEvent.VK_F);
		imp = new JMenuItem("Importieren...");
		exp = new JMenuItem("Exportieren...");
		exi = new JMenuItem("Exit");
		fil.setFont(Variables.MENU_FONT);
		imp.setFont(Variables.MENU_FONT);
		exp.setFont(Variables.MENU_FONT);
		exi.setFont(Variables.MENU_FONT);
		imp.setIcon(getImage("import.png", 16, 16));
		exp.setIcon(getImage("export.png", 16, 16));
		exi.setIcon(getImage("exit.png", 16, 16));
		imp.addActionListener(a);
		exp.addActionListener(a);
		exi.addActionListener(a);
		menu.add(fil);
		fil.add(imp);
		fil.add(exp);
		fil.add(exi);
		this.setJMenuBar(menu);

		// Titel
		title = new JLabel();
		title.setBounds(45, 35, this.getWidth(), 30);
		title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Laden - Knopf
		load = new JButton();
		load.setBounds(45, 85, 220, 35);
		load.setText("Andere Kartei laden");
		load.setFont(Variables.DEFAULT_FONT);
		load.setForeground(Color.BLACK);
		load.setBackground(Variables.DEFAULT_COLOR);
		load.setBorder(Variables.ROUNDED_BORDER);
		load.addActionListener(a);
		load.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(load);

		// Starten - Knopf
		start = new JButton();
		start.setBounds((this.getWidth() - 180) / 2, 220, 200, 80);
		start.setText("Lernen starten!");
		start.setIcon(getImage("start.png", 31, 28));
		start.setFont(Variables.BOLD_FONT);
		start.setForeground(Color.BLACK);
		start.setBackground(Variables.DEFAULT_COLOR);
		start.setBorder(Variables.ROUNDED_BORDER);
		start.addActionListener(a);
		start.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(start);

		// Erstellen - Knopf
		create = new JButton();
		create.setBounds(45, 438, 180, 35);
		create.setText("Erstellen");
		create.setFont(Variables.DEFAULT_FONT);
		create.setForeground(Color.BLACK);
		create.setBackground(Variables.DEFAULT_COLOR);
		create.setBorder(Variables.ROUNDED_BORDER);
		create.addActionListener(a);
		create.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(create);

		// Bearbeiten - Knopf
		edit = new JButton();
		edit.setBounds((this.getWidth() - 180) / 2, 438, 180, 35);
		edit.setText("Bearbeiten");
		edit.setFont(Variables.DEFAULT_FONT);
		edit.setForeground(Color.BLACK);
		edit.setBackground(Variables.DEFAULT_COLOR);
		edit.setBorder(Variables.ROUNDED_BORDER);
		edit.addActionListener(a);
		edit.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(edit);

		// Karten hinzufügen - Knopf
		add = new JButton();
		add.setBounds(525, 438, 180, 35);
		add.setText("Karte hinzufügen");
		add.setFont(Variables.DEFAULT_FONT);
		add.setForeground(Color.BLACK);
		add.setBackground(Variables.DEFAULT_COLOR);
		add.setBorder(Variables.ROUNDED_BORDER);
		add.addActionListener(a);
		add.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(add);

		// Border
		border = new JPanel();
		TitledBorder title = new TitledBorder(new LineBorder(Color.black, 1), "Lernkartei");
		title.setTitleFont(Variables.SUBTITLE_FONT);
		border.setBorder(title);
		border.setBounds(20, 380, 708, 140);
		this.getContentPane().add(border);

		expiredgui = new DateExpiredGUI(MainGUI.this);
		subjectgui = new WithSubjectsGUI(MainGUI.this);
	}

	private class MeinKnopfAbhoerer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {

			if (evt.getSource() == exp) {
				subjectgui.setVisible(true);
				
				// JFileChooser-Objekt
				filechooser = new JFileChooser();
				// DateiFilter setzen
				filechooser.setFileFilter(new FileNameExtensionFilter("Textdateien", "txt"));
				// Speichern-Dialog wird gezeigt. Wenn auf "Speichern" gerueckt wird
				if (filechooser.showSaveDialog(MainGUI.this) == JFileChooser.APPROVE_OPTION) {
					File newfile = filechooser.getSelectedFile();
					boolean overwrite = true;
					if (!newfile.getName().toLowerCase().endsWith(".txt")) {
						// .html wird hinzugefuegt
						newfile = new File(newfile.getParentFile(), newfile.getName() + ".txt");
					}
					// Wenn diese Datei bereits vorhanden ist
					if (newfile.exists()) {
						// Ueberschreib-Abfrage
						int ret = JOptionPane.showConfirmDialog(MainGUI.this,
								"Die Datei ist bereits vorhanden. Überschreiben?", "Meldung",
								JOptionPane.YES_NO_OPTION);
						// Wenn nicht ueberschrieben werden soll
						if (ret == JOptionPane.NO_OPTION) {
							overwrite = false;
						}
					}
					// Wenn ueberschrieben werden soll
					if (overwrite) {
						
						// neuer FileWriter
						VokabeltrainerDB.exportierenKarten(
								VokabeltrainerDB.getLernkarteien().get(act_index).getNummer(),
								newfile.getAbsolutePath(), subjectgui.isDialogApproved());
						subjectgui.dispose();
					}
					System.out.println("Export to: " + newfile.getAbsolutePath());
				}
			}
			// Import
			if (evt.getSource() == imp) {
				// JFileChooser-Objekt
				filechooser = new JFileChooser();
				// DateiFilter setzen
				filechooser.setFileFilter(new FileNameExtensionFilter("Textdateien", "txt"));
				// Oeffnen Dialog wird angezeigt
				if (filechooser.showOpenDialog(MainGUI.this) == JFileChooser.APPROVE_OPTION) {
					File newfile = filechooser.getSelectedFile();
					System.out.println("Import from: " + newfile.getAbsolutePath());
				}
			}

			if (evt.getSource() == exi) {
				dispose();
				System.exit(0);
			}

			if (evt.getSource() == load) {
				loadgui = new LoadGUI(MainGUI.this);
				create.setEnabled(false);
				edit.setEnabled(false);
				add.setEnabled(false);
				load.setEnabled(false);
				// LoadGUI visible
				loadgui.setVisible(true);
				create.setEnabled(true);
				edit.setEnabled(true);
				add.setEnabled(true);
				load.setEnabled(true);
				if (loadgui.isDialogApproved()) {
					act_index = loadgui.getSelectedIndex();
					title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
				}
				loadgui.dispose();
			}

			if (evt.getSource() == start) {
				create.setEnabled(false);
				edit.setEnabled(false);
				add.setEnabled(false);
				load.setEnabled(false);
				//Keine Karten?
				boolean karten = false;
				for (int i = 0; 
						i < VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).size(); 
						i++) {
					if (VokabeltrainerDB.getZufaelligeKarte(
							VokabeltrainerDB.getLernkarteien().get(act_index).getNummer(), 
							VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getNummer()) != null
							) {
						karten = true;
					}
				}
				if (!karten) {
					JOptionPane.showMessageDialog(MainGUI.this, "In dieser Lernkartei sind keine Karten vorhanden!", "Fehler!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					boolean abgelaufen = false;
					for (int i = 0; 
							i < VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).size(); 
							i++) {
						System.out.println(VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getGelerntAmString());
						System.out.println(VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getErinnerungFaellig());
						System.out.println(VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getErinnerungsIntervall());
						if (VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getErinnerungFaellig()) {
							abgelaufen = true;
						}
						if (VokabeltrainerDB.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i).getErinnerungsIntervall() == 0) {
							abgelaufen = true;
						}
					}
					if (!abgelaufen) {
						expiredgui.setVisible(true);
						if (expiredgui.isDialogApproved()) {
							lsettinggui = new LearnSettingsGUI(MainGUI.this);
							lsettinggui.setVisible(true);
							if (lsettinggui.isDialogApproved()) {
								learngui = new LearnGUI(MainGUI.this);
								learngui.setVisible(true);
								learngui.dispose();
							}
							lsettinggui.dispose();
						}
						expiredgui.dispose();
					}
					else {
						lsettinggui = new LearnSettingsGUI(MainGUI.this);
						lsettinggui.setVisible(true);
						if (lsettinggui.isDialogApproved()) {
							learngui = new LearnGUI(MainGUI.this);
							learngui.setVisible(true);
							learngui.dispose();
						}
						lsettinggui.dispose();
					}
				}
				create.setEnabled(true);
				edit.setEnabled(true);
				add.setEnabled(true);
				load.setEnabled(true);
			}

			if (evt.getSource() == create) {
				creategui = new CreateGUI(MainGUI.this);
				setVisible(false);
				creategui.setVisible(true);
				title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
				setVisible(true);
				creategui.dispose();
			}

			if (evt.getSource() == edit) {
				editgui = new EditGUI(MainGUI.this);
				setVisible(false);
				editgui.setVisible(true);
				title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
				setVisible(true);
				editgui.dispose();
			}

			if (evt.getSource() == add) {
				addgui = new AddCardGUI(MainGUI.this);
				setVisible(false);
				addgui.setVisible(true);
				setVisible(true);
				addgui.dispose();
			}

		}

	}

	/**
	 * @return the act_index
	 */
	public static int getAct_index() {
		return act_index;
	}

	/**
	 * @param act_index
	 *            the act_index to set
	 */
	public static void setAct_index(int act_index) {
		MainGUI.act_index = act_index;
	}

	/**
	 * Liefert das Icon zurück, dessen Dateiname übergeben wurde. Dabei wirde es
	 * nach den übergebenen Parametern skaliert. Es muss im src Ordner vorhanden
	 * sein. Falls dies nicht der Fall ist oder der Dateiname nicht gefunden wurde,
	 * wird null zurückgeliefert.
	 * 
	 * @param dateiname
	 *            Der Dateiname des Bilds
	 * @param width
	 *            Die Breite die das Icon haben soll
	 * @param height
	 *            Die Höhe die das Icon haben soll
	 * 
	 * @return Das Icon falls es gefunden wurde, null falls nicht
	 */
	public ImageIcon getImage(String dateiname, int width, int height) {
		URL url = null;
		Image bild = null;
		ImageIcon icon = null;
		url = this.getClass().getResource(dateiname);
		if (url != null) {
			bild = getToolkit().getImage(url);
			icon = new ImageIcon(new ImageIcon(bild).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		}
		return icon;
	}

}