package baekjoon.좌표정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 좌표정렬하기_2차원배열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] point = new int[N][];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
					};
		}
		
		Arrays.sort(point, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(point[i][0]+" "+point[i][1]);
		}
		
	}
}
