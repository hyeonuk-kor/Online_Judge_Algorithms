package baekjoon.백조의호수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {

	static int R, C;
	static char[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] lVisit;
	static Queue<int[]> melt;
	static Queue<int[]> next_melt;
	static Queue<int[]> swan;
	static Queue<int[]> next_swan;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		lVisit = new boolean[R][C];

		int day = 0;


		melt = new LinkedList<>();
		swan = new LinkedList<>();
		next_melt = new LinkedList<>();
		next_swan = new LinkedList<>();
		
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
		
		swan.add(new int[] {si, sj});
		lVisit[si][sj]=true;
		
		while(true) {
			if(moveSwan())
				break;
			
			melting();
			
			while(!next_swan.isEmpty()) 
				swan.add(next_swan.poll());
			while(!next_melt.isEmpty()) 
				melt.add(next_melt.poll());
			day++;
			
		}//simulation

		System.out.println(day);
		
	}  //main
	
	private static boolean moveSwan() {
		while(!swan.isEmpty()) {
			int[] temp = swan.poll();
			for(int k=0; k<dir.length; k++) {
				int ni = temp[0]+dir[k][0];
				int nj = temp[1]+dir[k][1];
				if(ni>=0 && nj>=0 && ni<R && nj<C && !lVisit[ni][nj]) {
					if(map[ni][nj]=='.') {
						swan.add(new int[] {ni, nj});
					}
					if(map[ni][nj]=='X') {
						next_swan.add(new int[] {ni, nj});
					}
					if(map[ni][nj]=='L') {
						return true;
					}
					lVisit[ni][nj]=true;
				}
			}
		}
		return false;
	} //moveSwan
	
	private static void melting() {
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
	} // melting
	
	
} //class