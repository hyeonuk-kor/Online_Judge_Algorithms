package baekjoon.마법사상어와파이어스톰;
import java.io.*;
import java.util.*;
public class Main {
	static int N, SUM, MAX, SIZE, Q, A[][], T[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visit[][];
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		SIZE = 1<<N;
		A = new int[SIZE][SIZE];
		T = new int[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<SIZE; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int t=0; t<Q; t++) {
			//rotate
			int L = 1<<Integer.parseInt(st.nextToken());
			for(int y=0; y<SIZE; y+=L) {
				for(int x=0; x<SIZE; x+=L) {
					for(int i=0; i<L; i++) 
						for(int j=0; j<L; j++) 
							T[i][j] = A[L+y-j-1][x+i];
					for(int i=0; i<L; i++) 
						for(int j=0; j<L; j++) 
							A[y+i][x+j] = T[i][j];
				}
			}
			//melt
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(A[i][j]==0) 
						continue;
					int cnt = 0;
					for(int d=0; d<4; d++) {
						int ni = i + dir[d][0];
						int nj = j + dir[d][1];
						if(ni<0 || nj<0 || ni>=SIZE || nj>=SIZE || A[ni][nj]==0)
							continue;
						cnt++;
					}
					if(cnt<3)
						q.add(new int[] {i, j});
				}
			}
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int y = info[0];
				int x = info[1];
				A[y][x]--;
			}
		} //End FireStorm
		//calc
		visit = new boolean[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				SUM += A[i][j];
				if(A[i][j]==0 || visit[i][j]) 
					continue;
				int calc = 1;
				visit[i][j] = true;
				q.add(new int[] {i, j});
				while(!q.isEmpty()) {
					int[] info = q.poll();
					for(int d=0; d<4; d++) {
						int ni = info[0] + dir[d][0];
						int nj = info[1] + dir[d][1];
						if(ni<0 || nj<0 || ni>=SIZE || nj>=SIZE || A[ni][nj]==0 || visit[ni][nj])
							continue;
						visit[ni][nj] = true;
						q.add(new int[] {ni, nj});
						calc++;
					}
				}
				MAX = Math.max(MAX, calc);
			}
		}
		System.out.println(SUM);
		System.out.println(MAX);
	}
}