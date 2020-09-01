package baekjoon.일로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기 {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		System.out.println(solve(N, arr));
	}

	private static int solve(int n, int[] arr) {
		if(arr[n]!=0)
			return arr[n];
		
		switch(n) {
		case 1:
			arr[n] = 0;
			break;
		case 2:
		case 3:
			arr[n] = 1;
			break;
		default:
			if(n%3==0) {
				int check = solve(n/3, arr);
				arr[n] = check + 1;
			}
			if(n%2==0) {
				int check = solve(n/2, arr);
				if(arr[n]==0 || arr[n] > check + 1)
					arr[n] = check + 1;
			}
			
			int check = solve(n-1, arr);
			if(arr[n]==0 || arr[n] > check +1)
				arr[n] = check + 1;
			break;
		}
		
		return arr[n];
	}
	
}
