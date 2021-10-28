package net.tfobz.ratenrechner;

/**
 * RatenRechnerException
 * realistiert eine Exceptionklasse für RatenRechner.java
 * extends Exception
 * @author Michael Morandell
 *
 */
public class RatenRechnerException extends Exception{
	/**
	 * RatenRechnerException-Konstruktor
	 * @param msg, Sting mit der Error-Nachricht
	 */
	public RatenRechnerException(String msg) {
		//Konstruktor-Aufruf der ExceptionKlasse
		super(msg);
	}
	
}
