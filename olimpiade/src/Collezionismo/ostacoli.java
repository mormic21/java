package Collezionismo;

import java.util.*;
import java.io.*;
import java.lang.*;

public class ostacoli {
    public int solve(int N, int K, int[] C) {
    	//n -->Anzahl modelle
    	//K--> regale
    	//c --> Wert der modelle
    	int risposta = 0;
    	int diff = 0;
    	
    	int [][] cases = new int [K][(N-K)+1];
    	for (int i = 0; i < K; i++) {
    		for (int j = 0; j < ((N-K)+1); j++) {
    			for (int n = 0; n < N; n++) {
    				for (int l = 0; l < K; l++) {
    					if (l == i) {
    						cases[0][0] = 0;
    					}
    					else {
    						cases[0][0] = 0;
    					}
    				}
    				cases[0][0] = 0;
    			}
    		}
    	}

    	
        // aggiungi codice...

        return risposta;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // se preferisci leggere e scrivere da file
        // ti basta modificare la seguente variabile
        boolean input_from_file = false;

        InputStream fin;
        OutputStream fout;
        if(input_from_file) {
            fin = new FileInputStream("input.txt");
            fout = new FileOutputStream("output.txt");
        } else {
            fin = System.in;
            fout = System.out;
        }

        Scanner scn = new Scanner(fin);
        PrintStream prnt = new PrintStream(fout);

        int T = scn.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = scn.nextInt();
            int K = scn.nextInt();

            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                C[i] = scn.nextInt();
            }

            ostacoli solver = new ostacoli();
            int risposta = solver.solve(N, K, C);

            prnt.format("Case #%d: %d\n", t, risposta);
            fout.flush();
        }
    }
}
