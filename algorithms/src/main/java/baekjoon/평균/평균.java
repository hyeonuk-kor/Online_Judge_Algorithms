package baekjoon.평균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평균 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] exam = new int[N];
		
		st = new StringTokenizer(br.readLine());
		exam[0] = Integer.parseInt(st.nextToken());
		int max = exam[0];
		
		for (int i = 1; i < exam.length; i++) {
			exam[i] = Integer.parseInt(st.nextToken());
			if(exam[i]>max)
				max = exam[i];
		}
		
		double sum = 0;
		for (int i : exam) {
			sum += (double)i/max*100;
		}
		
		System.out.println(sum/exam.length);
	}
	
}
