package Quicksort;

public class QuickSortTestprogramm {

	public static void main(String[] args) {
		QuickSort q = new QuickSort(10000000);
		q.printFile("neu.txt");
		q.sort();
		q.printFile("sorted.txt");
	}

}
