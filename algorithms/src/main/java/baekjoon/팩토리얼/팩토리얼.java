package baekjoon.팩토리얼;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팩토리얼 {

	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println(factorial(N));
		
	}

	private static int factorial(int n) {
		if(n<=1)
			return 1;
		return n * factorial(n-1);
	}

}
