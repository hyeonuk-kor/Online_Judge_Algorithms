package baekjoon.감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시 {

	static int N,M;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j]=='1')
					q.add(new int[] {i,j,map[i][j]-'0',4});
				else if(map[i][j]=='2')
					q.add(new int[] {i,j,map[i][j]-'0',2});
				else if(map[i][j]=='3')
					q.add(new int[] {i,j,map[i][j]-'0',4});
				else if(map[i][j]=='4')
					q.add(new int[] {i,j,map[i][j]-'0',4});
				else if(map[i][j]=='5')
					q.add(new int[] {i,j,map[i][j]-'0',1});
				
			}
		}
//
		
		
	} // end main

	private static void go(int x, int y, char[][] map, int dir, int cameraNumber) {
		if(cameraNumber==1) {
			if(dir==4) {
				for(int i=y; i>=0; i--)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==3) {
				for(int i=x; i>=0; i--)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
			}
		} else if(cameraNumber==2) {
			if(dir==2) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
			}
		} else if(cameraNumber==3) {
			if(dir==4) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')	
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==3) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==1) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
			}
		} else if(cameraNumber==4) {
			if(dir==4) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==3) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
			}
		} else if(cameraNumber==5) {
			for(int i=y; i>=0; i--) 
				if(map[i][x]=='0')
					map[i][x] = '#';
				else if(map[i][x]=='6')
					break;
			for(int i=x; i>=0; i--) 
				if(map[y][i]=='0')	
					map[y][i] = '#';
				else if(map[y][i]=='6')
					break;
			for(int i=y; i<N; i++) 
				if(map[i][x]=='0')
					map[i][x] = '#';
				else if(map[i][x]=='6')
					break;
			for(int i=x; i<M; i++) 
				if(map[y][i]=='0')
					map[y][i] = '#';
				else if(map[y][i]=='6')
					break;
		}
			

	} // end go


} // end class
