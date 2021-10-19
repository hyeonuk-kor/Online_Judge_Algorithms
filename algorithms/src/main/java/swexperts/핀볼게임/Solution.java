package swexperts.핀볼게임;
import java.io.*;
import java.util.*;
public class Solution {
	static class Pinball {
		int y, x;
		public Pinball(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static final int R=0, L=1, D=2, U=3;
	static int N, board[][]= new int[102][102];
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static int answer;
	static int nextDir[][] = {
			{R, L, D, U},
			{L, U, R, D},
			{L, D, U, R},
			{D, R, U, L},
			{U, R, L, D},
			{L, R, U, D}
	};
	static List<ArrayList<Integer>> wormhole;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N+2; i++) {
				Arrays.fill(board[i], 5);
			}
			wormhole = new ArrayList<>();
			for(int i=0; i<5; i++) {
				wormhole.add(new ArrayList<>());
			}
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]>=6) {
						wormhole.get(board[i][j]-6).add(i);
						wormhole.get(board[i][j]-6).add(j);
					}
				}
			}
			answer = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(board[i][j]==0) {
						for(int d=0; d<4; d++) {
							simulate(i, j, d);
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void simulate(int sy, int sx, int d) {
		int cnt = 0;
		Pinball p = new Pinball(sy, sx);
		while(true) {
			p.y += dy[d];
			p.x += dx[d];
			if((p.y==sy && p.x==sx) || board[p.y][p.x]==-1) {
				answer = Math.max(answer, cnt);
				break;
			}
			if(board[p.y][p.x]>=1 && board[p.y][p.x]<=5) {
				d = nextDir[board[p.y][p.x]][d];
				cnt++;
			} else if(board[p.y][p.x]>=6 && board[p.y][p.x]<=10){
				for(int i=0; i<4; i+=2) {
					int wy = wormhole.get(board[p.y][p.x]-6).get(i);
					int wx = wormhole.get(board[p.y][p.x]-6).get(i+1);
					if(wy!=p.y && wx!=p.x) {
						p.y = wy;
						p.x = wx;
						break;
					}
				}
			} 

		}
	}
}