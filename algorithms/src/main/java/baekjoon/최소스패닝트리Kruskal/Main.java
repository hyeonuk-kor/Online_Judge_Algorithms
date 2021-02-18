package baekjoon.최소스패닝트리Kruskal;
import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge> {
	private int vertex1, vertex2, weight;
	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	public int getVertex1() {
		return vertex1;
	}
	public int getVertex2() {
		return vertex2;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public int compareTo(Edge o) {
		return this.getWeight() - o.getWeight();
	}
}
class DisjointSet {
	private int[] parent;
	public DisjointSet(int v) {
		parent = new int[v];
		Arrays.fill(parent, -1);
	}
	public int find(int x) {
		if(parent[x]==-1)
			return x;
		return parent[x] = find(parent[x]);
	}
	public void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a] = b;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		ArrayList<Edge> graph = new ArrayList<Edge>();
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex1 = Integer.valueOf(st.nextToken());
			int vertex2 = Integer.valueOf(st.nextToken());
			int weight = Integer.valueOf(st.nextToken());
			graph.add(new Edge(vertex1, vertex2, weight));
		}
		System.out.println(kruskalMST(graph, V));
	}
	static int kruskalMST(ArrayList<Edge> graph, int v) {
		int result = 0;
		Collections.sort(graph);
		DisjointSet vertexSet = new DisjointSet(v+1);
		for(int i=0; i<graph.size(); i++) {
			Edge currentEdge = graph.get(i);
			int root1 = vertexSet.find(currentEdge.getVertex1());
			int root2 = vertexSet.find(currentEdge.getVertex2());
			if(root1!=root2) {
				vertexSet.union(root1, root2);
				result += currentEdge.getWeight();
			}
		}
		return result;
	}
}