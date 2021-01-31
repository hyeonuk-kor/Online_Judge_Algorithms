package baekjoon.연구소2;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, map[][], activeVirus[], min = Integer.MAX_VALUE;
	static ArrayList<int[]> virus = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		activeVirus = new int[M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					map[i][j]=-1;
				if(map[i][j]==2) {
					map[i][j]=-2;
					virus.add(new int[] {i,j,0});
				}
			}
		}
		simulate(virus.size(), M, 0, 0);
		if(min==Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
	static void simulate(int n, int r, int index, int number) {
		if(r==0) {
			int copyMap[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				copyMap[i] = map[i].clone();
				for(int j=0; j<N; j++) {
					if(copyMap[i][j]==-2) {
						copyMap[i][j]=0;
					}
				}
			}
			min = Math.min(min, spreadVirus(copyMap, activeVirus));
			return;
		} 
		if(number==n)
			return;
		activeVirus[index] = number;
		simulate(n, r-1, index+1, number+1);
		simulate(n, r, index, number+1);
	}
	static int spreadVirus(int[][] map, int[] activeVirus) {
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean visit[][] = new boolean[N][N];
		int max = Integer.MIN_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		for(int n: activeVirus) {
			visit[virus.get(n)[0]][virus.get(n)[1]] = true;
			q.add(virus.get(n));
		}
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0; d<dir.length; d++) {
				int ni = info[0] + dir[d][0];
				int nj = info[1] + dir[d][1];
				if(ni<0 || nj<0 || ni>=N || nj>=N || visit[ni][nj] || map[ni][nj]!=0)
					continue;
				visit[ni][nj] = true;
				map[ni][nj] = info[2]+1;
				q.add(new int[] {ni, nj, map[ni][nj]});
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0 && !visit[i][j]) {
					return Integer.MAX_VALUE;
				} else if(map[i][j]!=-1){
					max = Math.max(max, map[i][j]);
				}
			}
		}
		return max;
	}
}