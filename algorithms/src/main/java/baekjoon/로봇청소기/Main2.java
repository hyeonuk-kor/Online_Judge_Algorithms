package baekjoon.로봇청소기;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P4991 {
		static class Test {
			int y, x, clean, board[][];
			public Test(int y, int x, int clean, int[][] board) {
				this.y = y;
				this.x = x;
				this.clean = clean;
				this.board = board;
			}
		}
		ArrayList<Test> tc;
		ArrayList<ArrayList<Integer>> order;
		int number[], select[], graph[][];
		boolean check[];
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		String solve() {
			input();
			for (Test test : tc) {
				preprocess(test); // 갈 수 있는 모든 경우의 수 만들기
				setGraph(test);
				int answer = simulate();
				if(answer == Integer.MAX_VALUE)
					answer = -1;
				sb.append(answer).append('\n');
			}
			return sb.toString();
		}
		int simulate() {
			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < order.size(); i++) {
				int sum = 0;
				for(int j=0; j < order.get(i).size()-1; j++) {
					int from = order.get(i).get(j);
					int to = order.get(i).get(j+1);
					if(graph[from][to]==-1) {
						sum = Integer.MAX_VALUE;
						break;
					}
					sum += graph[from][to];
				}
				answer = Math.min(answer, sum);
			}
			return answer;
		}
		void preprocess(Test t) {
			order = new ArrayList<>();
			int end = t.clean;
			number = new int[end];
			select = new int[end];
			check = new boolean[end];
			for(int i=1; i<end; i++) {
				number[i] = i;
			}
			select[1] = 1;
			check[1] = true;
			rec_func(2, end);
		}
		void rec_func(int depth, int end) {
			if(depth==end) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=1; i<end; i++)
					list.add(select[i]);
				order.add(list);
				return;
			} else {
				for(int i=2; i<end; i++) {
					if(!check[i]) {
						check[i] = true;
						select[depth] = i; 
						rec_func(depth+1, end);
						select[depth] = 0;
						check[i] = false;
					}
				}
			}
		}
		void setGraph(Test t) {
			graph = new int[t.clean][t.clean];
			for(int i=0; i<graph.length; i++)
				Arrays.fill(graph[i], -1); //초기 설정
			for(int i=0; i<t.y; i++) {
				for(int j=0; j<t.x; j++) {
					if(t.board[i][j]>=1 && t.board[i][j]<t.clean) {
						for(int k=1; k<t.clean; k++) {
							int from = t.board[i][j];
							int to = k;
							if(from==to) {
								graph[from][to] = 0;
							} else {
								graph[from][to] = bfs(t.board, i, j, t.board[i][j], k);
								graph[to][from] = graph[from][to];
							}
						}
					}
				}
			}
		}
		int bfs(int[][] board, int y, int x, int from, int to) {
			Queue<int[]> q = new ArrayDeque<>();
			int row_size = board.length;
			int col_size = board[0].length;
			boolean visit[][] = new boolean[row_size][col_size];
			int dir[][] = { {0,1},{0,-1},{1,0},{-1,0}};
			q.add(new int[] {y, x, 0});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int info[] = q.poll();
				int cy = info[0];
				int cx = info[1];
				int dis = info[2];
				if(board[cy][cx]==to) {
					return dis;
				} else {
					for(int d=0; d<4; d++) {
						int ny = cy + dir[d][0];
						int nx = cx + dir[d][1];
						if(nx<0 || ny<0 || nx>=col_size || ny>=row_size)
							continue;
						if(visit[ny][nx])
							continue;
						if(board[ny][nx]==-1)
							continue;
						q.add(new int[] {ny, nx, dis+1});
						visit[ny][nx] = true;
					}
				}
			}
			return -1;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			tc = new ArrayList<>();
			try {
				while(true) {
					st = new StringTokenizer(br.readLine(), " ");
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					if(x==0 && y==0) {
						break;
					} else {
						int board[][] = new int[y][x];
						int count = 2;
						for(int i=0; i<y; i++) {
							String input = br.readLine();
							for(int j=0; j<x; j++) {
								if(input.charAt(j)=='o') {
									board[i][j] = 1;
								} else if(input.charAt(j)=='*') {
									board[i][j] = count++;
								} else if(input.charAt(j)=='x') {
									board[i][j] = -1;
								} else {
									board[i][j] = 0;
								}
							}
						}
						tc.add(new Test(y, x, count, board));
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P4991().solve());
	}
}
