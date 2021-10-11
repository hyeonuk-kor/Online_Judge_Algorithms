package baekjoon.N과M9;
import java.io.*;
import java.util.*;
public class Main {
	static class P15663 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M, number[], select[];
		boolean visit[];
		String solve() {
			input();
			rec_func(1);
			return sb.toString();
		}
		void rec_func(int depth) {
			if(depth==M+1) {
				for(int i=1; i<=M; i++)
					sb.append(select[i]).append(' ');
				sb.append('\n');
			} else {
				for(int i=1; i<=N; i++) {
					if(!visit[i]) {
						visit[i] = true;
						select[depth] = number[i];
						rec_func(depth+1);
						select[depth] = 0;
						visit[i] = false;
					}
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				number = new int[N+1];
				visit = new boolean[N+1];
				select = new int[M+1];
				st = new StringTokenizer(br.readLine());
				for(int i=1; i<=N; i++) {
					number[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P15663().solve());
	}
}
