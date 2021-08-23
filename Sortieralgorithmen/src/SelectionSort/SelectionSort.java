package SelectionSort;

import java.io.*;

public class SelectionSort {

	private int [] liste;
	
	public SelectionSort(int length) {
		liste = new int[length];
		fillRandom(0, length);
	}
	
	public void fillRandom(int min, int max) {
		min--;
		for (int i = 0; i < liste.length; i++) {
			liste[i] = (int)(Math.random()*(max-min+1)+min);
		}
	}
	
	public void fillArray(int [] in) {
		liste = new int [in.length];
		for (int i = 0; i < in.length; i++) {
			liste[i] = in[i];
		}
	}
	
	public void print() {
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]+"; ");
		}
		System.out.println();
	}
	
	public void printFile(String path) {
		try {
			File datei = new File("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\Sortieralgorithmen\\src\\SelectionSort\\"+path);
			FileWriter writer = new FileWriter(datei);
			for (int i = 0; i < liste.length; i++) {
				writer.write("["+i+"]: "+liste[i]+";\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben der Datei");
		}
	}
	
	public void sort() {
		for (int i = 0; i < liste.length; i++) {
			int minIndex = i;
			for (int j = minIndex+1; j < liste.length; j++) {
				if (liste[minIndex] > liste[j]) {
					minIndex = j;
				}
			}
			int cache = liste[i];
			liste[i] = liste[minIndex];
			liste[minIndex] = cache;
		}
	}
}
