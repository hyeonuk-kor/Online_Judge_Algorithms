package swexperts.격자판의숫자이어붙이기;
import java.io.*;
import java.util.*;
public class Solution {
	static HashSet<String> set;
	static int board[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			set = new HashSet<>();
			board = new int[4][4];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					solve(1, i, j, String.valueOf(board[i][j]));
				}
			}
			bw.append("#"+tc+" "+set.size()+"\n");
		}
		bw.flush();
	}
	static void solve(int index, int y, int x, String number) {
		if(index==7) {
			set.add(number);
			return;
		}
		for(int d=0; d<4; d++) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if(ny<0 || nx<0 || ny>=4 || nx>=4) continue;
			solve(index+1, ny, nx, number+board[ny][nx]);
		}
	}
}