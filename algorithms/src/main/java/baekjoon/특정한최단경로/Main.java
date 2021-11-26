package baekjoon.특정한최단경로;
import java.io.*;
import java.util.*;
public class Main {
	static class P1504 {
		BufferedReader br;
		StringTokenizer st;
		int N, E, v1, v2, dist[], answer;
		class Edge {
			int to, weight;
			Edge(int to, int weight) {
				this.to = to;
				this.weight = weight;
			}
		}
		class Info {
			int idx, dist;
			Info(int idx, int dist) {
				this.idx = idx;
				this.dist = dist;
			}
		}
		List<List<Edge>> graph;
		P1504() {
			graph = new ArrayList<>();
			input();
			pro();
			System.out.println(answer);
		}
		int dijkstra(int start, int end) {
			for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;
			PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
			pq.add(new Info(start, 0));
			dist[start] = 0;
			while(!pq.isEmpty()) {
				Info info = pq.poll();
				if(dist[info.idx] != info.dist) continue;
				for(Edge e: graph.get(info.idx)) {
					if(dist[info.idx] + e.weight < dist[e.to]) {
						dist[e.to] = dist[info.idx] + e.weight;
						pq.add(new Info(e.to, dist[e.to]));
					}
				}
			}
			return dist[end];
		}
		void pro() {
			
			// v1 먼저 방문
			long s1 = dijkstra(1, v1);
			long w1 = dijkstra(v1, v2);
			long e1 = dijkstra(v2, N);
			long sum1 = s1 + w1 + e1;
			
			// v2 먼저 방문
			long s2 = dijkstra(1, v2);
			long w2 = dijkstra(v2, v1);
			long e2 = dijkstra(v1, N);
			long sum2 = s2 + w2 + e2;

			long sum = Math.min(sum1, sum2);
			if(sum>=Integer.MAX_VALUE) {
				answer = -1;
			} else {
				answer = (int)sum;
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				dist = new int[N+1];
				for(int i=0; i<=N; i++)	graph.add(new ArrayList<>());
				for(int i=0; i<E; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					graph.get(from).add(new Edge(to, weight));
					graph.get(to).add(new Edge(from, weight));
				}
				st = new StringTokenizer(br.readLine().trim());
				v1 = Integer.parseInt(st.nextToken());
				v2 = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1504();
	}
}