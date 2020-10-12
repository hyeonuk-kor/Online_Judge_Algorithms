package baekjoon.N과M7;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, arr[], answer[];
	static boolean[] check;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		answer = new int[M];
		rePerm(0, 0);
		System.out.println(sb);
	}

	static void rePerm(int idx, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < answer.length; i++)
				sb.append(answer[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			answer[cnt] = arr[i];
			rePerm(i, cnt+1);
		}
		
	}
	
}
