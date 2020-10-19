package baekjoon.마법의상어와토네이도;
import java.io.*;
import java.util.*;
public class Main {
	static int N, map[][], skill[][], move[][], blowMap[][][], answer;
	static final int WEST=0, SOUTH=1, EAST=2, NORTH=3;
	static final int BLANK = -999, ALPHA = -111;
	public static void main(String[] args) throws Exception {
		input();
		blowingInit();
		sharkInfoInit();
		simulate();
		System.out.println(answer);
	}

	static void simulate() {
		Queue<int[]> q = new ArrayDeque<>();
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		q.add(new int[] {(N/2), ((N/2)), 1});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int si = info[0];
			int sj = info[1];
			if(si==0 && sj==0) break;
			int snum = info[2];
			useTornado(si+2, sj+2, skill[si][sj]);
			for(int i=0; i<4; i++) {
				int ni = si + di[i];
				int nj = sj + dj[i];
				if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
				else if(move[ni][nj]==snum+1) {
					q.add(new int[] {ni, nj, move[ni][nj]});
					break;
				}
			}
		}
		for(int i=0; i< N; i++) {
			for(int j=0; j< N; j++) {
				if(i<2 || i>=N+2 || j<2 || j>=N+2)
					answer+=map[i][j];
			}
		}
	}

	static void useTornado(int y, int x, int dir) {
		int bi = 0, bj = 0;
		int curMount = 0;
		
		if(dir==0) {
			curMount = map[y][x-1]; bi = y-2; bj = x-3;
		} else if(dir==1) {
			curMount = map[y+1][x]; bi = y-1; bj = x-2; 
		} else if(dir==2) {
			curMount = map[y][x+1]; bi = y-2; bj = x-1; 
		} else {
			curMount = map[y-1][x]; bi = y-3; bj = x-2;
		}
		
		int sum = 0, ai = ALPHA, aj = ALPHA;
		for(int i=bi, ii=0; i<bi+5; i++, ii++) {
			for(int j=bj, jj=0; j<bj+5; j++, jj++) {
				int percent = 0;
				if(blowMap[dir][ii][jj]!=BLANK && blowMap[dir][ii][jj]!=ALPHA)
					percent = blowMap[dir][ii][jj];
				if(blowMap[dir][ii][jj]==ALPHA) {
					ai = i; aj = j;
					continue;
				}
					
				sum += (curMount * percent / 100);
				map[i][j] += (curMount * percent / 100);
			}
		}
		
		if(ai!=ALPHA && aj!=ALPHA) {
			map[ai][aj] += curMount - sum;
		}
		
		if(dir==0) map[y][x-1] = 0;
		else if(dir==1) map[y+1][x] = 0;
		else if(dir==2) map[y][x+1] = 0;
		else map[y-1][x] = 0;
		
	}

	static void sharkInfoInit() {
		int cnt = N*N;
		skill = new int[N][N];
		move = new int[N][N];
		int rowIndex = 0, colIndex = 0;
		for(int i=0; i<N; i++) {
			while(colIndex-i<N-i*2) { 
				move[rowIndex][colIndex] = cnt--;
				skill[rowIndex][colIndex++] = WEST;
			}
			rowIndex++;	colIndex--;
			
			while(rowIndex<N-i) {
				move[rowIndex][colIndex] = cnt--;
				skill[rowIndex++][colIndex] = NORTH;
			}
			rowIndex--;	colIndex--;
			
			while(colIndex>=i)  {
				move[rowIndex][colIndex] = cnt--;
				skill[rowIndex][colIndex--] = EAST;
			}
			rowIndex--;	colIndex++;
			
			while(rowIndex>i) {
				move[rowIndex][colIndex] = cnt--;
				skill[rowIndex--][colIndex] = SOUTH;
			}
			rowIndex++;	colIndex++;
		}
	}

	static void blowingInit() {
		blowMap = new int[4][][];
		blowMap[0] = new int[][] {
			{BLANK, BLANK, 2, BLANK, BLANK},
			{BLANK,  10  , 7,   1  , BLANK},
			{  5,   ALPHA, 0, BLANK, BLANK},
			{BLANK,  10,   7,   1,   BLANK},
			{BLANK, BLANK, 2, BLANK, BLANK}
		};
		//90도 회전시키면서 바람방향 정의
		for(int dir=1; dir<4; dir++) {
			blowMap[dir] = new int[5][5];
			for(int i=0; i<5; i++) {
				for(int j=4; j>=0; j--) {
					blowMap[dir][4-j][i] = blowMap[dir-1][i][j];
				}
			}
		}
	}

	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+4][N+4];
		for(int i=2; i<N+2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=2;j<N+2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	} // end input

}
