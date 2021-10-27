package baekjoon.줄세우기;
import java.io.*;
import java.util.*;
public class Main {
	static class P2252 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, indegree[];
		ArrayList<ArrayList<Integer>> graph;
		void solve() {
			input();
			sb = new StringBuilder();
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				if(indegree[i]==0) {
					q.add(i);
				}
			}
			while(!q.isEmpty()) {
				int x = q.poll();
				sb.append(x+1).append(' ');
				for(int y: graph.get(x)) {
					indegree[y]--;
					if(indegree[y]==0)
						q.add(y);
				}
			}
			System.out.println(sb);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				indegree = new int[N];
				graph = new ArrayList<>();
				for(int i=0; i<N; i++) {
					graph.add(new ArrayList<>());
				}
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					graph.get(a).add(b);
					indegree[b]++;
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2252().solve();
	}
}