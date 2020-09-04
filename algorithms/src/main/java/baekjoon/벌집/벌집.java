package baekjoon.벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int number = 1;
		int count = 1;
		
		while(number < N) 
			number += count++ * 6;
		System.out.println(count);
		
		
	}
	
}
