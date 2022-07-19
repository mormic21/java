package net.tfobz.aufzaehltypen;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Arbeitstage
 * implements Iterable<Wochentag>
 * @author Michael Morandell
 *
 */
public class Arbeitstage implements Iterable<Wochentag> {
	//EnumSet
	private EnumSet<Wochentag> arbeitswoche = null;
	
	/**
	 * Arbeitstage-Konstruktor
	 */
	public Arbeitstage() {
		//alle Elemente des Enums
		arbeitswoche = EnumSet.allOf(Wochentag.class);
	}
	
	/**
	 * Arbeitstage-Konstruktor
	 * nimmt alle Wochentage vom erster bis letzter ins EnumSet-Objekt auf
	 * @param erster, Wochentag
	 * @param letzter, Wochentag
	 */
	public Arbeitstage(Wochentag erster, Wochentag letzter) {
		arbeitswoche = EnumSet.<Wochentag>range(erster, letzter);
	}
	
	/**
	 * add - Methode
	 * @param tag, Wochentag
	 * @return boolean, true wenn erfolgreich
	 */
	public boolean add(Wochentag tag) {
		return arbeitswoche.add(tag);
	}
	
	/**
	 * remove - Methode
	 * @param tag, Wochentag
	 * @return boolean, true wenn erfolgreich
	 */
	public boolean remove(Wochentag tag) {
		return arbeitswoche.remove(tag);
	}
	
	/**
	 * contains - Methode
	 * @param tag, Wochentag
	 * @return boolean, true wenn erfolgreich
	 */
	public boolean contains(Wochentag tag) {
		return arbeitswoche.contains(tag);
	}
	
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		return arbeitswoche.toString();
	}
	
	/**
	 * getWochenart
	 * @return Wochenart
	 */
	public Wochenart getWochenart() {
		//Wochenart null
		Wochenart ret = null;
		//Solange kein Sonntag enthalten ist
		if (!this.arbeitswoche.contains(Wochentag.SONNTAG)) {
			//Wenn Montag in der arbeitswoche vorhanden
			if (this.arbeitswoche.contains(Wochentag.MONTAG)) {
				if (this.arbeitswoche.contains(Wochentag.DIENSTAG)) {
					if (this.arbeitswoche.contains(Wochentag.MITTWOCH)) {
						if (this.arbeitswoche.contains(Wochentag.DONNERSTAG)) {
							//Wenn Freitag vorhanden und Samstag nicht vorhanden
							if (this.arbeitswoche.contains(Wochentag.FREITAG)
									&& !this.arbeitswoche.contains(Wochentag.SAMSTAG)) {
								//FuenftageWoche
								ret = Wochenart.FUENFTAGE;
							}
							//Wenn Freitag und Samstag vorhanden sind
							if (this.arbeitswoche.contains(Wochentag.FREITAG)
									&& this.arbeitswoche.contains(Wochentag.SAMSTAG)) {
								//Sechstagewoche
								ret = Wochenart.SECHSTAGE;
							}
						}
					}
				}
			}
		}
		//return
		return ret;
	}
	
	/**
	 * Iterable-Interface
	 */
	
	/**
	 * iterator
	 * @return Iterator<Wochentag>
	 */
	@Override
	public Iterator<Wochentag> iterator() {
		return arbeitswoche.iterator();
	}
}