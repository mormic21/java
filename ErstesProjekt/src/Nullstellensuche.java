
public class Nullstellensuche
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int a = 4;
    int b = -7;
    int c = 3;
    double d = (b*b)-4*(a*c);
    double x1;
    double x2;
    double w = Math.sqrt((b*b)-4*(a*c));
    
     x1 = (-b + w)/(2*a);
     x2 = (-b - w)/(2*a);
    
    System.out.print("Diskriminante =" +d);
    System.out.println("Nullstelle 1 =" +x1);
    System.out.print("Nullstelle 2 =" +x2);
	}

}
