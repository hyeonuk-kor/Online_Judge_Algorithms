package baekjoon.인내의도미노장인호석;
import java.io.*;
import java.util.*;
public class Main {
	static class P20165 {
		class Foward {
			int y, x, d;
			Foward(int y, int x, int d) {
				this.y = y;
				this.x = x;
				this.d = d;
			}
		}
		class Defender {
			int y, x;
			Defender(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
		BufferedReader br;
		StringTokenizer st;
		int N, M, R, board[][];
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean check[][];
		Foward[] foward;
		Defender[] defender;
		P20165() {
			input();
			pro();
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(check[i]));
			}
		}
		void pro() {
			check = new boolean[N][M]; // 도미노가 넘어졌는지 아닌지 확인
			for(int r=0; r<R; r++) { // R턴을 수행하면서 상태를 확인
				turn_foward(foward[r]);
				turn_defender(defender[r]);
			}
		}
		void turn_foward(Foward cmd) {
			int y = cmd.y;
			int x = cmd.x;
			int d = cmd.d;
			int cnt = board[y][x];
			for(int i=0; i<cnt; i++) {
				int ey = y + dir[d][0]*board[y][x];
				int ex = x + dir[d][1]*board[y][x];
				if(ey<0 || ex<0 || ey>=N || ex>=M)
					break;
				if(check[ey][ex]) {
					check[y][x] = true;
					y+=dir[d][0];
					x+=dir[d][1];
				} else {
					
				}
			}
		}
		void turn_defender(Defender cmd) {
			int y = cmd.y;
			int x = cmd.x;
			check[y][x] = false;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				board = new int[N][M];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<M; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				foward = new Foward[R];
				defender = new Defender[R];
				for(int i=0; i<R; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken())-1;
					int x = Integer.parseInt(st.nextToken())-1;
					int d = getDir(st.nextToken());
					foward[i] = new Foward(y, x, d);
					st = new StringTokenizer(br.readLine().trim());
					y = Integer.parseInt(st.nextToken())-1;
					x = Integer.parseInt(st.nextToken())-1;
					defender[i] = new Defender(y, x);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int getDir(String str) {
			if(str.equals("E")) {
				return 0;
			} else if(str.equals("W")) {
				return 1;
			} else if(str.equals("S")) {
				return 2;
			} else {
				return 3;
			}
		}
	}
	public static void main(String[] args) {
		new P20165();
	}
}