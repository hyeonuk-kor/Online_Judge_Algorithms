package baekjoon.친구네트워크;
import java.util.*;
import java.io.*;
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
			parent[a]=b;
	}
	public int find(int x) {
		if(parent[x]==-1)
			return x;
		return parent[x]=find(parent[x]);
	}
}
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.valueOf(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int F = Integer.valueOf(br.readLine());
			int friend[] = new int[2*F+1];
			Arrays.fill(friend, 1);
			DisjointSet set = new DisjointSet(friend.length);
			HashMap<String, Integer> map = new HashMap<>();
			int friendNumber = 1;
			for(int i=0; i<F; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!map.containsKey(name1))
					map.put(name1, friendNumber++);
				if(!map.containsKey(name2))
					map.put(name2, friendNumber++);
				if(set.find(map.get(name1))!=set.find(map.get(name2))) {
					friend[set.find(map.get(name2))] += friend[set.find(map.get(name1))];
					set.union(map.get(name1), map.get(name2));
				}
				pw.println(friend[set.find(map.get(name2))]);
			}
		}
		pw.flush();
	}
}