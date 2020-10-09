package coupang.test1;

import java.util.Arrays;

public class test1 {
	
	public static void main(String[] args) {
		int N = 14;
		int[] answer = solution(N);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int n) {
		int max = 1;
		int k = 1;
		for(int i=2; i<=10; i++) {
			int input = n;
			int calc = 1;
			System.out.println(i+"진법");
			while(input!=0) {
				if(input%i!=0) {
					System.out.println(input%i+"자리수계산중");
					calc*=(input%i);
				}
				input/=i;
			}
			if(max<=calc) {
				max = calc;
				k = i;
			}
		}
		return new int[] {k, max};
	}
	
}
