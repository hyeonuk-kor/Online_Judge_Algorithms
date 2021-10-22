package swexperts.탈주범검거;
import java.io.*;
import java.util.*;
public class Solution {
	static int N, M, R, C, L; // 가로 세로 크기 5<=(N, M)<=50, 멘홀(R, C), 시간<=20
	static int board[][] = new int[50][50]; 
	static boolean visit[][] = new boolean[50][50];
	static Queue<int[]> q = new ArrayDeque<>();
	// 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0}; 
	static int[] dx = {0, 0, -1, 1}; 
	static int[][] dir = {
			{0, 0, 0, 0}, // 0
			{1, 1, 1, 1}, // 1 상 하 좌 우
			{1, 1, 0, 0}, // 2 상 하
			{0, 0, 1, 1}, // 3 좌 우
			{1, 0, 0, 1}, // 4 상 우 
			{0, 1, 0, 1}, // 5 하 우
			{0, 1, 1, 0}, // 6 하 좌
			{1, 0, 1, 0}  // 7 상 좌
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken())-1;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			bfs();
			System.out.println("#"+tc+" "+calc());
		}
	}
	static int calc() {
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) {
					answer++;
					visit[i][j] = false;
				}
			}
		}
		return answer;
	}
	static void bfs() {
		q.add(new int[] {R, C, L});
		visit[R][C] = true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int y = info[0];
			int x = info[1];
			int t = info[2];
			for(int d=0; d<dir[board[y][x]].length; d++) {
				if(dir[board[y][x]][d]==0)
					continue;
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=M)
					continue;
				if(visit[ny][nx])
					continue;
				if(board[ny][nx]==0)
					continue;
				int nd = getNext(d);
				if(dir[board[ny][nx]][nd]==0)
					continue;
				if(t==0)
					continue;
				q.add(new int[] {ny, nx, t-1});
				visit[ny][nx] = true;
			}
		}
	}
	static int getNext(int number) {
		if(number<=1)
			return 1-number;
		return 5-number;
	}
}