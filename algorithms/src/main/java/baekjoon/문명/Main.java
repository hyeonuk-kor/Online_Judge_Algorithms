package baekjoon.문명;
import java.io.*;
import java.util.*;
class DisjointSet {
	private int parent[];
	public DisjointSet(int v) {
		parent = new int[v];
		Arrays.fill(parent, -1);
	}
	public int find(int x) {
		if(parent[x]==-1)
			return x;
		return parent[x] = find(parent[x]);
	}
	public void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a] = b;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int map[][] = new int[N][N];
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.valueOf(st.nextToken()) - 1;
			int x = Integer.valueOf(st.nextToken()) - 1;
			map[y][x] = i;
			q1.add(new int[] {y, x});
		}

		DisjointSet set = new DisjointSet(K+1);
		int time = 0;
		int unity = K;
		int dy[] = {0,0,1,-1};
		int dx[] = {1,-1,0,0};
		loop:while(true) {
			while(!q1.isEmpty()) {
				int y = q1.peek()[0];
				int x = q1.peek()[1];
				q2.add(q1.poll());
				for(int d=0; d<4; d++) {
					int ny = y + dy[d], nx = x + dx[d];
					if(ny<0 || nx<0 || nx>=N || ny>=N || map[ny][nx]==0)
						continue;
					if(set.find(map[ny][nx])!=set.find(map[y][x])) {
						set.union(map[ny][nx], map[y][x]);
						if(--unity==1)
							break loop;
					}
				}
			}
			while(!q2.isEmpty()) {
				int[] point = q2.poll();
				int y = point[0];
				int x = point[1];
				for(int d=0; d<4; d++) {
					int ny = y + dy[d], nx = x + dx[d];
					if(ny<0 || nx<0 || nx>=N || ny>=N)
						continue;
					if(map[ny][nx]==0) {
						q1.add(new int[] {ny, nx});
						map[ny][nx] = map[y][x];
					}
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
