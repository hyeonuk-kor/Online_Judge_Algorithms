package baekjoon.다리만들기2;
import java.util.*;
import java.io.*;
public class Main {
	static int N, M, number, map[][], graph[][], w[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}, answer=Integer.MAX_VALUE;
	static boolean select[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st  = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) 
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		init();
		simulation(0,0,0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	static void simulation(int index, int start, int weight) {
		if(index==number-1) {
			if(check()) answer = Math.min(answer, weight);
			return;
		}
		for(int i=start; i<number*number; i++) {
			int y = i/number+1, x = i%number+1;
			if(y<=x) continue;
			if(w[y][x]!=Integer.MAX_VALUE) {
				select[y][x]=true; select[x][y]=true;
				simulation(index+1, i+1, weight+w[y][x]);
				select[x][y]=false;	select[y][x]=false;
			}
		}
	}
	static boolean check() {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		boolean visit[] = new boolean[7];
		int count = 0; q.add(1); visit[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;
			for(int i=1; i<=number; i++) {
				if(visit[i]) continue;
				if(select[now][i]) {
					q.add(i);
					visit[i]=true;
				}
			}
		}
		if(count==number) return true;
		return false;
	}
	static void getDistance(int y, int x) {
		if(map[y][x]==0) return;	
		int start = map[y][x];
		for(int d=0; d<4; d++) {
			int ny = y, nx = x, dist = 0, next = 0;
			while(true) {
				ny += dir[d][0]; nx += dir[d][1];
				if(isRange(ny, nx)) break;	if(map[ny][nx]==start) break;
				next = map[ny][nx];
				if(next!=0) {
					if(dist>=2) w[start][next] = Math.min(w[start][next], dist);
					break;
				}
				dist++;
			}
		}
	}
	static void init() {
		for(int i=0; i<N; i++) 
			for(int j=0; j<M; j++) 
				if(map[i][j]==-1) setNumber(i, j, ++number);
		w = new int[11][11]; select = new boolean[11][11];
		for(int i=1; i<=number; i++) 
			for(int j=1; j<=number; j++) 
				if(i!=j) w[i][j] = Integer.MAX_VALUE;
				else w[i][j] = 0; 
		for(int i=0; i<N; i++) 
			for(int j=0; j<M; j++) 
				getDistance(i,j);
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
		return y<0 || x<0 || y>=N || x>=M;
	}
}
