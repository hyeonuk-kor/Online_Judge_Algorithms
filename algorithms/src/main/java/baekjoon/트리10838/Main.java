package baekjoon.트리10838;
import java.io.*;
import java.util.*;
public class Main {
	static class P10838 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, K, r, a, b, c, parent[], color[], v[];
		boolean check[];
		P10838() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				parent = new int[N+1];
				color = new int[N+1];
				v = new int[N+1];
				check = new boolean[N+1];
				for(int k=0; k<K; k++) {
					st = new StringTokenizer(br.readLine().trim());
					r = Integer.parseInt(st.nextToken());
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					if(r==1) {
						c = Integer.parseInt(st.nextToken());
						int lca = getLca(a, b);
						paint(lca, a, c);
						paint(lca, b, c);
					} else {
						if(r==2) {
							move(a, b);
						} else {
							sb.append(count(a, b)).append('\n');
						}
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void paint(int a, int b, int c) {
			int node = b;
			if(a==b)
				return;
			while(node!=a) {
				color[node] = c;
				node = parent[node];
			}
		}
		void move(int a, int b) {
			parent[a] = b;
		}
		int count(int a, int b) {
			Set<Integer> set = new HashSet<>();
			int lca = getLca(a, b);
			while(a!=lca) {
				set.add(color[a]);
				a = parent[a];
			}
			while(b!=lca) {
				set.add(color[b]);
				b = parent[b];
			}
			return set.size();
		}
		int getLca(int a, int b) {
			int node = a, number = 0;
			for(int i=0; i<=1000 && i<v.length; i++) {
				check[node] = true;
				v[i] = node;
				node = parent[node];
			}
			node = b;
			for(int i=0; i<=1000; i++) {
				if(check[node]) {
					number = node;
					break;
				}
				node = parent[node];
			}
			for(int i=0; i<=1000 && i<v.length; i++)
				check[v[i]] = false;
			return number;
		}
	}
	public static void main(String[] args) {
		new P10838();
	}
}