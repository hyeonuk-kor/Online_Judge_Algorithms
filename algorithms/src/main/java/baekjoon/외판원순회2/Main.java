package baekjoon.외판원순회2;
import java.io.*;
import java.util.*;
public class Main {
	static class P10971 {
		BufferedReader br;
		StringTokenizer st;
		int n, graph[][], select[], answer=Integer.MAX_VALUE;
		boolean visit[];
		int solve() {
			input();
			rec_func(1);
			return answer;
		}
		private void rec_func(int k) {
			if(k==n+1) {
				int sum = 0;
				int start = select[1];
				int end = select[n];
				for(int i=1; i<=n-1; i++) {
					int from = select[i];
					int to = select[i+1];
					sum += graph[from][to];
				}
				sum += graph[end][start];
				answer = Math.min(answer, sum);
				return;
			} else {
				for(int i=1; i<=n; i++) {
					if(!visit[i]) {
						select[k] = i;
						visit[i] = true;
						rec_func(k+1);
						visit[i] = false;
						select[k] = 0;
					}
				}
			}
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				n = Integer.parseInt(br.readLine());
				graph = new int[n+1][n+1];
				select = new int[n+1];
				visit = new boolean[n+1];
				for(int i=1; i<=n; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=1; j<=n; j++) {
						graph[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P10971().solve());
	}
}
