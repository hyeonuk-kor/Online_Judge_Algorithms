package baekjoon.수정렬하기3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기3 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] check = new int[10000000];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			check[num]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < check.length; i++) {
			if(check[i]>0) {
				for(int j=0; j<check[i]; j++)
					sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
}
