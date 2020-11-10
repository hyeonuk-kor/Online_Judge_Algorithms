package Graph.dijkstra;
public class dijkstraGetMin {
	static final int INF = (int)1e9; //최초에는 연결되지 않았다는 무한의 의미
	static int n, dist[], parent[];
	static boolean[] visit;
	public static void main(String[] args) {
		n = 7;
		int[][] graph = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 5, 3, 8, INF, INF, INF},
				{0,INF, 0, INF, 2, 4, INF, INF},
				{0,INF, INF, 0, 6, INF, INF, INF},
				{0,INF, INF, INF, 0, 3, 9, 10},
				{0,INF, INF, INF, INF, 0, INF, 6},
				{0,INF, INF, INF, INF, INF, 0, 7},
				{0,INF, INF, INF, INF, INF, INF, 0}
		};

		int start = 1; //출발 정점
		int end = 7; //도착 정점

		dijkstra(graph, start, end);
		for(int i=1; i<dist.length; i++) {
			System.out.println("dist[" + i + "]=" + dist[i]);
		}
	}

	private static String tracking(int end) {
		String str = end+" ";
		while(parent[end]!=-1) {
			str += parent[end] +" ";
			end = parent[end];
		}
		return new StringBuilder(str).reverse().toString();
	}

	static void dijkstra(int[][] graph, int start, int end) {
		visit = new boolean[n+1];
		dist = new int[n+1];
		parent = new int[n+1]; //경로 추적
		for(int i=0; i<=n; i++) {
			dist[i] = INF;
			parent[i] = -1;
		}
		dist[start] = 0;
		for(int i=1; i<=n-1; i++) {
			int curV = findMinIndex();
			visit[curV] = true;
			for(int j=1; j<=n; j++) {
				if(visit[j]) continue;
				if(dist[j] > dist[curV] + graph[curV][j]) {
					dist[j] = dist[curV] + graph[curV][j];
					parent[j] = curV;
				}
			}
		}
		System.out.println(tracking(end));
	}

	static int findMinIndex() {
		int min = INF;
		int index = -1;
		for(int i=1; i<=n; i++) {
			if(visit[i]) continue;
			if(dist[i] <= min) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}

}
