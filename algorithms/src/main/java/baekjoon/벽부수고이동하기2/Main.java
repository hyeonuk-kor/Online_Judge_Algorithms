package baekjoon.벽부수고이동하기2;
import java.io.*;
import java.util.*;
public class Main {
	static class P14442 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K, answer;
		int dy[] = {0, 0, -1, 1};
		int dx[] = {1,-1, 0, 0};
		char board[][];
		boolean visit[][][];
		P14442() {
			input();
			answer = process();
			System.out.println(answer);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new char[N][M];
				visit = new boolean[N][M][K+1];
				for(int i=0; i<N; i++)
					board[i] = br.readLine().toCharArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int process() {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {0, 0, 0, 1});
			visit[0][0][0] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int y = info[0];
				int x = info[1];
				int t = info[2];
				int m = info[3];
				if(y==N-1 && x==M-1) {
					return m;
				} else {
					for(int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(isNotRange(ny, nx))
							continue;
						if(visit[ny][nx][t])
							continue;
						if(board[ny][nx]=='1' && t==K)
							continue;
						if(board[ny][nx]=='1' && t<K) {
							q.add(new int[] {ny, nx, t+1, m+1});
							visit[ny][nx][t] = true;
						} else {
							q.add(new int[] {ny, nx, t, m+1});
							visit[ny][nx][t] = true;
						}
					}
				}
			}
			return -1;
		}
		boolean isNotRange(int y, int x) {
			return y<0 || y>=N || x<0 || x>=M;
		}
	}
	public static void main(String[] args) {
		new P14442();
	}
}