package baekjoon.showmethecode.p2;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	static int N, Q, w[], e;
	static List<Integer>[] tree;
	static boolean visit[];
	static StringBuilder sb;
	static class Node {
		int x;
		String s;
		public Node(int x, String s) {
			this.x = x;
			this.s = s;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		w = new int[N+1];
		tree = new ArrayList[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
			w[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}
		for(int i=0; i<Q; i++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new boolean[N+1];
			go(s);
			BigInteger b = new BigInteger(sb.toString());
			BigInteger m = new BigInteger("1000000007");
			System.out.println(b.mod(m));
		}
	}
	static void go(int x) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x, w[x]+""));
		visit[x] = true;
		while(!q.isEmpty()) {
			Node info = q.poll();
			if(info.x==e) {
				sb.append(info.s);
				return;
			}
			for(int y: tree[info.x]) {
				if(visit[y]) continue;
				q.add(new Node(y, info.s+w[y]));
				visit[y] = true;
			}
		}
	}
}
