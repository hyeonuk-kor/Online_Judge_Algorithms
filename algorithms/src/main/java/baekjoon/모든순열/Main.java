package baekjoon.모든순열;
import java.io.*;
import java.util.*;
public class Main {
	static class P10974 {
		BufferedReader br;
		StringBuilder sb;
		int N, select[];
		boolean check[];
		P10974() {
			sb = new StringBuilder();
			input();
			solve();
			System.out.println(sb);
		}
		void solve() {
			select = new int[N];
			check = new boolean[N+1];
			dfs(0);
		}
		void dfs(int depth) {
			if(depth==N) {
				for(int i=0; i<N; i++)
					sb.append(select[i]).append(' ');
				sb.append('\n');
			} else {
				for(int i=1; i<=N; i++) {
					if(!check[i]) {
						check[i] = true;
						select[depth] = i;
						dfs(depth+1);
						check[i] = false;
					}
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10974();
	}
}