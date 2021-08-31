package baekjoon.P1764_듣보잡;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeSet<String> group_n = new TreeSet<>();
		TreeSet<String> group_m = new TreeSet<>();
		for(int i=0; i<N; i++)
			group_n.add(br.readLine());
		for(int i=0; i<M; i++)
			group_m.add(br.readLine());
		group_n.retainAll(group_m);
		System.out.println(group_n.size());
		for(String name: group_n)
			System.out.println(name);
	}
}
