package baekjoon.최소스패닝트리;
import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge> {
	private int vertex, weight;
	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	public int getVertex() {
		return vertex;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public int compareTo(Edge o) {
		return this.getWeight() - o.getWeight();
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<V; i++)
			graph.add(new ArrayList<>());
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex1 = Integer.valueOf(st.nextToken())-1;
			int vertex2 = Integer.valueOf(st.nextToken())-1;
			int weight = Integer.valueOf(st.nextToken());
			graph.get(vertex1).add(new Edge(vertex2, weight));
			graph.get(vertex2).add(new Edge(vertex1, weight));
		}
		System.out.println(primMST(graph, V));
	}
	static int primMST(ArrayList<ArrayList<Edge>> graph, int v) {
		int result = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean visit[] = new boolean[v];
		Edge start = new Edge(0, 0);
		pq.add(start);
		while(!pq.isEmpty()) {
			Edge currentEdge = pq.poll();
			if(visit[currentEdge.getVertex()])
				continue;
			visit[currentEdge.getVertex()] = true;
			result += currentEdge.getWeight();
			for(Edge next: graph.get(currentEdge.getVertex())) {
				if(!visit[next.getVertex()])
					pq.add(next);
			}
		}
		return result;
	}
}