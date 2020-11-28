package baekjoon.아기상어;
import java.io.*;
import java.util.*;
public class Main {
	static int N, map[][], size=2, sy, sx, exp;
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
		int answer = 0;
		int[] info = getFindFish(sy, sx);
		while(info!=null) {
			sy = info[0];
			sx = info[1];
			map[sy][sx] = 0;
			answer += info[2];
			exp++;
			if(exp==size) {
				exp = 0;
				size++;
			}
			info = getFindFish(sy, sx);
		}
		System.out.println(answer);
	}

	static int[] getFindFish(int sy, int sx) {
		int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
		boolean[][] visit = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int out = compareUsingIndex(2, o1, o2);
				if(out!=0) return out;
				out = compareUsingIndex(0, o1, o2);
				if(out!=0) return out;
				return compareUsingIndex(1, o1, o2);
			}
			private int compareUsingIndex(int index, int[] o1, int[] o2){
		        if (o1[index]==o2[index]){return 0;}
		        else if (o1[index]>o2[index]){return 1;}
		        return -1;
		    }
		});
		visit[sy][sx]=true;
		pq.add(new int[] {sy, sx,0});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int y = info[0];
			int x = info[1];
			int move = info[2];
			if(map[y][x]<size && map[y][x]!=0) 
				return new int[] {y, x, move};
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