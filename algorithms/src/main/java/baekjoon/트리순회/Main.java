package baekjoon.트리순회;
import java.io.*;
import java.util.*;
public class Main {
	static class P1991 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, graph[][];
		P1991() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			preorder(0);
			sb.append('\n');
			inorder(0);
			sb.append('\n');
			postorder(0);
		}
		void preorder(int x) {
			if(x==-1) return;
			sb.append((char)(x+'A'));
			preorder(graph[x][0]);
			preorder(graph[x][1]);
		}
		void inorder(int x) {
			if(x==-1) return;
			inorder(graph[x][0]);
			sb.append((char)(x+'A'));
			inorder(graph[x][1]);
		}
		void postorder(int x) {
			if(x==-1) return;
			postorder(graph[x][0]);
			postorder(graph[x][1]);
			sb.append((char)(x+'A'));
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				graph = new int[N][2];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					String p = st.nextToken();
					int cur = p.charAt(0) - 'A';
					for(int j=0; j<2; j++) {
						String lrstr = st.nextToken();
						if(lrstr.equals(".")) {
							graph[cur][j] = -1; 
						} else {
							graph[cur][j] = lrstr.charAt(0) - 'A';
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1991();
	}
}