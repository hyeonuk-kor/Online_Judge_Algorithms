package baekjoon.일이삼더하기3;
import java.io.*;
public class Main {
	static final int MOD = 1000000009;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		long[] memo = new long[1000001];
		memo[1] = 1; memo[2] = 2; memo[3] = 4;
		for(int i=4; i<memo.length; i++) {
			memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
			memo[i] %= MOD;
		}
		int T = Integer.valueOf(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int n = Integer.valueOf(br.readLine());
			pw.println(memo[n]);
		}
		pw.flush();
	}
}