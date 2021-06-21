package baekjoon.구슬탈출2;
import java.io.*;
import java.util.*;
public class Main {
	static char[][] board ;
	static int N, M, SIZE, answer=-1;
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		SIZE = Math.max(N, M);
		board = new char[SIZE][SIZE];
		for(int i=0; i<SIZE; i++)
			Arrays.fill(board[i], '#');
		for(int i=0; i<N; i++)
			board[i] = br.readLine().toCharArray();
		dfs(0, board);
		System.out.println(answer);
	}
	static void dfs(int depth, char[][] curBoard) {
		if(depth==10)
			return;
		if(check)
			return;
		char[][][] copyBoard = new char[4][SIZE][SIZE];
		copy(copyBoard[0], curBoard);
		for(int r=1; r<4; r++) 
			copyBoard[r] = rotate(copyBoard[r-1]);
		for(int r=0; r<4; r++) {
			move(copyBoard[r]);
			if(check) {
				answer = depth;
				return;
			}
			dfs(depth+1, copyBoard[r]);
		}
	}
	static void move(char[][] copyBoard) {
		boolean rgoal=false, bgoal=false;
		int ry=0, rx=0, by=0, bx=0;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(copyBoard[i][j]=='R') {
					ry = i;
					rx = j;
				} else if(copyBoard[i][j]=='B') {
					by = i;
					bx = j;
				}
			}
		}
		int cr=0, cb=0;
		copyBoard[ry][rx]='.';
		while(ry<SIZE) {
			if(copyBoard[ry][rx]=='O') {
				rgoal=true;
				break;
			} else if(copyBoard[ry][rx]=='#') {
				ry--;
				break;
			}
			ry++;
			cr++;
		}
		copyBoard[by][bx]='.';
		while(by<SIZE) {
			if(copyBoard[by][bx]=='O') {
				bgoal=true;
				break;
			} else if(copyBoard[by][bx]=='#') {
				by--;
				break;
			}
			by++;
			cb++;
		}
		if(!bgoal && rgoal) {
			check = true;
		} else if(bgoal && rgoal) {
			copyBoard[ry-cr][rx]='R';
			copyBoard[by-cb][bx]='B';
		} else {
			if(ry==by) {
				if(cr>cb)
					ry--;
				else if(cr<cb)
					by--;
			}
			copyBoard[by][bx]='B';
			copyBoard[ry][rx]='R';
		}
	}
	static char[][] rotate(char[][] origin) {
		char[][] temp = new char[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) 
			for(int j=0; j<SIZE; j++)
				temp[i][j] = origin[SIZE-1-j][i];
		return temp;
	}
	static void copy(char[][] to, char[][] from) {
		for(int i=0; i<SIZE; i++)
			to[i] = from[i].clone();
	}
}
