package baekjoon.P6497_전력난;
import java.io.*;
import java.util.*;
public class Main {
	static class DisjointSet {
		int[] parent;
		DisjointSet(int v) {
			parent = new int[v+1];
			Arrays.fill(parent, -1);
		}
		int find(int x) {
			if(parent[x]==-1)
				return x;
			return parent[x] = find(parent[x]);
		}
		void union(int a, int b) {
			a=find(a);
			b=find(b);
			if(a!=b)
				parent[a] = b;
		}
	}
	static class Edge implements Comparable<Edge> {
		int x, y, z;
		public Edge(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.z, o.z);
		}
	}
	static int N, M, SUM;
	static ArrayList<Edge> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			SUM = 0;
			if(N==0 && M==0)
				break;
			graph = new ArrayList<Edge>();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				SUM += z;
				graph.add(new Edge(x, y, z));
			}
			pw.println(SUM-kruskal());
		}
		pw.flush();
	}
	static int kruskal() {
		int result = 0;
		Collections.sort(graph);
		DisjointSet set = new DisjointSet(M);
		for(Edge c: graph) {
			int root1 = set.find(c.x);
			int root2 = set.find(c.y);
			if(root1!=root2) {
				set.union(root1, root2);
				result += c.z;
			}
		}
		return result;
	}
}