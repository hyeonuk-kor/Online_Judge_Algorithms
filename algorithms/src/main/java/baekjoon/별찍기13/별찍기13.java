package baekjoon.별찍기13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = N-1;
		
		for(int i=0; i<2*N-1; i++) {
			if(i<cnt) {
				for(int j=0; j<i+1; j++) {
					System.out.print("*");
				}
			} else {
				for(int j=cnt--; j>=0; j--)
					System.out.print("*");
			}
			System.out.println();
		}
	}

}
