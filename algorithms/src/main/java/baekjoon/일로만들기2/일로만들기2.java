package baekjoon.일로만들기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기2 {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i=2; i<N+1; i++) {
			arr[i] = arr[i-1] + 1;
			if(i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
			if(i%2==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
		}

		int solution = N;
		for(int i=N-1; i>=0; i--) {
			if(arr[i]==solution) {
			}
		}
		
		System.out.println(arr[N]);
	}

}
