package baekjoon.다리놓기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int pascalTriangle[][] = new int[30][];
		for(int i=0; i<30; i++) {
			pascalTriangle[i] = new int[i+1];
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i)
					pascalTriangle[i][j] = 1;
				else
					pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
			}
		}
				
		while(T-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			bw.append(pascalTriangle[m][n]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
