package baekjoon.빙산;
import java.io.*;
import java.util.*;
public class Main {
	static class P2573 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, board[][], count;
		boolean visit[][];
		int dy[] = {0, 0, 1,-1};
		int dx[] = {1,-1, 0, 0};
		P2573() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			int time = 0;
			while(count<2) {
				System.out.println(time);
				for(int i=0; i<board.length; i++) {
					System.out.println(Arrays.toString(board[i]));
				}
				count = 0;
				if(!bfs()) {
					time = 0;
					break;
				} else {
					visit = new boolean[N][M];
					for(int i=0; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(!visit[i][j] && board[i][j]!=0) {
								dfs(i, j);
								count++;
							}
						}
					}
					time++;
				}
			}
			System.out.println();
			for(int i=0; i<board.length; i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			System.out.println(time);
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
				if(board[ny][nx]==0)
					continue;
				dfs(ny, nx);
			}
		}
		boolean isRange(int y, int x) {
			return (y<0 || x<0 || y>=N || x>=M);
		}
		boolean bfs() {
			Queue<int[]> q = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(board[i][j]!=0) {
						q.add(new int[] {i, j});
					}
				}
			}
			if(q.isEmpty())
				return false;
			int copy[][] = new int[N][M];
			while(!q.isEmpty()) {
				int info[] = q.poll();
				int y = info[0];
				int x = info[1];
				int count = 0;
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(isRange(ny, nx))
						continue;
					if(board[ny][nx]==0) {
						count++;
					}
				}
				int melt = board[y][x] - count;
				copy[y][x] = (melt<0) ? 0 : melt;
			}
			board = copy;
			return true;
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