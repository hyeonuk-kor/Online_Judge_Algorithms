package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 통나무옮기기 {

	private static int N,ex,ey,edir;
	private static final int HOR=0,VER=HOR^1;
	private static boolean[][][] visited;
	private static char[][] map;
	private static Queue<Point> queue;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	private static class Point{
		int cx,cy,dir,cnt;

		public Point(int cx, int cy, int dir, int cnt) {
			super();
			this.cx = cx;
			this.cy = cy;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [cx=" + cx + ", cy=" + cy + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		visited = new boolean[2][N][N];
		map = new char[N][];
		queue =new LinkedList<Point>();
		
		boolean isFindB =false, isFindE=false;
		for (int i = 0; i < N; ++i) {
			char[] line = in.readLine().toCharArray();
			
			for (int j = 0; j < N; ++j) {
				switch (line[j]) {
				case 'B':
					if(!isFindB) {
						Point p = null;
						if(j+1<N && line[j+1]=='B') p =  new Point(i, j+1, HOR, 0); // 수평 
						else p = new Point(i+1, j,VER, 0);
						
						visited[p.dir][p.cx][p.cy] = true;
						queue.offer(p);
						isFindB = true;
					}
					line[j] = '0';
					break;
				case 'E':
					if(!isFindE) {
						if(j+1<N && line[j+1]=='E') {
							ex = i;
							ey = j+1;
							edir = HOR;
						}else {
							ex = i+1;
							ey = j;
							edir = VER;
						}
						isFindE = true;
					}
					line[j] = '0';
					break;
				}
			}
			
			map[i] = line;
		}

		System.out.println(bfs());
	}
	private static int bfs() {
		
		int nx,ny;
		Point p = null;
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			if(p.cx == ex && p.cy == ey && p.dir == edir) return p.cnt;
			// 사방이동
			for (int d = 0; d < 4; ++d) {
				nx = p.cx+dx[d];
				ny = p.cy+dy[d];
				if(p.dir==HOR) {
					if(nx<0 || nx>=N || ny<1 ||ny>=N-1 || visited[p.dir][nx][ny] || 
							map[nx][ny-1]=='1' || map[nx][ny]=='1' || map[nx][ny+1] =='1') continue;
				}else {
					if(nx<1 || nx>=N-1 || ny<0 ||ny>=N || visited[p.dir][nx][ny]|| 
							map[nx-1][ny]=='1' || map[nx][ny]=='1'|| map[nx+1][ny] =='1') continue;
				}
				visited[p.dir][nx][ny] = true;
				queue.offer(new Point(nx, ny, p.dir, p.cnt+1));
			}
			// 회전 
			if(p.dir == HOR) {
				if(p.cx <= 0 || p.cx >= N-1) continue;
			}else {
				if(p.cy <= 0 || p.cy >= N-1) continue;
			}
			if(visited[p.dir^1][p.cx][p.cy] || !isClean(p.cx, p.cy)) continue;
			visited[p.dir^1][p.cx][p.cy] = true;
			queue.offer(new Point(p.cx, p.cy, p.dir^1, p.cnt+1));
		}
		return 0;
	}
	private static boolean isClean(int cx,int cy) {
		for (int i = cx-1; i <= cx+1; ++i) {
			for (int j = cy-1; j <= cy+1; ++j) {
				if(map[i][j]=='1') return false;
			}
		}
		return true;
	}
}














