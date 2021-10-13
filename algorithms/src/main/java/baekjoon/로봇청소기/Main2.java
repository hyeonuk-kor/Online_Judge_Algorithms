package baekjoon.로봇청소기;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P4991 {
		static class Test {	// 각 테스트케이스
			int y, x, clean, board[][];
			public Test(int y, int x, int clean, int[][] board) {
				this.y = y;	// y축 크기
				this.x = x; // x축 크기
				this.clean = clean; // 먼지의 수
				this.board = board; // 격자
			}
		}
		ArrayList<Test> tc; // 테스트케이스가 담긴 리스트
		ArrayList<ArrayList<Integer>> order; // t.board 격자에서 이동가능한 모든 경우의 수
		int number[], select[]; // number배열에 시작점+먼지수만큼 초기화 한 뒤, select에서 모든 경우를 구하고 order에 추가
		boolean check[]; // number와 select 계산 과정에서의 중복확인용 배열
		int graph[][]; // bfs를 활용하여 시작점과 먼지의 최단 경로를 구함
		
		StringBuilder sb = new StringBuilder(); 
		BufferedReader br;
		StringTokenizer st;
		String solve() { 
			input(); // 모든 테스트케이스를 입력받는 함수
			for (Test test : tc) { // 각 테스트 케이스 별로 정답 계산
				preprocess(test); // 갈 수 있는 모든 경우의 수 만들기 order 리스트가 완성되는 함수
				setGraph(test); // 현재 테스트 케이스의 최단 경로 계산 graph[][] 배열이 완성되는 함수
				int answer = simulate(); // order리스트와 graph를 통해 최소를 찾는다.
				if(answer == Integer.MAX_VALUE) // 최소가 갱신되지 않는다면 -1 출력
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
			select[1] = 1; // 먼지에서 시작할 수 없으므로 1은 고정해둔다.
			check[1] = true;
			rec_func(2, end);
		}
		void rec_func(int depth, int end) { // n과 m 문제
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
		void setGraph(Test t) { // 그래프를 2차원 배열로 만들고 bfs 함수 호출
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
		int bfs(int[][] board, int y, int x, int from, int to) { // from과 to를 이용해 목적지에 다다르면 즉시 리턴한다. 실패의 경우 -1
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
		void input() { // 모든 테스트케이스를 입력받는 곳
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
						int board[][] = new int[y][x]; // 문자 -> 정수로 변환하여 탐색
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
		System.out.println(new P4991().solve()); // 출력
	}
}