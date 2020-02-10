import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * input
 * N, M
 * Map*(N*N)
 */


public class Main {
	static int[][] map;
	static int N, M;

	static class Robot {
		int day; //이동 가능한 날
		int y; //현재 y 위치
		int x; //현재 x 위치
		int work; //작업 가능한 양

		public Robot(int day, int y, int x, int work) {
			this.day = day;
			this.y = y;
			this.x = x;
			this.work = work;
		}

		void move(int dy, int dx, int dir) {
			switch (dir) {
			case 0:   //오른쪽
				x++;
				break;
			case 1:   //앞
				y--;
				break;
			case 2:   //왼쪽
				x--;
				break;
			default:  //뒤
				y++;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int answer = 0;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<N; j++) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}

		Robot r = null;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				r = new Robot(M, i, j, 0);
				dfs(r);
				if(answer<r.work)
					answer = r.work;
			}
		}
		
		System.out.println(answer);

	}

	private static void dfs(Robot r) {
		if(!isAvailable(r.y, r.x)) {
			return;
		} else {
			for(int i=0; i<4; i++) {
				//오전
				r.move(r.x, r.y, i);
				if(!isAvailable(r.y, r.x)) {
					if(i==0) r.move(r.y, r.x, 2);
					else if(i==1) r.move(r.y, r.x, 3);
					else if(i==2) r.move(r.y, r.x, 0);
					else r.move(r.y, r.x, 1);
					return;
				}
				
				if(map[r.y][r.x]==3) {//수확
					map[r.y][r.x]=0;
					r.work++;
				} 
				
				//오후
				if(map[r.y][r.x]>-1) {
					dfs(r);
				}
				
			}
		}
	}

	static boolean isAvailable(int x, int y) {
		if(0 <= x && x < N && 0 <= y && y < N)
			return false;
		return map[y][x]!=-1;
	}
}

