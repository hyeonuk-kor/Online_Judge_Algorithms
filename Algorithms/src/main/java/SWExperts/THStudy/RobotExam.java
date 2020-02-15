package SWExperts.THStudy;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * input
 * N, M
 * Map*(N*N)
 */


public class RobotExam {
	static int N, M;

	static class Robot {
		int[][] map; //로봇의 활동 범위
		boolean[][] visit;
		int day; //이동 가능한 날
		int y; //현재 y 위치
		int x; //현재 x 위치
		int dir; //로봇의 방향
		int work; //작업 가능한 양

		public Robot(int[][] map,boolean[][] visit, int day, int y, int x, int dir, int work) {
			this.map = map;
			this.visit = visit;
			this.day = day;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.work = work;
		}

		public Robot(int y, int x) {
			this.y = y;
			this.x = x;
		}

		void moved(int dy, int dx) {
			x += dx;
			y += dy;
		}
		
		boolean isAvailable(int y, int x) {
			return (0 <= x && x < N && 0 <= y && y < N) && (map[y][x]!=-1) && (!visit[y][x]);
		}

		
		public boolean equals(Object obj) {
			Robot robot = (Robot)obj;
			return x==robot.x && y==robot.y;
		}
		
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
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
				for(int dir=0; dir<4; dir++) {
					r = new Robot(map, visit, M, i, j, dir, 0);
					dfs(r);
					if(answer<r.work)
						answer = r.work;
				}
			}
		}

		System.out.println(answer);

	}

	private static void dfs(Robot r) {
		if(r.day>M)
			return;
		if(!r.isAvailable(r.y, r.x)) {
			return;
		} else {
			Queue<int[]> q = new LinkedList<>();
			boolean check = false;
			for(int dir=0; dir<4; dir++) {
				//오전
				Robot tmp = null;
				if(r.map[r.y][r.x]==0) { //빈 농지?
					for(int ndir=0; ndir<4; ndir++) { //갈 수 있는 방향이 존재하는가?
						tmp = simulation(ndir, r);
						if(r.equals(tmp)) check = false;
						else {
							check = true;
							break;
						}
					}
					if(check) {
						if(r.map[r.x][r.y]>=3) {
							r.work++;
							r.map[r.x][r.y]=0;
						}
						r.visit[r.x][r.y]=true;
						q.add(new int[] {r.y, r.x}); //갈 수 있는 방향이 존재 -> 씨앗뿌림
					}
				}
				//오후
				if(check) {
					while(!q.isEmpty()) {
						int[] temp = q.poll();
						r.map[temp[0]][temp[1]]++;
					}
					r.day++;
					r = tmp;
					dfs(r);
				}
				
			}
		}
	}

	
	static Robot simulation(int dir, Robot r) {		
		switch(dir) {
			case 0:
				r.moved(0,1);
				break;
			case 1:
				r.moved(-1,0);
				break;
			case 2:
				r.moved(0,-1);
				break;
			case 3:
				r.moved(1,0);
				break;
		}
	
		if(!r.isAvailable(r.y, r.x)) {
			switch(dir) {
				case 0:
					r.moved(0,-1);
					break;
				case 1:
					r.moved(1,0);
					break;
				case 2:
					r.moved(0,1);
					break;
				case 3:
					r.moved(-1,0);
					break;
			}
		}	
		return r;
	}
}

