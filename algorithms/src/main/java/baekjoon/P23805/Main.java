package baekjoon.P23805;
import java.io.*;
public class Main {
	static class P23805 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		P23805() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			for(int i=0; i<N*5; i++) {
				if(i<=N-1) {
					for(int j=0; j<N*3; j++) {
						sb.append('@');
					}
					for(int j=0; j<N; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
				} else if(i>=N && i<N*5-N){
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
					for(int j=0; j<N; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
					for(int j=0; j<N; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
				} else {
					for(int j=0; j<N; j++) {
						sb.append('@');
					}
					for(int j=0; j<N; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N*3; j++) {
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
		new P23805();
	}
}