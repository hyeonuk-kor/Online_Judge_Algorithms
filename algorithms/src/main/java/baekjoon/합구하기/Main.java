package baekjoon.합구하기;
import java.io.*;
import java.util.*;
public class Main {
	static class P11441 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, S[];
		P11441() {
			br = new BufferedReader(new InputStreamReader(System.in));
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				S = new int[N+1];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=1; i<=N; i++) {
					S[i] = S[i-1] + Integer.parseInt(st.nextToken());
				}
				int M = Integer.parseInt(br.readLine());
				for(int m=0; m<M; m++) {
					st = new StringTokenizer(br.readLine().trim());
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					sb.append(S[j]-S[i-1]).append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P11441();
	}
}