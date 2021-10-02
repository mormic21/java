package net.tfobz.tictactoe.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.tfobz.tictactoe.*;

/**
 * Stellt das Spielfeld des Spiels TicTacToe in einem JFrame-Fenster dar. Das Spielfeld
 * wird durch Knöpfe des Typs TicTacToeJButton dargestellt. Weiters verfügt das Fenster
 * über eine Überschrift, welche denselben Text wie der Fenstertitel enthält und eine 
 * Statusleiste durch welche Meldungen an den Benutzer ausgegeben werden können 
 * @author Michael Wild
 */
public class TicTacToeJFrame extends JFrame
{
	/**
	 * Das Spielfeld der Knöpfe 
	 */
	private TicTacToeJButton[][] b = null;
	/**
	 * Die Statusleiste
	 */
	private JLabel statusleiste = null;
	/**
	 * Ein Verweis auf das Objekt welches das TicTacToe-Spiel realisiert
	 */
	private TicTacToe tictactoe = null;
	/**
	 * Legt fest, ob das Fenster auf Eingaben des Benutzers reagiert oder nicht
	 */
	private boolean eingabenMoeglich = false;
	/**
	 * Die Feldnummer des Feldes das der Benutzer durch die maus ausgewählt hat
	 */
	private int gewaehlteFeldnummer = -1;
	
	/**
	 * Konstruktor der die Benutzerschnittstelle in einem Fenster erstellt und anzeigt.
	 * Dem Konstruktor wird der Titel des Fensters übergeben. Weiters erhält der Konstruktor
	 * das TicTacToe-Spielobjekt aus welchem dann die Benutzerschnittstelle die Größe
	 * des Spielfeldes und die gesetzten Züge ermitteln kann. Dieses Objekt stellt das
	 * Hauptprogramm dar
	 * @param titel des Fensters
	 * @param tictactoe jenes Objekt welches die Funktionalität des Spiels in sich birgt,
	 * entweder ein Objekt vom Typ TicTacToeServer oder TicTacToeClient
	 */
	public TicTacToeJFrame(String titel, TicTacToe tictactoe) {
		super(titel);
		// Verbindung zum Hauptprogramm
		this.tictactoe = tictactoe;

		// Anlegen der Überschrift und der Statuszeile
		JLabel ueberschrift = new JLabel(titel);
		ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		ueberschrift.setFont(new Font(this.getContentPane().getFont().getName(),Font.BOLD,20));
		this.getContentPane().add(ueberschrift, BorderLayout.NORTH);
		statusleiste = new JLabel("Statusleiste");
		statusleiste.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(statusleiste, BorderLayout.SOUTH);
		
		// Anlegen der Knöpfe
		JPanel p = new JPanel();
		p.setLayout(
			new GridLayout(this.tictactoe.getFeldgroesse(),this.tictactoe.getFeldgroesse()));
		b = new 
			TicTacToeJButton[this.tictactoe.getFeldgroesse()][this.tictactoe.getFeldgroesse()];
		int feldnummer = 0;
		for (int i = 0; i < this.tictactoe.getFeldgroesse(); i = i + 1)
			for (int j = 0; j < this.tictactoe.getFeldgroesse(); j = j + 1) {
				b[i][j] = new TicTacToeJButton(feldnummer);
				feldnummer = feldnummer + 1;
				// Registrieren des Aktionsabhoerers
				b[i][j].addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (eingabenMoeglich) {
								// Fenster reagiert auf das Klicken der Knöpfe. Es wird der 
								// gewählte Knopf gemerkt und sofort das Drücken weiterer Knöpfe
								// unterbunden
								eingabenMoeglich = false;
								gewaehlteFeldnummer = ((TicTacToeJButton)(e.getSource())).getFeldnummer();
							}
						}
					}
				);
				p.add(b[i][j]);
			}
		this.getContentPane().add(p,BorderLayout.CENTER);
		
		// Schließen des Fensters
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// Das Fenster wird geschlossen und mit ihm das gesamte Programm
					setVisible(false);
					dispose();
					System.exit(0);
				}
			}
		);
		this.setBounds(100,100,250,350);
		this.setVisible(true);
	}
	
	/**
	 * Stellt das Fenster neu dar indem es auch die gesetzten Züge in den Knöpfen
	 * darstellt
	 */
	public void repaint() {
		for (int i = 0; i < this.tictactoe.getFeldgroesse(); i = i + 1)
			for (int j = 0; j < this.tictactoe.getFeldgroesse(); j = j + 1) {
				if (this.tictactoe.getSpielfeld(i,j) == this.tictactoe.SPIELER1)
			  	this.b[i][j].setX();
				if (this.tictactoe.getSpielfeld(i,j) == this.tictactoe.SPIELER2)
			  	this.b[i][j].set0();
			}
		super.repaint();
	}
	
	/*
	 * Getter- und Settermethoden
	 */
	/**
	 * Setzt den Statusleistentext des Fensters
	 * @param statusleistentext der zu setzen ist
	 */
	public void setStatusleistentext(String statusleistentext) {
		this.statusleiste.setText(statusleistentext);
	}
	/**
	 * Diese Methode liefert nur den ausgewählten Zug zurück. Sie setzt kein "X" oder "0"
	 * in den Knopf des Spielfeldes. Diese Methode wartet solange, solange der Zug nicht
	 * gesetzt ist und beendet erst dann den Aufruf, wenn der Zug über das Fenster 
	 * eingegeben wurde 
	 * @return der ausgewählte Zug
	 */
	public int getGewaehlteFeldnummer() {
		int ret = -1;
		this.eingabenMoeglich = true;
		this.gewaehlteFeldnummer = -1;
		do {
			Thread.yield();
			ret = this.gewaehlteFeldnummer;
		} while (ret == -1);
		this.eingabenMoeglich = false;
		return ret;
	}
}
