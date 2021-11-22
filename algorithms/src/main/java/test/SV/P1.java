package test.SV;

import java.util.*;

public class P1 {
	static int[] solution(int rows, int columns, int[][] connections, int[][] queries) {
		List<Integer> list = new ArrayList<>();
		int[][] board = new int[rows][columns];
		int number = 1;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				board[i][j] = number++;
			}
		}
		int[][] graph = new int[number][number];
		for(int[] p: connections) {
			int y1 = p[0]-1;
			int x1 = p[1]-1;
			int y2 = p[2]-1;
			int x2 = p[3]-1;
			int to = board[y1][x1];
			int from = board[y2][x2]; 
			graph[to][from] = 1;
			graph[from][to] = 1;
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		for(int[] p: queries) {
			int count = 0;
			int min_y = Math.min(p[0], p[2])-1;
			int min_x = Math.min(p[1], p[3])-1;
			int max_y = Math.max(p[0], p[2])-1;
			int max_x = Math.max(p[1], p[3])-1;
			for(int y=min_y; y<=max_y; y++) {
				for(int x=min_x; x<=max_x; x++) {
					int to = board[y][x];
					for(int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(ny<0 || nx<0 || ny>=rows || nx>=columns)
							continue;
						if(ny>=min_y && ny<=max_y && nx>=min_x && nx<=max_x)
							continue;
						int from = board[ny][nx];
						if(graph[to][from] == 1) {
							graph[from][to] = graph[to][from] = 0;
							count++;
						}
					}
				}
			}
			list.add(count);
		}
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	public static void main(String[] args) {
		int rows = 4;
		int columns = 3;
		int[][] connections = {{1, 1, 2, 1}, {1, 2, 1, 3}, {1, 3, 2, 3}, {2, 2, 2, 3}, {2, 2, 3, 2}, {2, 3, 3, 3}, {3, 2, 3, 3}, {3, 2, 4, 2}, {4, 1, 4, 2}};
		int[][] queries = {{2, 2, 3, 1}, {1, 2, 4, 2}};
		System.out.println(Arrays.toString(solution(rows, columns, connections, queries)));
	}
}
