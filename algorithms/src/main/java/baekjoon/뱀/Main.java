package baekjoon.뱀;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[2*L+1][2*L+1]; // Heap Overflow...
		int mi=L, mj=L;
		int di = 0;
		int dj = 1;
		int dir = 0;
		int time = 1;
		map[mi][mj]=true;

		if(N==0) System.out.println(L+1);
		else {
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int curTime = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				
				for(int t=time; t<time+curTime; t++) {
					int ni = mi + di;
					int nj = mj + dj;
					if(ni<0 || ni >= 2*L+1 || nj<0 || nj>=2*L+1 || map[ni][nj]) {
						System.out.println(t);
						System.exit(0);
					} else {
						map[ni][nj]=true;
						mi = ni;
						mj = nj;
					}
				}
				time += curTime;
				if(s.equals("L")) {
					if(dir==0) {
						dir = 1;
						di = -1;
						dj = 0;
					} else if(dir==1) {
						dj = -1;
						di = 0;
						dir = 2;
					} else if(dir==2) {
						di = 1;
						dj = 0;
						dir = 3;
					} else {
						dj = 1;
						di = 0;
						dir = 0;
					}
				} else {
					if(dir==0) {
						di = 1;
						dj = 0;
						dir = 3;
					} else if(dir==1) {
						di = 0;
						dj = 1;
						dir = 0;
					} else if(dir==2) {
						di = -1;
						dj = 0;
						dir = 1;
					} else {
						di = 0;
						dj = -1;
						dir = 2;
					}
				} 
			}
		}
		
		for(int t=time; ;t++) {
			int ni = mi + di;
			int nj = mj + dj;
			if(ni<0 || ni >= 2*L+1 || nj<0 || nj>=2*L+1 || map[ni][nj]) {
				System.out.println(t);
				System.exit(0);
			} else {
				map[ni][nj]=true;
				mi = ni;
				mj = nj;
			}
		}
		
	}
}

/*
 * 
 */ 
