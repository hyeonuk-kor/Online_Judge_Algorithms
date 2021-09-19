package baekjoon.마법사상어와파이어볼;
import java.io.*;
import java.util.*;
public class Main {
	static final int NOT_EXIST = 0, EXIST=1;
	static final int LOCATION = 0, MASS = 1, SPEED = 2, DIRECTION = 3;
	static int N, M, K;
	static int board[][][]; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[4][N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int m = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				board[LOCATION][y][x] = EXIST;
				board[MASS][y][x] = m;
				board[SPEED][y][x] = s;
				board[DIRECTION][y][x] = d;
			}
		}
		
		//print();

	}
	static void print() {
		System.out.println("LOCATION\t "+"MASS\t "+"SPEED\t "+"DIRECTION");
		for(int i=0; i<board.length; i++) {
			System.out.println(Arrays.toString(board[LOCATION][i])+" "+
					Arrays.toString(board[MASS][i])+" "+
					Arrays.toString(board[SPEED][i])+" "+
					Arrays.toString(board[DIRECTION][i])+" "
					);
		}
	}

}
