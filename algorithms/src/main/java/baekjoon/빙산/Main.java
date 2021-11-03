package baekjoon.빙산;
import java.io.*;
import java.util.*;
public class Main {
	static class P2573 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, board[][], melt[][], count;
		boolean visit[][];
		int dy[] = {0, 0, 1,-1};
		int dx[] = {1,-1, 0, 0};
		P2573() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			visit = new boolean[N][M];
			melt = new int[N][M];
			int year = 0;
			while(true) {
				count = 0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(board[i][j]!=0 && !visit[i][j]) {
							dfs(i, j);
							count++;
						}
					}
				}
				if(count==0) {
					year = 0;
					break;
				} else if(count>=2) {
					break;
				} else {
					year++;
					melting();
				}
			}
			System.out.println(year);
		}
		private void print() {
			for(int i=0; i<board.length; i++)
				System.out.println(Arrays.toString(board[i]));
			System.out.println();
		}
		void dfs(int y, int x) {
			visit[y][x] = true;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(isRange(ny, nx))
					continue;
				if(visit[ny][nx])
					continue;
				if(board[ny][nx]==0) {
					melt[y][x]++;
					continue;
				}
				dfs(ny, nx);
			}
		}
		boolean isRange(int y, int x) {
			return (y<0 || x<0 || y>=N || x>=M);
		}
		void melting() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(board[i][j]!=0) {
						board[i][j] = (board[i][j] - melt[i][j] < 0) ? 0 : board[i][j] - melt[i][j];
						visit[i][j] = false;
						melt[i][j] = 0;
					}
				}
			}
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				board = new int[N][M];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<M; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2573();
	}

}
