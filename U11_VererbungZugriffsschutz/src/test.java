public class test {
	
	public static void main(String[] args) {
		int von = 1 + (10 * (1 - 1));
		System.out.println("von: "+von);
		int bis = 10 * 1;
		System.out.println("bis: "+bis);
		for (int i = 0; i < 50; i++)
			System.out.println((int)(Math.random()*(bis-von+1)+von));
		
		
		
		
		
//		int a = -10;
//		int b = 5;
//		b = (int)Math.copySign(a, b);
//		System.out.println(b);
		
		
		
//		NullPointerException e = new NullPointerException("at file: help.docx");
//		NullPointerException f = new NullPointerException("@author: Lairex59");
//		NullPointerException g = new NullPointerException("Unresolved Problem: Dog");
//		System.out.println(e);
//		System.out.println(f);
//		System.out.println(g);
	}

}
