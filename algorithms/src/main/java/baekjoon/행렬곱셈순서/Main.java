package baekjoon.행렬곱셈순서;
import java.io.*;
import java.util.*;
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int matrix[][] = new int[N+1][2];
		int memo[][] = new int[N+1][N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			matrix[i][0] = Integer.valueOf(st.nextToken());
			matrix[i][1] = Integer.valueOf(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i; j++) {
				int a = j;
				int b = j+i;
				if(a==b) {
					memo[a][b] = 0;
				} else {
					memo[a][b] = INF;
					for(int k=a; k<b; k++) {
						memo[a][b] = Math.min(memo[a][b], memo[a][k]+memo[k+1][b]+(matrix[a][0]*matrix[k][1]*matrix[b][1]));
					}
				}
			}
		}
		System.out.println(memo[0][N-1]);
	}
}