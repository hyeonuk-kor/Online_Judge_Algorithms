package baekjoon.두단계최단경로1;
import java.io.*;
import java.util.*;
public class Main {
	static class P23793 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, X, Y, Z, dist[], answer;
		class Edge {
			int to, weight;
			Edge(int to, int weight) {
				this.to = to;
				this.weight = weight;
			}
			public void setWeight(int weight) {
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
		P23793() {
			graph = new ArrayList<>();
			input();
			pro();
		}
		long dijkstra(int start, int end) {
			for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;
			PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
			pq.add(new Info(start, 0));
			dist[start] = 0;
			while(!pq.isEmpty()) {
				Info info = pq.poll();
				if(dist[info.idx] != info.dist) continue;
				for(Edge e: graph.get(info.idx)) {
					if(e.weight==Integer.MAX_VALUE) continue;
					if(dist[info.idx] + e.weight < dist[e.to]) {
						dist[e.to] = dist[info.idx] + e.weight;
						pq.add(new Info(e.to, dist[e.to]));
					}
				}
			}
			if(dist[end]==Integer.MAX_VALUE)
				return -1;
			return dist[end];
		}
		void pro() {
			long s1 = dijkstra(X, Y);
			long s2 = dijkstra(Y, Z);
			long non_direct = s1+s2;
			if(s1==-1 || s2==-1)
				non_direct = -1;
			for(int i=0; i<graph.get(Y).size(); i++)
				graph.get(Y).get(i).setWeight(Integer.MAX_VALUE);
			long direct = dijkstra(X, Z);
			if(direct==Integer.MAX_VALUE)
				direct = -1;
			System.out.println(non_direct+" "+direct);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				dist = new int[N+1];
				for(int i=0; i<=N; i++)	graph.add(new ArrayList<>());
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					graph.get(from).add(new Edge(to, weight));
				}
				st = new StringTokenizer(br.readLine().trim());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				Z = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23793();
	}
}