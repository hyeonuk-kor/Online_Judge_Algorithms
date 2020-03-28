package baekjoon.일곱난장이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2309번 일곱 난장이
 * @author mrseo
 */
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[] m = new int[9];
		
		int sum  = -100; //전체의 합
		
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(br.readLine());
			sum+=m[i];
		}
		Arrays.sort(m);
		
		
		
	}

}
