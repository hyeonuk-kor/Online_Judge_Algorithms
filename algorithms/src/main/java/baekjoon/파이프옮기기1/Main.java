package baekjoon.파이프옮기기1;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][N];
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new int[] {0,1,0}); //최초의 파이프 상태 입력
		
		int answer = 0;
		int dir[][] = {
				{0,1},
				{1,0},
				{1,1}
		};
		
		while(!q.isEmpty()) {
			int[] pipe = q.poll();
			int ci = pipe[0];
			int cj = pipe[1];
			int cdir = pipe[2];
			
			if(ci==N-1 && cj==N-1) {
				answer++;
				continue;
			}
			
			for(int k=0; k<3; k++) { //0: 가로, 1:세로, 2:대각선
				if(k==0 && cdir==1) continue;
				if(k==1 && cdir==0) continue;
				
				int ni = ci + dir[k][0];
				int nj = cj + dir[k][1];
				
				if(ni>=N || nj>=N || house[ni][nj]==1) continue;
				if(k==2 && (house[ni][cj]==1 || house[ci][nj]==1)) continue; 
				q.add(new int[] {ni, nj, k});
			}

		}
		
		System.out.println(answer);
		
	} // end main()

} // end class
