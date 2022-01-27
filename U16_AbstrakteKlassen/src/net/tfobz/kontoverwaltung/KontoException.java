package net.tfobz.kontoverwaltung;

/**
 * KontoException
 * realisiert die Behandlung von Fehlerf�llen in den einzelnen Objekten
 * extends Exception
 * @author Michael Morandell
 *
 */
@SuppressWarnings("serial")
public class KontoException extends Exception {
	/**
	 * KontoException-Konstruktor
	 * @param msg, String
	 */
	public KontoException(String msg) {
		super(msg);
	}
}
