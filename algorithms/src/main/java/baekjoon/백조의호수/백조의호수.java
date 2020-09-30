package baekjoon.백조의호수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {

	static int R, C;
	static char[][] map;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int answer = 0;
		int[][] dir = {
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}
		};

		int[][] L = new int[2][];
		int lcnt = 0;
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='L')
					L[lcnt++] = new int[] {i,j};
			}
		}
		Queue<int[]> q = new LinkedList<>();

		loop:while(true) {

			boolean[][] lVisit = new boolean[R][C];
			lVisit[L[0][0]][L[0][1]] = true;
			q.add(new int[] {L[0][0], L[0][1]});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				for(int k=0; k<dir.length; k++) {
					lVisit[temp[0]][temp[1]] = true;
					int ni = temp[0]+dir[k][0];
					int nj = temp[1]+dir[k][1];
					if(ni>=0 && nj>=0 && ni<R && nj<C) {
						if(ni==L[1][0] && nj==L[1][1])
							break loop;
						else if(map[ni][nj]=='.' && !lVisit[ni][nj]) {
							q.add(new int[] {ni, nj});
						}
					}
				}
			}

			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					for(int k=0; k<dir.length; k++) {
						int ni = i+dir[k][0];
						int nj = j+dir[k][1];
						if(ni>=0 && nj>=0 && ni<R && nj<C) {
							if(map[i][j]=='.' && (map[ni][nj]=='X'||map[ni][nj]=='L'))
								q.add(new int[] {ni, nj});
						}
					}
				}
			} // 녹는 부분 계산

			while(!q.isEmpty()) {
				int[] t = q.poll();
				map[t[0]][t[1]]='.';
			}

			answer++;

		} 
		//simulation
		System.out.println(answer);
	} //main

} //class
