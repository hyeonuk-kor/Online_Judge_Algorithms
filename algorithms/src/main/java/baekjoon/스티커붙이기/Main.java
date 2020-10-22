package baekjoon.스티커붙이기;
import java.util.*;
import java.io.*;
public class Main {
	static int N, M, K, answer;
	static int notebook[][], sticker[][][][];
	public static void main(String[] args) throws Exception {
		input();
		stickerInit();
		simulate();
		System.out.println(answer);
	}
	static void simulate() {
		stickerInit();
		for(int i=0; i<K; i++) { 
			for(int j=0; j<4; j++) {
				System.out.println(i+" "+j);
				if(isAttahced(i,j)) {
					break; // 다음 스티커 붙이기
				}
			}
		}
		getSum(); // 합계 구하기
	}
	private static void stickerInit() {
		for(int i=0; i<K; i++) {
			for(int j=1; j<4; j++) {
				int y = sticker[i][j-1].length;
				int x = sticker[i][j-1][y-1].length; 
				int[][] temp = new int[x][y];
				for(int k=0; k<x; k++) {
					for(int l=0; l<y; l++) {
						temp[k][l] = sticker[i][j-1][y-l-1][k];
					}
				}
				sticker[i][j] = temp.clone();
			}
		}
	}
	static void getSum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(notebook[i][j]!=0) {
					answer++;
				}
			}
		}
	}
	static boolean isAttahced(int n, int dir) {
		int temp[][] = deepCopy(notebook);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
			}
		}
		return false;
	}

	static int[][] deepCopy(int[][] temp) {
		int[][] copyMap = new int[temp.length][];
		for(int i=0; i<temp.length; i++) {
			int len = temp[i].length;
			copyMap[i] = new int[len];
			for(int j=0; j<len; j++) {
				copyMap[i][j] = temp[i][j];
			}
		}
		return copyMap;
	}
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		notebook = new int[N][M];
		sticker = new int[K][4][][];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sticker[i][0] = new int[r][c];
			sticker[i][1] = new int[c][r];
			sticker[i][2] = new int[r][c];
			sticker[i][3] = new int[c][r];
			for(int j=0; j<r; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<c; k++) {
					sticker[i][0][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
	}
}