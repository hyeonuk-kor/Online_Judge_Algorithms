package baekjoon.회의실배정;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int[][] timeTable = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timeTable, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				return 
				start[1]==end[1] ?
				Integer.compare(start[0], end[0]) : Integer.compare(start[1], end[1]);
			}
		});
		
		int answer = 0;
		int end = -1;
		
		for(int i=0; i<N; i++) {
			if(timeTable[i][0]>=end) {
				end = timeTable[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}

}