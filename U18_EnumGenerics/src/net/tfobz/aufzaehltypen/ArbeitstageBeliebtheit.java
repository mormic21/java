package net.tfobz.aufzaehltypen;
import java.util.EnumMap;
import java.util.Iterator;

/**
 * ArbeitstageBeliebtheit
 * implementiert Iterable<Wochentag>
 * @author Michael Morandell
 *
 */
public class ArbeitstageBeliebtheit implements Iterable<Wochentag> {
	//EnumMap
	private EnumMap<Wochentag, Beliebtheit> beliebtheit = null;
	
	/**
	 * ArbeitstageBeliebtheit-Konstruktor
	 * leeres EnumMap
	 */
	public ArbeitstageBeliebtheit() {
		beliebtheit = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
	}
	
	/**
	 * ArbeitstageBeliebtheit-Konstruktor
	 * @param woche, Arbeitstage
	 * @param bel, Beliebtheit
	 */
	public ArbeitstageBeliebtheit(Arbeitstage woche, Beliebtheit bel) {
		beliebtheit = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
		//Beliebtheit wird auf alle Wochentage übertragen
		for (Wochentag tag : woche) {
			beliebtheit.put(tag, bel);
		}
	}
	
	/**
	 * put
	 * @param wochentag, Wochentag
	 * @param bel, Beliebtheit
	 */
	public void put(Wochentag wochentag, Beliebtheit bel) {
		beliebtheit.put(wochentag, bel);
	}
	
	/**
	 * remove
	 * @param wochentag, Wochentag
	 */
	public void remove(Wochentag wochentag) {
		beliebtheit.remove(wochentag);
	}
	
	/**
	 * get
	 * @param wochentag, Wochentag
	 * @return Beliebtheit
	 */
	public Beliebtheit get(Wochentag wochentag) {
		return beliebtheit.get(wochentag);
	}
	
	/**
	 * contains
	 * @param wochentag, Wochentag
	 * @param bel, Beliebtheit
	 * @return boolean, wenn Tag enthalten
	 */
	public boolean contains(Wochentag wochentag, Beliebtheit bel) {
		boolean ret = false;
		//Wenn Wochentag enthalten
		if (beliebtheit.containsKey(wochentag)) {
			//Wenn dieser Wochentag mit dieser Beliebtheit enthalten
			ret = beliebtheit.get(wochentag).equals(bel);
		}
		return ret;
	}
	
	/**
	 * toString
	 * @return toString
	 */
	@Override
	public String toString() {
		return beliebtheit.toString();
	}
	
	/**
	 * Iterator-Interface
	 */
	
	/**
	 * iterator()
	 * @return Iterator<Wochentag>
	 */
	@Override
	public Iterator<Wochentag> iterator() {
		return beliebtheit.keySet().iterator();
	}
}