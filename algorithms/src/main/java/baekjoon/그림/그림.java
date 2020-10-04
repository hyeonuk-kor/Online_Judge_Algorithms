package baekjoon.그림;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int max = 0;
		int drawing = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] mark = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int[][] dir = {
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}
		};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]==1 && !mark[i][j]) {
					int calc = 0;
					q.add(new int[] {i,j});
					drawing++;
					mark[i][j] = true;
					while(!q.isEmpty()) {
						calc++;
						int[] temp = q.poll();
						for (int k = 0; k < dir.length; k++) {
        					int ni = temp[0] + dir[k][0];
							int nj = temp[1] + dir[k][1];
							if(ni>=0 && nj>=0 && ni<N && nj<M && board[ni][nj]==1 && !mark[ni][nj]) {
								mark[ni][nj]=true;
								q.add(new int[] {ni, nj});
							}
						}
					}
					if(max<calc)
						max = calc;
				}
			}
		}
		

		System.out.println(drawing);
		System.out.println(max);
		
	}

}
