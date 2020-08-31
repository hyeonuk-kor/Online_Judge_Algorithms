package baekjoon.별찍기21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별찍기21 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[2][N];
		
		Arrays.fill(map[0], ' ');
		Arrays.fill(map[1], ' ');
		
		for(int i=0; i<N; i++) {
			if(i%2==0) map[0][i]='*';
			else map[1][i]='*';
		}

		for(int i=0; i<N; i++) {
			for(char[] a: map)
				System.out.println(a);
		}
	}

}
