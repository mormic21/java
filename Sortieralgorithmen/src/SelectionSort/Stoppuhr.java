package SelectionSort;
import java.io.*;

/**
 * Stoppuhr Klasse für das bereitgestellte Programm StoppuhrTest.java
 * 
 * @author Michael Morandell
 *
 */
public class Stoppuhr {
	private long starttime = 0;
	private long stoptime = 0;
	private long[] stoppzeit = new long[10000000];
	private int index = -1;
	private String dateiname = "";
	

	/**
	 * @return the starttime
	 */
	public long getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the stoptime
	 */
	public long getStoptime() {
		return stoptime;
	}

	/**
	 * @param stoptime the stoptime to set
	 */
	public void setStoptime(long stoptime) {
		this.stoptime = stoptime;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the dateiname
	 */
	public String getDateiname() {
		return dateiname;
	}

	/**
	 * @param dateiname the dateiname to set
	 */
	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}
	
	/**
	 * starteStoppuhr misst die aktuelle Zeit in ms und speichert sie in die Membervariable starttime
	 */
	public void starteStoppuhr() {
		this.setStarttime(new java.util.GregorianCalendar().getTimeInMillis());
	}
	
	/**
	 * stoppeStoppuhr misst die aktuelle Zeit in ms und speichert diese in die Membervariable stoptime
	 * Dann wird die Stoppzeit mithilfe der Differenz aus stoptime - starttime ermittelt und in das Array
	 * geschrieben, welche alle Stoppzeiten speichert.
	 */
	public void stoppeStoppuhr() {
		this.setStoptime(new java.util.GregorianCalendar().getTimeInMillis());
		this.setIndex(index + 1);
		this.stoppzeit[index] = this.getStoptime() - this.getStarttime();
	}
	
	/**
	 * Gibt die gemessene Stopzeit zurück, welche im Array an der Stelle index gespeichert ist
	 * @return
	 */
	public long getGestoppteZeit() {
		return this.stoppzeit[index];
	}
	
	/**
	 * Schreibt die gessenen Werte, welche im Array gespeichert wurden in eine CSV-Datei. Kann die Datei nicht angelegt
	 * werden, so wird -1 als Fehlermeldung zurückgegeben.
	 * @return ein Int, -1 bei Fehler, 0 bei erfolgreichem Schreiben
	 */
	public int schreibeZeiten(int [] anzahl) {
		//Rückgabevariable
		int ret = -1;
		// Zeilenweises Schreiben in eine Datei
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.getDateiname()));
			//Anlegen der Datei hat funktioniert, also ist ret gleich 0
			ret = 0;
			//Schreiben der Titelzeile
			writer.write("Anzahl Elemente;gestoppte Zeit[ms]\n");
			//Jedes Element im Array wird geschrieben
			for (int i = 0; i <= index; i++) {
				writer.write(anzahl[i]+";"+stoppzeit[i]+"\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Datei nicht angelegt");
		}
		return ret;
	}

}