package swexperts.디저트카페;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Solution2 {
	
	static int N;					//맵 크기
	static int max;					// 디저트를 먹은 최대 개수
	static int sr;					// 시작 좌표
	static int sc;					// 시작 좌표
	static int[][] map ;			// 
	static boolean[] visit ;		// 방문 처리 
	
	//우하 -> 좌하 -> 좌상 -> 우상
	static int[][] direction = {{1,1},{1,-1},{-1,-1},{-1,1}};
	
	public static void main(String[] args) throws Exception{
//		입력처리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc =1 ;tc<=T; tc++) {
//			max를 0으로 초기화
			max = 0;
//			N을 입력받아 N*N 배열을 생성
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
//			먹은 디저트 중복체크, 방문체크
			visit = new boolean[101];
//			데이터 읽기
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//		탐색(dfs)
//			N*N을 반복 돌면서 i j번째의 카페부터 투어
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
//			  		시작 좌표를 i,j로 설정
					sr = i;
					sc = j;
//			  		set을 초기화
//					visit 초기화
					Arrays.fill(visit, false);
//			 	 	dfs 탐색(i,j,d)
					dfs(i,j,0,1);
				}
			}
//		출력 max==0?-1:max
			System.out.println("#"+tc+" "+(max==0?-1:max));
		}
	}

	private static void dfs(int r, int c, int dir, int cnt) {
//		현재 노드의 대한 방문 표시
		visit[map[r][c]] = true;
//   	현재 방향에서 부터 <4 반복하면서
		for(int d=dir; d<4; d++) {
			int nr = r + direction[d][0];
			int nc = c + direction[d][1];
//		   	다음 좌표가 시작좌표이고 cnt>=4이상인지 검사 => 한바퀴를 탐색
			if(nr==sr && nc==sc && cnt>=4) {
//				cnt를 max값과 비교해서 갱신
				if(cnt > max) {
					max = cnt;
					return;
				}
			}
//			다음 좌표가 경계내에 있고, 방문한 적이 없고, 처음 먹어보는 디저트인지 검사
			if(nr > -1 && nr < N && nc > -1 && nc < N 
					&& !visit[map[nr][nc]] ) {
//				다음노드로 이동 => 재귀 호출
				dfs(nr, nc, d, cnt+1);
			}
		}
		
//		visit 배열에서 현재 노드의 대한 방문 표시한 것을 해제
		visit[map[r][c]] = false;
		
	}
	
}