package net.tfobz.listen;

/**
 * Auto
 * @author Michael Morandell
 *
 */
public class Auto {
	//Membervariablen
	private String name = null;
	private int erstzulassung = 0;
	
	/**
	 * Auto-Konstruktor
	 */
	public Auto() {
	}
	
	/**
	 * Auto-Konstruktor
	 * @param name, String
	 * @param erstzulassung, Int
	 */
	public Auto(String name, int erstzulassung) {
		this.name = name;
		this.erstzulassung = erstzulassung;
	}
	
	/**
	 * setName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getName
	 * @return name, String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * setErstzulassung
	 * @param erstzulassung
	 */
	public void setErstzulassung(int erstzulassung) {
		this.erstzulassung = erstzulassung;
	}
	
	/**
	 * getErstzulassung
	 * @return erstzulassung, int
	 */
	public int getErstzulassung() {
		return this.erstzulassung;
	}
}