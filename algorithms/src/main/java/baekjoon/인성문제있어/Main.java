package baekjoon.인성문제있어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static int H,W,O,F,Si,Sj,Ei,Ej;
	static int[][] maze;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			init();
			if(simulate())
				System.out.println("잘했어!!");
			else
				System.out.println("인성 문제있어??");
		}
	}
	static boolean simulate() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[H][W];
		check[Si][Sj] = true;
		q.add(new int[] {Si, Sj, F});
		int[][] dir = {
				{1,0},  // 상
				{-1,0}, // 하
				{0,-1}, // 좌
				{0,1},  // 우
		};
		while(!q.isEmpty()) {
			int[] currentInfo = q.poll();
			int ci = currentInfo[0];
			int cj = currentInfo[1];
			int cf = currentInfo[2];
			if(ci==Ei && cj==Ej)
				return true;
			if(cf==0) //힘이 0이라면 이동불가
				continue;
			for (int i = 0; i < dir.length; i++) {
				int ni = ci + dir[i][0];
				int nj = cj + dir[i][1];
				if(ni>=0 && nj>=0 && ni<H && nj<W && !check[ni][nj]) {
					check[ni][nj] = true;
					if(maze[ni][nj]<=maze[ci][cj]) { //현재 위치보다 방문하려는 곳이 낮은 곳이라면
						q.add(new int[] {ni, nj, cf-1});
					} else if(maze[ni][nj]>maze[ci][cj]) { //현재 위치보다 방문하려는 곳이 높은 곳이라면
						int jump = maze[ni][nj] - maze[ci][cj];
						if(cf>=jump) { //남아있는 힘이 점프해야하는 높이보다 크거나 같으면 이동
							q.add(new int[] {ni, nj, cf-1});
						}
					}
				}
			}
		}
		return false;
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		Si = Integer.parseInt(st.nextToken())-1;
		Sj = Integer.parseInt(st.nextToken())-1;
		Ei = Integer.parseInt(st.nextToken())-1;
		Ej = Integer.parseInt(st.nextToken())-1;
		maze = new int[H][W];
		for(int i=0; i<O; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int oi = Integer.parseInt(st.nextToken())-1;
			int oj = Integer.parseInt(st.nextToken())-1;
			int oh = Integer.parseInt(st.nextToken());
			maze[oi][oj] = oh;
		}
	}
}
