package baekjoon.달팽이;
import java.io.*;
public class Main2 {
	static class P1913 {
		BufferedReader br;
		StringBuilder sb1, sb2;
		int N, findNumber, board[][];
		int dy[] = {1, 0, -1, 0};
		int dx[] = {0, 1,  0, -1};
		P1913() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			board = new int[N][N];
			sb1 = new StringBuilder();
			sb2 = new StringBuilder();
			dfs(0, 0, 0, N*N);
			output();
		}
		void output() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					sb1.append(board[i][j]).append(' ');
				sb1.append('\n');
			}
			System.out.println(sb1.append(sb2));
		}
		void dfs(int y, int x, int d, int number) {
			board[y][x] = number;
			if(findNumber==number)
				sb2.append(y+1).append(' ').append(x+1);
			if(number==1)
				return;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny<0 || nx<0 || ny>=N || nx>=N || board[ny][nx]!=0) {
				d = (d+1==4)?0:d+1;
				ny = y + dy[d];
				nx = x + dx[d];
			}
			dfs(ny, nx, d, number-1);
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				findNumber = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1913();
	}
}
