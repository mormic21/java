package net.tfobz.webbrowser;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * MeinWeb
 * realisiert einen einfachen Web-Browser mit GUI
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
public class MeinWeb extends JFrame {
	//Membervariablen fuer GUI
	private JLabel jLabel = null;
	private JTextField textfield = null;
	private JButton button = null;
	private JScrollPane scrollpane = null;
	private JEditorPane webview = null;
	
	/**
	 * MeinWeb-Konstruktor
	 * Setzt die GUI-Eigenschaften
	 */
	public MeinWeb() {
		//Exit on Close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Darstellung in der Mitte
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width / 2) - 300, (screen_size.height / 2) - 300, 600, 600);
		this.setResizable(false);
		//Titel
		this.setTitle("MeinWeb");
		this.getContentPane().setLayout(null);

		// jLabel
		jLabel = new JLabel();
		jLabel.setBounds(10, 10, 80, 20);
		jLabel.setText("Adresse: ");
		jLabel.setDisplayedMnemonic(KeyEvent.VK_S);

		// jtextfield
		textfield = new JTextField();
		textfield.setBounds(80, 10, (this.getWidth() - 200), 20);
		textfield.addFocusListener(new FocusAbhoerer());
		this.getContentPane().add(textfield);
		jLabel.setLabelFor(textfield);
		this.getContentPane().add(jLabel);

		// jbutton
		button = new JButton();
		button.setBounds((this.getWidth() - 110), 5, 80, 30);
		button.setText("search");
		button.addActionListener(new ButtonListener());
		this.getContentPane().add(button);
		this.getRootPane().setDefaultButton(button);

		// jEditorPane
		webview = new JEditorPane();

		// scrollpane
		scrollpane = new JScrollPane(webview);
		scrollpane.setBounds(0, 40, this.getWidth() - 10, this.getHeight() - 80);
		// setBounds webview
		webview.setBounds(0, 0, scrollpane.getWidth() - 10, scrollpane.getHeight());
		webview.setEditable(false);
		webview.addHyperlinkListener(new HTMLListener());
		// ScrollBars
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollpane);
	}
	
	/**
	 * ButtonListener
	 * reagiert auf das druecken des Buttons
	 * implementiert ActionListener
	 * @author Michael Morandell
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Url wird von GUI geholt
			String url = textfield.getText();
			//Wenn kein http:// oder https:// enthalten ist, wird ein http:// hinzugefuegt
			if (!url.contains("http://") && !url.contains("https://")) {
				url = "http://"+url;
			}
			try {
				//url wird ans editorpane uebergeben
				webview.setPage(url);
				//Url wird in Titel gezeigt
				setTitle("MeinWeb - " + url);
				//wenn IOException geworfen wird
			} catch (IOException err) {
				//MessageDialog
				JOptionPane.showMessageDialog(MeinWeb.this, "Kann dem Hyperlink nicht folgen", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * FocusAbhoerer
	 * Ueberprueft ob Textfeld in focus ist
	 * erbt von FocusAdapter
	 * @author Michael Morandell
	 *
	 */
	private class FocusAbhoerer extends FocusAdapter {
		/**
		 * focusGained
		 * @param e, FocusEvent
		 */
		@Override
		public void focusGained(FocusEvent e) {
			//ganzer Text in Textfield wird markiert
			textfield.selectAll();
		}
	}
	
	/**
	 * HTMLListener
	 * extrahiert alle Links und macht sie anklickbar
	 * implementiert HyperlinkListener
	 * @author Michael Morandell
	 *
	 */
	private class HTMLListener implements HyperlinkListener {
		/**
		 * hyperlinkUpdate
		 * @param e, HyperlinkEvent
		 */
		public void hyperlinkUpdate(HyperlinkEvent e) {
			//Wenn Hyperlink angeklickt wurde
			if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				try {
					//neue URL wird an das EditorPane uebergeben
					webview.setPage(e.getURL());
					//neue URL wird im Titel gesetzt
					setTitle("MeinWeb - "+e.getURL());
				} catch (IOException e1) {
					//MessageDialog
					JOptionPane.showMessageDialog(MeinWeb.this, "Kann dem Hyperlink nicht folgen", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
