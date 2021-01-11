package baekjoon.평범한배낭;
import java.io.*;
import java.util.*;
public class Main {
	static int N, K, w[], p[];
	static HashMap<String, Integer> map;
	static int ks(int index, int weight) {
		if(weight<0)
			return Integer.MIN_VALUE;
		if(index==-1 || weight==0)
			return 0;
		String key = index+" "+weight;
		if(!map.containsKey(key)) {
			int include = ks(index-1, weight-w[index]) + p[index];
			int exclude = ks(index-1, weight);
			map.put(key, Math.max(include, exclude));
		}
		return map.get(key);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N];
		p = new int[N];
		map = new HashMap<String, Integer>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			w[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ks(N-1, K));
	}
}