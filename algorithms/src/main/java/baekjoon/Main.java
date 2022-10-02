package baekjoon;
import java.io.*;
import java.util.*;
public class Main {
	static class 오후1번 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K, answer;
		int trail[][];
		boolean isChange, visit[][];
		int dy[] = {0, -1, 0, 1};
		int dx[] = {1, 0, -1, 0};
		int[][] present;
		int tx, ty;
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				trail = new int[N][N];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<N; j++) {
						trail[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		오후1번() {
			input();
			answer = 0;
			present = getPre();
			for(int t=0; t<K; t++) {
				isChange = false;
				step1(); // 기차가 한 칸 움직인다.
				step2(t%(4*N)); // 선물이 분배된다.
				print(trail);
				if(isChange) {
					step3(); // 선물을 받은 기차의 머리와 꼬리가 바뀐다.
				}
				print(trail);
				System.out.println(answer);
			}
			System.out.println(answer);
		}
		void step3() {
			int[][] nextTrail = new int[N][N];
			for(int i=0; i<N; i++) {
				nextTrail[i] = trail[i].clone();
			}
			visit = new boolean[N][N];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {ty, tx});
			visit[ty][tx] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int sy = info[0];
				int sx = info[1];
				if(trail[sy][sx]==3) {
					nextTrail[sy][sx] = 1;
					nextTrail[ty][tx] = 3;
					trail = nextTrail;
					return;
				}
				for(int d=0; d<4; d++) {
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(isNotRange(ny, nx)) continue;
					if(visit[ny][nx]) continue;
					if(trail[ny][nx]<1 || trail[ny][nx]>3) continue;
					q.add(new int[] {ny, nx});
					visit[ny][nx] = true;
				}
			}
		}
		void step2(int time) {
			int dir = time/N;
			int sy = present[time][0];
			int sx = present[time][1];
			visit = new boolean[N][N];
			while(true) {
				if(isNotRange(sy, sx)) break;
				if(trail[sy][sx]>=1 && trail[sy][sx]<=3) {
					int number = getNumber(sy, sx);
					answer += (number*number);
					isChange = true;
					break;
				}
				sy += dy[dir];
				sx += dx[dir];
			}
		}
		int getNumber(int y, int x) {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x, 1});
			visit[y][x] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int sy = info[0];
				int sx = info[1];
				int number = info[2];
				if(trail[sy][sx]==1) {
					ty = sy;
					tx = sx;
					return number;
				}
				for(int d=0; d<4; d++) {
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(isNotRange(ny, nx)) continue;
					if(visit[ny][nx]) continue;
					if(trail[ny][nx]<1 || trail[ny][nx]>3) continue;
					q.add(new int[] {ny, nx, number+1});
					visit[ny][nx] = true;
				}
			}
			return 0;
		}
		int[][] getPre() {
			int[][] temp = new int[4*N][2];
			int idx = 0;
			for(int i=0; i<N; i++) {
				temp[idx++] = new int[] {i, 0};
			}
			for(int i=0; i<N; i++) {
				temp[idx++] = new int[] {N-1, i};
			}
			for(int i=N-1; i>=0; i--) {
				temp[idx++] = new int[] {i, N-1};
			}
			for(int i=N-1; i>=0; i--) {
				temp[idx++] = new int[] {0, i};
			}
			return temp;
		}
		private void print(int[][] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println();
		}
		void step1() {
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && trail[i][j]==3) {
						move(i, j);
					}
				}
			}
		}
		void move(int y, int x) {
			int[][] nextTrail = new int[N][N];
			for(int i=0; i<N; i++) {
				nextTrail[i] = trail[i].clone();
			}
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {y, x});
			visit[y][x] = true;
			nextTrail[y][x] = 4;
			boolean first2 = false;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int sy = info[0];
				int sx = info[1];
				if(trail[sy][sx]==1) {
					for(int d=0; d<4; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];
						if(isNotRange(ny, nx)) continue;
						if(trail[ny][nx]==4) {
							nextTrail[ny][nx] = 1;
							nextTrail[sy][sx] = 2;
							trail = nextTrail;
							return;
						}
					}
				}
				for(int d=0; d<4; d++) {
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if(isNotRange(ny, nx)) continue;
					if(visit[ny][nx]) continue;
					if(trail[ny][nx]<1) continue;
					if(trail[ny][nx]==2 && !first2) {
						first2 = true;
						nextTrail[ny][nx] = 3;
					}
					q.add(new int[] {ny, nx});
					visit[ny][nx] = true;
				}
			}
		}
		boolean isNotRange(int y, int x) {
			return y<0 || x<0 || y>=N || x>=N;
		}
	}
	public static void main(String[] args) {
		new 오후1번();
	}
}