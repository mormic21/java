package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.tfobz.vokabeltrainer.model.*;

/**
 * MainGUI 
 * realisiert das Haupfenster fuer den Vokabletrainer 
 * erbt von JFrame
 * @author Michael Morandell, Elija Innerkofler
 * @version 2.6 Final Version
 */
@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	// Membervariablen
	private JMenuBar menu = null;
	private JMenu fil = null;
	private JMenuItem imp = null;
	private JMenuItem exp = null;
	private JMenuItem exi = null;
	private JLabel title = null;
	private JPanel border2 = null;
	private JButton load = null;
	private JButton start = null;
	private JButton create = null;
	private JButton edit = null;
	private JButton add = null;
	private JButton editKarte = null;
	private JFileChooser filechooser = null;
	private JPanel border1 = null;

	// Deklarieren der Fenster
	private LearnSettingsGUI lsettinggui = null;
	private LearnGUI learngui = null;
	private CreateGUI creategui = null;
	private EditGUI editgui = null;
	private AddCardGUI addgui = null;
	private LoadGUI loadgui = null;
	private EditKarteGUI editkartegui = null;
	public static DateExpiredGUI expiredgui = null;
	private MitFaecherGUI subjectgui = null;
	private ImportOverwriteGUI impoverwritegui = null;
	// aktueller Index der Kartei
	private static int act_index = 0;
	// Owner
	public static JFrame owner = null;

	/**
	 * MainGUI-Konstruktor
	 */
	public MainGUI() {
		// Einstellen der Werte für das Fenster
		int height = 600;
		int width = 750;
		// Setzen des Fensters
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width - width) / 2, (screen_size.height - height) / 2, width, height);
		this.setTitle("Vokabeltrainer");
		this.setResizable(false);
		// Ausschalten des Layoutmgr
		this.getContentPane().setLayout(null);
		// Setzen des Owners
		owner = MainGUI.this;
		// Setzen des Abhörers
		MeinKnopfAbhoerer a = new MeinKnopfAbhoerer();

		// Menu
		menu = new JMenuBar();
		fil = new JMenu("Lernkartei");
		fil.setMnemonic(KeyEvent.VK_L);
		imp = new JMenuItem("Importieren...");
		exp = new JMenuItem("Exportieren...");
		exi = new JMenuItem("Exit");
		//Font
		fil.setFont(Variables.MENU_FONT);
		imp.setFont(Variables.MENU_FONT);
		exp.setFont(Variables.MENU_FONT);
		exi.setFont(Variables.MENU_FONT);
		//Icons
		imp.setIcon(getImage("import.png", 16, 16));
		exp.setIcon(getImage("export.png", 16, 16));
		exi.setIcon(getImage("exit.png", 16, 16));
		//Listener
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
		//Wenn keine Lernkarteien vorhanden
		if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
			title.setText("__Keine_Lernkartei_vorhanden__");
		} else {
			//Beschreibung wenn Lernkarteien vorhanden
			title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
		}
		//Font
		title.setFont(Variables.TITLE_FONT);
		this.getContentPane().add(title);

		// Laden - Knopf
		load = new JButton();
		load.setBounds(45, 85, 220, 35);
		load.setText("Lernkartei laden");
		//Font
		load.setFont(Variables.DEFAULT_FONT);
		load.setForeground(Color.BLACK);
		load.setBackground(Variables.DEFAULT_COLOR);
		load.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		load.addActionListener(a);
		load.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(load);

		// Starten - Knopf
		start = new JButton();
		start.setBounds((this.getWidth() - 180) / 2, 180, 200, 80);
		start.setText("Lernen starten!");
		start.setIcon(getImage("start.png", 31, 28));
		//Font
		start.setFont(Variables.BOLD_FONT);
		start.setForeground(Color.BLACK);
		start.setBackground(Variables.DEFAULT_COLOR);
		start.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		start.addActionListener(a);
		start.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(start);

		// Karte bearbeiten - Knopf
		editKarte = new JButton();
		editKarte.setBounds(405, 343, 180, 35);
		editKarte.setText("Karten bearbeiten");
		//Font
		editKarte.setFont(Variables.DEFAULT_FONT);
		editKarte.setForeground(Color.BLACK);
		editKarte.setBackground(Variables.DEFAULT_COLOR);
		editKarte.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		editKarte.addActionListener(a);
		editKarte.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(editKarte);

		// Karten hinzufügen - Knopf
		add = new JButton();
		add.setBounds(180, 343, 180, 35);
		add.setText("Karte hinzufügen");
		//Font
		add.setFont(Variables.DEFAULT_FONT);
		add.setForeground(Color.BLACK);
		add.setBackground(Variables.DEFAULT_COLOR);
		add.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		add.addActionListener(a);
		add.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(add);

		// Erstellen - Knopf
		create = new JButton();
		create.setBounds(180, 458, 180, 35);
		create.setText("Erstellen");
		//Font
		create.setFont(Variables.DEFAULT_FONT);
		create.setForeground(Color.BLACK);
		create.setBackground(Variables.DEFAULT_COLOR);
		create.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		create.addActionListener(a);
		create.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(create);

		// Bearbeiten - Knopf
		edit = new JButton();
		edit.setBounds(405, 458, 180, 35);
		edit.setText("Bearbeiten");
		//Font
		edit.setFont(Variables.DEFAULT_FONT);
		edit.setForeground(Color.BLACK);
		edit.setBackground(Variables.DEFAULT_COLOR);
		edit.setBorder(Variables.ROUNDED_BORDER);
		//Listener
		edit.addActionListener(a);
		edit.addMouseListener(Variables.MOUSEABHOERER);
		this.getContentPane().add(edit);

		// Border 1
		border1 = new JPanel();
		TitledBorder title2 = new TitledBorder(new LineBorder(Color.black, 1), "Karten");
		title2.setTitleFont(Variables.SUBTITLE_FONT);
		border1.setBorder(title2);
		border1.setBounds(20, 305, 708, 100);
		this.getContentPane().add(border1);

		// Border 2
		border2 = new JPanel();
		TitledBorder title1 = new TitledBorder(new LineBorder(Color.black, 1), "Lernkartei");
		title1.setTitleFont(Variables.SUBTITLE_FONT);
		border2.setBorder(title1);
		border2.setBounds(20, 420, 708, 100);
		this.getContentPane().add(border2);

		// Instanziieren der Fenster
		expiredgui = new DateExpiredGUI(MainGUI.this);
		subjectgui = new MitFaecherGUI(MainGUI.this);
		impoverwritegui = new ImportOverwriteGUI(MainGUI.this);

		// Default-Button
		this.getRootPane().setDefaultButton(start);
	}
	
	/**
	 * MeinKnopfAbhoerer
	 * reagiert auf die Buttons
	 * implements ActionListener
	 * @author Michael Morandell, Elija Innerkofler
	 */
	private class MeinKnopfAbhoerer implements ActionListener {
		/**
		 * actionPerformed
		 * @param evt, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent evt) {
			// Exportieren-Knopf
			if (evt.getSource() == exp) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Deaktivieren der Knöpfe
					create.setEnabled(false);
					edit.setEnabled(false);
					add.setEnabled(false);
					load.setEnabled(false);
					start.setEnabled(false);
					editKarte.setEnabled(false);
					// Anzeigen der GUI
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
							int err = VokabeltrainerDB.exportierenKarten(
									VokabeltrainerDB.getLernkarteien().get(act_index).getNummer(),
									newfile.getAbsolutePath(), subjectgui.isDialogApproved());
							// Datenbankfehler
							if (err == -1) {
								JOptionPane.showMessageDialog(MainGUI.this,
										"Ein Datenbankfehler oder Schreibfehler in Datei ist aufgetreten!", "Fehler!",
										JOptionPane.ERROR_MESSAGE);
							}
							// Lernkartei existiert nicht
							if (err == -3) {
								JOptionPane.showMessageDialog(MainGUI.this, "Die Lernkartei existiert nicht!",
										"Fehler!", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					// Grafikspeicher freigabe
					subjectgui.dispose();
					// Aktiveren der Knöpfe
					create.setEnabled(true);
					edit.setEnabled(true);
					add.setEnabled(true);
					load.setEnabled(true);
					start.setEnabled(true);
					editKarte.setEnabled(true);
				}
			}

			// Importieren-Knopf
			if (evt.getSource() == imp) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Deaktivieren der Knöpfe
					create.setEnabled(false);
					edit.setEnabled(false);
					add.setEnabled(false);
					load.setEnabled(false);
					start.setEnabled(false);
					editKarte.setEnabled(false);
					// Anzeigen des Warnfensters
					impoverwritegui.setVisible(true);
					// Abfrage
					if (impoverwritegui.isDialogApproved()) {
						// JFileChooser-Objekt
						filechooser = new JFileChooser();
						// DateiFilter setzen
						filechooser.setFileFilter(new FileNameExtensionFilter("Textdateien", "txt"));
						// Oeffnen Dialog wird angezeigt
						if (filechooser.showOpenDialog(MainGUI.this) == JFileChooser.APPROVE_OPTION) {
							File newfile = filechooser.getSelectedFile();
							int ret = VokabeltrainerDB.importierenKarten(
									VokabeltrainerDB.getLernkarteien().get(act_index).getNummer(),
									newfile.getAbsolutePath());
							// Importierfehler
							if (ret == -1) {
								JOptionPane.showMessageDialog(MainGUI.this, "Ein Importierfehler ist aufgetreten!",
										"Fehler!", JOptionPane.ERROR_MESSAGE);
							}
							// Datei nicht gefunden
							if (ret == -2) {
								JOptionPane.showMessageDialog(MainGUI.this, "Die Datei wurde nicht gefunden!",
										"Fehler!", JOptionPane.ERROR_MESSAGE);
							}
							// Lernkartei nicht vorhanden
							if (ret == -3) {
								JOptionPane.showMessageDialog(MainGUI.this, "Die Lernkartei ist nicht vorhanden",
										"Fehler!", JOptionPane.ERROR_MESSAGE);
							}
						}
						// Setzen der Beschreibung, des Erinnerungsintervalls und Gelernt am
						int i = 0;
						List<Fach> faecher = VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer());
						for (Fach fach : faecher) {
							fach.setBeschreibung("Fach" + i);
							fach.setErinnerungsIntervall(0);
							fach.setGelerntAm(new Date());
							VokabeltrainerDB.aendernFach(fach);
							i++;
						}
					}
					// Grafikspeicher wird freigegeben
					impoverwritegui.dispose();
					// Aktivieren der Knöpfe
					create.setEnabled(true);
					edit.setEnabled(true);
					add.setEnabled(true);
					load.setEnabled(true);
					start.setEnabled(true);
					editKarte.setEnabled(true);
				}
			}
			// Exit-Knopf
			if (evt.getSource() == exi) {
				// Grafikspeicher wird freigegeben
				dispose();
				// Programm wird geschlossen
				System.exit(0);
			}
			// Laden-Knopf
			if (evt.getSource() == load) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Instanziieren des Fensters
					loadgui = new LoadGUI(MainGUI.this);
					// Deaktivieren der Knöpfe
					create.setEnabled(false);
					start.setEnabled(false);
					editKarte.setEnabled(false);
					edit.setEnabled(false);
					add.setEnabled(false);
					load.setEnabled(false);
					// LoadGUI visible
					loadgui.setVisible(true);
					// Aktivieren der Knöpfe
					start.setEnabled(true);
					editKarte.setEnabled(true);
					create.setEnabled(true);
					edit.setEnabled(true);
					add.setEnabled(true);
					load.setEnabled(true);
					// Abfrage der Auswahl
					if (loadgui.isDialogApproved()) {
						act_index = loadgui.getSelectedIndex();
						title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
					}
					// Freigabe des Grafikspeichers
					loadgui.dispose();
				}
			}
			// Start-Knopf
			if (evt.getSource() == start) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Deaktivieren der Knöpfe
					create.setEnabled(false);
					start.setEnabled(false);
					editKarte.setEnabled(false);
					edit.setEnabled(false);
					add.setEnabled(false);
					load.setEnabled(false);
					// Ueberprüft ob Karten vorhanden sind
					boolean karten = false;
					for (int i = 0; i < VokabeltrainerDB
							.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).size(); i++) {
						if (VokabeltrainerDB.getZufaelligeKarte(
								VokabeltrainerDB.getLernkarteien().get(act_index).getNummer(),
								VokabeltrainerDB
										.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer())
										.get(i).getNummer()) != null) {
							karten = true;
						}
					}
					//Error-Ausgabe
					if (!karten) {
						JOptionPane.showMessageDialog(MainGUI.this, "In dieser Lernkartei sind keine Karten vorhanden!",
								"Fehler!", JOptionPane.ERROR_MESSAGE);
					} else {
						boolean abgelaufen = false;
						for (int i = 0; i < VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer())
								.size(); i++) {
							//Erinnerung Faellig
							if (VokabeltrainerDB
									.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i)
									.getErinnerungFaellig()) {
								abgelaufen = true;
							}
							if (VokabeltrainerDB
									.getFaecher(VokabeltrainerDB.getLernkarteien().get(act_index).getNummer()).get(i)
									.getErinnerungsIntervall() == 0) {
								abgelaufen = true;
							}
						}
						//wenn noch nicht abgelaufen
						if (!abgelaufen) {
							//Meldung an Benutzer
							expiredgui.setVisible(true);
							//Wenn Ok geklickt wurde
							if (expiredgui.isDialogApproved()) {
								//settings-GUI
								lsettinggui = new LearnSettingsGUI(MainGUI.this);
								lsettinggui.setVisible(true);
								//wenn Ok geklickt wurde
								if (lsettinggui.isDialogApproved()) {
									//Lernen
									learngui = new LearnGUI(MainGUI.this);
									learngui.setVisible(true);
									learngui.dispose();
								}
								//freigeben des Speichers
								lsettinggui.dispose();
							}
							expiredgui.dispose();
						} else {
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
					// Aktivieren der Knöpfe
					start.setEnabled(true);
					editKarte.setEnabled(true);
					create.setEnabled(true);
					edit.setEnabled(true);
					add.setEnabled(true);
					load.setEnabled(true);
				}
			}
			// Erstellen-Knopf
			if (evt.getSource() == create) {
				// Instanziieren der GUI
				creategui = new CreateGUI(MainGUI.this);
				// Unsichtbar machen der Main-GUI
				setVisible(false);
				// Sichtbar machen der Create-GUI
				creategui.setVisible(true);
				// Setzen des Titels
				title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
				// Sichtbar machen der Main-GUI
				setVisible(true);
				// Freigeben des Grafikspeichers
				creategui.dispose();
			}
			// Bearbeiten-Knopf
			if (evt.getSource() == edit) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Instanziieren der GUI
					editgui = new EditGUI(MainGUI.this);
					// Unsichtbar machen der Main-GUI
					setVisible(false);
					// Sichtbarmachen der Edit-GUI
					editgui.setVisible(true);
					// Falls keine Lernkartei vorhanden ist soll der Titel gesetz werden
					if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
						title.setText("__Keine_Lernkartei_vorhanden__");
					} else {
						title.setText(VokabeltrainerDB.getLernkarteien().get(act_index).getBeschreibung());
					}
					// Sichtbar machen der Main-GUI
					setVisible(true);
					// Freigeben des Grafikspeichers
					editgui.dispose();
				}
			}
			// Hinzufügen-Knopf
			if (evt.getSource() == add) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					// Instanziieren der GUI
					addgui = new AddCardGUI(MainGUI.this);
					// Unsichtbar machen der Main-GUI
					setVisible(false);
					// Sichtbar machen der Add-GUI
					addgui.setVisible(true);
					// Sichtbar machen der Main-GUI
					setVisible(true);
					// Freigeben des Grafikspeichers
					addgui.dispose();
				}
			}
			// Karten bearbeiten-Knopf
			if (evt.getSource().equals(editKarte)) {
				// Überprüfen ob eine Lernkartei vorhanden ist
				if (VokabeltrainerDB.getLernkarteien().size() <= 0) {
					JOptionPane.showMessageDialog(MainGUI.this, "In der Datenbank sind keine Lernkarteien vorhanden",
							"Fehler: Keine Lernkarteien", JOptionPane.ERROR_MESSAGE);
				} else {
					//Alle Karten werden geholt
					List<Karte> lernkarten = new ArrayList<>();
					for (int i = 0; i < VokabeltrainerDB
							.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
							.size(); i++) {
						List<Karte> karten = VokabeltrainerDB.getKarten(VokabeltrainerDB
								.getFaecher(VokabeltrainerDB.getLernkarteien().get(MainGUI.getAct_index()).getNummer())
								.get(i).getNummer());
						lernkarten.addAll(karten);
					}
					//Wenn keine Karten vorhanden sind
					if (lernkarten.size() <= 0) {
						//Fehlermeldung
						JOptionPane.showMessageDialog(MainGUI.this,
								"In der ausgewählten Lernkartei sind keine Karten vorhanden", "Fehler: Keine Karten",
								JOptionPane.ERROR_MESSAGE);
					} else {
						editkartegui = new EditKarteGUI(MainGUI.this);
						setVisible(false);
						editkartegui.setVisible(true);
						setVisible(true);
						editkartegui.dispose();
					}
				}
			}
		}
	}

	/**
	 * getAct_index
	 * @return the act_index
	 */
	public static int getAct_index() {
		return act_index;
	}

	/**
	 * setAct_index
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
	 * @param dateiname
	 *        	  Der Dateiname des Bilds
	 * @param width
	 *            Die Breite die das Icon haben soll
	 * @param height
	 *            Die Höhe die das Icon haben soll
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