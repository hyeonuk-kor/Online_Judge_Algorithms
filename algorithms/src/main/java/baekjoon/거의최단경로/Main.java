package baekjoon.거의최단경로;
import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
	private int index, distance;
	public Node(int index, int distance) {
		this.setIndex(index);
		this.setDistance(distance);
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.distance, o.distance);
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}

public class Main {
	static final int INF = (int)1e9;
	static int n, m, start, end, dist[];
	static List<Node> adj[];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curIndex = node.getIndex();
			int curWeight = node.getDistance();
			for(int i=0; i<adj[n].size(); i++) {
				int nextIndex = adj[curIndex].get(i).getIndex();
				int nextWeight = adj[curIndex].get(i).getDistance();
				if(curWeight + nextWeight < dist[nextIndex]) {
					dist[nextIndex] = curWeight + nextWeight;
					pq.add(new Node(nextIndex, curWeight + nextWeight));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0) break;
			st = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st.nextToken())+1;
			end = Integer.parseInt(st.nextToken())+1;
			dist = new int[n+1];
			adj = new ArrayList[n+1];
			for (int i = 0; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int u = Integer.parseInt(st.nextToken())+1;
				int v = Integer.parseInt(st.nextToken())+1;
				int p = Integer.parseInt(st.nextToken())+1;
				adj[u].add(new Node(v,p));
			}
			
			for(int i=1; i<=n; i++) {
				if(i==start) {
					dist[i] = 0;
				} else {
					dist[i] = INF;
				}
			}
			
			dijkstra(start);
			remove(end);
			dijkstra(start);
		}
		
	}

	public static void remove(int end) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(end);
		while(!q.isEmpty()) {
			int index = q.peek();
		}
	}
}
