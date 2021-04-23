package baekjoon.달팽이3;
import java.io.*;
import java.util.*;
public class Main {
	static boolean map[][];
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	static int rowSize, colSize;
	static int count, ey, ex;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.valueOf(st.nextToken());
		colSize = Integer.valueOf(st.nextToken());
		map = new boolean[rowSize][colSize];
		simulate(0, 0, 0, rowSize*colSize);
		System.out.println(count);
		System.out.println(ey+" "+ex);
	}
	static void simulate(int y, int x, int dir, int exitNumber) {
		if(exitNumber==1) {
			ey = y+1;
			ex = x+1;
			return;
		} 
		map[y][x] = true;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(ny<0 || nx<0 || ny>=rowSize || nx>=colSize || map[ny][nx]) {
			dir++;
			dir%=4;
			count++;
			ny = y + dy[dir];
			nx = x + dx[dir];
		}
		simulate(ny, nx, dir, exitNumber-1);
	}
}