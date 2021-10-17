package swexperts.원자소멸시뮬레이션;
import java.io.*;
import java.util.*;
public class Solution {
	static class Point {
		int x, y, d, e;
		Point(int x, int y, int d, int e) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.e = e;
		}
	}
	static int answer;
	static int[][] map = new int[4001][4001];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static Queue<Point> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = 0;
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int y = (Integer.parseInt(st.nextToken())+1000)*2;
				int x = 4000 - ((Integer.parseInt(st.nextToken())+1000)*2);
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				q.add(new Point(x, y, d, e));
				map[x][y] = e;
			}
			bfs();
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.x][p.y]!=p.e) {
				answer += map[p.x][p.y];
				map[p.x][p.y]= 0;
				continue;
			} 
			int nx = p.x + dx[p.d];
			int ny = p.y + dy[p.d];
			map[p.x][p.y] = 0; 
			if(nx<0 || ny<0 || nx>=4001 || ny>=4001)
				continue;
			if(map[nx][ny]==0) {
				map[nx][ny] = p.e;
				q.add(new Point(nx, ny, p.d, p.e));
			} else {
				map[nx][ny] += p.e;
			}
		}
	}
}
