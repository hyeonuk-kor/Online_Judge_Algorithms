package baekjoon.공항;
import java.io.*;
import java.util.*;
class DisjointSet {
	private int parent[];
	public DisjointSet(int v) {
		parent = new int[v+1];
		Arrays.fill(parent, -1);
	}
	public void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a] = b;
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
		int G = Integer.valueOf(br.readLine());
		int P = Integer.valueOf(br.readLine());
		DisjointSet set = new DisjointSet(G);
		int answer = 0;
		for(int i=0; i<P; i++) {
			int plane = Integer.valueOf(br.readLine());
			int dock = set.find(plane);
			if(dock-1<0)
				break;
			set.union(plane, dock-1);
			answer++;
		}
		System.out.println(answer);
	}
}