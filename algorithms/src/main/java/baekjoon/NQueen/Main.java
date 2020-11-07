package baekjoon.NQueen;
import java.io.*;
public class Main {
	public static int N, answer, chessboard[];
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		chessboard = new int[N];
		for(int i=0; i<N; i++) {
			chessboard[0] = i+1;
			getResult(0);
		}
		System.out.println(answer);
	}

	private static void getResult(int row) {
		if(row==N-1) {
			answer++;
			return;
		} else {
			for(int i=0; i<N; i++) {
				chessboard[row+1]=i+1;
				if(check(row+1)) {
					getResult(row+1);
				} else {
					chessboard[row+1]=0;
				}
			}
		}
		chessboard[row] = 0;
	}

	private static boolean check(int p) {
		for(int i=0; i<p; i++) {
			if(chessboard[i]==chessboard[p])
				return false;
			if(Math.abs(chessboard[i]-chessboard[p])==Math.abs(i-p))
				return false;
		}
		return true;
	}



}
