package baekjoon.N과M1;
import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static int N, M, selected[], used[];
	public static void main(String[] args) {
		initialize();
		rec_func(0);
		output();
	}
	static void initialize() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			selected = new int[M];
			used = new int[N+1];
			sb = new StringBuilder();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void rec_func(int k) {
		if(k==M) {
			for(int number: selected)
				sb.append(number).append(' ');
			sb.append('\n');
			return;
		} else {
			for(int i=1; i<=N; i++) {
				if(used[i]==0) {
					selected[k] = i;
					used[i] = 1;
					rec_func(k+1);
					used[i] = 0;
					selected[k] = 0;
				}
			}
		}
	}
	static void output() {
		System.out.println(sb.toString());
	}
}