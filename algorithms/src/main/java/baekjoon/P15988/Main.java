package baekjoon.P15988;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dy = new long[1000001];
		dy[1] = 1;
		dy[2] = 2;
		dy[3] = 4;
		for(int i=4; i<=1000000; i++)
			dy[i] = (dy[i-1]+dy[i-2]+dy[i-3])%1000000009;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dy[n]);
		}
	}
}