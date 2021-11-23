package baekjoon.P23562;
import java.io.*;
import java.util.*;
public class Main {
	static class P23562 {
		BufferedReader br;
		StringTokenizer st;
		int n, m, a, b;
		char[][] board;
		P23562() {
			input();
			solve();
		}
		void solve() {
			int min = Integer.MAX_VALUE;
			// n,m 20이하, 만들 수 있는 경우 -> 1*3 2*3 3*3 4*3 5*3 6*3
			int min_digeut_length = Math.min(n, m)/3;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					for(int k=1; k<=min_digeut_length; k++) {
						if(i+k*3-1>=n || j+k*3-1>=m)
							break;
						min = Math.min(min, makeDigeut(i, j, k));
					}
				}
			}
			System.out.println(min);
		}
		int makeDigeut(int y, int x, int k) {
			int sum = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(i>=y && j>=x && i<y+3*k && j<x+3*k) { // ㄷ이 그려져야하는 범위라면
						if(i>=y+k && i<y+2*k &&  j>=x+k) { //공백이 되어야 하는 부분
							if(board[i][j]=='#') {
								sum += b;
							}
						} else { // 칠해야하는 부분
							if(board[i][j]=='.') {
								sum+=a;
							}
						}
					} else { // 아닐 경우 모두 지우는 비용 계산
						if(board[i][j]=='#') {
							sum += b;
						}
					}
				}
			}
			return sum;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine().trim());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				board = new char[n][m];
				for(int i=0; i<n; i++) {
					board[i] = br.readLine().toCharArray();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23562();
	}
}
