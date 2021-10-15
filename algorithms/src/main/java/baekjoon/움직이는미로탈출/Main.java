package baekjoon.움직이는미로탈출;
import java.io.*;
import java.util.*;
public class Main {
	static class P16954 {
		BufferedReader br;
		char board[][];
		boolean visit[][][];
		int dy[] = {0, -1, -1, -1,  0,  1, 1, 1, 0};
		int dx[] = {1,  1,  0, -1, -1, -1, 0, 1, 0};
		int sy = 7, sx = 0, ey = 0, ex = 7;
		int answer = 0;
		int solve() {
			input();
			bfs();
			return answer;
		}
		void bfs() {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {sy, sx, 0});
			visit[sy][sx][0] = true;
			while(!q.isEmpty()) {
				int info[] = q.poll();
				int y = info[0];
				int x = info[1];
				int time = info[2];
				if(time==7) {
					answer = 1;
					return;
				}
					
				if((y==ey && x==ex)) {
					answer = 1;
					return;
				}
				for(int d=0; d<9; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(ny<0 || nx<0 || ny>=8 || nx>=8)
						continue;
					if(ny-time>=0 && board[ny-time][nx]=='#')
						continue;
					if(ny-time-1>=0 && board[ny-time-1][nx]=='#')
						continue;
					if(visit[ny][nx][time+1])
						continue;
						
					q.add(new int[] {ny, nx, time+1});
					visit[ny][nx][time] = true;
				}
			}
			answer = 0;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				board = new char[8][8];
				visit = new boolean[8][8][9];
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