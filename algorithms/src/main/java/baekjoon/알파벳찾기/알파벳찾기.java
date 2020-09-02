package baekjoon.알파벳찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		for(int i=0; i<str.length; i++) {
			if(alphabet[str[i]-97]==-1)
				alphabet[str[i]-97]=i;
		}
		
		for(int a: alphabet)
			System.out.print(a+" ");
		System.out.println();
	}
	
}
