package baekjoon.사이클게임;
import java.io.*;
import java.util.*;
public class Main {
	static class Solution {
		static class DisjointSet {
			int p[];
			public DisjointSet(int v) {
				p = new int[v];
				Arrays.fill(p, -1);
			}
			void union(int a, int b) {
				a = find(a);
				b = find(b);
				if(a!=b)
					p[a] = b;
			}
			int find(int number) {
				if(p[number]==-1)
					return number;
				return p[number] = find(p[number]);
			}
		}
		int solve() throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int answer = 0;
			DisjointSet s = new DisjointSet(N);
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int root1 = s.find(a);
				int root2 = s.find(b);
				if(root1==root2) {
					answer = i+1;
					break;
				} else {
					s.union(root1, root2);
				}
			}
			return answer;
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println(new Solution().solve());
	}
}