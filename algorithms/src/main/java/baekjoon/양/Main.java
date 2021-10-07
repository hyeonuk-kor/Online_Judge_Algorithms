package baekjoon.양;
import java.io.*;
import java.util.*;
public class Main {
	static class Solution {
		public Solution(String str) {
			this.cmd = str;
		}
		String cmd;
		StringBuilder sb = new StringBuilder();
		int R, C;
		char board[][];
		boolean visit[][];
		int sheep, wolves, sheep_count, wolf_count;
		int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
		String answer() {
			input();
			pro(cmd);
			return sb.append(sheep).append(' ').append(wolves).toString();
		}
		void pro(String cmd) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(visit[i][j]) continue;
					if(board[i][j]=='v' || board[i][j]=='o') {
						sheep_count = 0;
						wolf_count = 0;
						if(cmd.equals("BFS")) {
							bfs(i, j);
						} else {
							dfs(i,j);
						}
						if(sheep_count > wolf_count) {
							wolves -= wolf_count;
						} else {
							sheep -= sheep_count;
						}
					}
				}
			}
		}
		void dfs(int y, int x) {
			visit[y][x] = true;
			if(board[y][x]=='o') sheep_count++;
			if(board[y][x]=='v') wolf_count++;
			for (int d = 0; d < dir.length; d++) {
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
				if(visit[ny][nx] || board[ny][nx]=='#') continue;
				dfs(ny, nx);
			}
		}
		void bfs(int y, int x) {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				y = info[0];
				x = info[1];
				if(board[y][x]=='o') sheep_count++;
				if(board[y][x]=='v') wolf_count++;
				for (int d = 0; d < dir.length; d++) {
					int ny = y + dir[d][0];
					int nx = x + dir[d][1];
					if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
					if(visit[ny][nx] || board[ny][nx]=='#') continue;
					q.add(new int[] {ny, nx});
					visit[ny][nx] = true;
				}
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				R = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				board = new char[R][C];
				visit = new boolean[R][C];
				for (int i = 0; i < board.length; i++) {
					board[i] = br.readLine().toCharArray();
					for (int j = 0; j < board[i].length; j++) {
						if(board[i][j]=='o') {
							sheep++;
						} else if(board[i][j]=='v') {
							wolves++;
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution("BFS").answer());
		//System.out.println(new Solution("DFS").answer());
	}
}