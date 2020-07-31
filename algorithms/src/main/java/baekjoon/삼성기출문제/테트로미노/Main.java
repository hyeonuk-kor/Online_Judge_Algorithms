package baekjoon.삼성기출문제.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int max = 0;
	
	static int[][][][] tetroMino = {
			
			// iMino
			{
				{{0,0}, {0,1}, {0,2}, {0,3}},
				{{0,0}, {1,0}, {2,0}, {3,0}}
			},
			
			// oMino
			{
				{{0,0}, {0,1}, {1,0}, {1,1}}
			},
	
			// sMino
			{
				{{0,0}, {1,0}, {1,1}, {2,1}},
				{{0,0}, {0,1}, {-1,1}, {-1,2}}
			},

			// zMino 
			{
				{{0,0}, {0,1}, {1,1},{1,2}},
				{{0,0}, {1,0}, {1,-1}, {2,-1}}
			},	
			
			// tMino
			{
				{{0,0}, {0,-1}, {0,1}, {-1,0}},
				{{0,0}, {-1,0}, {1,0}, {0,1}},
				{{0,0}, {0,-1}, {0,1}, {1,0}},
				{{0,0}, {-1,0}, {1,0}, {0,-1}}
			},
			
			// jMino
			{
				{{0,0}, {0,1}, {-1,1}, {-2,1}},
				{{0,0}, {1,0}, {1,1}, {1,2}},
				{{0,0}, {0,1}, {1,0}, {2,0}},
				{{0,0}, {0,1}, {0,2}, {1,2}}
			},
			
			// lMino
			{
				{{0,0},{1,0},{2,0},{2,1}},
				{{0,0},{0,1},{0,2},{1,0}},
				{{0,0},{0,1},{1,1},{2,1}},
				{{0,0},{0,1},{0,2},{-1,2}}
			}
			
	};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N+6][M+6];
		
		for(int i=3; i<N+3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=3; j<M+3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int j=3; j<M+3; j++) {
			for(int i=3; i<N+3; i++) {
				getMax(i,j);
			}
		}
		
		System.out.println(max);
	
	}

	private static void getMax(int i, int j) {
		for (int k = 0; k < tetroMino.length; k++) {
			for (int l = 0; l < tetroMino[k].length; l++) {
				int sum = 0;
				for (int m = 0; m < tetroMino[k][l].length; m++) {
					int ni = i + tetroMino[k][l][m][0];
					int nj = j + tetroMino[k][l][m][1];
					sum += map[ni][nj];					
					max = Integer.max(sum, max);
				}
			}
		}
	}

}
