package baekjoon.영우는사기꾼;
import java.io.*;
import java.util.*;
public class Main {
	static class P14676 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K;
		int indeg[];
		String answer;
		List<List<Integer>> graph;
		List<List<Integer>> game;
		void solve() {
			input();
			answer = pro();
			System.out.println(answer);
		}
		String pro() {
			int builded[] = new int[N]; 
			for(int i=0; i<K; i++) {
				int cmd = game.get(i).get(0);
				int a = game.get(i).get(1); 
				if(cmd==1) {	// 건설
					if(indeg[a]!=0) {
						return "Lier!";
					}
					if(builded[a]!=0) {
						builded[a]++;
						continue;
					} 
					builded[a]++;
					for(int x: graph.get(a)) {
						indeg[x]--;
					}

				} else {
					if(builded[a]==0) {
						return "Lier!";
					}
					builded[a]--;
					if(builded[a]==0) {
						for(int x: graph.get(a)) {
							indeg[x]++;
						}
					}
				}
			}
			return "King-God-Emperor";
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				indeg = new int[N];
				graph = new ArrayList<>();
				for(int i=0; i<N; i++)
					graph.add(new ArrayList<>());
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int x = Integer.parseInt(st.nextToken()) - 1;
					int y = Integer.parseInt(st.nextToken()) - 1;
					graph.get(x).add(y);
					indeg[y]++;
				}
				game = new ArrayList<>();
				for(int i=0; i<K; i++) {
					game.add(new ArrayList<>());
					st = new StringTokenizer(br.readLine().trim());
					int cmd = Integer.parseInt(st.nextToken());
					int a = Integer.parseInt(st.nextToken()) - 1;
					game.get(i).add(cmd);
					game.get(i).add(a);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P14676().solve();
	}
}
