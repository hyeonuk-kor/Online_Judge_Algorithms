package baekjoon.P2422;
import java.io.*;
import java.util.*;
class P2422 {
	BufferedReader br;
	StringTokenizer st;
	int N, M, answer;
	int[] select;
	boolean[][] unsavory;
	P2422() {
		input();
		if(N>=3) {
			solve(1);
		}
		System.out.println(answer);
	}
	void solve(int index) {
		if(index>3) { // 3가지 아이스크림을 다 골랐다면?
			if(check())
				answer++;
		} else {
			for(int i=select[index-1]+1; i<=N; i++) {
				select[index] = i;
				solve(index+1);
			}
		}
	}
	boolean check() {
		if(unsavory[select[1]][select[2]])
			return false;
		if(unsavory[select[1]][select[3]])
			return false;
		if(unsavory[select[2]][select[3]])
			return false;
		return true;
	}
	void input() {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			select = new int[4];
			unsavory = new boolean[N+1][N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unsavory[a][b] = true;
				unsavory[b][a] = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Main {
	public static void main(String[] args) {
		new P2422();
	}
}