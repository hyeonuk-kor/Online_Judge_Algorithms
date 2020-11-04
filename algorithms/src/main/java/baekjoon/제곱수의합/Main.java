package baekjoon.제곱수의합;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[N+1];
		for(int i=1; i<dp.length; i++) {
			dp[i] = i;
		}
		
		for(int i=4; i<dp.length; i++) {
			for(int j=2; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
