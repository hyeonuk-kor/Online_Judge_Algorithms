package baekjoon.침투;

import java.util.*;
import java.io.*;

public class 침투BFS {

	static int M, N;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			map[i]= br.readLine().toCharArray();
		}
		
		Queue<int[]> q = new LinkedList<>();
		for (int j=0; j<N; j++) {
			if(map[0][j]=='0')
				q.add(new int[] {0,j});
		}
		
		String answer = "NO";
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int ci = temp[0];
			int cj = temp[1];
			if(visit[ci][cj]) //이 조건 없으면 시간초과
				continue;
			visit[ci][cj]=true;
			
			if(ci==M-1) { //안쪽까지 온 경우
				answer = "YES";
				break;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int ni = ci + dir[i][0];
				int nj = cj + dir[i][1];
				if(ni<0 || nj<0 || ni>=M || nj>=N || visit[ni][nj] || map[ni][nj]=='1')
					continue;
				q.add(new int[] {ni, nj});
			}
		}
		
		bw.write(answer);
		bw.close();

	}

}
