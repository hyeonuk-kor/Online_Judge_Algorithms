package baekjoon.새로운게임2;
import java.util.*;
import java.io.*;
class Board {
	int color;
	LinkedList<Integer> list;
	public Board(int color, LinkedList<Integer> list) {
		this.color = color;
		this.list = list;
	}
}
class Horse {
	int y, x, dir;
	public Horse(int y, int x, int dir) {
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}
public class Main {
	static int N, K, map[][];
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static Board board[][];
	static ArrayDeque<Integer> horse;
	static Horse h[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new Board[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				board[i][j] = new Board(Integer.parseInt(st.nextToken()), new LinkedList<>());
			}
		}
		h = new Horse[K];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			board[y][x].list.add(i);
			h[i] = new Horse(y,x,dir);
		}
		System.out.println(simulate());
	}
	static int simulate() {
		horse = new ArrayDeque<Integer>();
		int turn = 1;
		while(turn<=1000) {
			for(int i=0; i<K; i++) {
				int index = -1;
				int size = board[h[i].y][h[i].x].list.size();
				for(int j=0; j<size; j++) {
					if(board[h[i].y][h[i].x].list.get(j)==i) {
						index = j;
						break;
					}
				}
				for(int j=index; j<size; j++) 
					horse.add(board[h[i].y][h[i].x].list.get(j));
				for(int j=index;j<size;j++)
					board[h[i].y][h[i].x].list.remove(index);
				int ny = h[i].y + dir[h[i].dir][0];
				int nx = h[i].x + dir[h[i].dir][1];
				int nd = h[i].dir;
				int cDir[] = {1,0,3,2};
				if(ny<0 || nx<0 || ny>=N || nx>=N || board[ny][nx].color==2) {
					nd = cDir[nd];
					ny = ny + dir[nd][0]*2;
					nx = nx + dir[nd][1]*2;
				} 
				
				if(ny<0 || nx<0 || ny>=N || nx>=N || board[ny][nx].color==2) {
					ny = ny - dir[nd][0];
					nx = nx - dir[nd][1];
					while(!horse.isEmpty()) 
						board[ny][nx].list.add(horse.poll());
				} else if(board[ny][nx].color==0) {
					while(!horse.isEmpty()) 
						board[ny][nx].list.add(horse.poll());
				} else {
					while(!horse.isEmpty()) 
						board[ny][nx].list.add(horse.pollLast());
				}
				if(board[ny][nx].list.size()>=4) {
					return turn;
				} else {
					for(int j=0; j<board[ny][nx].list.size(); j++) {
						int number = board[ny][nx].list.get(j);
						Horse temp = h[number];
						if(number==i) h[number] = new Horse(ny, nx, nd);
						else h[number] = new Horse(ny, nx, temp.dir);
					}
				}
			}
			turn++;
		}
		return -1;
	}
}