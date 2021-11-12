package baekjoon.다오의데이트;
import java.io.*;
import java.util.*;
public class Main {
	static class P18188 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int H, W, N, dao_x, dao_y, dizini_x, dizini_y, select[];
		int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		char[][] board, marid;
		P18188() {
			input();
			sb = new StringBuilder();
			dfs(0);
			if(sb.length()==0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				System.out.println(sb);
			}
		}
		void dfs(int depth) {
			if(depth==N) {
				move(dao_y, dao_x);
				return;
			} else {
				for(int i=0; i<2; i++) {
					select[depth] = i;
					dfs(depth+1);
					if(sb.length()!=0)
						return;
				}
			}
		}
		void move(int y, int x) {
			for(int i=0; i<N; i++) {
				int d = 0;
				switch (marid[i][select[i]]) {
					case 'W': d=0; break;
					case 'A': d=1; break;
					case 'S': d=2; break;
					case 'D': d=3; break;
				}
				y += dir[d][0]; 
				x += dir[d][1];
				if(y<0 || x<0 || y>=H || x>=W || board[y][x]=='@')
					return;
				if(y==dizini_y && x==dizini_x) {
					for(int j=0; j<=i; j++) {
						sb.append(marid[j][select[j]]);
					}
					return;
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				H = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				board = new char[H][W];
				for(int i=0; i<H; i++) {
					board[i] = br.readLine().toCharArray();
					for(int j=0; j<W; j++) {
						if(board[i][j]=='D') {
							dao_y = i;
							dao_x = j;
						} else if(board[i][j]=='Z') {
							dizini_y = i;
							dizini_x = j;
						}
					}
				}
				N = Integer.parseInt(br.readLine());
				select = new int[N];
				marid = new char[N][2];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					marid[i][0] = st.nextToken().charAt(0);
					marid[i][1] = st.nextToken().charAt(0);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P18188();
	}
}