package baekjoon.트리;
import java.io.*;
import java.util.*;
public class Main {
	static class P1068 {
		BufferedReader br;
		StringTokenizer st;
		int N, erase, answer;
		List<List<Integer>> graph;
		ArrayList<Integer> root;
		P1068() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			pro();
		}
		void pro() {
			// 노드 삭제
			for(int i=0; i<N; i++) {
				if(graph.get(i).contains(erase)) {
					graph.get(i).remove((Integer)erase);
				}
			}
			for(int r: root) {
				if(r!=erase)
				dfs(r, -1);
			}
			System.out.println(answer);
		}
		void dfs(int x, int parent) {
			if(graph.get(x).isEmpty()) {
				answer++;
				return;
			}
			for(int y: graph.get(x)) {
				dfs(y, x);
			}
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				graph = new ArrayList<>();
				for(int i=0; i<N; i++)
					graph.add(new ArrayList<>());
				root = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					int node = Integer.parseInt(st.nextToken());
					if(node==-1) {
						root.add(i);
					} else {
						graph.get(node).add(i);
					}
				}
				erase = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P1068();
	}
}
