package baekjoon.색종이만들기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, board[][], white, blue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		getCount(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	static void getCount(int y, int x, int n) {
		int count = 0;
		for(int i=y; i<y+n; i++) 
			for(int j=x; j<x+n; j++) 
				if(board[i][j]==1)
					count++;
		if(count==0) white++;
		else if(count==n*n) blue++;
		else {
			getCount(y, x, n/2);
			getCount(y, x+n/2, n/2);
			getCount(y+n/2, x, n/2);
			getCount(y+n/2, x+n/2, n/2);
		}
	}
}