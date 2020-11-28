package baekjoon.인구이동;
import java.util.*;
import java.io.*;
public class Main {
	static int N, L, R, map[][];
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int drift = 0;
		while(drift<=2000) {
			int map2[][] = new int[N][N];
			for(int i=0; i<N; i++) 
				map2[i] = map[i].clone();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i][j]) continue;
					visit[i][j]=true;
					bfs(i, j);
				}
			}
			if(check(map2)) {
				for(int i=0; i<N; i++)
					Arrays.fill(visit[i], false);
				drift++;
			} else break;
		}
		System.out.println(drift);
	}
	static boolean check(int[][] map2) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=map2[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	static void bfs(int i, int j) {
		int sum = 0;
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		q1.add(new int[] {i, j});
		while(!q1.isEmpty()) {
			int[] info = q1.poll();
			int y = info[0];
			int x = info[1];
			q2.add(new int[] {y, x});
			sum += map[y][x];
			for(int d=0; d<4; d++) {
				int ny = y+dir[d][0];
				int nx = x+dir[d][1];
				if(adjCheck(y, x, ny, nx)) {
					q1.add(new int[] {ny, nx});
					visit[ny][nx]=true;
				}
			}
		}
		int count = q2.size();
		while(!q2.isEmpty()) {
			int[] info = q2.poll();
			int y = info[0];
			int x = info[1];
			map[y][x] = sum/count;
		}
	}
	static boolean adjCheck(int y, int x, int ny, int nx) {
		if(ny<0 || nx<0 || ny>=N || nx>=N) return false;
		if(visit[ny][nx]) return false;
		int people = Math.abs(map[y][x]-map[ny][nx]);
		if(people<L || people>R ) return false;
		return true;
	}
}
