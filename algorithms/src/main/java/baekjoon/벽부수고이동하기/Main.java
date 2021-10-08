package baekjoon.벽부수고이동하기;
import java.io.*;
import java.util.*;
public class Main {
	static class Solution {
		BufferedReader br;
		StringTokenizer st;
		int N, M, board[][], visit[][];
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		int solve() {
			input();
			return bfs();
		}
		int bfs() {
			Queue<Integer> q = new ArrayDeque<>();
			visit[0][0] = 0;
			q.add(0);
			q.add(0);
			q.add(0);
			q.add(1);
			while(!q.isEmpty()) {
				int y = q.poll();
				int x = q.poll();
				int broken = q.poll();
				int count = q.poll();
				if(y==N-1 && x==M-1)
					return count;
				for (int d = 0; d < dir.length; d++) {
					int ny = y + dir[d][0];
					int nx = x + dir[d][1];
					if(ny<0 || nx<0 || ny>=N || nx>=M)
						continue;
					if(visit[ny][nx]<=broken) continue;
					if(board[ny][nx]==0) {
						visit[ny][nx] = broken;
						q.add(ny);
						q.add(nx);
						q.add(broken);
						q.add(count+1);
					} else {
						if(broken==0) {
							visit[ny][nx] = broken+1;
							q.add(ny);
							q.add(nx);
							q.add(broken+1);
							q.add(count+1);
						}
					}
				}
			}
			return -1;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				board = new int[N][M];
				visit = new int[N][M];
				for (int i = 0; i < N; i++) {
					String input = br.readLine();
					for (int j = 0; j < input.length(); j++) {
						board[i][j] = input.charAt(j)-'0';
						visit[i][j] = Integer.MAX_VALUE;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solve());
	}
}