package baekjoon.골드바흐의추측;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10001];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		for (int i = 2; i < arr.length; i++) {
			for (int j = i+i; j < arr.length; j+=i) {
				arr[j]=0;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int input = Integer.parseInt(br.readLine());
			int i, j, mid = input/2;
			for(i=j=mid; i<=input; i--,j++) {
				if(arr[i]!=0 && arr[j]!=0) {
					System.out.println(i+" "+j);
					break;
				}
			}
		}
	}
}
