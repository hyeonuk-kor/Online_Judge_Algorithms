package baekjoon.다리만들기;
import java.util.*;
import java.io.*;
public class Main {
	static int N, map[][], distance[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}, answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) 
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		mapInit();
		for(int i=0; i<N; i++)
			System.out.println(Arrays.toString(map[i]));
		distanceInit();
		simulation();
		System.out.println(answer);
	}
	static void simulation() {
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(map[i][j]>=1) getResult(i, j, map[i][j], 0);		
	}
	static void distanceInit() {
		distance = new int[N][N];
		for(int i=0; i<N; i++) 
			Arrays.fill(distance[i],Integer.MAX_VALUE);
	}
	static void mapInit() {
		int number = 1;
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(map[i][j]==-1) setNumber(i, j, number++);		
	}
	static void getResult(int y, int x, int number, int dist) {
		if(answer<=dist) return;
		for(int d=0; d<4; d++) {
			int ny = y + dir[d][0], nx = x + dir[d][1];
			if(isRange(ny, nx)) continue;
			if(distance[ny][nx]<=dist+1) continue;
			if(map[ny][nx]==number) continue;
			if(map[ny][nx]==0) {
				distance[ny][nx]=dist+1;
				getResult(ny, nx, number, dist+1);
			} else if(map[ny][nx]!=number) {
				answer = Math.min(dist, answer);
			}
		}
	}
	static void setNumber(int y, int x, int number) {
		map[y][x] = number;
		for(int d=0; d<4; d++) {
			int ny = y + dir[d][0], nx = x + dir[d][1];
			if(!isRange(ny, nx) && map[ny][nx]==-1) 
				setNumber(ny, nx, number);
		}
	}
	static boolean isRange(int y, int x) {
		return y<0 || x<0 || y>=N || x>=N;
	}
}
