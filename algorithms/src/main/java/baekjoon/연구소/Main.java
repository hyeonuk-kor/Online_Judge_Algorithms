package baekjoon.연구소;
import java.util.*;
import java.io.*;
public class Main {
	static int answer, N, M;
	static int[][] map, copyMap;
	static int dir[][] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
	static boolean[][] built, check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		built = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0)
					built[i][j] = true;
			}
		}
		simulate(0,0,0);
		bw.append(answer+"\n");
		bw.flush();
	}
	static void simulate(int y, int x, int count) {
		if(count==3) {
			preTest();
			spreadVirus();
			answer = Math.max(answer, getCleanArea());
			return;
		}
		if(y==N) 
			return;
		if(x==M) {
			simulate(y+1, 0, count);
			return;
		}
		if(!built[y][x] && map[y][x]==0) {
			map[y][x]=1;
			built[y][x]=true;
			simulate(y,x+1,count+1);
			built[y][x]=false;
			map[y][x]=0;
		} else {
			built[y][x]=true;
		}
		simulate(y,x+1,count);
	}
	static void preTest() {
		copyMap = new int[N][M];
		for(int i=0; i<N; i++) 
			copyMap[i] = map[i].clone();
	}
	static int getCleanArea() {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0)
					count++;
			}
		}
		return count;
	}
	static void spreadVirus() {
		check = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<int[]>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==2) 
					q.add(new int[] {i,j});
				if(copyMap[i][j]!=0)
					check[i][j] = true;
			}
		}
		while(!q.isEmpty()) {
			int[] info = q.poll();
			for(int d=0; d<dir.length; d++) {
				int ni = info[0] + dir[d][0];
				int nj = info[1] + dir[d][1];
				if(ni<0 || nj<0 || ni>=N || nj>=M || check[ni][nj] || copyMap[ni][nj]!=0) continue;
				check[ni][nj]=true;
				copyMap[ni][nj]=2;
				q.add(new int[] {ni, nj});
			}
		}
	}
}
