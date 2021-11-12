package baekjoon.스키테일암호;
import java.io.*;
public class Main {
	static class P23080 {
		BufferedReader br;
		StringBuilder sb;
		int K;
		char[] S;
		P23080() {
			input();
			solve();
		}
		void solve() {
			sb = new StringBuilder();
			for(int i=0; i<S.length; i+=K) {
				sb.append(S[i]);
			}
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				K = Integer.parseInt(br.readLine());
				S = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23080();
	}
}