package baekjoon.수열;
import java.io.*;
import java.util.*;
public class Main {
	static int N, K, A[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		int r=K, sum = 0, answer = 0;
		for(int i=1; i<=K; i++)
			sum += A[i];
		answer = sum;
		for(int l=2; l<=N-K+1; l++) {
			sum -= A[l-1];
			sum += A[++r];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}