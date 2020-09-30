package baekjoon.백조의호수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] lVisit = new boolean[R][C];

		int answer = 0;
		int[][] dir = {
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}
		};

		Queue<int[]> melt = new LinkedList<>();
		Queue<int[]> cur_swan = new LinkedList<>();
		Queue<int[]> next_melt = new LinkedList<>();
		Queue<int[]> next_swan = new LinkedList<>();
		
		int si = 0, sj = 0;
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='L') {
					si = i;
					sj = j;
					melt.add(new int[] {i,j});
				} else if(map[i][j]=='.') {
					melt.add(new int[] {i,j});
				}
			}
		}
		
		cur_swan.add(new int[] {si, sj});
		lVisit[si][sj]=true;
		loop:while(true) {				
			while(!cur_swan.isEmpty()) {
				int[] temp = cur_swan.poll();
				for(int k=0; k<dir.length; k++) {
					int ni = temp[0]+dir[k][0];
					int nj = temp[1]+dir[k][1];
					if(ni>=0 && nj>=0 && ni<R && nj<C && !lVisit[ni][nj]) {
						if(map[ni][nj]=='.') {
							cur_swan.add(new int[] {ni, nj});
						}
						if(map[ni][nj]=='X') {
							next_swan.add(new int[] {ni, nj});
						}
						if(map[ni][nj]=='L') {
							break loop;
						}
						lVisit[ni][nj]=true;
					}
				}
			}
	
			while(!next_swan.isEmpty()) {
				cur_swan.add(next_swan.poll());
			}
			
			while(!melt.isEmpty()) {
				int[] temp = melt.poll();
				int i = temp[0];
				int j = temp[1];
				for(int k=0; k<dir.length; k++) {
					int ni = i + dir[k][0];
					int nj = j + dir[k][1];
					if(ni>=0 && nj>=0 && ni<R && nj<C) {
						if(map[ni][nj]=='X') {
							next_melt.add(new int[] {ni, nj});
							map[ni][nj]='.';
						}
					}
				}
			}
			
			while(!next_melt.isEmpty()) {
				melt.add(next_melt.poll());
			}
			// 녹는 부분 계산

			answer++;
			
		}//simulation

		System.out.println(answer);
		
	}  //main
	
} //class