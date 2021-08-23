package SelectionSort;

public class SelectionSortHauptprogramm {

	public static void main(String[] args) {
		Stoppuhr s = new Stoppuhr();
		s.setDateiname("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\Sortieralgorithmen\\src\\SelectionSort\\table_selection.csv");
		int n = 0;
		int i = 1;
		int c = 0;
		int [] cache = new int[100000000];
		int j = 0;
		while (n < 10000000) {
			if (i == 10) {
				i = 1;
				c++;
			}
			n = i*(int)(Math.pow(10, c));
			SelectionSort l = new SelectionSort(n);
			s.starteStoppuhr();
			l.sort();
			s.stoppeStoppuhr();
			System.out.println("Anzahl: "+n+" Zeit: "+s.getGestoppteZeit()+"ms");
			cache[j] = n;
			i++;
			j++;
		}
		int ret = s.schreibeZeiten(cache);
		System.out.println(ret);
	}

}