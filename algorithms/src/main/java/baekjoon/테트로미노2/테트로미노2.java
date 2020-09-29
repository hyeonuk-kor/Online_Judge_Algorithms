package baekjoon.테트로미노2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노2 {
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
	private static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+6][M+6];

		for(int i=3; i<N+3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=3; j<M+3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for(int j=3; j<M+3; j++) {
			for(int i=3; i<N+3; i++) {
				for(int k=3; k<M+3; k++) {
					for(int l=3; l<N+3; l++) {
						dfs(i,j,l,k);
					}
				}
			}
		}

		System.out.println(max);

	}

	private static void dfs(int i, int j, int i2, int j2) {
		for (int k = 0; k < tetroMino.length; k++) {
			for (int l = 0; l < tetroMino[k].length; l++) {
				int sum1 = 0, sum2 = 0;
				boolean[][] check = new boolean[N+6][M+6];
				for (int m = 0; m < tetroMino[k][l].length; m++) {
					int ni = i + tetroMino[k][l][m][0];
					int nj = i + tetroMino[k][l][m][1];
					check[ni][nj]=true;
					sum1 += map[ni][nj];
				}
				for (int p = 0; p < tetroMino[k][l].length; p++) {
					int pi = i2 + tetroMino[k][l][p][0];
					int pj = j2 + tetroMino[k][l][p][1];
					if(check[pi][pj]) {
						for(int q=0; q<=p; q++) {
							int qi = i2 + tetroMino[k][l][q][0];
							int qj = j2 + tetroMino[k][l][q][1];
							check[qi][qj]=false;
						}
						sum2=0;
					} else {
						check[pi][pj] = true;
						sum2 += map[pi][pj];					
					}
				}
				max = Integer.max(sum1+sum2, max);
			}
		}
	}
}
