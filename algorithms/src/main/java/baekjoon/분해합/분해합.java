package baekjoon.분해합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분해합 {

	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int answer = 0;
		
		for(int i=1; i<=N; i++) {
			int M = i;
			int sum = i;
			
			while(M!=0) {
				int calc = M%10;
				sum += calc;
				M/=10;
			}
			
			if(sum==N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
