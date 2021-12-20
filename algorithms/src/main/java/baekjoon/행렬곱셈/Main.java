package baekjoon.행렬곱셈;
import java.io.*;
import java.util.*;
public class Main {
	static class P2740 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, K, A[][], B[][];
		P2740() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<K; j++) {
					int calc = 0;
					for(int k=0; k<M; k++) {
						calc += A[i][k] * B[k][j];
					}
					sb.append(calc).append(' ');
				}
				sb.append('\n');
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				A = new int[N][M];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<M; j++) {
						A[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				st = new StringTokenizer(br.readLine().trim());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				B = new int[M][K];
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<K; j++) {
						B[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2740();
	}
}