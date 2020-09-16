package baekjoon.일로만들기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일로만들기2 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] track = new int[N+1];

		
		for(int i=2; i<N+1; i++) {
			arr[i] = arr[i-1] + 1;
			track[i] = i-1;
			
			if(i%3==0) {
				int min = arr[i];
				arr[i] = Math.min(arr[i], arr[i/3]+1);
				if(min!=arr[i])
					track[i] = i/3;
			}
			
			if(i%2==0) {
				int min = arr[i];
				arr[i] = Math.min(arr[i], arr[i/2]+1);
				if(min!=arr[i])
					track[i] = i/2;
			}
			
		}
		sb.append(arr[N]).append('\n');
		while(N!=0) {
			sb.append(N).append(' ');
			N = track[N];
		}
		bw.write(sb.toString());
		bw.close();
	}

}
