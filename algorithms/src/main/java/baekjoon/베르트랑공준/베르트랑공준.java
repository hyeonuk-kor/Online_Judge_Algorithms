package baekjoon.베르트랑공준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[123456*2+1];
		for(int i=2; i<123456*2+1; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<=123456*2; i++) {
			if(arr[i]==0)
				continue;
			for(int j=i+i; j<=123456*2; j=j+i) {
				arr[j]=0;
			}
		}
		
		int input = Integer.parseInt(br.readLine());
		
		do {
			int count=0;
			for(int i=input+1; i<=input*2; i++) {
				if(arr[i]!=0)
					count++;
			}
			System.out.println(count);
			input = Integer.parseInt(br.readLine());
		} while(input!=0);
		
	}
	
}
