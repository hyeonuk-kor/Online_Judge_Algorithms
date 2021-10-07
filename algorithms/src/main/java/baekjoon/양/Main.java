package baekjoon.양;
import java.io.*;
import java.util.*;
public class Main {
	static int R, C;
	static char board[][];
	static boolean visit[][];
	static int sheep, wolves, sheep_count, wolf_count;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sheep+" "+wolves);
	}
	private static void pro() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visit[i][j]) continue;
				if(board[i][j]=='v' || board[i][j]=='o') {
					sheep_count = 0;
					wolf_count = 0;
					dfs(i, j);
					if(sheep_count > wolf_count) {
						wolves -= wolf_count;
					} else {
						sheep -= sheep_count;
					}
				}
			}
		}
	}
	private static void dfs(int y, int x) {
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
	private static void input() {
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