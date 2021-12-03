package baekjoon.온풍기안녕;
import java.io.*;
import java.util.*;
public class Main {
	static class P23289 {
		BufferedReader br;
		StringTokenizer st;
		final int right = 1, left = 2, up = 3, down = 4;
		int R, C, K, W, board[][], wind[][], heater[][];
		int dy[] = {0, 0, 0,-1, 1};
		int dx[] = {0, 1,-1, 0, 0};
		boolean wall[][][];
		P23289() {
			input();
			pro();
		}
		void pro() {
			int eat = 0;
			while(eat<=100) { // 초콜릿을 100개 이상 먹었을 경우 종료
				step1_wind(); // 모든 온풍기 바람 불기
				step2_adjust(); // 온도 조절
				step3_down(); // 온도 1 이상인 바깥쪽 칸 온도 1 감소
				eat++; // step 4 초콜릿 먹기
				//print(wind);
				//System.out.println(eat);
				if(check()) break; //온도를 조사해야하는 모든 칸이 K 이상이면 종료
			}
			System.out.println(eat);
		}
		boolean check() {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(board[i][j]==5) {
						if(wind[i][j]<K) {
							return false;
						}
					}
				}
			}
			return true;
		}
		boolean isRange(int y, int x) {
			return y>=0 && x>=0 && y<R && x<C;
		}
		void spread(int y, int x, int d, int p) {
			if(p==0)
				return;
			heater[y][x] = p;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(isRange(ny, nx) && !wall[d][y][x])
				spread(ny, nx, d, p-1);
			if(d==left || d==right) {
				if(isRange(y-1, x) && isRange(y-1, x+dx[d]) && !wall[d][y-1][x] && !wall[up][y][x])
					spread(y-1, x+dx[d], d, p-1);
				if(isRange(y+1, x) && isRange(y+1, x+dx[d]) && !wall[d][y+1][x] && !wall[down][y][x])
					spread(y+1, x+dx[d], d, p-1);
			} else {
				if(isRange(y, x-1) && isRange(y+dy[d], x-1) && !wall[d][y][x-1] && !wall[left][y][x])
					spread(y+dy[d], x-1, d, p-1);
				if(isRange(y, x+1) && isRange(y+dy[d], x+1) && !wall[d][y][x+1] && !wall[right][y][x])
					spread(y+dy[d], x+1, d, p-1);
			}
		}
		void step1_wind() {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(board[i][j]>=1 && board[i][j]<=4) {
						heater = new int[R][C];
						switch (board[i][j]) {
						case left:
							if(isRange(i, j-1))
								spread(i, j-1, board[i][j], 5);
							break;
						case right:
							if(isRange(i, j+1))
								spread(i, j+1, board[i][j], 5);
							break;
						case up:
							if(isRange(i-1, j))
								spread(i-1, j, board[i][j], 5);
							break;
						case down:
							if(isRange(i+1, j))
								spread(i+1, j, board[i][j], 5);
							break;

						}
						//print(heater);
						for(int y=0; y<R; y++) {
							for(int x=0; x<C; x++) {
								wind[y][x] += heater[y][x];
							}
						}
					}
				}
			}
			//print(wind);
		}
		private void print(int[][] arr) {
			for(int i=0; i<arr.length; i++)
				System.out.println(Arrays.toString(arr[i]));
			System.out.println();
		}
		void step2_adjust() {
			int temp[][] = new int[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					for(int d=1; d<=4; d++) {
						if(!wall[d][i][j]) {
							int ni = i + dy[d];
							int nj = j + dx[d];
							if(isRange(ni, nj)) {
								if(wind[i][j]>wind[ni][nj]) {
									int diff = (wind[i][j] - wind[ni][nj])/4;
									temp[i][j] -= diff;
									temp[ni][nj] += diff;
								}
							}
						}
					}
				}
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					wind[i][j] += temp[i][j];
				}
			}
			//print(wind);
		}
		void step3_down() {
			for(int i=0; i<R; i++) {
				wind[i][0] = Math.max(0, wind[i][0]-1);
				wind[i][C-1] = Math.max(0, wind[i][C-1]-1);
			}
			for(int i=1; i<C-1; i++) {
				wind[0][i] = Math.max(0, wind[0][i]-1);
				wind[R-1][i] = Math.max(0, wind[R-1][i]-1);
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				R = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new int[R][C];
				wind = new int[R][C];
				wall = new boolean[5][R][C];
				for(int i=0; i<R; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<C; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				W = Integer.parseInt(br.readLine());
				for(int i=0; i<W; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken())-1;
					int x = Integer.parseInt(st.nextToken())-1;
					int t = Integer.parseInt(st.nextToken());
					if(t==1) {
						wall[right][y][x] = true;
						wall[left][y][x+1] = true;
					} else {
						wall[up][y][x] = true;
						wall[down][y-1][x] = true;
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23289();
	}
}