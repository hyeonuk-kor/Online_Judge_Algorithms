package baekjoon.플로이드;
import java.util.*;
import java.io.*;
public class Main {
	static final int INF = (int)1e9;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(graph[i], INF); //아직 운행노선 x
			graph[i][i] = 0; //자기 자신에서 자신으로 갈 필요가 없음
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(graph[a][b]>c) //현재 버스가 비용이 더 저렴하다면? 
				graph[a][b]=c;
		}
		
		for(int k=1; k<=n; k++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j]>=INF)
					bw.append("0 ");
				else
					bw.append(graph[i][j]+" ");
			}
			bw.append("\n");
		}
		
		bw.flush();
	}
}
