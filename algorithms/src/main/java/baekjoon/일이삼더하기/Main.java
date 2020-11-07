package baekjoon.일이삼더하기;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dp = new int[11];
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i=4; i<11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			bw.append(dp[n]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
