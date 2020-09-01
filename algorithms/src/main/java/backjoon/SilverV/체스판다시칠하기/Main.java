package backjoon.SilverV.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static int N, M;
	private static String[] map;
	private static String[] answer = {"WBWBWBWB","BWBWBWBW"};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		
		int min = 64;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				min  = Math.min(min, find(i, j));
			}
		}
		System.out.println(min);
		
	}

	private static int find(int y, int x) {
		
		int min = 64;
		for (int i = 0; i < answer.length; i++) {
			int count = 0;
			for (int j = 0; j < 8; j++) {
				String target = answer[(j)%2].trim();
				String compare = map[y+j].substring(x, x+8);
				for(int k=0; k<8; k++) {
					if(target.charAt(k)!=compare.charAt(k))
						count++;
				}
//				System.out.println(count);
			}
			min = Math.min(min, count);
			String temp = answer[0];
			answer[0] = answer[1];
			answer[1] = temp;
		}
		
		return min;
	}

}
