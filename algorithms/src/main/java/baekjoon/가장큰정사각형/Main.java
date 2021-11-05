package baekjoon.가장큰정사각형;
import java.io.*;
import java.util.*;
public class Main {
	static class P1915 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, board[][];
		P1915() {
			input();
			solve();
		}
		void solve() {
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(board[i][j]==1) {
						int min = board[i-1][j-1];
						min = Math.min(board[i-1][j], min);
						min = Math.min(board[i][j-1], min);
						board[i][j] = min + 1;
						max = Math.max(board[i][j], max);
					}
				}
			}
			System.out.println(max*max);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				board = new int[N+1][M+1];
				for(int i=1; i<=N; i++) {
					String input = br.readLine();
					for(int j=1; j<=M; j++) {
						board[i][j] = input.charAt(j-1) - '0';
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1915();
	}
}