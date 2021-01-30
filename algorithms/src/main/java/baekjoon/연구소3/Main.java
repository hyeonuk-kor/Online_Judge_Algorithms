package baekjoon.연구소3;
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
				if(map[i][j]==2) {
					virus.add(new int[] {i,j});
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
			for(int i=0; i<N; i++) 
				copyMap[i] = map[i].clone();
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
		int time[][] = new int[N][N];
		for(int i=0; i<N; i++)
			Arrays.fill(time[i], -1);
		int max = Integer.MIN_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		for(int n: activeVirus) {
			time[virus.get(n)[0]][virus.get(n)[1]] = 0;
			q.add(virus.get(n));
		}
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0; d<dir.length; d++) {
				int ni = info[0] + dir[d][0];
				int nj = info[1] + dir[d][1];
				if(ni<0 || nj<0 || ni>=N || nj>=N || map[ni][nj]==1 || time[ni][nj]!=-1)
					continue;
				time[ni][nj] = time[info[0]][info[1]] + 1;
				q.add(new int[] {ni, nj});
			}
		}
		boolean check = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					check = true;
					if(time[i][j]!=-1)
						max = Math.max(max, time[i][j]);
					if(time[i][j]==-1)
						return Integer.MAX_VALUE;
				}
			}
		}
		if(!check)
			max = 0;
		return max;
	}
}