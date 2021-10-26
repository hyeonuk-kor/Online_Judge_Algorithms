package baekjoon.N과M.N과M_01;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P15649 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M;
		int[] select;
		boolean[] check;
		void solve() {
			input();
			sb = new StringBuilder();
			rec_func(1, M);
			System.out.println(sb);
		}
		void rec_func(int index, int K) {
			if(index==K+1) {
				for(int i=1; i<=M; i++) {
					sb.append(select[i]).append(' ');
				}
				sb.append('\n');
				return;
			} else {
				for(int i=1; i<=N; i++) {
					if(!check[i]) {
						check[i] = true;
						select[index] = i;
						rec_func(index+1, K);
						select[index] = 0;
						check[i] = false;
					}
				}
			}
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				select = new int[N+1];
				check = new boolean[N+1];
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P15649().solve();
	}
} // end Main Class
