package test;
import java.io.*;
import java.util.*;
public class CodeTree2 {
	static class Solution {
		BufferedReader br;
		StringTokenizer st;
		int N, zero, answer, order[][], cmd[][], dir[][] = {
				{0,0}, 
				{-1,0}, {-1,-1}, {0,-1}, {1,-1},
				{1,0}, {1,1}, {0,1}, {-1,1}	
		};
		LinkedList<ArrayList<Integer>> board;
		int solve() {
			input();
			dfs(0);
			return answer;
		}

		private void dfs(int depth) {
			if(depth==zero) {
				answer = Math.max(answer, game());
				return;
			} else {
				for(int i=0; i<N; i++) {
					if(cmd[i][1]==0) {
						for(int j=1; j<=4; j++) {
							cmd[i][1] = j;
							dfs(depth+1);
						}
					}
				}
			}
		}
		
		private void dropBlock(int k, int c) { // k : 블록 종류, c : x축 위치
			int y = board.size()-1;
			for(int i=0; i<=y; i++) {
				if(board.get(i).get(c-1)>0) {
					y = i-1;
					break;
				}
			}
			board.get(y).set(c-1, k);
		}
		private int getScore() {
			int sum = 0;
			int y = board.size()-1;
			while(y!=0) {
				if(!board.get(y).contains(0)) {
					board.remove(y);
					board.addFirst(emptyArray());
					sum++;
				} else {
					y--;
				}
			}
			return sum;
		}
		private int game() {
			int sum = 0;
			for(int i=0; i<cmd.length; i++) {
				dropBlock(cmd[i][0], cmd[i][1]);
				sum += getScore();
				gravity();
				moveBlock();
				gravity();
				sum += getScore();
				gravity();
			}
			return sum;
		}
		private void gravity() {
			for(int j=0; j<4; j++) {
				ArrayDeque<Integer> deq = new ArrayDeque<>();
				for(int i=0; i<board.size(); i++) {
					if(board.get(i).get(j)==0) {
						deq.addLast(0);
					} else {
						deq.addFirst(board.get(i).get(j));
					}
				}
				for(int i=0; i<board.size(); i++) {
					board.get(i).set(j, deq.pollLast());
				}
			}
		}
		private void moveBlock() {
			LinkedList<ArrayList<Integer>> next_board = new LinkedList<>();
			for(int i=0; i<100; i++) {
				next_board.add(emptyArray());
			}
			for(int i=0; i<board.size(); i++) {
				for(int j=0; j<board.get(i).size(); j++) {
					if(board.get(i).get(j)!=0) {
						int number = board.get(i).get(j);
						for(int d=0; d<8; d++) {
							int ny = i + dir[order[number][d]][0];
							int nx = j + dir[order[number][d]][1];
							if(ny<0 || nx < 0 || ny>=100 || nx>=4)
								continue;
							if(next_board.get(ny).get(nx)==0) {
								next_board.get(ny).set(nx, board.get(i).get(j));
							} else {
								int min = Math.min(next_board.get(ny).get(nx), board.get(i).get(j));
								next_board.get(ny).set(nx, min);
							}
							break;
						}
					}
				}
			}
			board = next_board;
		}
		private ArrayList<Integer> emptyArray() {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=0; i<4; i++)
				temp.add(0);
			return temp;
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				board = new LinkedList<>();
				for(int i=0; i<100; i++) {
					board.add(emptyArray());
				}
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
					if(cmd[i][1]==0)
						zero++;
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
