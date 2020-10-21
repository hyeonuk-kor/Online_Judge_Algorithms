package baekjoon.별찍기15;

import java.io.*;

public class Main {
	static int N;
	static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][2*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				map[i][j]=' ';
			}
			map[i][N-i-1]='*';
			for(int j=N-i; j<N+i-1; j++) {
				map[i][j]=' ';
			}
			map[i][N+i-1]='*';
			map[i][N+i]='\0';
		}
 
		for(int i=0; i<N; i++) {
			for(int j=0; map[i][j]!='\0'; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
