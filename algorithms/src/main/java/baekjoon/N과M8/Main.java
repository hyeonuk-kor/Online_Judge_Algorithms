package baekjoon.N과M8;

import java.util.*;
import java.io.*;

public class Main {

	static int N, M, number[], answer[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		number = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(number);
		answer = new int[M];
		sb = new StringBuilder();
		dfs(0, 0);
		bw.write(sb.toString());
		bw.close();
	}
	
	static void dfs(int idx, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.append('\n');
			idx++;
			return;
		}
		
		for (int i = idx; i < number.length; i++) {
			answer[cnt]=number[i];
			dfs(i, cnt+1);
		}
		
		
	}
	
}
