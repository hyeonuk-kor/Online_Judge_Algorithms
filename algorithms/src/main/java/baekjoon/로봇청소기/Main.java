package baekjoon.로봇청소기;
import java.io.*;
import java.util.*;
public class Main {
	static final int NORTH=0, EAST=1, SOUTH=2, WEST=3;
	static int N, M, map[][], dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
	static boolean check[][];
	static int answer=1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int sy = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		simulate(sy, sx, dir, 0);
		bw.append(Integer.toString(answer));
		bw.flush();
	}
	static void simulate(int y, int x, int d, int count) {
		if(count==4) { //4방향 모두 청소가 끝났을 때
			switch (d) {
				case NORTH : y=y+1; break;
				case EAST : x=x-1; break;
				case SOUTH : y=y-1; break;
				case WEST : x=x+1; break;
			}
			if(!isRange(y, x) && map[y][x]!=1)
				simulate(y, x, d, 0);
			return;
		}
		check[y][x]=true;
		d = (d==0)?3:d-1;
		int ny = y + dir[d][0]; 
		int nx = x + dir[d][1]; 
		if(searchArea(ny, nx)) {
			simulate(ny, nx, d, 0); 
			answer++;
		} else { 
			simulate(y, x, d, count+1);
		}
	}
	static boolean searchArea(int y, int x) {
		if(isRange(y, x) || map[y][x]==1 || check[y][x]) 
			return false;
		return true;
	}
	static boolean isRange(int y, int x) {
		return (y<0 || x<0 || y>=N || x>=M);
	}
}
