package baekjoon.새로운게임2;
import java.io.*;
import java.util.*;
// 11:02 start
public class Main2 {
	static class P17837 {
		BufferedReader br;
		StringTokenizer st;
		class Horse {
			int number;
			int y;
			int x;
			int d;
			Horse(int number, int y, int x, int d) {
				this.number = number;
				this.y = y;
				this.x = x;
				this.d = d;
			}
			@Override
			public String toString() {
				return "Horse [number=" + number + ", y=" + y + ", x=" + x + ", d=" + d + "]";
			}
		}
		class Board {
			int color;
			LinkedList<Horse> list;
			Board(int color, LinkedList<Horse> list) {
				this.color = color;
				this.list = list;
			}
			int findIndex(int number) {
				int index = 0;
				while(index<list.size()) {
					if(list.get(index).number==number) {
						break;
					}
					index++;
				}
				return index;
			}
		}
		Board board[][];
		ArrayList<Horse> horse;
		int N, K;
		int dy[] = {0, 0,-1, 1};
		int dx[] = {1,-1, 0, 0};
		void solve() {
			input();
			int answer = pro();
			System.out.println(answer);
		}
		int pro() {
			int turn = 0;
			Queue<Horse> q = new ArrayDeque<>();
			while(turn++<1000) {
				for(int i=0; i<horse.size(); i++) {
					int number = horse.get(i).number;
					int y = horse.get(i).y;
					int x = horse.get(i).x;
					int d = horse.get(i).d;
					int ny = y + dy[d];
					int nx = x + dx[d];
					int index = 0;
					switch (board[ny][nx].color) {
					case 0:
						index = board[y][x].findIndex(number);
						for(int j=0; j<=index; j++) {
							q.add(board[y][x].list.get(j));
						}
						while(!q.isEmpty()) {
							Horse h = q.poll();
							h.y = ny;
							h.x = nx;
							horse.set(h.number-1, h);
							board[ny][nx].list.addFirst(h);
						}
						for(int j=0; j<=index; j++) {
							board[y][x].list.remove(0);
						}
						break;
					case 1:
						index = board[y][x].findIndex(number);
						for(int j=0; j<=index; j++) {
							q.add(board[y][x].list.get(j));
						}
						while(!q.isEmpty()) {
							Horse h = q.poll();
							h.y = ny;
							h.x = nx;
							horse.set(h.number-1, h);
							board[ny][nx].list.addFirst(h);
						}
						for(int j=0; j<=index; j++) {
							board[y][x].list.remove(0);
						}
						break;
					case 2:
						if(d<2) {
							d = 1 - d;
						} else {
							d = 5 - d;
						}
						ny = y + dy[d];
						nx = x + dx[d];
						if(board[ny][nx].color==2) {
							ny = y;
							nx = x;
						}
						horse.set(number-1, new Horse(number, ny, nx, d));
						break;
					}
					if(board[ny][nx].list.size()>=4)
						return turn;
				}
			}
			return -1;
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new Board[N+2][N+2];
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						board[i][j] = new Board(2, new LinkedList<>());
					}
				}
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=1; j<=N; j++) {
						board[i][j].color = Integer.parseInt(st.nextToken());
					}
				}
				horse = new ArrayList<>();
				for(int i=1; i<=K; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken());
					int x = Integer.parseInt(st.nextToken());
					int d = Integer.parseInt(st.nextToken())-1;
					Horse h = new Horse(i, y, x, d);
					board[y][x].list.add(h);
					horse.add(h);
				}
				print();
				br.close();
				// print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void print() {
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					System.out.print(board[i][j].color+" ");
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		new P17837().solve();
	}

}
