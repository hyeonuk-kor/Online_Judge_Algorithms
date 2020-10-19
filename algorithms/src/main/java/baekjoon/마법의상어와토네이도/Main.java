package baekjoon.마법의상어와토네이도;
import java.io.*;
import java.util.*;
public class Main {
	static int N, map[][], sharkMap[][], blowMap[][][], answer;
	
	public static void main(String[] args) throws Exception {
	//	input();
		// blowingInit();
		sharkMoveInit();
		//simulate();
		//System.out.println(answer);
	}

	static void sharkMoveInit() {
		N=3;
		sharkMap = new int[N][N];
		int cnt = N*N;
		int rowIndex = 0, colIndex = 0;
		int adjustIdx = 0;
		while(cnt>0) {
			while(colIndex+adjustIdx!=N-adjustIdx) {
				sharkMap[rowIndex][colIndex++] = cnt--;
			}
			rowIndex++;
			colIndex--;
			while(rowIndex+adjustIdx!=N-adjustIdx) {
				sharkMap[rowIndex++][colIndex] = cnt--;
			}
			rowIndex--;
			colIndex--;
			while(colIndex+adjustIdx>=adjustIdx) {
				sharkMap[rowIndex][colIndex--] = cnt--;
			}
			colIndex++;
			rowIndex--;
			while(rowIndex-adjustIdx>=adjustIdx+1) {
				sharkMap[rowIndex--][colIndex] = cnt--;
			}
			rowIndex++;
			colIndex++;
			adjustIdx++;
		}
		for(int i=0; i<3; i++) {
			System.out.println(Arrays.toString(sharkMap[i]));
		}
	}

	static void blowingInit() {
		final int BLANK = -999;
		final int ALPHA = -111;
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
			blowMap[dir] = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					blowMap[dir][N-j-1][i] = blowMap[dir-1][i][j];
				}
			}
		}
		/* 
		 0:서쪽	1:남쪽	2: 동쪽	3: 북쪽
		*/
	}

	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N+4][N+4];
		for(int i=2; i<N+2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=2;j<N+2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	} // end input

}
