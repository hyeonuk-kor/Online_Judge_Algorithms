package baekjoon.빗물;
import java.io.*;
import java.util.*;
public class Main {
	static class P14719 {
		BufferedReader br;
		StringTokenizer st;
		int H, W, board[][];
		int solve() {
			input();
			int sum = 0;
			for(int i=0; i<H; i++) {
				int count = 0;
				int first_one = 0, last_one = 0;
				for(int j=0; j<W; j++) {
					if(board[i][j]==1) {
						first_one = j;
						break;
					}
				}
				for(int j=0; j<W; j++) {
					if(board[i][j]==1) {
						last_one = j;
					}
				}
				for(int j=first_one; j<last_one; j++) {
					if(board[i][j]==0) {
						count++;
					}
				}
				sum += count;
			}
			return sum;
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				H = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				board = new int[H][W];
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<W; i++) {
					int h = Integer.parseInt(st.nextToken());
					for(int j=0; j<h; j++) {
						board[j][i] = 1;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P14719().solve());
	}
}
