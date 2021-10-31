package baekjoon.운동;
import java.io.*;
import java.util.*;
public class Main {
	static class P1956 {
		BufferedReader br;
		StringTokenizer st;
		final int MAX = 10000;
		int V, E, graph[][], answer;
		boolean[][] visit;
		P1956() {
			br = new BufferedReader(new InputStreamReader(System.in));
			answer = Integer.MAX_VALUE;
			input();
			solve();
		}
		void solve() {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					for(int k=1; k<=V; k++) {
						if(graph[j][k] > graph[j][i] + graph[i][k])
							graph[j][k] = graph[j][i] + graph[i][k];
					}
				}
			}
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(i!=j) {
						if(graph[i][j] != MAX && graph[j][i] != MAX)
							answer = Math.min(answer, graph[i][j] + graph[j][i]);
					}
				}
			}
			System.out.println(answer==MAX?-1:answer);
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				V = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				graph = new int[V+1][V+1];
				for(int i=0; i<graph.length; i++) {
					Arrays.fill(graph[i], MAX);
				}
				for(int i=0; i<E; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					graph[a][b] = c;
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1956();
	}
}