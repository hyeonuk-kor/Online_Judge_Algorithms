package baekjoon.스도쿠미노;
import java.io.*;
import java.util.*;
public class Main {
	static class Solution {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, board[][], domino[][], END;
		boolean domino_check[]; // 사용한 도미노 확인하기
		public Solution() throws Exception {
			br = new BufferedReader(new InputStreamReader(System.in));
			sb = new StringBuilder();
			board = new int[9][9]; // 스도미노쿠 보드판
			N = Integer.parseInt(br.readLine());
			domino = new int[36][2]; // 36개의 도미노 타일
			makeDominoTile(); //도미노 카드 초기화
			domino_check = new boolean[36];
		}
		String solve() throws Exception {
			StringTokenizer st = null;
			int game = 1;
			while(N!=0) {
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					int num1 = 0, num2 = 0;
					for(int j=0; j<2; j++) {
						int number = Integer.parseInt(st.nextToken());
						String point = st.nextToken();
						int y = point.charAt(0)-'A'; 
						int x = point.charAt(1)-'1'; 
						board[y][x] = number;
						if(j==0) {
							num1 = number;
						} else {
							num2 = number;
						}
					}
					for(int j=0; j<domino.length; j++) {
						if(domino[j][0]==num1 && domino[j][1]==num2)
							domino_check[j] = true;
						else if(domino[j][0]==num2 && domino[j][1]==num1)
							domino_check[j] = true;
					}
				}
				st = new StringTokenizer(br.readLine());
				for(int number=1; number<=9; number++) {
					String point = st.nextToken();
					int y = point.charAt(0)-'A'; 
					int x = point.charAt(1)-'1'; 
					board[y][x] = number;
				}
				// end tc input
				sb.append("Puzzle "+game++).append('\n');
				END = (81-(N*2)-9)/2;
				fill(0,0,0);
				N = Integer.parseInt(br.readLine());
				board = new int[9][9];
				domino_check = new boolean[36];
			}
			return sb.toString();
		}
		boolean fill(int y, int x, int depth) {
			if(depth==END) {
				for(int i=0; i<domino_check.length; i++) {
					if(!domino_check[i])
						return false;
				}
				print();
				return true;
			}
			if(y==9) return false;	
			if(x==9) return fill(y+1, 0, depth);
			if(board[y][x]!=0) return fill(y, x+1, depth);
			for(int i=0; i<domino.length; i++) {
				int num1 = domino[i][0];
				int num2 = domino[i][1];
				boolean check;
				if(domino_check[i]) continue;
				if(x+1<9 && board[y][x+1]==0) { // 가로로 놓기
					// 가로 순방향 ex : [1,2]
					if(isPossible(y, x, num1) && isPossible(y, x+1, num2)) {
						board[y][x] = num1;
						board[y][x+1] = num2;
						domino_check[i] = true;
						check = fill(y, x+1, depth+1); // 다음 탐색
						if(check)
							return check;
						domino_check[i] = false;
						board[y][x] = 0;
						board[y][x+1] = 0;
					}
					// 가로 역방향 ex : [2, 1]
					if(isPossible(y, x, num2) && isPossible(y, x+1, num1)) {
						board[y][x] = num2;
						board[y][x+1] = num1;
						domino_check[i] = true;
						check = fill(y, x+1, depth+1); // 다음 탐색
						if(check)
							return check;
						domino_check[i] = false;
						board[y][x] = 0;
						board[y][x+1] = 0;
					}
				}
				if(y+1<9 && board[y+1][x]==0) { // 세로로 놓기
					// 세로 순방향
					if(isPossible(y, x, num1) && isPossible(y+1, x, num2)) {
						board[y][x] = num1;
						board[y+1][x] = num2;
						domino_check[i] = true;
						check = fill(y, x+1, depth+1); // 다음 탐색
						if(check)
							return check;
						domino_check[i] = false;
						board[y][x] = 0;
						board[y+1][x] = 0;
					}
					// 세로 역방향
					if(isPossible(y, x, num2) && isPossible(y+1, x, num1)) {
						board[y][x] = num2;
						board[y+1][x] = num1;
						domino_check[i] = true;
						check = fill(y, x+1, depth+1); // 다음 탐색
						if(check)
							return check;
						domino_check[i] = false;
						board[y][x] = 0;
						board[y+1][x] = 0;
					}
				}
			}
			return false;
		}
		boolean isPossible(int row, int col, int number) {
			return isBox(row, col, number) && isCol(col, number) && isRow(row, number);
		}
		boolean isRow(int row, int number) {
			for(int i=0; i<9; i++)
				if(board[row][i]==number)
					return false;
			return true;
		}
		boolean isCol(int col, int number) {
			for(int i=0; i<9; i++)
				if(board[i][col]==number)
					return false;
			return true;
		}
		boolean isBox(int row, int col, int number) {
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
		void print() {
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[i].length; j++) {
					sb.append(board[i][j]);
				}
				sb.append('\n');
			}
		}
		void makeDominoTile() {
			int count = 0;
			for(int i=1; i<=8; i++) {
				for(int j=i+1; j<=9; j++) {
					domino[count][0] = i;
					domino[count][1] = j;
					count++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println(new Solution().solve());
	}
}