package baekjoon.한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 99;

		if(N<100) {
			System.out.println(N);
		} else {
			
			for(int i=100; i<=N; i++) {
				if(checkNum(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

	private static boolean checkNum(int number) {
		if(number==1000)
			return false;
		
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			arr[i]=number%10;
			number/=10;
			if(number==0)
				break;
		}
		
		return (arr[2]-arr[1])==(arr[1]-arr[0]);
	}

}
