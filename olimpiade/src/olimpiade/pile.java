package olimpiade;
import java.util.*;
import java.io.*;
import java.lang.*;

public class pile {
    public int solve(int N, int[] A, int[] B, int[] C) {
    	int risposta = 0;
    	int [] help = new int [3]; 
    	for (int i = 0; i < N; i++) {
    		help[0] = A[i];
    		help[1] = B[i];
    		help[2] = C[i];
    		
    		if (help[0] > help[1]) {
    			if (help[0] > help[2]) {
    				risposta = risposta + help[0];
    			}
    			else {
    				risposta = risposta + help[2];
    			}
    		}
    		else {
    			if (help[1] > help[2]) {
    				risposta = risposta + help[1];
    			}
    			else {
    				risposta = risposta + help[2];
    			}
    		}
    		
    	}
        // aggiungi codice...
        return risposta;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // se preferisci leggere e scrivere da file
        // ti basta modificare la seguente variabile
        boolean input_from_file = true;

        InputStream fin;
        OutputStream fout;
        if(input_from_file) {
            fin = new FileInputStream("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\olimpiade\\src\\olimpiade\\pile_input_1.txt");
            fout = new FileOutputStream("C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\olimpiade\\src\\olimpiade\\output.txt");
        } else {
            fin = System.in;
            fout = System.out;
        }

        Scanner scn = new Scanner(fin);
        PrintStream prnt = new PrintStream(fout);
        
        int T = scn.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = scn.nextInt();

            int[] A = new int[N];
            int[] B = new int[N];
            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scn.nextInt();
                B[i] = scn.nextInt();
                C[i] = scn.nextInt();
            }

            pile solver = new pile();
            int risposta = solver.solve(N, A, B, C);

            prnt.format("Case #%d: %d\n", t, risposta);
            fout.flush();
        }
    }
}