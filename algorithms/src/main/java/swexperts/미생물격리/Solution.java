package swexperts.미생물격리;
import java.io.*;
import java.util.*;
public class Solution {
	static class Org {
		int number, y, x, count, dir;
		public Org(int number, int y, int x, int count, int dir) {
			this.number = number;
			this.y = y;
			this.x = x;
			this.count = count;
			this.dir = dir;
		}
	}
	// 격자 길이 : N <=100 , 미생물 수 K<=1000, 격리 시간 M<=1000, 
	// board 내의 값 <=10000
	static int N, M, K, answer;
	// 1 상 2 하 3 좌 4 우
	static int dy[] = {0,-1, 1, 0, 0};
	static int dx[] = {0, 0, 0,-1, 1};
	static int board[][];
	static ArrayList<Org> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			list = new ArrayList<>();
			list.add(new Org(0,0,0,0,0));
			for(int number=1; number<=K; number++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				board[y][x] = number;
				list.add(new Org(number, y, x, count, dir));
			}
			simulate();
			System.out.println("#"+tc+" "+answer);
		} // end of for tc
	} // end of main
	static void simulate() {
		while(M>0) {
			int[][] board2 = new int[N][N];
			int[][] temp = new int[N][N];
			for(Org o: list) {
				if(o.number==0)
					continue;
				int ny = o.y + dy[o.dir];
				int nx = o.x + dx[o.dir];
				if(ny<1 || nx<1 || ny>=N-1 || nx>=N-1) {
					o.dir = getDir(o.dir);
					board2[ny][nx] = o.number;
					temp[ny][nx] = o.count/2;
				} else {
					if(board2[ny][nx]==0) {
						board2[ny][nx] = o.number;
						temp[ny][nx] += o.count;
					} else {
						for(Org on: list) {
							if(on.number==0)
								continue;
							if(board2[ny][nx] == on.number) {
								if(on.count < o.count) {
									board2[ny][nx] = o.number;
									temp[ny][nx] += o.count;
									on.number = 0;
									on.count = 0;
								} else {
									temp[ny][nx] += o.count;
									o.number = 0;
									o.count = 0;
								}
								break;
							}
						}
					}
				}
				o.y = ny;
				o.x = nx;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j]!=0) {
						for(Org o: list) {
							if(board2[i][j]==o.number) {
								o.count = temp[i][j];
								break;
							}
						}
					}
				}
			}
			for(int i=0; i<N; i++)
				board[i] = board2[i].clone();
			M--;
		}
		for(Org o : list) {
			if(o.number!=0)
				answer += o.count;
		}
	} // end of simulate
	static int getDir(int dir) {
		if(dir==1)
			return 2;
		if(dir==2)
			return 1;
		if(dir==3)
			return 4;
		return 3;
	}
} // end of class
