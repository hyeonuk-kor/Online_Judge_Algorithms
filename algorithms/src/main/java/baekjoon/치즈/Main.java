package baekjoon.치즈;
import java.util.*;
import java.io.*;
public class Main {
	static class P2636 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, board[][];
		int cheese, time, answer;
		int dy[] = {0, 0, 1, -1};
		int dx[] = {1,-1, 0,  0};
		boolean visit[][];
		void solve() {
			input();
			melting_cheese();
		}
		void melting_cheese() {
			Queue<int[]> q = new ArrayDeque<>();
			Queue<int[]> next_q = new ArrayDeque<>();
			visit = new boolean[N][M];
			q.add(new int[] {0, 0});
			visit[0][0] = true;
			while(cheese>0) {
				while(!q.isEmpty()) {
					int[] info = q.poll();
					int y = info[0];
					int x = info[1];
					for(int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(nx<0 || ny<0 || ny>=N || nx>=M || visit[ny][nx])
							continue;
						if(board[ny][nx]==1) {
							board[ny][nx] = 0;
							next_q.add(new int[] {ny, nx});
						} else if(board[ny][nx]==0) {
							q.add(new int[] {ny, nx});
						}
						visit[ny][nx]= true;
					}
				}
				q = new ArrayDeque<>(next_q);
				time++;
				answer = cheese;
				cheese -= next_q.size();
				next_q.clear();
			}
			System.out.println(time);
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				board = new int[N][M];
				visit = new boolean[N][M];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<M; j++) {
						board[i][j] = Integer.parseInt(st.nextToken());
						if(board[i][j]==1)
							cheese++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		P2636 t = new P2636();
		t.solve();
	}
}