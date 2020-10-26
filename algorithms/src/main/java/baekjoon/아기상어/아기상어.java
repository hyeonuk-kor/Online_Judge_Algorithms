package baekjoon.아기상어;
import java.io.*;
import java.util.*;
public class 아기상어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]<o2[2])
					return Integer.compare(o1[2], o2[2]);
				else if(o1[2]>o2[2])
					return Integer.compare(o2[2], o2[2]);
				else {
					if(o1[1]<o2[1])
						return Integer.compare(o1[1], o2[1]);
					else if(o1[1]>o2[1])
						return Integer.compare(o2[1], o1[1]);
					else {
						return Integer.compare(o1[0], o2[0]);
					}
				}
			}
		});

		boolean visit[][] = visitInit(N);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][2]=2;
					pq.add(new int[] {i,j,0,0,2});
					visit[i][j]=true;
				}
			}
		}

		int[][] dir = {
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}
		};

		int answer = 0;
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int ci = temp[0];
			int cj = temp[1];
			int move = temp[2];
			int eat = temp[3];
			int size = temp[4];
			System.out.println(Arrays.toString(temp));
			if(eat==size) {
				size = eat;
				answer = move;
				visit = visitInit(N);
			}
			for(int d=0; d<dir.length; d++) {
				int ni = ci + dir[d][0];
				int nj = cj + dir[d][1];
				if(ni<0 || nj<0 || ni>=N || nj>=N || visit[ni][nj] || map[ni][nj]>size) continue;
				pq.add(new int[] {ni, nj, move+1, eat, size});
				visit[ni][nj]=true;
			}
		}
		System.out.println(answer);


	} //end main

	private static boolean[][] visitInit(int n) {
		boolean[][] visitInit = new boolean[n][n];
		return visitInit;
	}


} // end class