package baekjoon.거의최단경로;
import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}
	
	
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node o) {
//		if(this.distance < o.distance)
//			return -1;
//		return 1;
		return this.distance - o.distance;
	}
	
}

public class Main {
	static final int INF = (int)1e9;
	static int n, m, start, end;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[10001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		d[start]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();
			int dist = node.getDistance();
			
			if(d[now]<dist) continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.add(new Node(graph.get(now).get(i).getIndex(), cost));
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
			//그래프 초기화
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int u = Integer.parseInt(st.nextToken())+1;
				int v = Integer.parseInt(st.nextToken())+1;
				int p = Integer.parseInt(st.nextToken())+1;
				
				graph.get(u).add(new Node(v,p));
			}
			
			Arrays.fill(d, INF);
			dijkstra(start);
			remove(end);
			for(int i=1; i<=n; i++) {
				if(i==start) {
					d[i] = 0;
				} else {
					d[i] = INF;
				}
			}
			dijkstra(start);
			for (int i = 1; i <= n; i++) {
	            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
	            if (d[i] == INF) {
	                System.out.println("-1");
	            }
	            // 도달할 수 있는 경우 거리를 출력
	            else {
	                System.out.println(d[end]);
	            }
	        }
		}
		
	}

	public static void remove(int end) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(new Node(end, 1));
		while(!q.isEmpty()) {
			Node node = q.poll();
			int now = node.getIndex();
			int dist = node.getDistance();
			for (int i = 0; i < graph.get(now).size(); i++) {
				System.out.println(graph.get(now).get(i).getIndex());
			}
		}
	}
}
