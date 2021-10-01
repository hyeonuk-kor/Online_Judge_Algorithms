package baekjoon.N과M2;
import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static int N, M, selected[];
	public static void main(String[] args) {
		initialize();
		rec_func(0);
		output();
	}
	static void initialize() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			selected = new int[M];
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void rec_func(int k) {
		if(k==M) {
			for(int number: selected)
				sb.append(number).append(' ');
			sb.append('\n');
			return;
		} else {
			int start = (k==0) ? 0:selected[k-1];
			for(int i=start+1; i<=N; i++) {
				selected[k] = i;
				rec_func(k+1);
				selected[k] = 0;
			}
		}
	}
	static void output() {
		System.out.println(sb.toString());
	}
}