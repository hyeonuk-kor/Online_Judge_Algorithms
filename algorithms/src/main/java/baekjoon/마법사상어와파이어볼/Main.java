package baekjoon.마법사상어와파이어볼;
import java.io.*;
import java.util.*;
public class Main {
	static final int LIST = 0, MASS = 1;
	static int N, M, K;
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int board[][][];
	static List<Queue<Integer>> speed, direction;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		initialize();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int m = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int index = board[LIST][y][x];
				board[MASS][y][x] = m;
				speed.get(index).add(s);
				direction.get(index).add(d);
			}
		}
		for(int i=0; i<K; i++)
			simulation();
	}
	static void simulation() {
		fireballMovement();
		fireballWorking();
		print();
	}
	private static void print() {
		for(int i=0; i<N; i++)
			System.out.println(Arrays.toString(board[MASS][i]));
	}
	static void fireballMovement() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int y=0; y<N; y++)
			for(int x=0; x<N; x++)
				if(board[MASS][y][x]!=0)
					q.add(new int[] {y, x});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int y = point[0];
			int x = point[1];
			if(board[MASS][y][x]!=0) {
				int index = board[LIST][y][x];
				while(!speed.isEmpty() && !direction.isEmpty()) {
					int s = speed.get(index).poll();
					int d = direction.get(index).poll();
					int ny = y, nx = x;
					for(int i=0; i<s; i++) {
						ny = range(ny+dy[d]);
						nx = range(nx+dx[d]);
					}
					board[MASS][ny][nx] += board[MASS][y][x];
					board[MASS][y][x] = 0;
					int next_index = board[LIST][ny][nx];
					speed.get(next_index).add(s);
					direction.get(next_index).add(d);
				}
			}
		}
	}
	static void fireballWorking() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int y=0; y<N; y++)
			for(int x=0; x<N; x++)
				if(board[MASS][y][x]!=0)
					q.add(new int[] {y, x});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int y = point[0];
			int x = point[1];
			if(board[MASS][y][x]!=0) {
				int index = board[LIST][y][x];
				int m = board[MASS][y][x]/5;
				int sum = 0;
				for(int i: speed.get(index))
					sum += i;
				int s = sum/speed.get(index).size();
				int dir = getDir(direction.get(index));
			}
		}
	}
	private static int getDir(Queue<Integer> q) {
		int[] dir = new int[q.size()];
		int index = 0;
		while(!q.isEmpty()) {
			dir[index++] = q.poll()%2;
		}
		int sum = 0;
		for(int i=0; i<dir.length; i++)
			sum += dir[i];
		if(sum==0 || sum==q.size())
			return 0;
		return 1;
	}
	static int range(int point) {
		if(point==-1)
			return N-1;
		else if(point==N)
			return 0;
		return point;
	}
	static void initialize() {
		board = new int[2][N][N];
		speed = new ArrayList<>();
		direction = new ArrayList<>();
		int index = 0;
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				board[LIST][i][j] = index++;
		for(int i=0; i<index; i++) {
			speed.add(new ArrayDeque<>());
			direction.add(new ArrayDeque<>());
		}
	}
}
