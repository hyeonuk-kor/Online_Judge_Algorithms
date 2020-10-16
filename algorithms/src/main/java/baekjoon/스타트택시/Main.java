package baekjoon.스타트택시;
import java.util.*;
import java.io.*;
public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					map[i][j]=INF;
			}
		}

		Queue<int[]> taxi = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0])
					return 1;
				else if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				} else {
					return -1;
				}
			}
		});
		st = new StringTokenizer(br.readLine());
		int ti = Integer.parseInt(st.nextToken());
		int tj = Integer.parseInt(st.nextToken());
		taxi.add(new int[] {ti, tj, fuel});
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int pi = Integer.parseInt(st.nextToken());
			int pj = Integer.parseInt(st.nextToken());
			map[pi][pj] = i;
			int di = Integer.parseInt(st.nextToken());
			int dj = Integer.parseInt(st.nextToken());
			map[di][dj] = -i;
		}
		
		int answer = -1;
		int dir[][] = {
				{1,0},
				{-1,0},
				{0,1},
				{0,-1}
		};
		while(!taxi.isEmpty()) {
			int tInfo[] = taxi.poll();
			int cti = tInfo[0];
			int ctj = tInfo[1];
			int ctf = tInfo[2];
			if(map[cti][ctj]>0) {
				Queue<int[]> passenger = new ArrayDeque<>();
				passenger.add(new int[] {cti, ctj, map[cti][ctj]});
				map[cti][ctj]=0;
				while(!passenger.isEmpty()) {
					int[] pInfo = passenger.poll();
					int mi = pInfo[0];
					int mj = pInfo[1];
					int num = pInfo[2];
					if(map[mi][mj]==-num) break;
					for (int i = 0; i < dir.length; i++) {
						int ni = mi + dir[i][0];
						int nj = mj + dir[i][1];
						if(ni<0 || nj<0 || ni>=N || nj>=N || )
					}
				}
			}
			if(ctf==0) break;
			for (int i = 0; i < dir.length; i++) {
				int ni = cti + dir[i][0];
				int nj = ctj + dir[i][1];
			}
			break;
		}
		
		System.out.println(answer);
		
	}//end main
}//end class
