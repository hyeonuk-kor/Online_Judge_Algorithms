package baekjoon.피보나치수5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치수5 {

	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] arr = new int[20];
		System.out.println(fibo(N, arr));
		
	}

	private static int fibo(int n, int[] arr) {
		if(n==0)
			return 0;
		if(n==1 || n==2)
			return 1;
		return fibo(n-1, arr) + fibo(n-2, arr);
	}



}
