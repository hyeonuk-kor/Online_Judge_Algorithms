package baekjoon.수정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
