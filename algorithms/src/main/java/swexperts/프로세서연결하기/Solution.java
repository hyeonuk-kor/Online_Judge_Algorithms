package swexperts.프로세서연결하기;
import java.io.*;
import java.util.*;
class Solution {
	static int size, map[][], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static int maxCore=Integer.MIN_VALUE, minLength=Integer.MAX_VALUE;
	static ArrayList<int[]> core;
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			core = new ArrayList<>();
			for(int i=0; i<size; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0 || j==0 || i==size-1 || j==size-1) 
							continue;
						core.add(new int[] {i, j});
					}
				}
			}
			solve(0,0);
			bw.append("#"+tc+" "+minLength+"\n");
		}
		bw.flush();
	}
	static void solve(int depth, int connect) {
		if(depth==core.size()) {
			if(maxCore<connect) {
				maxCore = connect;
				minLength = getLength();
			} else if(maxCore==connect) {
				minLength = Math.min(getLength(), minLength);
			}
			return;
		}
		int y = core.get(depth)[0];
		int x = core.get(depth)[1];
		for(int d=0; d<4;d++) {
			if(check(y,x,d)) {
				isConnected(y,x,d,2);
				solve(depth+1, connect+1);
				isConnected(y,x,d,0);
			} 
		}
		solve(depth+1, connect);
	}
	static int getLength() {
		int length = 0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j]==2)
					length++;
			}
		}
		return length;
	}
	static void isConnected(int y, int x, int d, int cover) {
		while(true) {
			y += dir[d][0];
			x += dir[d][1];
			if(y<0 || x<0 || y>=size || x>=size)
				break;
			map[y][x]=cover;
		}
	}
	static boolean check(int y, int x, int d) {
		while(true) {
			y += dir[d][0];
			x += dir[d][1];
			if(y<0 || x<0 || y>=size || x>=size) return true;
			if(map[y][x]>=1) break;
		}
		return false;
	}
}