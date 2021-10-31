package baekjoon.공바꾸기;
import java.io.*;
import java.util.*;
public class Main {
	static class P10813 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M;
		List<Integer> bucket;
		P10813() {
			br = new BufferedReader(new InputStreamReader(System.in));
			bucket = new ArrayList<>();
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int i=1; i<=N; i++)
				sb.append(bucket.get(i)).append(' ');
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				for(int i=0; i<=N; i++) {
					bucket.add(i);
				}
				for(int m=0; m<M; m++) {
					st = new StringTokenizer(br.readLine().trim());
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					Collections.swap(bucket, i, j);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10813();
	}
}