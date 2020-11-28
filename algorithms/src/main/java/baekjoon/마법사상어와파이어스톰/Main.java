package baekjoon.마법사상어와파이어스톰;
import java.io.*;
import java.util.*;
public class Main {
	static int N, Q, A[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		A = new int[1<<N][1<<N];
		
		int sum = 0;
		for(int i=0; i<(1<<N); i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<(1<<N); j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				sum += A[i][j];
			}
		}
		System.out.println(sum);
	}
}
