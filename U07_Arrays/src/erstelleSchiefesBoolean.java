
public class erstelleSchiefesBoolean {

	public static void main(String[] args) {
		boolean b [][] = methode(10);	
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean [][] methode (int zeilen) {
		boolean [][] ret = null;
		ret = new boolean [zeilen][];
		for (int i = 0; i < ret.length; i++) {
			ret [i] = new boolean[i+1];
		}
		return ret;
	}

}
