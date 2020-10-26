package baekjoon.토마토;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		int dy[] = {0,0,1,-1};
		int dx[] = {1,-1,0,0};
		boolean[][] visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new int[] {i, j, 0});
					visit[i][j]=true;
				}
			}
		}

		boolean flag = false;
		loop:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					flag = true;
					break loop;
				}
			}
		}

		int answer = -1;
		if(flag) {
			while(!q.isEmpty()) {
				int[] tomato = q.poll();
				int ty = tomato[0];
				int tx = tomato[1];
				int day = tomato[2];
				for(int d=0; d<4; d++) {
					int ni = ty + dy[d];
					int nj = tx + dx[d];
					if(ni<0 || nj<0 || ni>=N || nj>=M || visit[ni][nj] || map[ni][nj]==-1)
						continue;
					if(map[ni][nj]==0) {
						visit[ni][nj]=true;
						map[ni][nj] = day+1;
						q.add(new int[] {ni, nj, day+1});
					}
				}
			}
			loop:for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						answer = -1;
						break loop;
					} else if(map[i][j]>answer){
						answer = map[i][j];
					}
				}
			}
		} else {
			answer = 0;
		}
		
		System.out.println(answer);

	}
}
