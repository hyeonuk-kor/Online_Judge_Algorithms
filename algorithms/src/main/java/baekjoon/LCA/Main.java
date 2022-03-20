package baekjoon.LCA;
import java.io.*;
import java.util.*;
public class Main {
	static class P11437 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, a, b, parent[], d[];
		boolean check[];
		List<List<Integer>> graph;
		P11437() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				parent = new int[N+1];
				d = new int[N+1];
				check = new boolean[N+1];
				graph = new ArrayList<>();
				graph.add(new ArrayList<>());
				for(int n=0; n<N; n++) {
					graph.add(new ArrayList<>());
				}
				for(int n=1; n<N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					graph.get(a).add(b);
					graph.get(b).add(a);
				}
				dfs(1, 0);
				M = Integer.parseInt(br.readLine());
				for(int m=0; m<M; m++) {
					st = new StringTokenizer(br.readLine().trim());
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					sb.append(lca(a, b)).append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void dfs(int x, int depth) {
			check[x] = true;
			d[x] = depth;
			for(int y: graph.get(x)) {
				if(!check[y]) {
					parent[y] = x;
					dfs(y, depth+1);
				}
			}
		}
		int lca(int a, int b) {
			while(d[a]!=d[b]) {
				if(d[a]>d[b])
					a = parent[a];
				else
					b = parent[b];
			}
			while(a!=b) {
				a = parent[a];
				b = parent[b];
			}
			return a;
		}
	}
	public static void main(String[] args) {
		new P11437();
	}
}
