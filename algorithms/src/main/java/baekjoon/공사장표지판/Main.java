package baekjoon.공사장표지판;
import java.io.*;
public class Main {
	static class P23055 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		P23055() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==0 || j==0 || i==N-1 || j==N-1) {
						sb.append('*');
					} else if(i==j || i==N-j-1) {
						sb.append('*');
					} else {
						sb.append(' ');
					}
				}
				sb.append('\n');
			}
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23055();
	}
}