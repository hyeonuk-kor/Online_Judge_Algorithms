package baekjoon.책나눠주기;
import java.io.*;
import java.util.*;
public class Main {
	static class P9576 {
		BufferedReader br;
		PrintWriter pw;
		StringTokenizer st;
		int N, M, student[][], d[];
		boolean check[];
		P9576() {
			input();
			pw.flush();
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=0; t<T; t++) {
					st = new StringTokenizer(br.readLine());
					N = Integer.parseInt(st.nextToken());
					M = Integer.parseInt(st.nextToken());
					student = new int[M+1][];
					for(int i=1; i<=M; i++) {
						st = new StringTokenizer(br.readLine());
						int a = Integer.parseInt(st.nextToken());
						int b = Integer.parseInt(st.nextToken());
						student[i] = new int[b-a+1];
						for(int j=a; j<=b; j++) {
							student[i][j-a] = j;
						}
					}
					solve();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void solve() {
			pw = new PrintWriter(new OutputStreamWriter(System.out));
			d = new int[N+1];
			check = new boolean[N+1];
			int answer = 0;
			for(int i=1; i<=N; i++) {
				if(dfs(i))
					answer++;
			}
			pw.println(answer);
		}
		boolean dfs(int x) {
			for(int i=0; i<student[x].length; i++) {
				int t = student[x][i];
				if(check[t]) continue;
				check[t] = true;
				if(d[t]==0 || dfs(d[t])) {
					d[t] = x;
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		new P9576();
	}
}
