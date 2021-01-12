package baekjoon.정수삼각형;
import java.io.*;
import java.util.*;
public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int table[][] = new int[N][N];
		table[0][0] = Integer.parseInt(br.readLine());
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			table[i][0] = table[i-1][0] + Integer.parseInt(st.nextToken());
			for(int j=1; j<i; j++) 
				table[i][j] = Math.max(table[i-1][j-1], table[i-1][j]) + Integer.parseInt(st.nextToken());
			table[i][i] = table[i-1][i-1] + Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.stream(table[N-1]).max().getAsInt());
	}
}