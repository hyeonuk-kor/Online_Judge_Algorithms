package baekjoon.단지번호붙이기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, count;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static char map[][];
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) 
			map[i] = br.readLine().toCharArray();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='1' && !visit[i][j]) {
					count=0;
					bfs(i, j);
					pq.add(count);
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
	static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y, x});
		visit[y][x] = true;
		count++;
		while(!q.isEmpty()) {
			int info[] = q.poll();
			int cy = info[0];
			int cx = info[1];
			for(int d=0; d<4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=N)
					continue;
				if(map[ny][nx]=='0')
					continue;
				if(visit[ny][nx])
					continue;
				q.add(new int[] {ny, nx});
				visit[ny][nx] = true;
				count++;
			}
		}
	}
}