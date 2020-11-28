package baekjoon.아기상어;
import java.io.*;
import java.util.*;
public class Main {
	static int N, map[][], size=2, sy, sx, exp;
	static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					sy = i;	sx = j;
				}
			}
		}
		System.out.println(simulate());
	}
	static int simulate() {
		int move = 0;
		pqInit();
		int[] info = getFindFish(sy, sx);
		while(info!=null) { // 먹을 수 있는 물고기가 없을 때 까지
			sy = info[0]; sx = info[1]; map[sy][sx] = 0; //물고기를 먹은 곳으로부터 다시 시작
			move += info[2]; //이동한 거리를 더함.
			exp++; //먹었으니 경험치 증가
			if(exp==size) { //경험치가 해당 상어의 사이즈가 되면 레벨업한다.
				exp = 0;
				size++;
			}
			info = getFindFish(sy, sx); //다시 물고기를 찾는다.
		}
		return move;
	}
	static void pqInit() {
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			int result = 0;
			@Override
			public int compare(int[] o1, int[] o2) {
				result = compareUsingIndex(2, o1, o2);
				if(result!=0) 
					return result;	// 거리가 가까운 물고기 우선
				result = compareUsingIndex(0, o1, o2);
				if(result!=0) 
					return result;	// 가까운 물고기가 여럿일 땐 가장 위에 있는 물고기 우선
				return compareUsingIndex(1, o1, o2); // 위 두 조건을 동시에 성립할 때, 가장 왼쪽 우선 
			}
			private int compareUsingIndex(int index, int[] o1, int[] o2) {
		        return o1[index]-o2[index];
		    }
		});
	}
	static int[] getFindFish(int sy, int sx) {
		int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
		boolean[][] visit = new boolean[N][N];
		visit[sy][sx]=true;
		pq.add(new int[] {sy, sx,0});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int y = info[0];
			int x = info[1];
			int move = info[2];
			if(map[y][x]<size && map[y][x]!=0) {
				pq.clear();
				return new int[] {y, x, move};
			}
			for(int d=0; d<4; d++) {
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx]>size) continue;
				visit[ny][nx] = true;
				pq.add(new int[] {ny, nx, move+1});
			}
		}
		return null;
	}
}