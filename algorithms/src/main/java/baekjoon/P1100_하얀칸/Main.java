package baekjoon.P1100_하얀칸;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[8][];
		for(int i=0; i<8; i++) 
			board[i] = br.readLine().toCharArray();
		int answer = 0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2==0 && board[i][j]=='F')
					answer++;
			}
		}
		System.out.println(answer);
	}
}