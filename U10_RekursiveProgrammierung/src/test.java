
public class test {

	public static void main(String[] args) {
		//System.out.println(machWas(128));
		//System.out.println("REkursiv ---------------------------------------------------");
		//System.out.println(reteilbar(128));
		//knochenArbeit(101);
	}
	
	public static int reteilbar (int x) {
		int ret = 0;
		if (x / 2 > 0) {
			ret = ret + 1 + reteilbar(x/2);
		}
		return ret;
	}
	
	public static int machWas(int x) {
		int ret = 0;
		while (x / 2 > 0) {
			ret = ret + 1;
			x = x / 2;
		}
		return ret;
	}
	
	public static void rek(int i) {
		if (i > 3) {
			System.out.println(i * 3);
			rek(i - 1);
		}
	}
	
	public static void whileRekursiv(int i) {
		while (i > 3) {
			System.out.println(i * 3);
			i = i - 1;
		}
	}
	
	
	public static int knochenArbeit(int n) { 
		System.out.println(n);
		if (n == 100) 
			return 0; 
		else 
			if (n < 100) 
				return 1 + knochenArbeit(n + 2); 
			else 
				return 1 - knochenArbeit(n - 2); 
		}
}
