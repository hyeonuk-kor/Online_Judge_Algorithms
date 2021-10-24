package baekjoon.영우는사기꾼;
import java.io.*;
import java.util.*;
public class Main {
	static class P14676 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K;
		int indeg[];
		String answer = "King-God-Emperor";
		List<List<Integer>> graph;
		List<List<Integer>> game;
		List<Integer> sortedGraph;
		void solve() {
			input();
			pro();
			System.out.println(answer);
		}
		void pro() {
			TopologySort(indeg.clone()); // 위상 정렬, indeg는 재 사용해야해서 복사해서 넘김
			//print();
			boolean check[] = new boolean[K]; // 건물을 건설했는지 유무를 확인하는 배열
			for(int i=0; i<K; i++) {
				int cmd = game.get(i).get(0); // 명령어
				int a = game.get(i).get(1);   // 건물 번호
				int degree = indeg[a];	      // 건물이 어느 시점에 건설되었는지 확인하는 변수
				if(cmd==1) {	// 건설
					check[a] = true; //지었다고 표시
					for(int x: sortedGraph) { // indegree를 검사한다.
						if(indeg[x]==degree-1 && !check[x]) { // 자신보다 한 단계 낮은 차수가 건설되지 않았다면?
							answer = "Lier!";
							return;
						}
					}
				} else {
					if(!check[a]) { // 지어진 적이 없는데 파괴하려한다면 거짓
						answer = "Lier!";
						return;
					} else {
						check[a] = false; // 건물 파괴
					}
				}
			}
		}
		void print() {
			for(int n: sortedGraph)
				System.out.print((n+1)+" ");
			System.out.println();
		}
		void TopologySort(int[] indegree) {
			Queue<Integer> queue = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				if(indegree[i]==0)
					queue.add(i);
			}
			sortedGraph = new ArrayList<>();
			while(!queue.isEmpty()) {
				int x = queue.poll();
				sortedGraph.add(x);
				for(int y: graph.get(x)) {
					indegree[y]--;
					if(indegree[y]==0)
						queue.add(y);
				}
			}
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
