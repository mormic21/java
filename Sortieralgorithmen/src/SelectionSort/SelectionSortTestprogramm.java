package SelectionSort;

public class SelectionSortTestprogramm {

	public static void main(String[] args) {
		SelectionSort s = new SelectionSort(0);
		s.printFile("new.txt");
		s.sort();
		s.printFile("sorted.txt");

	}

}
