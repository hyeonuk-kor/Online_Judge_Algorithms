package baekjoon.토마토;
import java.io.*;
import java.util.*;
public class Main2 {
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int N, M, map[][];
	static Queue<int[]> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new ArrayDeque<int[]>();
		for(int i=0; i<map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) 
					queue.add(new int[] {i, j, 0});
			}
		} // end input
		System.out.println(simulate());
	} // end main
	static int simulate() {
		boolean check = false;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int cy = info[0];
			int cx = info[1];
			int day = info[2];
			for(int d=0; d<4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx]!=0)
					continue;
				check = true;
				queue.add(new int[] {ny, nx, day+1});
				map[ny][nx] = day+1;
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) 
					return -1;
				else 
					max = Math.max(max, map[i][j]);
			}
		}
		return check?max:0;
	} // end simulate
} // end class