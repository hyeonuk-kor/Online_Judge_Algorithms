package baekjoon.집합의표현;
import java.io.*;
import java.util.*;
class DisjointSet{
	private int[] parent;
	public DisjointSet(int v) {
		parent = new int[v+1];
		Arrays.fill(parent, -1);
	}
	public void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a]=b;
	}
	public int find(int x) {
		if(parent[x]==-1)
			return x;
		return parent[x] = find(parent[x]);
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		DisjointSet set = new DisjointSet(n);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int cmd = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			if(cmd==0) {
				set.union(a, b);
			} else {
				if(set.find(a)==set.find(b))
					pw.println("YES");
				else
					pw.println("NO");
			}
		}
		pw.flush();
	}
}