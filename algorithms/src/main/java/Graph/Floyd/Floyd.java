package Graph.Floyd;

public class Floyd {
	
	static final int INF = (int)1e9;
	public static void main(String[] args) throws Exception {
		int n = 3;
		int[][] graph = {
				{  0,  INF,  5  },
				{  7,   0,  INF },
				{  20,  8,   0  },
		};
		
		for(int k=0; k<n; k++) {
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for(int a=0; a<n; a++) {
			for(int b=0; b<n; b++) {
				if(graph[a][b]==INF) {
					System.out.println(a+"에서 "+b+"로 갈 수 없습니다.");
				} else {
					System.out.print(graph[a][b]+" ");
				}
			}
			System.out.println();
		}
	}
	
}
