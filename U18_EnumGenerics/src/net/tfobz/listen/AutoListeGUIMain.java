package net.tfobz.listen;

/**
 * AutoListeGUIMain
 * instanzieert ein GUI-Fenster vom Typ AutoListeGUI und macht es visible
 * @author Michael Morandell
 *
 */
public class AutoListeGUIMain {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//neues GUI-Fenster
		AutoListeGUI autogui = new AutoListeGUI();
		//visible
		autogui.setVisible(true);
	}
}