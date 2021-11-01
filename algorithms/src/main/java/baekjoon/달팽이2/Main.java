package baekjoon.달팽이2;
import java.io.*;
import java.util.*;
public class Main {
	static class P1952 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, count, board[][];
		int dy[] = {0, 1,  0, -1};
		int dx[] = {1, 0, -1 , 0};
		P1952() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			board = new int[N][M];
			dfs(0, 0, 0, N*M);
			System.out.println(count);
		}
		void dfs(int y, int x, int d, int number) {
			board[y][x] = number;
			if(number==1)
				return;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny<0 || nx<0 || ny>=N || nx>=M || board[ny][nx]!=0) {
				d = (d+1==4)?0:d+1;
				ny = y + dy[d];
				nx = x + dx[d];
				count++;
			}
			dfs(ny, nx, d, number-1);
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1952();
	}
}
