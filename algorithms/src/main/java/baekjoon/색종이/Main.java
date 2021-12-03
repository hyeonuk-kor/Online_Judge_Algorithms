package baekjoon.색종이;
import java.io.*;
import java.util.*;
public class Main {
	static class P2563 {
		BufferedReader br;
		StringTokenizer st;
		int N, answer;
		boolean board[][];
		P2563() {
			board = new boolean[100][100];
			input();
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken())-1;
					int x = Integer.parseInt(st.nextToken())-1;
					for(int i=y; i<y+10; i++) {
						for(int j=x; j<x+10; j++) {
							board[i][j] = true;
						}
					}
				}
				for(int i=0; i<board.length; i++) {
					for(int j=0; j<board[i].length; j++) {
						if(board[i][j])
							answer++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2563();
	}
}