package baekjoon.세용액;
import java.io.*;
import java.util.*;
public class Main {
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
		long best_sum = Long.MAX_VALUE;
		int v1 = 0, v2 = 0, v3 = 0;
		for(int i=1; i<=N-2; i++) {
			int target = -A[i];
			int L = i + 1, R = N;
			while(L<R) {
				long sum = -(long)target + A[L] + A[R];
				if(Math.abs(sum) < best_sum) {
					best_sum = Math.abs(sum);
					v1 = -target;
					v2 = A[L];
					v3 = A[R];
				}
				if(A[L]+A[R]>target) {
					R--;
				} else {
					L++;
				}
			}
		}
		sb.append(v1).append(' ').append(v2).append(' ').append(v3);
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

