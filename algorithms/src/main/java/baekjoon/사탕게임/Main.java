package baekjoon.사탕게임;
import java.io.*;
import java.util.*;
public class Main {
	static class P3085 {
		BufferedReader br;
		int N, answer;
		char board[][];
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				board = new char[N][N];
				for(int i=0; i<N; i++) {
					board[i] = br.readLine().toCharArray();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P3085() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-1; j++) {
					if(board[i][j]!=board[i][j+1]) {
						board[i][j] ^= board[i][j+1];
						board[i][j+1] ^= board[i][j];
						board[i][j] ^= board[i][j+1];
						calc();
						board[i][j] ^= board[i][j+1];
						board[i][j+1] ^= board[i][j];
						board[i][j] ^= board[i][j+1];
					}
				}
			}
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j]!=board[i+1][j]) {
						board[i][j] ^= board[i+1][j];
						board[i+1][j] ^= board[i][j];
						board[i][j] ^= board[i+1][j];
						calc();
						board[i][j] ^= board[i+1][j];
						board[i+1][j] ^= board[i][j];
						board[i][j] ^= board[i+1][j];
					}
				}
			}
		}
		void calc() {
			for(int i=0; i<N; i++) {
				int count = 1;
				int target = board[i][0];
				for(int j=1; j<N; j++) {
					if(board[i][j]==target) {
						count++;
						answer = Math.max(answer, count);
					} else {
						answer = Math.max(answer, count);
						count = 1;
						target = board[i][j];
					}
				}
			}
			for(int i=0; i<N; i++) {
				int count = 1;
				int target = board[0][i];
				for(int j=1; j<N; j++) {
					if(board[j][i]==target) {
						count++;
						answer = Math.max(answer, count);
					} else {
						answer = Math.max(answer, count);
						count = 1;
						target = board[j][i];
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new P3085();
	}
}
