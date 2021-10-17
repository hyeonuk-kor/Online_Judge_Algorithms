package swexperts.벽돌깨기;
import java.io.*;
import java.util.*;
public class Solution {
	static int T, N, W, H, board[][], select[], answer = Integer.MAX_VALUE;
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static ArrayList<ArrayList<Integer>> order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			board = new int[H][W];
			answer = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			order = new ArrayList<>();
			select = new int[N+1];
			rec_func(1);
			for(List<Integer> s: order)
				answer = Math.min(answer, simulate(s));
			System.out.println("#"+tc+" "+answer);
		}
	}
	static int simulate(List<Integer> s) {
		int sum = 0;
		int temp[][] = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				temp[i][j] = board[i][j];
			}
		}
		for(int x: s) {
			int start = 0;
			for(int y=0; y<H; y++) {
				if(board[y][x]!=0) {
					start = y;
					break;
				}
			}
			int power = board[start][x];
			for(int d=0; d<4; d++)
				boom(start, x, d, power);
			gravity();
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(board[i][j]!=0)
					sum++;
			}
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				board[i][j] = temp[i][j];
			}
		}
		
		return sum;
	}
	private static void gravity() {
		int temp[][] = new int[H][W];
		for(int i=0; i<W; i++) {
			int start = H-1;
			for(int j=H-1; j>=0; j--) {
				if(board[j][i]!=0) {
					temp[start--][i] = board[j][i];
				}
			}
		}
		board = temp;
	}
	static void boom(int y, int x, int dir, int power) {
		board[y][x] = 0;
		for(int i=1; i<power; i++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if(ny<0 || nx<0 || ny>=H || nx>=W)
				break;
			y = ny;
			x = nx;
			int p = board[y][x];
			board[y][x] = 0;
			if(p>1) {
				for(int d=0; d<4; d++)
					boom(y, x, d, p);
			}
		}
	}
	static void rec_func(int K) {
		if(K==N+1) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1; i<K; i++)
				list.add(select[i]-1);
			order.add(list);
			return;
		} else {
			for(int i=1; i<=W; i++) {
				select[K] = i;
				rec_func(K+1);
				select[K] = 0;
			}
		}
	}

}
