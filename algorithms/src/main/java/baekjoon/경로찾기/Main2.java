package baekjoon.경로찾기;
import java.util.*;
import java.io.*;
public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int check = Integer.parseInt(st.nextToken());
				if(check==1)
					graph[i][j] = true;
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					if(!graph[a][b])
						graph[a][b] = graph[a][k] && graph[k][b];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j])
					bw.append(1+" ");
				else 
					bw.append(0+" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
