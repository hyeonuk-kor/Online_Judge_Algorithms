package baekjoon.여행가자;
import java.io.*;
import java.util.*;
public class Main {
	static class P1976 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		class DisjointSet {
			int[] parent;
			DisjointSet(int v) {
				parent = new int[v];
			}
			int find(int x) {
				if(parent[x]==0)
					return x;
				return parent[x] = find(parent[x]);
			}
			void union(int a, int b) {
				a = find(a);
				b = find(b);
				if(a!=b)
					parent[a] = b;
			}
		}
		int N, M, graph[][];
		P1976() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				M = Integer.parseInt(br.readLine());
				graph = new int[N+1][N+1];
				DisjointSet set = new DisjointSet(N+1);
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=1; j<=N; j++) {
						graph[i][j] = Integer.parseInt(st.nextToken());
						if(graph[i][j]==1) {
							set.union(i, j);
						}
					}
				}
				st = new StringTokenizer(br.readLine().trim());
				int start = set.find(Integer.parseInt(st.nextToken()));
				for(int i=1; i<M; i++) {
					int next = set.find(Integer.parseInt(st.nextToken()));
					if(start!=next) {
						sb.append("NO");
						break;
					}
				}
				if(sb.length()==0)
					sb.append("YES");
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1976();
	}
}
