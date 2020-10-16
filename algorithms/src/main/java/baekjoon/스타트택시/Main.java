package baekjoon.스타트택시;
import java.util.*;
import java.io.*;
public class Main {
	static int N, M, fuel, map[][];
	static int startFuel, endFuel; 
	static ArrayList<int[]> passengerInfo;
	static int si, sj, ei, ej;
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getResult());

	} //end main

	static int getResult() {
		for(int i=0; i<M; i++) {
			if(fuel<=0)
				return -1;
			if(!findPassenger())
				return -1;
			if(!movePassenger())
				return -1;
		}
		return fuel;
	} // end getResult

	static boolean movePassenger() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visit = new boolean[N][N];
		q.add(new int[] {si, sj, 0});
		visit[si][sj] = true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int ci = info[0];
			int cj = info[1];
			int distance = info[2];
			if(startFuel+distance > fuel) return false;
			if(map[ci][cj]==-1) continue;
			if(ci==ei && cj==ej) {
				endFuel = distance;
				fuel = fuel - startFuel - endFuel + (endFuel*2);
				si = ci;
				sj = cj;
				return true;
			}
			for(int i=0; i<4; i++) {
				int ni = ci+dir[i][0];
				int nj = cj+dir[i][1];
				if(ni<0 || nj<0 || ni>=N || nj>=N || map[ni][nj]==-1 || visit[ni][nj]) continue;
				visit[ni][nj] = true;
				q.add(new int[] {ni, nj, distance+1});
			}
		}
		return false;
	} // end movePassenger

	static boolean findPassenger() {
		PriorityQueue<int[]> taxi = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for(int i=0; i<3; i++) {
					int out = compareUsingIndex (i, o1, o2);
					if (out !=0) return out;
				}
				return compareUsingIndex (3, o1, o2);
			}
			private int compareUsingIndex(int index, int[] o1, int[] o2){
				if (o1[index]==o2[index]) return 0;
				else if (o1[index]>o2[index]) return 1;
				return -1;
			}
		});
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visit = new boolean[N][N];
		q.add(new int[] {si, sj, 0});
		visit[si][sj] = true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int ci = info[0];
			int cj = info[1];
			int distance = info[2];
			for(int i=1; i<passengerInfo.size(); i++) 
				if(passengerInfo.get(i)[0]==ci && passengerInfo.get(i)[1]==cj) 
					taxi.add(new int[] {distance, ci, cj, i});
			for(int i=0; i<4; i++) {
				int ni = ci+dir[i][0];
				int nj = cj+dir[i][1];
				if(ni<0 || nj<0 || ni>=N || nj>=N || map[ni][nj]==-1 || visit[ni][nj]) continue;
				visit[ni][nj] = true;
				q.add(new int[] {ni, nj, distance+1});
			}
		}
		if(taxi.size()==0) return false;
		int[] getInfo = taxi.poll();
		int useFuel = getInfo[0];
		int passengerIndex = getInfo[3];
		si = passengerInfo.get(passengerIndex)[0];
		sj = passengerInfo.get(passengerIndex)[1];
		ei = passengerInfo.get(passengerIndex)[2];
		ej = passengerInfo.get(passengerIndex)[3];
		map[si][sj]=0;
		passengerInfo.remove(passengerIndex);
		if(fuel<useFuel)
			return false;
		else
			startFuel= useFuel;
		return true;
	} // end findPassenger
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		si = Integer.parseInt(st.nextToken())-1;
		sj = Integer.parseInt(st.nextToken())-1;
		passengerInfo = new ArrayList<>();
		passengerInfo.add(new int[] {});
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int pi = Integer.parseInt(st.nextToken())-1;
			int pj = Integer.parseInt(st.nextToken())-1;
			int di = Integer.parseInt(st.nextToken())-1;
			int dj = Integer.parseInt(st.nextToken())-1;
			passengerInfo.add(new int[] {pi,pj,di,dj});
		}
	} // end input
}//end class
