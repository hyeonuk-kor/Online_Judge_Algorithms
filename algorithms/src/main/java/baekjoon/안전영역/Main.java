package baekjoon.안전영역;
import java.io.*;
import java.util.*;
public class Main {
	static class P2468 {
		BufferedReader br;
		StringTokenizer st;
		int N, board[][], answer;
		int dy[] = {0, 0, 1, -1};
		int dx[] = {1,-1, 0,  0};
		boolean flood[][], visit[][];
		int solve() {
			input();
			for(int h=1; h<=100; h++) {
				flood = new boolean[N][N];
				visit = new boolean[N][N];
				flooding(h);
				raining(h);
			}
			return answer;
		}
		void raining(int h) {
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!flood[i][j] && !visit[i][j]) {
						getSafetyZone(i, j);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		void getSafetyZone(int y, int x) {
			visit[y][x] = true;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=N || visit[ny][nx] || flood[ny][nx])
					continue;
				getSafetyZone(ny, nx);
			}
		}
		void flooding(int h) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j]<=h)
						flood[i][j] = true;
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				board = new int[N][N];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<N; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P2468().solve());
	}
}