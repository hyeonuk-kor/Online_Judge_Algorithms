package baekjoon.외판원순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회 {
	
	static int[][] city, memo;
	static int N;
	static int INF = Integer.MAX_VALUE - 1000000;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		city = new int[16][16];
		memo = new int[16][1<<16];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1));
		
	}

	static int tsp(int current, int visit) {
		if((visit==(1<<N)-1)) {
			if(city[current][0]==0)
				return INF;
			return city[current][0];
		}
		
		if(memo[current][visit]!=0) {
			return memo[current][visit];
		}
		
		memo[current][visit] = INF;
		for (int i = 0; i < N; i++) {
			int next = 1 << i;
			if((visit&next)==0 && city[current][i]>0)
				memo[current][visit] = Math.min(memo[current][visit], tsp(i, visit|next)+city[current][i]); 
		}
		return memo[current][visit];
		
	}
	
}
