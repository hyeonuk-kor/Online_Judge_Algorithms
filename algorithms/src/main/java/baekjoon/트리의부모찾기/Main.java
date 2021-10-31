package baekjoon.트리의부모찾기;
import java.io.*;
import java.util.*;
public class Main {
	static class P11725 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, p[];
		List<List<Integer>> graph;
		P11725() {
			br = new BufferedReader(new InputStreamReader(System.in));
			graph = new ArrayList<>();
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				p = new int[N+1];
				for(int i=0; i<=N; i++)
					graph.add(new ArrayList<>());
				for(int i=1; i<=N-1; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					graph.get(a).add(b);
					graph.get(b).add(a);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void pro() {
			dfs(1, -1);
			for(int i=2; i<=N; i++)
				sb.append(p[i]).append('\n');
		}
		void dfs(int x, int parent) {
			for(int y: graph.get(x)) {
				if(y!=parent) {
					p[y] = x;
					dfs(y, x);
				}
			}
		}
	}
	public static void main(String[] args) {
		new P11725();
	}
}