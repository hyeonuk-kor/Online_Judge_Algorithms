package baekjoon.움직이는미로탈출;
import java.io.*;
import java.util.*;
public class Main {
	static class P16954 {
		BufferedReader br;
		char board[][];
		boolean visit[][];
		int dy[] = {0, -1, -1, -1, 0, 0};
		int dx[] = {1, 1, 0, -1, -1, -1};
		int sy = 7, sx = 0, ey = 0, ex = 7;
		int answer = 0;
		int solve() {
			input();
			bfs();
			return answer;
		}
		private void bfs() {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {sy, sx});
			visit[sy][sx] = true;
			while(!q.isEmpty()) {
				int info[] = q.poll();
				int y = info[0];
				int x = info[1];
				if(board[y][x]=='#')
					continue;
				if(y==ey && x==ex) {
					answer = 1;
					return;
				}
				for(int d=0; d<6; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(ny<0 || nx<0 || ny>=8 || nx>=8)
						continue;
					if(board[ny][nx]=='#')
						continue;
					if(ny-1>0 && board[ny-1][nx]=='#')
						continue;
					if(visit[ny][nx])
						continue;
					q.add(new int[] {ny, nx});
					visit[ny][nx] = true;
				}
				drop();
				//q.add(new int[] {y, x}); // 가만히 있는 경우
			}
			answer = 0;
		}
		private void drop() {
			char[][] copy_board = new char[8][8];
			for(int i=0; i<8; i++)
				Arrays.fill(copy_board[i], '.');
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(board[i][j]=='#') {
						if(i<7)
							copy_board[i+1][j]='#';
					}
				}
			}
			board = copy_board;
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				board = new char[8][8];
				visit = new boolean[8][8];
				for(int i=0; i<8; i++)
					board[i] = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P16954().solve());
	}
}
