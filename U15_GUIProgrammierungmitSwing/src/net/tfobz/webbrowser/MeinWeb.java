package net.tfobz.webbrowser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MeinWeb extends JFrame {
	private JLabel jLabel = null;
	private JTextField textfield = null;
	private JButton button = null;
	private JScrollPane scrollpane = null;
	private JEditorPane webview = null;

	public MeinWeb() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width / 2) - 300, (screen_size.height / 2) - 300, 600, 600);
		this.setResizable(false);
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

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String url = textfield.getText();
			if (!url.contains("http://") && !url.contains("https://")) {
				url = "http://"+url;
			}
			try {
				webview.setPage(url);
				setTitle("MeinWeb - " + url);
			} catch (IOException err) {
				JOptionPane.showMessageDialog(MeinWeb.this, "Kann dem Hyperlink nicht folgen", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class FocusAbhoerer extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			textfield.selectAll();
		}
	}

	private class HTMLListener implements HyperlinkListener {
		public void hyperlinkUpdate(HyperlinkEvent e) {
			if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				try {
					webview.setPage(e.getURL());
					setTitle("MeinWeb - "+e.getURL());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(MeinWeb.this, "Kann dem Hyperlink nicht folgen", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
