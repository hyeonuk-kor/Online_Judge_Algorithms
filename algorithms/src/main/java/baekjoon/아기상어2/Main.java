package baekjoon.아기상어2;
import java.io.*;
import java.util.*;
public class Main {
	static class P17086 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, board[][], answer;
		int count = 1;
		int dy[] = {-1,-1,-1, 0, 0, 1, 1, 1};
		int dx[] = {-1, 0, 1,-1, 1,-1, 0, 1};
		boolean visit[][];
		Queue<int[]> q;
		void solve() {
			input();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(board[i][j]==0)
						bfs(i, j, 0);
				}
			}
			System.out.println(answer);
		}
		void bfs(int y, int x, int dis) {
			q = new ArrayDeque<>();
			visit = new boolean[N][M];
			q.add(new int[] {y, x, dis});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int info[] = q.poll();
				y = info[0];
				x = info[1];
				dis = info[2];
				if(board[y][x]==1) {
					answer = Math.max(answer, dis);
					return;
				}
				for(int d=0; d<8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(ny<0 || nx<0 || ny>=N || nx>=M)
						continue;
					if(visit[ny][nx])
						continue;
					q.add(new int[] {ny, nx, dis+1});
					visit[ny][nx] = true;
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
				// TODO: handle exception
			}
			
		}
	}
	public static void main(String[] args) {
		new P17086().solve();
	}
}
