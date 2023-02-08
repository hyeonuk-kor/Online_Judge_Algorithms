package baekjoon.캠프준비;
import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, X, A[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(go(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

	static int go(int index, int cnt, int sum, int easy, int hard) {
		if (index == N) {
			if (cnt >= 2 && L <= sum && sum <= R && X <= hard - easy)
				return 1;
			return 0;
		}
		int cnt1 = go(index + 1, cnt + 1, sum + A[index], Math.min(easy, A[index]), Math.max(A[index], hard));
		int cnt2 = go(index + 1, cnt, sum, easy, hard);
		return cnt1 + cnt2;
	}
}