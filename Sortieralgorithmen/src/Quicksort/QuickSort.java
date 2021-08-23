package Quicksort;

import java.io.*;

public class QuickSort {
	private int [] liste;
	
	public QuickSort(int length) {
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
			File datei = new File("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\Sortieralgorithmen\\src\\Quicksort\\"+path);
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
		sort(0, this.liste.length-1);
	}
	
	public void sort(int low, int high) {
		if (low < high) {
			int pivot = part(low, high);
			sort(low, pivot-1);
			sort(pivot+1, high);
		}
	}
	
	public int part(int low, int high) {
		int pivot = liste[high];
		int low_speicher = low;
		int high_speicher = high;
		while(low < high) {
			while(high > low_speicher && liste[high] >= pivot) {
				high--;
			}
			while(low < high_speicher && liste[low] < pivot) {
				low++;
			}
			if (low < high) {
				int help = liste[low];
				liste[low] = liste[high];
				liste[high] = help;
			}
		}
		if (liste[low] > pivot) {
			int help = liste[high_speicher];
			liste[high_speicher] = liste[low];
			liste[low] = help;
		}
		return low;
	}
}
