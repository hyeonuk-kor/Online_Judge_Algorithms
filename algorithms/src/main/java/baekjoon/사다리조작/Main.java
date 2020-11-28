package baekjoon.사다리조작;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, H, answer=4;
	static int row, col, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		row = H+2; col = 2*N+1;
		map = new int[row][col];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j+=2) {
				map[i][j]=1;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][2*b] = 0;
		}
		simulate(1, 1, 1, 0);
		if(answer==4) answer = -1;
		System.out.println(answer);
	}
	static void simulate(int y, int x, int number, int count) {
		if(number==N) {
			answer = Math.min(answer, count);
			return;
		}
		if(count>=answer) return;
		if(x<1 || x>=col-1) return;
		if(y==row-1) {
			if(x==number*2-1) simulate(1, x+2, number+1, count);
			return;
		} 
		if(map[y][x+1]==0) simulate(y+1, x+2, number, count);
		else if(map[y][x-1]==0)	simulate(y+1, x-2, number, count);
		else simulate(y+1, x, number, count);

		if(map[y][x+1]==1) addLadder(y, x+1, 1, number, count+1);
		if(map[y][x-1]==1) addLadder(y, x-1, -1, number, count+1);
	}
	static void addLadder(int y, int x, int dir, int number, int count) {
		if(x==0 || x==col-1) return;
		if(map[y][x-2]==0 || map[y][x+2]==0) return;
		map[y][x]=0;
		simulate(y+1, x+dir, number, count);
		map[y][x]=1;
	}
}