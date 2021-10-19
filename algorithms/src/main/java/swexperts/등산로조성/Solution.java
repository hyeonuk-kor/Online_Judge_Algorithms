package swexperts.등산로조성;
import java.io.*;
import java.util.*;
public class Solution {
	static int N; // 한 변의 길이
	static int K; // 최대 공사 가능 깊이 
	static int board[][] = new int[8][8];
	static int highest, answer;
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static boolean visit[][] = new boolean[8][8];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			highest = 0;
			answer = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					highest = Math.max(board[i][j], highest);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j]==highest) {
						dfs(i, j, 1, false);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		} // end of for testcase
	} // end of main
	static void dfs(int y, int x, int len, boolean work) {
		visit[y][x] = true;
		answer = Math.max(answer, len);
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny<0 || nx<0 || ny>=N || nx>=N || visit[ny][nx])
				continue;
			if(board[ny][nx]<board[y][x]) {
				dfs(ny, nx, len+1, work);
				visit[ny][nx] = false;
			} else { //공사해야하는 부분
				if(work==false && board[ny][nx]-K<board[y][x]) {
					for(int i=1; i<=K; i++) {
						if(board[ny][nx]-i>=0) {
							if(board[ny][nx]-i>=board[y][x])
								continue;
							board[ny][nx] -= i;
							work = true;
							dfs(ny, nx, len+1, work);
							work = false;
							visit[ny][nx] = false;
							board[ny][nx] += i;
						}
					}
				}
			}
		}
	}
} // end of solution
