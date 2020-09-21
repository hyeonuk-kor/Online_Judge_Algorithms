package baekjoon.스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {

	static int N, min=Integer.MAX_VALUE;
	static int[][] number;
	static List<Integer> startTeam, linkTeam;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		number = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				number[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startTeam = new ArrayList<>();
		linkTeam = new ArrayList<>();
		getTeam();
		
		System.out.println(min);
	}
	
	private static void getTeam() {
		if(startTeam.size()==N/2) {
			System.out.println(startTeam);
			System.out.println(linkTeam);
			System.out.println();
			int start = 0;
			int link = 0;
			return;
		}
		
		for(Integer i=0; i<N; i++) {
			if(startTeam.contains(i))
				continue;
			startTeam.add(i);
			linkTeam.add(N-1-i);
			getTeam();
			startTeam.remove(startTeam.size()-1);
			linkTeam.remove(linkTeam.size()-1);
		}
		
	}
	
}
