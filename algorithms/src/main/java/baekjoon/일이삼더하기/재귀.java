package baekjoon.일이삼더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 재귀 {
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp = new int[11];
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			bw.append(getResult(n)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static int getResult(int n) {
		if(dp[n]!=0)
			return dp[n];
		return dp[n] = getResult(n-1) + getResult(n-2) + getResult(n-3);

	}
}
