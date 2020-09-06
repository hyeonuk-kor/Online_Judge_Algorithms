package baekjoon.골드바흐의추측;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐의추측6588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[1000001];
		for (int i = 2; i < arr.length; i++) {
			arr[i]=i;
		}
		for (int i = 2; i < arr.length; i++) {
			for (int j = i+i; j < arr.length; j+=i) {
				arr[j]=0;
			}
		}
		
		int input = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		do {
			String answer = null;
			for(int i=0, j=input; i<=input/2; i++,j--) {
				if(i%2==1 && j%2==1 && arr[i]!=0 && arr[j]!=0) {
					answer = input+" = "+i+" + "+j;
					break;
				}
			}
			if(answer.length()==0)
				sb.append("Goldbach's conjecture is wrong");
			else
				sb.append(answer);
			sb.append('\n');
			input = Integer.parseInt(br.readLine());
		}while(input!=0);
		System.out.println(sb);
	}
}
