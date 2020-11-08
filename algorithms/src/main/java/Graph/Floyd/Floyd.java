package Graph.Floyd;
public class Floyd {	
	static final int INF = (int)1e9; // 10억을 무한으로 취급
	public static void main(String[] args) throws Exception {
		int n = 3;
		int[][] graph = {	//ppt 속의 그림
				{  0,  INF,  5  },
				{  7,   0,  INF },
				{  20,  8,   0  },
		};
		
		for(int k=0; k<n; k++) { // 거쳐가는 정점
			for(int a=0; a<n; a++) { // 출발지
				for(int b=0; b<n; b++) { // 목적지
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		//결과 출력
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
