package baekjoon.보물섬;
import java.io.*;
import java.util.*;
public class Main {
	static class P2589 {
		BufferedReader br;
		StringTokenizer st;
		int L, W, answer;
		int dir[][] = {{0,1},{0,-1}, {1,0}, {-1,0}};
		char[][] map;
		P2589() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			for(int i=0; i<L; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]=='L')
						bfs(i, j);
				}
			}
		}
		void bfs(int y, int x) {
			int max=0, min=0;
			boolean[][] visit = new boolean[L][W];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x, 0});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int cy = info[0];
				int cx = info[1];
				int dist = info[2];
				min = Math.min(min, info[2]);
				max = Math.max(max, info[2]);
				for(int d=0; d<4; d++) {
					int ny = cy + dir[d][0];
					int nx = cx + dir[d][1];
					if(ny<0 || nx<0 || ny>=L || nx>=W)
						continue;
					if(visit[ny][nx])
						continue;
					if(map[ny][nx]=='W')
						continue;
					q.add(new int[] {ny, nx, dist+1});
					visit[ny][nx] = true;
				}
			}
			answer = Math.max(max-min, answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				L = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				map = new char[L][W];
				for(int l=0; l<L; l++) {
					map[l] = br.readLine().toCharArray();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2589();
	}
}