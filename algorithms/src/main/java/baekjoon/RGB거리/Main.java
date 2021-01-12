package baekjoon.RGB거리;
import java.io.*;
import java.util.*;
public class Main {
	static final int R = 0, G = 1, B = 2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int memo[][] = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			memo[i][R] = Math.min(memo[i-1][G], memo[i-1][B]) + r;
			memo[i][G] = Math.min(memo[i-1][R], memo[i-1][B]) + g;
			memo[i][B] = Math.min(memo[i-1][R], memo[i-1][G]) + b;
		}
		System.out.println(Arrays.stream(memo[N]).min().getAsInt());
	}
}
