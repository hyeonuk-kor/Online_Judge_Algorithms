package baekjoon.십육진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 십육진수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int size = input.length-1;
		int sum = 0;
		
		for(char a: input) {
			if(a>='A' && a<='F')
				a=(char) (a-'A'+10);
			else
				a= (char) (a-'0');
			sum += a*Math.pow(16, size--);
		}
		
		System.out.println(sum);
		
	}

}
