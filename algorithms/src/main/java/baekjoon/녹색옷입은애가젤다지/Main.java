package baekjoon.녹색옷입은애가젤다지;
import java.io.*;
import java.util.*;
public class Main {
	static class P4485 {
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		ArrayList<Test> tc;
		int size, board[][], visit[][], answer;
		int dy[] = {0, 0, 1, -1};
		int dx[] = {1, -1, 0, 0};
		class Test {
			int N;
			int board[][];
			public Test(int n, int[][] board) {
				N = n;
				this.board = board;
			}
		}
		String solve() {
			input();
			for(int i=0; i<tc.size(); i++) {
				bfs(tc.get(i));
				sb.append("Problem "+(i+1)+": ").append(answer).append("\n");
			}
			return sb.toString();
		}
		void bfs(Test t) {
			Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});
			size = t.N;
			board = t.board;
			visit = new int[size][size];
			for(int i=0; i<size; i++)
				Arrays.fill(visit[i], Integer.MAX_VALUE);
			q.add(new int[] {0, 0, board[0][0]});
			visit[0][0] = board[0][0];
			while(!q.isEmpty()) {
				int info[] = q.poll();
				int y = info[0];
				int x = info[1];
				int pay = info[2];
				if(y==size-1 && x==size-1) {
					break;
				} else {
					for(int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(ny<0 || nx<0 || ny>=size || nx>=size)
							continue;
						if(visit[ny][nx] <= board[ny][nx]+pay)
							continue;
						q.add(new int[] {ny, nx, board[ny][nx]+pay});
						visit[ny][nx] = board[ny][nx]+pay;
					}
				}
			}
			answer = visit[size-1][size-1];
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				tc = new ArrayList<>();
				while(true) {
					int n = Integer.parseInt(br.readLine());
					if(n==0) {
						break;
					} else {
						int board[][] = new int[n][n];
						for(int i=0; i<n; i++) {
							st = new StringTokenizer(br.readLine());
							for(int j=0; j<n; j++) {
								board[i][j] = Integer.parseInt(st.nextToken());
							}
						}
						Test t = new Test(n, board);
						tc.add(t);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P4485().solve());
	}
}