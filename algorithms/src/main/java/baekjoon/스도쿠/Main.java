package baekjoon.스도쿠;
import java.io.*;
public class Main {
	static char board[][] = new char[9][9];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<board.length; i++)
			board[i] = br.readLine().toCharArray();
		if(solve(0)) {
			for(int i=0; i<board.length; i++)
				pw.println(board[i]);
		}
		pw.flush();
	}
	static boolean solve(int number) {
		if(number==81)
			return true;
		int y = number/9;
		int x = number%9;
		if(board[y][x]=='0') {
			for(char n='1'; n<='9'; n++) {
				if(isPossible(y, x, n)) {
					board[y][x] = n;
					if(solve(number+1))
						return true;
					else
						board[y][x] = '0';
				}
			}
			return false;
		} else {
			return solve(number+1);
		}
	}
	static boolean isPossible(int row, int col, char number) {
		return isBox(row, col, number) && isCol(col, number) && isRow(row, number);
	}
	static boolean isRow(int row, char number) {
		for(int i=0; i<9; i++)
			if(board[row][i]==number)
				return false;
		return true;
	}
	static boolean isCol(int col, char number) {
		for(int i=0; i<9; i++)
			if(board[i][col]==number)
				return false;
		return true;
	}
	static boolean isBox(int row, int col, char number) {
		int r = row - row % 3;
		int c = col - col % 3;
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(board[i][j]==number)
					return false;
			}
		}
		return true;
	}
}