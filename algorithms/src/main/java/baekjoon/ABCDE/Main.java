package baekjoon.ABCDE;
import java.io.*;
import java.util.*;
public class Main {
	static class P13023 {
		BufferedReader br;
		StringTokenizer st;
		int N, M;;
		boolean visit[];
		List<ArrayList<Integer>> graph;
		int answer = 0;
		void solve() {
			input();
			for(int i=0; i<N; i++)
				dfs(i, 1);
			System.out.println(answer);
		}

		void dfs(int idx, int depth) {
			if(answer==1)
				return;
			if(depth==5) {
				answer = 1;
				return;
			}
			visit[idx] = true;
			for(int i: graph.get(idx)) {
				if(!visit[i])
					dfs(i, depth+1);
			}
			visit[idx] = false;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				graph = new ArrayList<>();
				for(int i=0; i<N; i++) {
					graph.add(new ArrayList<>());
				}
				visit = new boolean[N];
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					graph.get(a).add(b);
					graph.get(b).add(a);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P13023().solve();
	}
}