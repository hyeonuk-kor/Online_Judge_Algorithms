package baekjoon.벽부수고이동하기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, map[][];
	static boolean visit[][][];
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit[0][0][0] = true;
		visit[0][0][1] = true;
		q.add(new int[] {0, 0, 1});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int y = info[0];
			int x = info[1];
			int move = info[2];
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(isRange(ny, nx)) {
					
				}
			}
		}
		return -1;
	}
	static boolean isRange(int y, int x) {
		if(y<0 || x<0 || y>=N || x>=M)
			return false;
		return true;
	}
}
