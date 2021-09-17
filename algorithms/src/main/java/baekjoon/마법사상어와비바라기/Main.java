package baekjoon.마법사상어와비바라기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, board[][];
	static class Cloud {
		int y;
		int x;
		public Cloud(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static ArrayList<Cloud> cloud_information;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		initialize();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			visit = new boolean[N][N];
			cloudsMoving(d, s);
			raining();
			cloudGeneration();
		}
		System.out.println(getSum());
	}
	static int getSum() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sum+=board[i][j];
		}
		return sum;
	}
	static void initialize() {
		board = new int[N][N];
		cloud_information = new ArrayList<>();
		cloud_information.add(new Cloud(N-1, 0));
		cloud_information.add(new Cloud(N-1, 1));
		cloud_information.add(new Cloud(N-2, 0));
		cloud_information.add(new Cloud(N-2, 1));		
	}
	static void cloudGeneration() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && board[i][j]>=2) {
					cloud_information.add(new Cloud(i, j));
					board[i][j]-=2;
				}
			}
		}
	}
	static void raining() {
		int dy[] = {-1, -1, 1, 1};
		int dx[] = {-1, 1, -1, 1};
		for(Cloud c: cloud_information)
			board[c.y][c.x]++;
		for(Cloud c: cloud_information) {
			int water = 0;
			for(int d=0; d<4; d++) {
				int ny = c.y + dy[d];
				int nx = c.x + dx[d];
				if(ny>=0 && nx>=0 && ny<N && nx<N)
					if(board[ny][nx]>0)
						water++;
			}
			board[c.y][c.x] += water;
		}
		cloud_information.clear();
	}
	static void cloudsMoving(int d, int s) {
		int dy[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
		int dx[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
		for(Cloud c: cloud_information) {
			for(int m=0; m<s; m++) {
				c.y += dy[d];
				c.x += dx[d];
				c.y = rangeCheck(c.y);
				c.x = rangeCheck(c.x);
			}
			visit[c.y][c.x] = true;
		}
	}
	static int rangeCheck(int idx) {
		if(idx<0)
			return N-1;
		if(idx>=N)
			return 0;
		return idx;
	}
}