package Graph.dijkstra;
import java.util.*;

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
	static int n, m, start;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[100001];
	
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		//그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node(b,c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
	}
	
}

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 * */
