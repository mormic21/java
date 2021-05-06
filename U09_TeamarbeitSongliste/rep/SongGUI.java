import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SongGUI extends JFrame
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
	 * Dieser Custom-Constructor erstellt die GUI
	 * für die Songliste. Das Fenster besteht aus insgesamt
	 * 5 Label und Textfelder, als auch 5 Buttons. 
	 */
	public SongGUI() {
		// Fenstereigenschaften
		setTitle("Songliste");
		setBounds(250, 500, 600, 400);
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
		tJahr.setBounds(100, 180, 50, 28);
		tJahr.setFont(new Font("Arial", 0, 14));
		// Alle Buttons werden gesetzt
		erster = new JButton();
		erster.setBounds(20, 225, 540/4, 50);
		erster.setText("Erster");
		erster.setFont(new Font("Arial", Font.BOLD, 15));
		voriger = new JButton();
		voriger.setBounds(20+540/4, 225, 540/4, 50);
		voriger.setText("Voriger");
		voriger.setFont(new Font("Arial", Font.BOLD, 15));
		naechster = new JButton();
		naechster.setBounds(20+540/4*2, 225, 540/4, 50);
		naechster.setText("Nächster");
		naechster.setFont(new Font("Arial", Font.BOLD, 15));
		letzter = new JButton();
		letzter.setBounds(20+540/4*3, 225, 540/4, 50);
		letzter.setText("Letzter");
		letzter.setFont(new Font("Arial", Font.BOLD, 15));
		neu = new JButton();
		neu.setBounds(20, 285, 540/3, 50);
		neu.setText("Neu");
		neu.setFont(new Font("Arial", Font.BOLD, 15));
		loeschen = new JButton();
		loeschen.setBounds(20+540/3, 285, 540/3, 50);
		loeschen.setText("Löschen");
		loeschen.setFont(new Font("Arial", Font.BOLD, 15));
		alleLoeschen = new JButton();
		alleLoeschen.setBounds(20+540/3*2, 285, 540/3, 50);
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
		// Alle Buttons werden hinzugefügt, damit sie sehabar sind
		contentPane.add(erster);
		contentPane.add(voriger);
		contentPane.add(naechster);
		contentPane.add(letzter);
		contentPane.add(neu);
		contentPane.add(loeschen);
		contentPane.add(alleLoeschen);
		// Fenster wird sichtbar gemacht
		setVisible(true);
		songliste = new Songliste(500);
		// Ereignis passiert, falls man den "erster" Knopf drückt
		erster.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				aktuellerSong = songliste.getErster();
				
				if (aktuellerSong != null) {
					tTitel.setText(aktuellerSong.getTitel());
					tInterpret.setText(aktuellerSong.getInterpret());
					tAlbum.setText(aktuellerSong.getAlbum());
					tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
				}
			}
		});

		// Ereignis passiert, falls man den "voriger" Knopf drückt
		voriger.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				aktuellerSong = songliste.getAktueller();
				if (songliste.getNummerAktueller() == 0) {
					JOptionPane.showMessageDialog(
							 getContentPane(),
							 "Am Anfang angekommen"); 
				}
			}
		});
		// Ereignis passiert, falls man den "naechster" Knopf drückt
		naechster.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		// Ereignis passiert, falls man den "letzer" Knopf drückt
		letzter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			aktuellerSong = songliste.getLetzter();
			
			if (aktuellerSong != null) {
				tTitel.setText(aktuellerSong.getTitel());
				tInterpret.setText(aktuellerSong.getInterpret());
				tAlbum.setText(aktuellerSong.getAlbum());
				tJahr.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));
			}
				
			}
		});
		// Ereignis passiert, falls man den "neu" Knopf drückt
		neu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		// Ereignis passiert, falls man den "loeschen" Knopf drückt
		loeschen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		// Ereignis passiert, falls man den "alleLoeschen" Knopf drückt
		alleLoeschen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(
						 getContentPane(),
						 "Wirklich alle löschen?",
						 "Alle löschen",
						 JOptionPane.YES_NO_OPTION) ==
						 JOptionPane.YES_OPTION) {
					
				}
			}
		});
	}
	/**
	 * @return the songliste
	 */
	public Songliste getSongliste() {
		return songliste;
	}
	/**
	 * @param songliste the songliste to set
	 */
	public void setSongliste(Songliste songliste) {
		this.songliste = songliste;
	}
	/**
	 * @return the aktuellerSong
	 */
	public Song getAktuellerSong() {
		return aktuellerSong;
	}
	/**
	 * @param aktuellerSong the aktuellerSong to set
	 */
	public void setAktuellerSong(Song aktuellerSong) {
		this.aktuellerSong = aktuellerSong;
	}
	/**
	 * @return the neuModus
	 */
	public boolean isNeuModus() {
		return neuModus;
	}
	/**
	 * @param neuModus the neuModus to set
	 */
	public void setNeuModus(boolean neuModus) {
		this.neuModus = neuModus;
	}
}
