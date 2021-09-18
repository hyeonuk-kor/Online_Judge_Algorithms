package baekjoon.어른상어;
import java.io.*;
import java.util.*;
public class Main {
	static class Shark {
		int number, y, x, dir;
		boolean exist;
		List<ArrayList<Integer>> order;
		public Shark(int number, int y, int x, int dir, boolean exist, List<ArrayList<Integer>> order) {
			this.number = number;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.exist = exist;
			this.order = order;
		}
		public int getNumber() {
			return number;
		}
		@Override
		public String toString() {
			return "Shark [number=" + number + ", y=" + y + ", x=" + x + ", dir=" + dir + ",\n order=" + order + "]\n";
		}
	}
	static final int SMELL=0, TIMETABLE=1;
	static int N, M, K, board[][][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static List<Shark> shark = new ArrayList<>(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[2][N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[SMELL][i][j] = Integer.parseInt(st.nextToken());
				if(board[SMELL][i][j]!=0) {
					board[TIMETABLE][i][j]=K;
					shark.add(new Shark(board[SMELL][i][j], i, j, 0, true, new ArrayList<>()));
				}
			}
		}
		Collections.sort(shark, Comparator.comparing(Shark::getNumber));
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++)
			shark.get(i).dir = Integer.parseInt(st.nextToken())-1;
		for(int i=0; i<M; i++) {
			for(int j=0; j<4; j++) {
				ArrayList<Integer> dir = new ArrayList<>();
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<4; k++)
					dir.add(Integer.parseInt(st.nextToken())-1);
				shark.get(i).order.add(dir);
			}
		}
		System.out.println(simulation());
	}
	static int simulation() {
		int time = 0;
		while(time++>1000) {
			sharkMove();
			smell();
			return time;
		}
		return -1;
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(board[SMELL][i]));
		}
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(board[TIMETABLE][i]));
		}
		System.out.println();
	}

}
