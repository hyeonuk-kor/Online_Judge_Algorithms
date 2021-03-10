package baekjoon.팰린드롬;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		int number[] = new int[n+1];
		boolean dp[][] = new boolean[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			number[i] = Integer.valueOf(st.nextToken());
		}

		for(int i=1; i<=n; i++) {
			dp[i][i] = true;
		}
		
		for(int i=1; i<n; i++) {
			if(number[i]==number[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for(int i=2; i<n; i++) {
			for(int j=1; j<n-i+1; j++) {
				if(number[j]==number[j+i]) {
					if(dp[j+1][j+i-1]) {
						dp[j][j+i]=true;
					}
				}
			}
		}

		int m = Integer.valueOf(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			if(dp[s][e])
				pw.println(1);
			else
				pw.println(0);
		}
		pw.flush();
	}
}