import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SonglisteGUI extends JFrame
{
	// Klassenvariablen für Label
	private JLabel lTitel = null;
	private JLabel lInterpret = null;
	private JLabel lAlbum = null;
	private JLabel lJahr = null;
	// Klassenvariablen für Titel
	private JTextField tTitel = null;
	private JTextField tInterpret = null;
	private JTextField tAlbum = null;
	private JTextField tJahr = null;
	// Klassenvariablen für Button
	private JButton erster = null;
	private JButton voriger = null;
	private JButton naechster = null;
	private JButton letzter = null;
	private JButton neu = null;
	private JButton loeschen = null;
	private JButton alleLoeschen = null;
	// Private Membervriablen
	private Songliste songliste;
	private Song aktuellerSong;
	private boolean neuModus;

	/**
	 * Dieser Custom-Constructor erstellt die GUI für die Songliste. Das Fenster
	 * besteht aus insgesamt 5 Label und Textfelder, als auch 5 Buttons.
	 */
	public SonglisteGUI() {
		// Fenstereigenschaften
		setTitle("Songliste");
		setBounds(250, 500, 600, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Alle Label werden gesetzt
		lTitel = new JLabel("Titel:");
		lTitel.setBounds(20, 30, 75, 25);
		lTitel.setFont(new Font("Arial", Font.BOLD, 15));
		lInterpret = new JLabel("Interpret:");
		lInterpret.setBounds(20, 80, 75, 25);
		lInterpret.setFont(new Font("Arial", Font.BOLD, 15));
		lAlbum = new JLabel("Album:");
		lAlbum.setBounds(20, 130, 75, 25);
		lAlbum.setFont(new Font("Arial", Font.BOLD, 15));
		lJahr = new JLabel("Jahr:");
		lJahr.setBounds(20, 180, 75, 25);
		lJahr.setFont(new Font("Arial", Font.BOLD, 15));
		// Alle Textfelder werden gesetzt
		tTitel = new JTextField();
		tTitel.setBounds(100, 30, 460, 28);
		tTitel.setFont(new Font("Arial", 0, 14));
		tInterpret = new JTextField();
		tInterpret.setBounds(100, 80, 460, 28);
		tInterpret.setFont(new Font("Arial", 0, 14));
		tAlbum = new JTextField();
		tAlbum.setBounds(100, 130, 460, 28);
		tAlbum.setFont(new Font("Arial", 0, 14));
		tJahr = new JTextField();
		tJahr.setBounds(100, 180, 60, 28);
		tJahr.setFont(new Font("Arial", 0, 14));
		// Alle Buttons werden gesetzt
		erster = new JButton();
		erster.setBounds(20, 225, 540 / 4, 50);
		erster.setText("Erster");
		erster.setFont(new Font("Arial", Font.BOLD, 15));
		voriger = new JButton();
		voriger.setBounds(20 + 540 / 4, 225, 540 / 4, 50);
		voriger.setText("Voriger");
		voriger.setFont(new Font("Arial", Font.BOLD, 15));
		naechster = new JButton();
		naechster.setBounds(20 + 540 / 4 * 2, 225, 540 / 4, 50);
		naechster.setText("Nächster");
		naechster.setFont(new Font("Arial", Font.BOLD, 15));
		letzter = new JButton();
		letzter.setBounds(20 + 540 / 4 * 3, 225, 540 / 4, 50);
		letzter.setText("Letzter");
		letzter.setFont(new Font("Arial", Font.BOLD, 15));
		neu = new JButton();
		neu.setBounds(20, 285, 540 / 3, 50);
		neu.setText("Neu");
		neu.setFont(new Font("Arial", Font.BOLD, 15));
		loeschen = new JButton();
		loeschen.setBounds(20 + 540 / 3, 285, 540 / 3, 50);
		loeschen.setText("Löschen");
		loeschen.setFont(new Font("Arial", Font.BOLD, 15));
		alleLoeschen = new JButton();
		alleLoeschen.setBounds(20 + 540 / 3 * 2, 285, 540 / 3, 50);
		alleLoeschen.setText("Alle Löschen");
		alleLoeschen.setFont(new Font("Arial", Font.BOLD, 15));
		// Container wird initialisiert
		Container contentPane = getContentPane();
		// Layout wird für den Container auf null gesetzt
		contentPane.setLayout(null);
		// Alle Labels werden hinzugefügt, damit sie sehbar sind
		contentPane.add(lTitel);
		contentPane.add(lInterpret);
		contentPane.add(lAlbum);
		contentPane.add(lJahr);
		// Alle Textfelder werden hinzugefügt, damit sie sehabar sind
		contentPane.add(tTitel);
		contentPane.add(tInterpret);
		contentPane.add(tAlbum);
		contentPane.add(tJahr);
		// Alle Buttons werden hinzugefügt, damit sie sichtbar sind
		contentPane.add(erster);
		contentPane.add(voriger);
		contentPane.add(naechster);
		contentPane.add(letzter);
		contentPane.add(neu);
		contentPane.add(loeschen);
		contentPane.add(alleLoeschen);
		// Fenster wird sichtbar gemacht
		setVisible(true);
		songliste = new Songliste(722);
		// setzt den Pfad für die Lese/Schreibe-Datei
		songliste.setPfad("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\U09_TeamarbeitSongliste\\src\\tracklist.csv");
		// songs werden aus der Datei ausgelesen
		int lesecode = songliste.lesenSongs();
		//wenn die Datei nicht vorhanden ist, oder anderer Fehler passiert ist
		if (lesecode != 0 || songliste.getAnzahl() == 0) {
			//neuer song wird dem leeren array angefügt
			songliste.anfuegenNeuen(new Song());
			aktuellerSong = songliste.getAktueller();
			neuModus = true;
		}
		//anstonsten wird der erste gesetzt
		else {
			neuModus = false;
			// geht zum ersten Song
			aktuellerSong = songliste.getErster();
		}
		// Ausgabe in der GUI, wenn nicht null
		if (aktuellerSong != null) {
			tTitel.setText(aktuellerSong.getTitel());
			tInterpret.setText(aktuellerSong.getInterpret());
			tAlbum.setText(aktuellerSong.getAlbum());
			if (aktuellerSong.getErscheinungsjahr() < 0) {
				tJahr.setText(null);
			} else {
				tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
			}
		}

		// Window-Listener for schreibenSongs
		/**
		 * Dises Window-Listener braucht man, damit man wenn man das Programm mit X
		 * beendet alles was man verändert hat in die CSV-Datei hineinschreibt
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//schließen
				super.windowClosing(e);
				aktuellerSong = songliste.getAktueller();
				int loschwert = 0;
				while (true) {
					//leere, unnötige Songs werden, vor dem schließen entfernt
					try {
						if (aktuellerSong.getErscheinungsjahr() == -1) {
							loschwert = songliste.loeschenAktuellen();
						} else {
							break;
						}
						if (loschwert == -1) {
							break;
						}
					} catch (NullPointerException n) {
						break;
					}
				}
				// schreiben Songs
				songliste.schreibenSongs();
			}

		});

		/**
		 * Das ist der Action Listener für den "Erster" Knopf, er wird erst aufgerufen
		 * wenn man ihn drükt. Falls man diesen Knopf drück so wird das erste Song in
		 * der GUI ausgegeben. Falls man das Jahr auf eine nicht gültige Zahl verändert
		 * hat, so wird ein Dialog ausgegeben, dass man eine gütlitge Zahl eingeben soll
		 * und es wird nicht auf gewünschten Song gesprungen solange man diesesn Fehler
		 * nicht aufgehoben hat. Das geschieht bei allen Knöpfen auser bei
		 * loechenAktuellen und bei alleLoeschen nicht, da es überflüssig ist
		 */
		erster.addActionListener(new ActionListener() {
			// wenn action performed
			public void actionPerformed(ActionEvent e) {
				//deklaration
				boolean empty = false;
				boolean abbruch = false;
				//wird gesetzt
				aktuellerSong = songliste.getAktueller();
				aktuellerSong.setTitel(tTitel.getText());
				aktuellerSong.setInterpret(tInterpret.getText());
				aktuellerSong.setAlbum(tAlbum.getText());
				//sollte jahr empty sein
				if (!tJahr.getText().isEmpty()) {
					try {
						aktuellerSong.setErscheinungsjahr(Integer.parseInt(tJahr.getText()));
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(getContentPane(), "Bitte eine gültige Zahl eingeben!");
						abbruch = true;
					}
				} else {
					aktuellerSong.setErscheinungsjahr(0);
				}
				//überprüft ob alles empty ist
				if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
						&& tJahr.getText().isEmpty()) {
					empty = true;
				}
				if (!abbruch) {
					if (songliste.getLetzter().equals(aktuellerSong) && empty && !neuModus) {
						songliste.loeschenAktuellen();
					}
					neuModus = false;
					//ausgabe an die GUI
					aktuellerSong = songliste.getErster();
					tTitel.setText(aktuellerSong.getTitel());
					tInterpret.setText(aktuellerSong.getInterpret());
					tAlbum.setText(aktuellerSong.getAlbum());
					if (aktuellerSong.getErscheinungsjahr() < 0) {
						tJahr.setText(null);
					} else {
						tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
					}
				}
			}
		});

		/**
		 * Dieser Actionlistener ist für den Button voriger gedacht. Es wird aufgeruft
		 * falls man auf den "Vorigen" Knopf drückt. Falls man diesen Knopf drückt und
		 * man schon am Anfang ist, kommt die Meldung "Am Anfang angekommen". Falls
		 * nicht dann wird der vorherige Song in der GUI ausgegeben. Hat man mit
		 * nächster einen leeren Song erstellt und dann auf diesen Knopf drück, so wird
		 * dieser gelöscht
		 */
		voriger.addActionListener(new ActionListener() {
			//wenn action-performed
			public void actionPerformed(ActionEvent e) {
				//deklaration
				boolean empty = false;
				boolean abbruch = false;
				boolean ausgabe = true;
				boolean neuErstellt = false;
				aktuellerSong = songliste.getAktueller();
				//überprüft ob der letzte erstellte song nicht beschrieben wurde
				if (aktuellerSong.getErscheinungsjahr() == -1) {
					neuErstellt = true;
				}
				//song wird gesetzt
				aktuellerSong.setTitel(tTitel.getText());
				aktuellerSong.setInterpret(tInterpret.getText());
				aktuellerSong.setAlbum(tAlbum.getText());
				if (!tJahr.getText().isEmpty()) {
					try {
						aktuellerSong.setErscheinungsjahr(Integer.parseInt(tJahr.getText()));
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(getContentPane(), "Bitte eine gültige Zahl eingeben!");
						abbruch = true;
					}
				} else {
					aktuellerSong.setErscheinungsjahr(0);
				}
				//überprüft ob die eingabe in der gui leer ist
				if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
						&& tJahr.getText().isEmpty()) {
					empty = true;
				}
				if (!abbruch) {
					if (neuErstellt && empty && !neuModus) {
						//löscht unnötigen song
						songliste.loeschenAktuellen();
						aktuellerSong = songliste.getAktueller();
					} else {
						//voriger wird gesetzt
						aktuellerSong = songliste.getVoriger();
					}
					//Fehlermeldung: am Anfang angekommen
					if (aktuellerSong == null) {
						JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
						ausgabe = false;
					}
					neuModus = false;
					//Ausgabe an die GUI
					if (ausgabe) {
						tTitel.setText(aktuellerSong.getTitel());
						tInterpret.setText(aktuellerSong.getInterpret());
						tAlbum.setText(aktuellerSong.getAlbum());
						if (aktuellerSong.getErscheinungsjahr() < 0) {
							tJahr.setText(null);
						} else {
							tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
						}
					}
				}
			}
		});

		/**
		 * Das ist der Action Listener für den "Nächster" Knopf. Es soll falls man auf
		 * ihn drückt zum nächst möglichen Song springen. Ist man am Ende und nächster
		 * drückt so wird ein leeres Song erstellt, drückt man mehrmals nächster am Ende
		 * wird trotztdem nur ein leerer Song erstellt. Dies wird gelöscht falls man
		 * nicht einträgt und voriger drückt.
		 */
		naechster.addActionListener(new ActionListener() {
			//action performed
			public void actionPerformed(ActionEvent e) {
				//deklaration
				boolean empty = false;
				boolean abbruch = false;
				aktuellerSong = songliste.getAktueller();
				//überprüft auf die Eingabe leer ist
				if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
						&& tJahr.getText().isEmpty()) {
					empty = true;
				}
				if (!empty) {
					//song wird gesetzt
					if (songliste.getAnzahl() == 1 || aktuellerSong != null) {
						aktuellerSong.setTitel(tTitel.getText());
						aktuellerSong.setInterpret(tInterpret.getText());
						aktuellerSong.setAlbum(tAlbum.getText());
						if (!tJahr.getText().isEmpty()) {
							try {
								aktuellerSong.setErscheinungsjahr(Integer.parseInt(tJahr.getText()));
							} catch (NumberFormatException n) {
								JOptionPane.showMessageDialog(getContentPane(), "Bitte eine gültige Zahl eingeben!");
								abbruch = true;
							}
						} else {
							aktuellerSong.setErscheinungsjahr(0);
						}
						if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
								&& tJahr.getText().isEmpty()) {
							empty = true;
						}
					}

				}
				
				if (!abbruch) {
					if (songliste.getNaechster() == null) {
						if (!empty) {
							//wenn am Ende angekommen, wird neuer Song angefügt
							int ret = songliste.anfuegenNeuen(new Song());
							//im fehlerfall erfolgt fehlermeldung
							if (ret == -1 || ret == -2) {
								JOptionPane.showMessageDialog(getContentPane(),
										"ERROR: Versuch einen neuen Song " + "hinzuzufügen fehlgeschlagen!");
							}
							aktuellerSong = songliste.getAktueller();
						}
					} else {
						//nächster wird angesteuert
						aktuellerSong = songliste.getAktueller();
					}
					neuModus = false;
					//ausgabe an die GUI
					tTitel.setText(aktuellerSong.getTitel());
					tInterpret.setText(aktuellerSong.getInterpret());
					tAlbum.setText(aktuellerSong.getAlbum());
					if (aktuellerSong.getErscheinungsjahr() < 0) {
						tJahr.setText(null);
					} else {
						tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
					}
				}
			}
		});

		/**
		 * Das ist der Action Listener für den "Letzter" Knopf. Falls man ihn drückt
		 * wird man beim letzten Song gesprungen
		 */
		letzter.addActionListener(new ActionListener() {
			//action performed
			public void actionPerformed(ActionEvent e) {
				//deklaration
				boolean empty = false;
				boolean abbruch = false;
				boolean neuErstellt = false;
				aktuellerSong = songliste.getAktueller();
				//überprüft ob der letzte erstellte song nicht beschrieben wurde
				if (aktuellerSong.getErscheinungsjahr() == -1) {
					neuErstellt = true;
				}
				//song wird gesetzt
				aktuellerSong.setTitel(tTitel.getText());
				aktuellerSong.setInterpret(tInterpret.getText());
				aktuellerSong.setAlbum(tAlbum.getText());
				if (!tJahr.getText().isEmpty()) {
					try {
						aktuellerSong.setErscheinungsjahr(Integer.parseInt(tJahr.getText()));
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(getContentPane(), "Bitte eine gültige Zahl eingeben!");
						abbruch = true;
					}
				} else {
					aktuellerSong.setErscheinungsjahr(0);
				}
				//überprüft ob GUI-Eingabe leer ist
				if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
						&& tJahr.getText().isEmpty()) {
					empty = true;
				}
				if (!abbruch) {
					//löscht unnötige Songs
					if (neuErstellt && empty && !neuModus) {
						songliste.loeschenAktuellen();
						aktuellerSong = songliste.getAktueller();
					} else {
						//steuert letzten an
						aktuellerSong = songliste.getLetzter();
					}
					neuModus = false;
					//ausgabe an die GUI
					tTitel.setText(aktuellerSong.getTitel());
					tInterpret.setText(aktuellerSong.getInterpret());
					tAlbum.setText(aktuellerSong.getAlbum());
					if (aktuellerSong.getErscheinungsjahr() < 0) {
						tJahr.setText(null);
					} else {
						tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
					}
				}

				// ----------V2----------END
			}
		});

		/**
		 * Das ist der Action Listener für den "Neu" Knopf. Falls man ihn drückt wird
		 * ein neues leeres Song am Ende erstellt. Trägt man nichts ein und trotztdem
		 * den vorigen Knopf drückt wird dies nicht gelöscht
		 */
		neu.addActionListener(new ActionListener() {
			//action performed
			public void actionPerformed(ActionEvent e) {
				boolean empty = false;
				boolean abbruch = false;
				boolean neuErstellt = false;
				aktuellerSong = songliste.getAktueller();
				//überprüft ob vorher erstellter song nicht beschrieben wurde
				if (aktuellerSong != null) {
					if (aktuellerSong.getErscheinungsjahr() == -1) {
						neuErstellt = true;
					}
					//song wird gesetzt
					aktuellerSong.setTitel(tTitel.getText());
					aktuellerSong.setInterpret(tInterpret.getText());
					aktuellerSong.setAlbum(tAlbum.getText());
					if (!tJahr.getText().isEmpty()) {
						try {
							aktuellerSong.setErscheinungsjahr(Integer.parseInt(tJahr.getText()));
						} catch (NumberFormatException n) {
							JOptionPane.showMessageDialog(getContentPane(), "Bitte eine gültige Zahl eingeben!");
							abbruch = true;
						}
					} else {
						aktuellerSong.setErscheinungsjahr(0);
					}
				}
				//überprüft ob die GUI-Eingabe leer ist
				if (tTitel.getText().isEmpty() && tInterpret.getText().isEmpty() && tAlbum.getText().isEmpty()
						&& tJahr.getText().isEmpty()) {
					empty = true;
				}
				if (!abbruch && !neuModus) {
					if (neuErstellt && empty) {
						//unnötiger Song wird gelöscht
						int ret = songliste.loeschenAktuellen();
						//fehlermeldung wenn beim löschen fehler passiert
						if (ret == -1 || ret == -2) {
							JOptionPane.showMessageDialog(getContentPane(),
									"ERROR: Versuch einen neuen Song " + "hinzuzufügen fehlgeschlagen!");
						}
					}
					//neuer Song wird angefügt
					Song s = new Song();
					s.setErscheinungsjahr(-2);
					songliste.anfuegenNeuen(s);
					//ausgabe an die GUI
					aktuellerSong = songliste.getAktueller();
					tTitel.setText(aktuellerSong.getTitel());
					tInterpret.setText(aktuellerSong.getInterpret());
					tAlbum.setText(aktuellerSong.getAlbum());
					if (aktuellerSong.getErscheinungsjahr() < 0) {
						tJahr.setText(null);
					} else {
						tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
					}
					//neuModus wird auf true gesetzt
					neuModus = true;
				}
			}
		});

		/**
		 * Das ist der Action Listener für den "Löschen" Knopf. Drückt man ihn so wird eine Meldung kommen
		 * ob man diesen Datensatz wirklich löschen möchte, falls der Benutzer diesen Knopf versehentlich
		 * gedrückt hat. Falls man den Knopf gedrückt hat und der aktuelleSong null ist wird die Meldung 
		 * Am Anfang angekommen gezeigt, andernfalls wird der vorige Song auf der GUI angezeigt 
		 */
		loeschen.addActionListener(new ActionListener() {
			//action performed
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Wirklich diesen Datensatz löschen?",
						"Diesen Datensatz löschen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					songliste.loeschenAktuellen();
					aktuellerSong = songliste.getAktueller();
					if (aktuellerSong == null) {
						JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
					} else {
						tTitel.setText(aktuellerSong.getTitel());
						tInterpret.setText(aktuellerSong.getInterpret());
						tAlbum.setText(aktuellerSong.getAlbum());
						tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
					}
				}
			}
		});

		/**
		 * Das ist der Action Listener für den "Alle Löschen" Knopf. Falls man ihn drückt wird zuerst
		 * sicherheitshalber die Meldung angezeigt ob man alle Songs wirklich löschen möchte. Falls ja
		 * werden alle gelöscht. Falls nicht wird diese Operation abgebrochen.
		 */
		alleLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Wirklich alle löschen?", "Alle löschen",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					int ret = songliste.loeschenAlle();
					aktuellerSong = songliste.getAktueller();
					if (ret == 0) {
						tTitel.setText("");
						tInterpret.setText("");
						tAlbum.setText("");
						tJahr.setText("");
						songliste.anfuegenNeuen(new Song());
						neuModus = true;
					}
				}
			}
		});
	}

}