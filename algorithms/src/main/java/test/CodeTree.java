package test;
import java.io.*;
import java.util.*;
public class CodeTree {
	static class Coin {
		int number, y, x;
		public Coin(int number, int y, int x) {
			this.number = number;
			this.y = y;
			this.x = x;
		}
		public int getNumber() {
			return number;
		}
	}
	static ArrayList<Coin> coin;
	static ArrayList<ArrayList<Integer>> order;
	static char board[][];
	static int N, answer = Integer.MAX_VALUE;
	static int sy, sx, ey, ex;
	static int number[], select[], graph[][];
	static int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0}};
	static boolean check[];
	public static void main(String[] args) {
		input(); // 입력받기
		init(); //갈 수 있는 모든 경우의 수 만들기
		setGraph(); // 그래프 계산완료
		simulation(); // init함수에서 나온 순서대로, 그래프에서 값을 꺼내 최소 정답 찾기
		if(answer==Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
		/*
		for(int i=0; i<graph.length; i++)
			System.out.println(Arrays.toString(graph[i]));
		*/
	}
	private static void simulation() {
		for(int i=0; i<order.size(); i++) {
			int sum = 0;
			for(int j=0; j<order.get(i).size()-1; j++) {
				int from = order.get(i).get(j);
				int to = order.get(i).get(j+1);
				if(graph[from][to]==Integer.MAX_VALUE) {
					sum = Integer.MAX_VALUE;
					break;
				} else {
					sum += graph[from][to];
				}
			}
			answer = Math.min(sum, answer);
		}
	}
	private static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			coin = new ArrayList<>();
			for(int i=0; i<N; i++) {
				board[i] = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					if(board[i][j]=='S') {
						sy = i; sx = j;
					} else if(board[i][j]=='E') {
						ey = i; ex = j;
					} else if(board[i][j]>='1' && board[i][j]<='9') {
						coin.add(new Coin(board[i][j]-'0', i, j));
					}
				}
			}
			coin.add(new Coin(0, sy, sx));
			coin.add(new Coin(10, ey, ex));
			coin.sort(Comparator.comparing(Coin::getNumber));
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void setGraph() {
		graph = new int[11][11];
		for(int i=0; i<10; i++) {
			for(int j=i+1; j<11; j++) {
				bfs(i, j);
			}
		}
	}
	private static void bfs(int from, int to) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<int[]>();
		int fy = 0, fx = 0, gy = 0, gx = 0;
		boolean f = false, g = false;
		for(int i=0; i<coin.size(); i++) {
			if(coin.get(i).number==from) {
				fy = coin.get(i).y;
				fx = coin.get(i).x;
				f = true;
			} else if(coin.get(i).number==to) {
				gy = coin.get(i).y;
				gx = coin.get(i).x;
				g = true;
			}
		}
		
		if(!f || !g) {
			graph[from][to]=Integer.MAX_VALUE;
			graph[to][from]=Integer.MAX_VALUE;
			return;
		}
		
		q.add(new int[] {fy, fx, 0});
		visit[fy][fx] = true;
		while(!q.isEmpty()) {
			int info[] = q.poll();
			int cy = info[0];
			int cx = info[1];
			int dis = info[2];
			if(gy == cy && gx == cx) {
				graph[from][to] = dis; 
				graph[to][from] = dis;
				return ;
			} else {
				for(int d=0; d<4; d++) {
					int ny = cy + dir[d][0];
					int nx = cx + dir[d][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N)
						continue;
					if(visit[ny][nx])
						continue;
					if(board[ny][nx]=='#')
						continue;
					q.add(new int[] {ny, nx, dis+1});
					visit[ny][nx] = true;
				}
			}
		}
		graph[from][to]=Integer.MAX_VALUE;
		graph[to][from]=Integer.MAX_VALUE;
	}
	private static void init() {
		number = new int[11];
		check = new boolean[11];
		for(int i=0; i<11; i++) {
			number[i] = i;
		}
		select = new int[coin.size()+1];
		order = new ArrayList<>();
		for(int i=5; i<=coin.size(); i++) {
			rec_func(1, i);
		}		
	}
	static void rec_func(int depth, int end) { //갈수 있는 모든 경우의 수
		if(depth==end+1) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1; i<=end; i++) {
				if(select[1]!=0 || select[end]!=10)
					return;
				list.add(select[i]);
			}
			//System.out.println(list.toString());
			order.add(list);
			return;
		}
		for(int i=select[depth-1]; i<11; i++) {
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