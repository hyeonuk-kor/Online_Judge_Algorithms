package baekjoon.로봇시뮬레이션;
import java.io.*;
import java.util.*;
public class Main {
	static class P2174 {
		class Robot {
			int x, y, dir;
			public Robot(int x, int y, int dir) {
				this.x = x;
				this.y = y;
				this.dir = dir;
			}
		}
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int A, B, N, M, board[][];
		int dy[] = {1, 0, -1, 0};
		int dx[] = {0, 1, 0, -1};
		Robot[] r;
		ArrayList<int[]> cmd = new ArrayList<>();
		void solve() {
			input();
			for(int[] c: cmd) {
				int number = c[0];
				int dir = c[1];
				int loop = c[2];
				for(int i=0; i<loop; i++) {
					Robot robot = r[number];
					if(dir==1) {
						r[number].dir++;
						if(r[number].dir==4)
							r[number].dir = 0;
					} else if(dir==-1) {
						r[number].dir--;
						if(r[number].dir==-1)
							r[number].dir = 3;
						
					} else {
						int ny = robot.y + dy[robot.dir];
						int nx = robot.x + dx[robot.dir];
						if(ny<1 || nx<1 || ny>=B+1 || nx>=A+1) {
							System.out.println("Robot "+number+" crashes into the wall");
							return;
						}
						if(board[ny][nx]!=0) {
							System.out.println("Robot "+number+" crashes into robot "+board[ny][nx]);
							return;
						}
						board[robot.y][robot.x] = 0;
						board[ny][nx] = number;
						r[number] = new Robot(nx, ny, r[number].dir);
					}
					print();
				}
			}
			System.out.println("OK");
		}
		private void print() {
			for(int i=0; i<board.length; i++)
				System.out.println(Arrays.toString(board[i]));
			System.out.println();
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				board = new int[B+1][A+1];
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				r = new Robot[N+1];
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int d = 0;
					board[y][x] = i;
					String dir = st.nextToken();
					if(dir.equals("N")) {
						d=0;
					} else if(dir.equals("E")) {
						d=1;
					} else if(dir.equals("S")) {
						d=2;
					} else if(dir.equals("W")) {
						d=3;
					}
					r[i] = new Robot(x, y, d);
				}
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine());
					int number = Integer.parseInt(st.nextToken());
					String input = st.nextToken();
					int dir = 0;
					if(input.equals("L"))
						dir = -1;
					else if(input.equals("R"))
						dir = 1;
					int distance = Integer.parseInt(st.nextToken());
					cmd.add(new int[] {number, dir, distance});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2174().solve();
	}
}
