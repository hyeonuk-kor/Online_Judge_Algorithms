package baekjoon.P23804;
import java.io.*;
public class Main {
	static class P23804 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		P23804() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			for(int i=0; i<N*5; i++) {
				if(i<=N-1 || i>=N*5-N) {
					for(int j=0; j<N*5; j++) {
						sb.append('@');
					}
				} else {
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
				}
				sb.append('\n');
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23804();
	}
}
