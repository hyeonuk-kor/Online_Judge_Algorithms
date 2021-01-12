package baekjoon.정수삼각형;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int table[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<i+1; j++)
				table[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=N-1; i>=1; i--)
			for(int j=0; j<i; j++)
				table[i-1][j] += Math.max(table[i][j], table[i][j+1]);
		System.out.println(table[0][0]);
	}
}