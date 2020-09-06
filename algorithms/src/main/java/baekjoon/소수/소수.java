package baekjoon.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for(int i=M; i<=N; i++) {
			boolean check = true;
			if(i==1)
				check = false;
			else {
				for(int j=2; j<i; j++) {
					if(i%j==0) {
						check = false;
						break;
					}
				}
			}
			if(check) {
				sum += i;
				if(min > i)
					min = i;
			}
		}

		if(sum==0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
