package baekjoon.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];
	static int memo[][];
	static final int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = 0;
			}
		}
		
		int day = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				day = Math.max(day, getDay(i, j));
			}
		}
		
		System.out.println(day);
		
	}

	private static int getDay(int ci, int cj) {
		
		if(memo[ci][cj]!=0)
			return memo[ci][cj];
		
		memo[ci][cj] = 1;
		
		for(int k=0; k<4; k++) {
			int ni = ci + dir[k][0];
			int nj = cj + dir[k][1];
			
			if(ni<0 || ni >= N || nj<0 || nj >=N)
				continue;
			if(map[ci][cj]>=map[ni][nj])
				continue;
			
			memo[ci][cj] = Math.max(memo[ci][cj], getDay(ni,nj)+1);
		}
		
		return memo[ci][cj];
	}

}
