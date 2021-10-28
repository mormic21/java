package net.tfobz.ratenrechner;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * TilgungsplanGUI
 * stellt den Tilgungsplan im HTML-Format dar. 
 * Auserdem wird die Speichern-Funktionalität hier realisiert
 * erbt von JDialog
 * @author Michael Morandell
 *
 */
public class TilgungsplanGUI extends JDialog {
	//Membervariablen fuer die GUI
	private JButton saveButton = null;
	private JScrollPane scrollpane = null;
	private JEditorPane htmlview = null;
	//Filechooser
	private JFileChooser filechooser = null;
	
	/**
	 * TilgungsplanGUI-Konstruktor
	 * @param owner, Besitzer-Frame dieses Dialogfensters
	 * @param tilgungsplan, im HTML-Format als String
	 */
	public TilgungsplanGUI(JFrame owner, String tilgungsplan) {
		//Konstruktoraufruf JDialog
		super(owner);
		//Hide on Close
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(1050, 180, 620, 720);
		//Titel
		this.setTitle("Tilgungsplan");
		//Modal
		this.setModal(true);
		this.setResizable(false);
		this.getContentPane().setLayout(null);

		// htmlview
		// jEditorPane
		htmlview = new JEditorPane();

		// scrollpane
		scrollpane = new JScrollPane(htmlview);
		scrollpane.setBounds(0, 0, this.getWidth() - 10, this.getHeight() - 80);
		// setBounds webview
		htmlview.setBounds(0, 0, scrollpane.getWidth() - 10, scrollpane.getHeight());
		//Content-Type
		htmlview.setContentType("text/html");
		//Nicht editirbar
		htmlview.setEditable(false);

		// ScrollBars
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//tilgungsplan als text
		htmlview.setText(tilgungsplan);
		//nach oben scrollen
		htmlview.setCaretPosition(0);
		//add scrollpane
		this.getContentPane().add(scrollpane);
		
		//Button
		saveButton = new JButton();
		saveButton.setBounds(scrollpane.getWidth() - 120, scrollpane.getHeight() + 6, 110, 30);
		saveButton.setText("Speichern");
		//add ActionListener
		saveButton.addActionListener(new SaveListener());
		//add button
		this.getContentPane().add(saveButton);
	}
	
	/**
	 * SaveListener
	 * Realisiert den Speichern-Dialog und die Speicherung des Tilgungsplans als HTML-Document
	 * @author Michael Morandell
	 *
	 */
	private class SaveListener implements ActionListener {

		/**
		 * Wenn Button gedrueckt wird
		 * @param e, actionEvent
		 * @Override
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//JFileChooser-Objekt
			filechooser = new JFileChooser();
			//DateiFilter setzen
			filechooser.setFileFilter(new FileNameExtensionFilter("HTML-Dateien", ".html"));
			//Speichern-Dialog wird gezeigt. Wenn auf "Speichern" gerueckt wird
			if (filechooser.showSaveDialog(TilgungsplanGUI.this) == JFileChooser.APPROVE_OPTION) {
				boolean overwrite = true;
				//Selected file wird untersucht
				File newfile = filechooser.getSelectedFile();
				//Wenn die Date nicht mit .html endet
				if (!newfile.getName().toLowerCase().endsWith(".html")) {
					//.html wird hinzugefuegt
					newfile = new File(newfile.getParentFile(), newfile.getName()+".html");
				}
				//Wenn diese Datei bereits vorhanden ist
				if (newfile.exists()) {
					//Ueberschreib-Abfrage
					int ret = JOptionPane.showConfirmDialog(TilgungsplanGUI.this,
							"Die Datei ist bereits vorhanden. Überschreiben?", "Meldung",
							JOptionPane.YES_NO_OPTION);
					//Wenn nicht ueberschrieben werden soll
					if (ret == JOptionPane.NO_OPTION) {
						overwrite = false;
					}
				}
				//Wenn ueberschrieben werden soll
				if (overwrite) {
					try {
						//neuer FileWriter
						FileWriter writer = new FileWriter(newfile);
						//File wird geschrieben
						writer.write(htmlview.getText());
						//FileWriter wird geschlossen
						writer.close();
					} catch (IOException ioerr) {
						//printen der IOException
						ioerr.printStackTrace();
					}
				}
			}
		}
	}
}
