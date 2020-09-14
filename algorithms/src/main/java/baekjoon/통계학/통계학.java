package baekjoon.통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class 통계학 {

	public static void main(String[] args) throws Exception {
		
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		//1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
		int sum = IntStream.of(number).sum();
		
		//2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		int mid = IntStream.of(number).sorted().toArray()[number.length/2];
		
		//3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
//		int maxf = IntStream.of(number)
		
		//4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
		
		/*
		 * line 1 [소수 첫째 자리에서 반올림]
		 * line 2 [중앙값 출력]
		 * line 3 [최빈값이 여러개라면 두번째로 작은 값 출력]
		 * line 4 [범위를 출력 ]
		 */
		
	}
	
}
