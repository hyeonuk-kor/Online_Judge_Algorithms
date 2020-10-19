package baekjoon;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[][] a = {
				{1,2},
				{3,4},
		};
		
		int map[][] = new int[a.length][a.length];
		for(int i=0; i<2; i++) {
			for(int j=2-1; j>=0; j--) {
				map[2-j-1][i] = a[i][j];
			}
		}
		
		System.out.println(Arrays.toString(map[0]));
		System.out.println(Arrays.toString(map[1]));
	
	}
}
