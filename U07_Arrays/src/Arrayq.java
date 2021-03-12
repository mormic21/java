
public class Arrayq {

	public static void main(String[] args) {
		int [][] b = {{11}, {21, 22, 23, 24, 25, 26, 27}, {7}, {41, 42, 43}};
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

}
