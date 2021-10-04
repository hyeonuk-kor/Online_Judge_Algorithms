package baekjoon.수들의합2;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, A[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		int r = 0, sum = 0, answer = 0;
		for(int l=1; l<=N; l++) {
			sum -= A[l-1];
			while(r+1<=N && sum<M)
				sum += A[++r];
			if(sum==M) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	static void input() {
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
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}