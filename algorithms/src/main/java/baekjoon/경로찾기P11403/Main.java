package baekjoon.경로찾기P11403;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					if(graph[a][b]==0 && graph[a][k]==1 && graph[k][b]==1) {
						graph[a][b] = 1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.append(graph[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
