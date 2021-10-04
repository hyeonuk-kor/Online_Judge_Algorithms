package baekjoon.부분합;
import java.io.*;
import java.util.*;
public class Main {
	static int N, S, number[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		int R = 0, sum = 0, answer = N+1;
		for(int L=1; L<=N; L++) {
			// L - 1을 구간에서 제외하기
			sum -= number[L-1];
			// R을 옮길 수 있을 때 까지 옮기기
			while(R+1<=N && sum < S) {
				R++;
				sum += number[R];
			}
			// [L...R]의 합, 즉 sum 조건을 만족하면 정답 갱신하기
			if(sum>=S) {
				answer = Math.min(answer, R-L+1);
			}
		}
		if(answer == N+1)
			answer = 0;
		System.out.println(answer);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			number = new int[N+1];
			for(int i=1; i<=N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}