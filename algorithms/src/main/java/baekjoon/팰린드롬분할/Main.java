package baekjoon.팰린드롬분할;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		boolean check[][] = new boolean[n+1][n+1];
		int dp[] = new int[n+1];
		for(int i=1; i<str.length(); i++) {
			check[i][i] = true;
			if(str.charAt(i-1)==str.charAt(i)) {
				check[i][i+1] = true;
				check[i+1][i] = true;
			}
		}
		check[n][n]=true;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			min = dp[i-1];
			for(int j=1; j<i; j++) {
				if(str.charAt(j-1)==str.charAt(i-1)) {
					if(check[j+1][i-1]) {
						check[j][i] = true;
						min = Math.min(dp[j-1], min);
					}
				}
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[n]);
	}
}
