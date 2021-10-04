package baekjoon.배열합치기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, A[], B[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		input();
		pro();
	}
	private static void pro() {
		int L = 1, R = 1;
		while(L<=N && R<=M) {
			if(A[L] < B[R]) {
				sb.append(A[L++]);
			} else {
				sb.append(B[R++]);
			}
			sb.append(' ');
		}
		while(L<=N) {
			sb.append(A[L++]).append(' ');
		}
		while(R<=M) {
			sb.append(B[R++]).append(' ');
		}
		System.out.println(sb);
	}
	private static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			B = new int[M+1];
			for(int i=1; i<=M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}