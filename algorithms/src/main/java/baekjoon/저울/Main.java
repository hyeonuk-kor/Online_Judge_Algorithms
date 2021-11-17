package baekjoon.저울;
import java.io.*;
import java.util.*;
public class Main {
	static class P10159 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, graph[][];
		P10159() {
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int n=1; n<=N; n++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(graph[i][n]<=0) continue; 
						// i>n 이고 n>j이면, i>j가 성립한다.
						if(graph[i][n]==graph[n][j]) {
							graph[i][j] = 1;
							graph[j][i] = -1;
						}
					}
				}
			}
			for(int i=1; i<=N; i++) {
				int count = 0;
				for(int j=1; j<=N; j++) {
					if(i!=j && graph[i][j]==0) {
						count++;
					}
				}
				sb.append(count).append('\n');
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				M = Integer.parseInt(br.readLine());
				graph = new int[N+1][N+1];
				for(int m=0; m<M; m++) {
					st = new StringTokenizer(br.readLine().trim());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					// a>b이면 graph[a][b] = 1, graph[b][a] = -1로 셋팅
					graph[a][b] = 1;
					graph[b][a] = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10159();
	}
}