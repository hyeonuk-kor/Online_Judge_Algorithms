package baekjoon.ListofUninqueNumbers;
import java.io.*;
import java.util.*;
public class Main {
	static int N, number[];
	static boolean check[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		long answer = 0;
		for(int L=1, R=0; L<=N; L++) {
			while(R+1 <= N && !check[number[R+1]]) {
				check[number[R+1]] = true;
				R++;
			}
			// 정답을 갱신
			answer += R - L + 1;
			check[number[L]] = false;
		}
		System.out.println(answer);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			N = Integer.parseInt(br.readLine());
			number = new int[N+1];
			check = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}