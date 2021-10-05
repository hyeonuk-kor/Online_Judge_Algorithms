package baekjoon.두용액;
import java.io.*;
import java.util.*;
public class Main2 {
	static StringBuilder sb = new StringBuilder();
	static int N, A[];
	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sb.toString());
	}
	static void pro() {
		// 정렬하기, -99 -2 -1 4 98
		Arrays.sort(A, 1, N+1);
		int best_sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0, L = 1, R = N;
		while(L<R) {
			int sum = A[L] + A[R];
			if(Math.abs(sum) < best_sum) {
				best_sum = Math.abs(sum);
				v1 = A[L];
				v2 = A[R];
			}
			if(sum>0) {
				R--;
			} else {
				L++;
			}
		}
		sb.append(v1).append(' ').append(v2);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			A = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

