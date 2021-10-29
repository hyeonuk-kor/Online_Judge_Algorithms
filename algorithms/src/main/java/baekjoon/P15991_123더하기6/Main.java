package baekjoon.P15991_123더하기6;
import java.io.*;
public class Main {
	static class P15991 {
		BufferedReader br;
		StringBuilder sb;
		int T;
		long dp[] = new long[100001];
		void solve() {
			sb = new StringBuilder();
			dp[1] = 1; dp[2] = 2; dp[3] = 2;
			dp[4] = 3; dp[5] = 3; dp[6] = 6;
			for(int i=7; i<=10000; i++) {
				dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1000000009;
			}
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				T = Integer.parseInt(br.readLine());
				for(int i=0; i<T; i++) {
					int n = Integer.parseInt(br.readLine());
					sb.append(dp[n]).append("\n");
				}
				System.out.println(sb);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P15991().solve();
	}
}