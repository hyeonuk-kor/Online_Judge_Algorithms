package baekjoon.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int N;
	private static char[][] m;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 그리드의 크기, N*N 1<= N <=100
		m = new char[N][N]; // 그리드 입력
		for (int i = 0; i < m.length; i++) {
			String str = br.readLine();
			m[i] = str.toCharArray();
		}
		
		visited = new boolean[N][N];
		int cnt = 0; // 정상인의 구획수
		// 정상 : 모든 좌표를 돌면서, 방문하지 않은 좌표는 dfs
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		//System.out.println(cnt);
		
		// RGB m 배열에서 G -> R
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(m[i][j]=='G') {
					m[i][j]='R';
				}
			}
		}
		// 색약 : 모든 좌표를 돌면서 방문하지 않은 좌표는 dfs
//		visited = new boolean[N][N]; //객체생성 시간손해
		for (int i = 0; i < N; i++) {	// 초기화가 더 빠름
//			Arrays.fill(visited, false);
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		
		int cnt2 = 0; // 정상인의 구획수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt2++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
		
	} // end of main

	public static int[] dr = {-1, 1, 0, 0}; //상 하 좌 우
	public static int[] dc = {0, 0, -1, 1}; //상 하 좌 우
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && m[nr][nc]==m[r][c]) {
				dfs(nr,nc);
			}
		}
	}
	
} // end of class