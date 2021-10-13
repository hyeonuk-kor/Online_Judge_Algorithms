package test;
import java.io.*;
import java.util.*;
public class CodeTree2 {
	static int N;
	static int[][] board, order, cmd;
	static int dir[][] = {
			{0,0}, {-1,0}, {-1,-1}, {0,-1}, {1,-1},{1,0},{1,1},{0,1},{-1,1}	
	};
	static class Solution {
		BufferedReader br;
		StringTokenizer st;
		int solve() {
			input();
			return simulate();
		}
		int simulate() {
			int score = 0;
			for(int i=0; i<N; i++) {
				int number = cmd[i][0];
				int x = cmd[i][1];
				int find[] = new int[5];
				if(x==0) {
					for(int j=1; j<=4; j++) {
						int[][] copy_board = copy(board);
						find[j] = drop(j, number, copy_board);
					}
					Arrays.sort(find);
					score += drop(find[4], number, board);
				} else {
					score += drop(x, number, board);
				}
			}
			score += move(board);
			return score;
		}
		int move(int[][] board) {
			int[][] copy_board = new int[board.length][board[0].length];
			boolean check = false;
			for(int i=0; i<board.length; i++) {
				for(int j=1; j<board[i].length; j++) {
					if(board[i][j]!=0) {
						check = true;
						for(int d=0; d<8; d++) {
							int ny = i + dir[order[board[i][j]][d]][0];
							int nx = j + dir[order[board[i][j]][d]][1];
							if(ny<1 || nx<1 || ny>=board.length || nx>=board[0].length)
								continue;
							if(board[ny][nx]!=0)
								copy_board[ny][nx] = Math.min(board[ny][nx], board[i][j]);
							else if(board[ny][nx]==0)
								copy_board[ny][nx] = board[i][j];
							break;
						}
					}
				}
			}
			int score = 0;
			if(check) {
				for(int k=1; k<=4; k++) {
					int y = copy_board.length-1;
					ArrayDeque<Integer> q = new ArrayDeque<>();
					for(int i=y; i>=0; i--) {
						if(copy_board[i][k]==0)
							q.addLast(copy_board[i][k]);
						else
							q.addFirst(copy_board[i][k]);
					}
					for(int i=y; i>=0; i--) {
						if(q.isEmpty())
							break;
						copy_board[i][k] = q.pollFirst();
					}
				}
				for(int i=copy_board.length-1; i>=0; i--) {
					if(copy_board[i][1]!=0 && copy_board[i][2]!=0 && copy_board[i][3]!=0 && copy_board[i][4]!=0)
						score++;
					else
						break;
				}
			}
			return score;
		}
		private int drop(int x, int number, int[][] board) {
			int y = board.length-1;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for(int i=y; i>=0; i--) {
				if(board[i][x]==0) {
					q.addLast(0);
				} else {
					q.addLast(board[i][x]);
				}
			}
			for(int i=y; i>=0; i--) {
				if(q.peek()==0) {
					board[i][x] = number;
					break;
				}
				board[i][x] = q.pollFirst();
			}
			int del = check(x, board);
			return del;
		}
		private int check(int x, int[][] board) {
			int count = 0;
			for(int i=board.length-1; i>=0; i--) {
				if(board[i][1]!=0 && board[i][2]!=0 && board[i][3]!=0 && board[i][4]!=0)
					count++;
				else
					break;
			}
			if(count!=0) {
				int y = board.length-1;
				ArrayDeque<Integer> q = new ArrayDeque<>();
				for(int i=y; i>=0; i--) {
					q.addLast(board[i][x]);
				}
				for(int i=y; i>=0; i--) {
					if(q.isEmpty())
						break;
					board[i][x] = q.pollFirst();
				}
			}
			return count;
		}
		private int[][] copy(int[][] origin) {
			int temp[][] = new int[origin.length][origin[0].length];
			for(int i=0; i<origin.length; i++)
				temp[i] = origin[i].clone();
			return temp;
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				board = new int[N+1][5];
				order = new int[9][8];
				for(int i=1; i<=8; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<8; j++) {
						order[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				cmd = new int[N][2];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					cmd[i][0] = Integer.parseInt(st.nextToken());
					cmd[i][1] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solve());
	}
}
