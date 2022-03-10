package baekjoon.주사위굴리기2;
import java.io.*;
import java.util.*;
public class Main {
	static class P23288 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K, board[][], score;
		int dy[] = {0, 0, 1, -1};
		int dx[] = {1, -1, 0, 0};
		int dice[] = {2,4,1,3,5,6};
		P23288() {
			input();
			go();
			System.out.println(score);
		}
		void go() {
			int y = 0;
			int x = 0;
			int dir = 0;
			for(int k=0; k<K; k++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if(isNotRange(ny, nx)) {
					dir = reverseDir(dir);
					ny = y + dy[dir];
					nx = x + dx[dir];
				}
				getScore(ny, nx);
				updateDice(dir);
				dir = updateDir(dir, dice[5]-board[ny][nx]);
				y = ny;
				x = nx;
			}
		}
		int updateDir(int dir, int number) {
			if(number>0) {
				if(dir==0) return 2;
				else if(dir==1) return 3;
				else if(dir==2) return 1;
				else return 0;
			} else if(number<0) {
				if(dir==0) return 3;
				else if(dir==1) return 2;
				else if(dir==2) return 0;
				else return 1;
			} else return dir;
		}
		void updateDice(int dir) {
			int back = dice[0];
			int left = dice[1];
			int top = dice[2];
			int right = dice[3];
			int front = dice[4];
			int bottom = dice[5];
			switch (dir) {
			case 0: //동
				dice[0] = back;
				dice[1] = bottom;
				dice[2] = left;
				dice[3] = top;
				dice[4] = front;
				dice[5] = right;
				break;
			case 1: //서
				dice[0] = back;
				dice[1] = top;
				dice[2] = right;
				dice[3] = bottom;
				dice[4] = front;
				dice[5] = left;
				break;
			case 2: //남
				dice[0] = bottom;
				dice[1] = left;
				dice[2] = back;
				dice[3] = right;
				dice[4] = top;
				dice[5] = front;
				break;
			case 3: //북
				dice[0] = top;
				dice[1] = left;
				dice[2] = front;
				dice[3] = right;
				dice[4] = bottom;
				dice[5] = back;
				break;
			}
		}
		void getScore(int y, int x) {
			boolean visit[][] = new boolean[N][M];
			int num = board[y][x];
			int cnt = 1;
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int cy = info[0];
				int cx = info[1];
				for(int d=0; d<4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if(!isNotRange(ny, nx)) {
						if(board[ny][nx]==num) {
							if(!visit[ny][nx]) {
								visit[ny][nx] = true;
								cnt++;
								q.add(new int[] {ny, nx});
							}
						}
					}
				}
			}
			score += (num*cnt);
		}
		int reverseDir(int dir) {
			if(dir==0)
				return 1;
			if(dir==1)
				return 0;
			if(dir==2)
				return 3;
			return 2;
		}
		boolean isNotRange(int y, int x) {
			return y<0 || y>=N || x<0 || x>=M;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new int[N][M];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<M; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23288();
	}
}
