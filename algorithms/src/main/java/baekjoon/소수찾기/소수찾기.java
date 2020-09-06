package baekjoon.소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];
		for(int i=2; i<1001; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<=1000; i++) {
			if(arr[i]==0)
				continue;
			for(int j=i+i; j<=1000; j=j+i) {
				arr[j]=0;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i=0; i<N; i++) {
			int check = Integer.parseInt(st.nextToken());
			if(arr[check]!=0)
				count++;
		}
		System.out.println(count);
	}
	
}
