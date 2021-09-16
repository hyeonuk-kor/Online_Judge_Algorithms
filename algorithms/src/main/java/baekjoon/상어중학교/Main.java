package baekjoon.상어중학교;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, board[][], getScore[], sy, sx;
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static int rainbow_count;
	static boolean visit[][];
	static final int BLANK = -9, RAINBOW = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		while(autoPlay()) {
			visit = new boolean[N][N];
			removeBlock(sy, sx, board[sy][sx]);
			sum += getScore[2]*getScore[2];
			gravity();
			rotate();
			gravity();
		}
		System.out.println(sum);
	}
	static boolean autoPlay() {
		visit = new boolean[N][N];
		getScore = findBlock();
		if(getScore[2]<2)
			return false;
		sy = getScore[0]; sx = getScore[1];
		return true;
	}
	static int[] findBlock() {
		int gy=0, gx=0, max_rainbow=0, max_size=0;
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if(board[y][x]>=1 && !visit[y][x]) {
					rainbow_count = 0;
					setRainbow();
					int size = groupBlock(y, x, board[y][x], 1);
					if(size>max_size) {
						max_rainbow = rainbow_count;
						gy = y; gx = x;	max_size = size;
					} else if(size==max_size) {
						if(max_rainbow<rainbow_count) {
							max_rainbow = rainbow_count;
							gy = y; gx = x;
						} else if(max_rainbow==rainbow_count) {
							if(gy<y) {
								gy = y;	gx = x;
							} else if(gy==y) {
								gx = Math.max(gx, x);
							}
						}
					}
				}
			}
		}
		return new int[] {gy, gx, max_size};
	}
	static void setRainbow() {
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(board[i][j]==RAINBOW && visit[i][j])
					visit[i][j] = false;
	}
	static int groupBlock(int y, int x, int color, int count) {
		visit[y][x] = true;
		if(board[y][x]==RAINBOW)
			rainbow_count++;
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(isMove(ny, nx) && !visit[ny][nx] && 
			  (board[ny][nx]==color || board[ny][nx]==RAINBOW))
				count = groupBlock(ny, nx, color, count+1);
		}
		return count;
	}
	static void removeBlock(int y, int x, int color) {
		visit[y][x] = true;
		board[y][x] = BLANK;
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(isMove(ny, nx) && !visit[ny][nx] && 
			  (board[ny][nx]==color || board[ny][nx]==RAINBOW)) {
				removeBlock(ny, nx, color);
			}
		}
	}
	static void gravity() {
		for(int i=0; i<N; i++) {
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			for(int j=0; j<N; j++) {
				if(board[j][i]==-1) {
					int sy = j;
					while(!q.isEmpty()) {
						int down = q.poll();
						board[--sy][i]=down;
					}
				} else if(board[j][i]!=BLANK) {
					q.addFirst(board[j][i]);
				} else {
					q.addLast(BLANK);
				}
			}
			int by = N;
			while(!q.isEmpty()) {
				int down = q.poll();
				board[--by][i]=down;
			}
		}
	}
	static void rotate() {
		int temp[][] = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				temp[i][j] = board[j][N-i-1];
		board = temp;
	}
	static boolean isMove(int ny, int nx) {
		return !(nx<0 || nx>=N || ny<0 || ny>=N);
	}
}