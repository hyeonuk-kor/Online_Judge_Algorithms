package swexperts.줄기세포배양;
import java.io.*;
import java.util.*;
public class Solution {
	static class Cell {
		int y, x, time, value;
		boolean active;
		Cell(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.value = 0;
		}
	}
	static int[][] board;
	static int dy[] = {0, 0, -1, 1};
	static int dx[] = {1, -1, 0, 0};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			board = new int[N+K][M+K];
			visit = new boolean[N+K][M+K];
			List<Cell> list = new ArrayList<>();
			for(int i=K/2; i<N+K/2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=K/2; j<M+K/2; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]!=0) {
						visit[i][j] = true;
						list.add(new Cell(i, j, board[i][j]));
					}
				}
			}
			int time = 0;
			while(time++<K) {
				for(Cell c: list) {
					if(c.active) { // 활성 상태가 됐다면? - 시간이 0초에는 모두 비활성상태이므로 패스한다.
						for(int d=0; d<4; d++) { // 4방향 탐색을 통해
							int ny = c.y + dy[d];
							int nx = c.x + dx[d];
							if(visit[ny][nx])
								continue;
							board[ny][nx] = Math.max(board[ny][nx], c.value); // 생명력 수치가 높은 줄기 세포가 그리드 셀을 차지한다
						}
					}
				}
				List<Cell> nextList = new ArrayList<>();
				int size = list.size();
				for(int i=0; i<size; i++) {
					Cell c = list.get(i);
					if(c.active) {	// 활성화 된 세포라면 4방향 탐색을 통해 
						for(int d=0; d<4; d++) {
							int ny = c.y + dy[d];
							int nx = c.x + dx[d];
							if(visit[ny][nx])
								continue;
							nextList.add(new Cell(ny, nx, board[ny][nx]));
							visit[ny][nx] = true;
						}
						c.value--;
					} else {	 
						c.value++;  
						if(c.value==c.time) 
							c.active = true; 
					}
					if(c.value!=0) 
						nextList.add(c); 
				}
				list = new ArrayList<>(nextList);
			}
			int answer = list.size();
			System.out.println("#"+tc+" "+answer);
		}
	}
}