package baekjoon.정수N개의합;

public class 정수N개의합 {
	
	long sum(int[] a) {
		
		long sum = 0;
		for (int i : a) {
			sum += i;
		}
		
		return sum;
	}
	
}
