package baekjoon.구슬탈출2;
import java.io.*;
import java.util.*;
public class Main2 {
	static int N, M, answer=11;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char board[][] = new char[11][11];
		for(int i=0; i<11; i++)
			Arrays.fill(board[i], '#');
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++)
				board[i][j] = input.charAt(j);
		}
		dfs(1, board);
		if(answer==11)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	static void dfs(int depth, char[][] board) {
		if(depth>10)
			return;
		for(int r=0; r<4; r++) {
			char copy[][] = new char[11][11];
			for(int i=0; i<11; i++)
				copy[i] = board[i].clone();
			if(dropBead(board)) {
				answer = Math.min(answer, depth);
				return;
			}
			dfs(depth+1, board);
			board = rotate(copy);
		}
	}
	static boolean dropBead(char[][] board) {
		int[] red = null, blue = null;
		int ry=0, rx=0, by=0, bx=0;
		for(int y=0; y<11; y++) {
			for(int x=0; x<11; x++) {
				if(board[y][x]=='R') {
					ry = y;
					rx = x;
					red = move(board, y, x);
				}
				if(board[y][x]=='B') {
					by = y;
					bx = x;
					blue = move(board, y, x);
				}
			}
		}
		return adjustBeads(board, ry, rx, by, bx, red, blue);
	}
	static boolean adjustBeads(char[][] board, int ry, int rx, int by, int bx, int[] red, int[] blue) {
		if(board[blue[0]][blue[1]]=='O')
			return false;
		if(board[red[0]][red[1]]=='O') {
			return true;
		} else {
			if(red[0]==blue[0] && red[1]==blue[1]) {
				if(ry>by)
					blue[0]--;
				else
					red[0]--;
			}
		}
		board[ry][rx]='.';
		board[by][bx]='.';
		board[red[0]][red[1]]='R';
		board[blue[0]][blue[1]]='B';
		return false;
	}
	static int[] move(char[][] board, int y, int x) {
		if(y>=11 || board[y][x]=='#')
			return new int[] {y-1, x};
		if(board[y][x]=='O')
			return new int[] {y, x};
		return move(board, y+1, x);
	}
	static char[][] rotate(char[][] board) {
		char[][] temp = new char[11][11];
		for(int i=0; i<11; i++)
			for(int j=0; j<11; j++)
				temp[i][j] = board[board.length-j-1][i];
		return temp;
	}
}