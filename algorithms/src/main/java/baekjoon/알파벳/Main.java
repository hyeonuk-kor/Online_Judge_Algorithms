package baekjoon.알파벳;
import java.io.*;
import java.util.*;
public class Main {
	static int R, C, answer;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static char board[][];
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visit = new boolean[26];
		for(int i=0; i<R; i++)
			board[i] = br.readLine().toCharArray();
		simulation(0,0,1);
		System.out.println(answer);
	}
	static void simulation(int y, int x, int ret) {
		visit[board[y][x]-'A'] = true;
		for(int d=0; d<4; d++) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if(ny<0 || nx<0 || ny>=R || nx>=C || visit[board[ny][nx]-'A'])
				continue;
			simulation(ny, nx, ret+1);
		}
		answer = Math.max(ret, answer);
		visit[board[y][x]-'A'] = false;
	}
}
