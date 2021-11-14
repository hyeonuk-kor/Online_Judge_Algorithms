package baekjoon.노래악보;
import java.io.*;
import java.util.*;
public class Main {
	static class P1392 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, Q;
		List<Integer> time;
		P1392() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				Q = Integer.parseInt(st.nextToken());
				time = new ArrayList<>();
				for(int i=0; i<N; i++) {
					int t = Integer.parseInt(br.readLine());
					for(int j=0; j<t; j++) {
						time.add(i+1);
					}
				}
				for(int i=0; i<Q; i++) {
					int q = Integer.parseInt(br.readLine());
					sb.append(time.get(q)).append('\n');
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P1392();
	}
}
