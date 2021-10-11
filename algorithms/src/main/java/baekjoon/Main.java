package baekjoon;

import java.util.Arrays;

public class Main {
	
	public static int conv(int[] array) {
		int number = 0;
		for(int i=0; i<6; i++) {
			number = number * 10 + array[i];
		}
		return number;
	}
	public static int[] inv_conv(int number) {
		int array[] = new int[6];
		for(int i=5; i>=0; i--) {
			array[i] = number%10;
			number/=10;
		}
		return array;
	}
	
	public static void main(String[] args) {
		dfs(new int[]{1,2,3,4,5,6}, 0, 3, 0);
	}

	private static void dfs(int[] array, int l, int r, int number) {
		if(l==3 && r==6) {
			System.out.println(number);
			return;
		}
		if(l<3)
			dfs(array, l+1, r, number*10+array[l]);
		if(r<6)
			dfs(array, l, r+1, number*10+array[r]);
	}

}
