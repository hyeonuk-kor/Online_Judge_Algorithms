package baekjoon.영역구하기;
import java.io.*;
import java.util.*;
public class Main {
	static class P2583 {
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		int N, M, K;
		int dy[] = {0,  0, -1, 1};
		int dx[] = {1, -1,  0, 0};
		boolean board[][], visit[][];
		int group_count, answer;
		String solve() {
			input();
			visit = new boolean[M][N];
			//getDFS();
			getBFS();
			return sb.toString();
		}
		private void getBFS() {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!board[i][j] && !visit[i][j]) {
						group_count = 0;
						bfs(i, j);
						list.add(group_count);
					}
				}
			}
			Collections.sort(list);
			sb.append(list.size()).append("\n");
			for(int n: list)
				sb.append(n+" ");
		}
		private void bfs(int y, int x) {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x, 0});
			visit[y][x] = true;
			group_count++;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				y = info[0];
				x = info[1];
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(!isRange(ny, nx) && !visit[ny][nx] && !board[ny][nx]) {
						q.add(new int[] {ny, nx});
						visit[ny][nx] = true;
						group_count++;
					}
				}
			}
		}
		private void getDFS() {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!board[i][j] && !visit[i][j]) {
						group_count = 0;
						dfs(i, j);
						list.add(group_count);
					}
				}
			}
			Collections.sort(list);
			sb.append(list.size()).append("\n");
			for(int n: list)
				sb.append(n+" ");
		}
		private void dfs(int y, int x) {
			visit[y][x] = true;
			group_count++;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(!isRange(ny, nx) && !visit[ny][nx] && !board[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
		private boolean isRange(int y, int x) {
			return y<0 || x<0 || y>=M || x>=N;
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new boolean[M][N];
				for(int i=0; i<K; i++) {
					st = new StringTokenizer(br.readLine());
					int y1 = Integer.parseInt(st.nextToken());
					int x1 = Integer.parseInt(st.nextToken());
					int y2 = Integer.parseInt(st.nextToken());
					int x2 = Integer.parseInt(st.nextToken());
					for(int j=y1; j<y2; j++) {
						for(int k=x1; k<x2; k++) {
							board[j][k] = true;
						}
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P2583().solve());
	}
}