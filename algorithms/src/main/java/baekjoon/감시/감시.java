package baekjoon.감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {

	static int N,M;
	static char[][] map;
	static char[][] orimap;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		orimap = new char[N][M];

		int cameraCount = 0;
		List<int[]> list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				orimap[i][j] = st.nextToken().charAt(0);
				if(orimap[i][j]>'0' && orimap[i][j]<'6') {
					list.add(new int[] {i,j,orimap[i][j]-'0'});
					cameraCount++;
				}
			}
		}
		
		int allCaseCount = (int)Math.pow(4, cameraCount);
		int min=N*M;
		
		for (int i = 0; i < allCaseCount ; i++) {
			
			for (int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					map[j][k]=orimap[j][k];
				}
			}
			
			int rePerm = i;
			for (int[] is : list) {
				int dir = rePerm%4;
				rePerm/=4;
				simulate(is[0],is[1],is[2],dir+1);
			}
			
			int zeroCount=0;
			for (int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(map[j][k]=='0') {
						zeroCount++;
					}
				}
			}
			min = Math.min(min, zeroCount);
		}
		
		System.out.println(min);

		
	} // end main

	private static void simulate(int y, int x, int cameraNumber,  int dir) {
		if(cameraNumber==1) {
			if(dir==4) {
				for(int i=y; i>=0; i--)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==3) {
				for(int i=x; i>=0; i--)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			}
		} else if(cameraNumber==2) {
			if(dir==2) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
				return;
			}
		} else if(cameraNumber==3) {
			if(dir==4) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')	
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==3) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==1) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++)
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			}
		} else if(cameraNumber==4) {
			if(dir==4) {
				for(int i=y; i<N; i++)
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==3) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==2) {
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else if(dir==1) {
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} 
		} else if(cameraNumber==5) {
			if(dir==1) {
				for(int i=y; i>=0; i--) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i>=0; i--) 
					if(map[y][i]=='0')	
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
				for(int i=y; i<N; i++) 
					if(map[i][x]=='0')
						map[i][x] = '#';
					else if(map[i][x]=='6')
						break;
				for(int i=x; i<M; i++) 
					if(map[y][i]=='0')
						map[y][i] = '#';
					else if(map[y][i]=='6')
						break;
			} else {
				return;
			}
		}

	} // end simulation


} // end class
