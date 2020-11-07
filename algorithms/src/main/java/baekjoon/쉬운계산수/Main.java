package baekjoon.쉬운계산수;
import java.io.*;
public class Main {
	public static final int MOD = 1000000000;
	public static void main(String[] args) throws Exception {
		int dp[][] = new int[101][10];
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		// N = 1, case = {1, 2, 3, 4, 5, 6, 7, 8, 9}
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		// N = 2; case = { 10, 21, 32, 43, 54, 65, 76, 87, 98
		//				   12, 23, 34, 45, 56, 67, 78, 89,    }
		for(int i=1; i<9; i++) {
			dp[2][i] = 2;
		}
		dp[2][9] = 1; // 98 경우 1가지
		
		//calc
		for(int i=3; i<=N; i++) {
			for(int j=1; j<=9; j++) {
				if(j==1) {
					dp[i][j] = dp[i-2][j] + dp[i-1][j+1];
				} else if(j==9) {
					dp[i][j] = dp[i-1][8];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				dp[i][j] %= MOD;
			}
		}

		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = sum + dp[N][i];
		}
		sum %= MOD;
		System.out.println(sum);
		
		
	}

}
