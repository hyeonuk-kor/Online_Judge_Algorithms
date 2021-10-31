package baekjoon.비숍;
import java.io.*;
import java.util.*;
class Main2 {
	static class P1799 {
		BufferedReader br;
		StringTokenizer st;
		int N, board[][], max[];
		boolean[] v1, v2;
		P1799() {
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			input();
			solve();
		}
		void solve() {
			v1 = new boolean[N*2];
			v2 = new boolean[N*2];
			max = new int[2];
			put(0, 0, 0, 0);
			put(0, 1, 0, 1);
			System.out.println(max[0] + max[1]);
		}
		void put(int y, int x, int count, int color) {
			if(x>=N) {
				y++;
				x = (x%2==0)?1:0;
			}
			if(y>=N) {
				max[color] = Math.max(max[color], count);
				return;
			}
			if(board[y][x]==1 && !v1[y+x] && !v2[N-y+x-1]) {
				v1[y+x] = true; v2[N-y+x-1] = true;
				put(y, x+2, count+1, color);
				v1[y+x] = false; v2[N-y+x-1] = false;
			}
			put(y, x+2, count, color);
			
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				board = new int[N][N];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<N; j++) {
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
		new P1799();
	}
}
