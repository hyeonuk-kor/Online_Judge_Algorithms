package baekjoon.새로운게임2;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P17837 {
		BufferedReader br;
		StringTokenizer st;
		class Board {
			int color;
			LinkedList<Integer> list;
			Board(int color, LinkedList<Integer> list) {
				this.color = color;
				this.list = list;
			}
		}
		class Horse {
			int y, x, dir;
			Horse(int y, int x, int dir) {
				this.y = y;
				this.x = x;
				this.dir = dir;
			}
		}
		int N, K, map[][], answer;
		int dy[] = {0, 0,-1, 1};
		int dx[] = {1,-1, 0, 0};
		Board board[][];
		ArrayDeque<Integer> horse;
		Horse h[];
		void solve() {
			input();
			pro();
			System.out.println(answer);
		}
		void pro() {
			horse = new ArrayDeque<>();
			int turn = 1;
			while(turn<=1000) {
				for(int k=0; k<K; k++) {
					int y = h[k].y, x = h[k].x, d = h[k].dir;
					int size = board[y][x].list.size();	// 현재 말이 위치한 (y, x)의 말의 총 개수
					int index = getIndex(y, x, k, size); // 몇 번째에 올려져 있는지?
					holdUp(index, y, x, size);		// k번 말 위에 있는 것들을 동시에 옮겨야 함
					currentRemove(index, y, x, size);   // 옮기기 전, 현재 격자에서 제외시킴
					int ny = y + dy[d];					// 이동할 위치 y 찾기
					int nx = x + dx[d];					// 이동할 위치 x 찾기
					if(putAfterSize(ny, nx, d, k)) {		// 옮겼을 때 사이즈가 4 이상이라면 종료
						answer = turn;
						return;
					}
				}
				turn++;
			}
			answer = -1;
		}
		boolean isRange(int y, int x) {
			return y<0 || x<0 || y>=N || x>=N;
		}
		boolean putAfterSize(int y, int x, int d, int k) {
			int color = isRange(y, x) ? 2 : board[y][x].color;
			if(color==2) {
				// 좌표 & 방향 재 조정
				d = (d<2) ? 1-d : 5-d;
				y += dy[d]*2;
				x += dx[d]*2;
				color = isRange(y, x) ? 2 : board[y][x].color;
				if(color==2) { // 그래도 파란색이면 원래 좌표로 되돌림
					y -= dy[d];
					x -= dx[d];
					put(y, x, 0);	// board[y][x].color를 하면 안된다. 가만히 둬야하므로 0으로 처리 
				} else {
					put(y, x, color);
				}
			} else {
				put(y, x, color);
			}
			int size = board[y][x].list.size();
			for(int i=0; i<board[y][x].list.size(); i++) {
				int number = board[y][x].list.get(i);
				Horse tmp = h[number];
				if(number==k) {
					h[number] = new Horse(y, x, d);
				} else {
					h[number] = new Horse(y, x, tmp.dir);
				}
			}
			return size>=4;
		}
		void put(int y, int x, int color) {
			while(!horse.isEmpty()) {
				if(color==1) {
					board[y][x].list.add(horse.pollLast());
				} else {
					board[y][x].list.add(horse.pollFirst());
				}
			}
		}
		void currentRemove(int index, int y, int x, int size) {
			for(int i=index; i<size; i++) {
				board[y][x].list.remove(index);
			}
		}
		void holdUp(int index, int y, int x, int size) {
			for(int i=index; i<size; i++) {
				horse.add(board[y][x].list.get(i));
			}
		}
		int getIndex(int y, int x, int k, int size) {
			int index = 0;
			for(int i=0; i<size; i++) {
				if(board[y][x].list.get(i)==k) {
					index = i;
					break;
				}
			}
			return index;
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				board = new Board[N][N];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<N; j++) {
						int color = Integer.parseInt(st.nextToken());
						board[i][j] = new Board(color, new LinkedList<>());
					}
				}
				h = new Horse[K];
				for(int i=0; i<K; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken())-1;
					int x = Integer.parseInt(st.nextToken())-1;
					int dir = Integer.parseInt(st.nextToken())-1;
					board[y][x].list.add(i);
					h[i] = new Horse(y, x, dir);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P17837().solve();
	}
}
