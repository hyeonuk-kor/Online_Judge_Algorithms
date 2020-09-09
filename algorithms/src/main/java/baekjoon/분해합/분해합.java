package baekjoon.분해합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분해합 {

	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int answer = 0;
		
		for(int num=1; num<=N; num++) {
			int M = num;
			int sum = num;
			
			while(M!=0) {
				int calc = M%10;
				sum += calc;
				M/=10;
			}
			
			if(sum==N) {
				answer = num;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
