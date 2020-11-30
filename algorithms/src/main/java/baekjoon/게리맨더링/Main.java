package baekjoon.게리맨더링;
import java.util.*;
import java.io.*;
public class Main {
	static int[] v, p;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(st.nextToken());
		v = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)  {
			v[i] = Integer.parseInt(st.nextToken());
			p[i] = i;
		}
		
		graph = new ArrayList<>();
		for(int i=0; i<N; i++) {
			ArrayList<Integer> d = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			int c = Integer.parseInt(st.nextToken());
			for(int j=0; j<c; j++)
				d.add(Integer.parseInt(st.nextToken()));
			graph.add(d);
		}
		
		
	}

}
