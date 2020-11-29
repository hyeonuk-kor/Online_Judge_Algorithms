package baekjoon.미세먼지안녕;
import java.util.*;
import java.io.*;
public class Main {
	static int R,C,T,map[][], start[][];
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C]; start = new int[2][];
		int sc = 0;
		for(int i=0; i<map.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) 
					start[sc++] = new int[] {i,j};
			}
		}
		while(T-->0) {
			getSpreadDust(); 
			rotateAir();
		}
		System.out.println(getAnswer());
	}
	static int getAnswer() {
		int sum = 0;
		for(int i=0; i<R; i++) 
			for(int j=0; j<C; j++) 
				sum = sum + map[i][j];
		return sum+2;
	}
	static void getSpreadDust() {
		int map2[][] = new int[R][C];
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				if(map[y][x]>0) {
					int count = 0;
					for(int d=0; d<4; d++) {
						int ny = y + dir[d][0];
						int nx = x + dir[d][1];
						if(ny<0 || nx<0 || ny>=R || nx>=C || map[ny][nx]==-1) continue;
						map2[ny][nx] += map[y][x]/5;
						count++;
					}
					map2[y][x] += (map[y][x]-(map[y][x]/5)*count);
				}
			}
		}
		for(int i=0; i<R; i++) map[i] = map2[i].clone();
		for(int i=0; i<2; i++) map[start[i][0]][start[i][1]] = -1;
	}
	static void rotateAir() {
		int up = start[0][0];
		for(int i=up-1; i>=1; i--) map[i][0] = map[i-1][0];
		for(int i=0; i<C-1; i++) map[0][i] = map[0][i+1];
		for(int i=0; i<up; i++) map[i][C-1] = map[i+1][C-1];
		for(int i=C-1; i>=2; i--) map[up][i] = map[up][i-1];
		map[up][1] = 0;
		int down = start[1][0];
		for(int i=down+1; i<R-1; i++) map[i][0] = map[i+1][0];
		for(int i=0; i<C-1; i++) map[R-1][i] = map[R-1][i+1];
		for(int i=R-1; i>down; i--)	map[i][C-1] = map[i-1][C-1];
		for(int i=C-1; i>=2; i--) map[down][i] = map[down][i-1];
		map[down][1] = 0;
	}
}