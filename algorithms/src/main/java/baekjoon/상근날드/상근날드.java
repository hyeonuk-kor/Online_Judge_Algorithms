package baekjoon.상근날드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상근날드 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] hamberger = new int[3];
		int hc = 0;
		
		int[] drink = new int[2];
		int dc = 0;
		
		for(int i=0; i<5; i++) {
			if(i<3)
				hamberger[hc++] = Integer.parseInt(br.readLine());
			else
				drink[dc++] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(hamberger);
		Arrays.sort(drink);
		
		System.out.println(hamberger[0]+drink[0]-50);
	}

}
