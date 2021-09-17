package baekjoon.마법사상어와블리자드;
import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static List<Point> order = new ArrayList<>();
	static int N, M, board[][], answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		initialize(0,0,0,N*N-1);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int c=0; c<M; c++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			blizzard(N/2, N/2, d, s);
			boolean check = true;
			while(check) {
				movement();
				check = explosion();
			}
			changeBeads();
		}
		System.out.println(answer);
	}
	static void changeBeads() {
		Queue<Integer> q = new ArrayDeque<>();
		int index = order.size()-1;
		while(index-1>=0) {
			Point p = order.get(index);
			Point np = order.get(index-1);
			if(board[p.y][p.x]==0)
				break;
			int count = 1;
			if(board[p.y][p.x]==board[np.y][np.x]) {
				int next = index-1;
				while(next-1>=0 && board[p.y][p.x]==board[np.y][np.x]) {
					p = order.get(next);
					np = order.get(--next);
					count++;
				}
				index = next;
			} else {
				index--;
			}
			q.add(count);
			q.add(board[p.y][p.x]);
		}
		index = order.size()-1;
		while(index>=0 && !q.isEmpty()) {
			Point p = order.get(index--);
			board[p.y][p.x] = q.poll(); 
		}
	}
	static boolean explosion() {
		boolean check = false;
		for(int i=order.size()-1; i>=1; i--) {
			Point p = order.get(i);
			Point np = order.get(i-1);
			if(board[p.y][p.x]!=0 && board[p.y][p.x]==board[np.y][np.x]) {
				int count=1;
				int next = i-1;
				while(next-1>=0 && board[p.y][p.x]==board[np.y][np.x]) {
					p = order.get(next);
					np = order.get(--next);
					count++;
				}
				if(count>=4) {
					answer += (board[p.y][p.x]*count);
					check = true;
					for(int j=i; j>next; j--) {
						Point r = order.get(j); 
						board[r.y][r.x]= 0; 
					}
				}
			}
		}
		return check;
	}
	private static void print() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	static void movement() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(Point p: order) {
			if(board[p.y][p.x]==0)
				deque.addFirst(board[p.y][p.x]);
			else
				deque.addLast(board[p.y][p.x]);
		}
		for(Point p: order)
			board[p.y][p.x] = deque.poll();
	}
	static void blizzard(int y, int x, int d, int s) {
		int dy[] = {0, -1, 1, 0, 0};
		int dx[] = {0, 0, 0, -1, 1};
		for(int i=0; i<s; i++) {
			y+=dy[d];
			x+=dx[d];
			board[y][x] = 0;
		}
	}
	static void initialize(int y, int x, int d, int number) {
		int dy[] = {0,1,0,-1};
		int dx[] = {1,0,-1,0};
		if(y==N/2 && x==N/2)
			return;
		board[y][x] = number;
		order.add(new Point(y, x));
		int ny = y + dy[d];
		int nx = x + dx[d];
		if(ny<0 || nx<0 || ny>=N || nx>=N || board[ny][nx]>0) {
			d = (d==3)?0:d+1;
			ny = y + dy[d];
			nx = x + dx[d];
		}
		initialize(ny, nx, d, number-1);
	}
}