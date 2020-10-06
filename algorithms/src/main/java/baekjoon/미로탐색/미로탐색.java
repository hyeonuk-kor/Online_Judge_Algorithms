package baekjoon.미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j)-'0';
			}
		}
		
		boolean[][] check = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		check[0][0] = true;
		
		int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
		};
		
		int answer = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp[0]==N-1 && temp[1]==M-1) {
				answer = temp[2];
				break;
			}
			for (int i = 0; i < dir.length; i++) {
				int di = temp[0] + dir[i][0];
				int dj = temp[1] + dir[i][1];
				if(di>=0 && dj>=0 && di<N && dj<M && maze[di][dj]==1 && !check[di][dj]) {
					check[di][dj]=true;
					q.add(new int[] {di,dj,temp[2]+1});
				}
			}
		}
		System.out.println(answer);
	}

}
