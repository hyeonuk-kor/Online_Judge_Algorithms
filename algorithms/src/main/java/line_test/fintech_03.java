package line_test;
import java.util.*;
public class fintech_03 {
	static class Solution {
		Solution() {
			int[][] array = {
					{5, 12},
					{5, 16},
					{6, 13}
			};
			for(int[] arr: array) {
				int n = arr[0];
				int k = arr[1];
				System.out.println(Arrays.toString(solution(n, k)));
			}
		}
		int[] dy = {0, 0, -1, 1};
		int[] dx = {1,-1, 0, 0};
		public int[] solution(int n, int k) {
			int board[][] = new int[n][n];
			board[0][0] = 1;
			int y=0, x=0;
			for(int i=2; i<=k; i++) {
				int[] info = getSeat(board, n);
				y = info[0];
				x = info[1];
				board[y][x] = i;
			}
			return new int[] {y+1, x+1};
		}
		int[] getSeat(int[][] board, int size) {
			boolean visit[][] = new boolean[size][size];
			int dist[][] = new int[size][size];
			Queue<int[]> q = new ArrayDeque<>();
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(board[i][j]!=0) {
						q.add(new int[] {i,j, 0});
						visit[i][j] = true;
					}
				}
			}
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int y = info[0];
				int x = info[1];
				int m = info[2];
				dist[y][x] = m;
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(nx<0 || ny<0 || nx>=size || ny>=size || visit[ny][nx])
						continue;
					q.add(new int[] {ny, nx, m+1});
					visit[ny][nx] = true;
				}
			}
			int max = 0;
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					max = Math.max(max, dist[i][j]);
				}
			}
			List<int[]> p = new ArrayList<>();
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(dist[i][j]==max)
						p.add(new int[]{i, j});
				}
			}
			Collections.sort(p, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(Integer.compare(o1[1], o2[1])==0) {
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});
			//System.out.println(Arrays.toString(p.get(0)));
			return p.get(0);
		}
	}
	public static void main(String[] args) {
		new Solution();
	}
}
