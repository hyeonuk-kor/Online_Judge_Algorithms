package baekjoon.평범한배낭;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P12865 {
		BufferedReader br;
		StringTokenizer st;
		int N, K, W[], P[];
		Map<String, Integer> bag;
		P12865() {
			input();
			bag = new HashMap<>();
			System.out.println(solve(N, K));
		}
		int solve(int index, int weight) {
			if(weight<0)
				return Integer.MIN_VALUE;
			if(index==0 || weight==0)
				return 0;
			String key = index+" "+weight;
			if(!bag.containsKey(key)) {
				int include = solve(index-1, weight-W[index]) + P[index];
				int exclude = solve(index-1, weight);
				bag.put(key, Math.max(include, exclude));
			}
			return bag.get(key);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				W = new int[N+1];
				P = new int[N+1];
				for(int n=1; n<=N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					W[n] = Integer.parseInt(st.nextToken());
					P[n] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P12865();
	}
}
