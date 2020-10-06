package baekjoon.카드역배치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드역배치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] number = new int[20];
		for(int input=0; input<20; input++) {
			number[input]=input+1;
		}
		
		for(int input=0; input <10; input++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int[] temp = new int[b-a+1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = number[b--];
			}
			for (int i = 0; i < temp.length; i++) {
				number[a++] = temp[i];
			}
		}
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]+" ");
		}
		System.out.println();
		
	}

}
