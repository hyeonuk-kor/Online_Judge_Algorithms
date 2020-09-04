package baekjoon.다이얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이얼 {

	public static void main(String[] args) throws IOException {
		
		char[] dials = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int time = 0;
		for(char i: dials) {
			System.out.print(i+" ");
			time += (i-'A')/3+3;
			if(i=='S'||i=='V'||i=='Y'||i=='Z')
				time--;
			System.out.println(time);
		}
		System.out.println(time);
		
	}

}
