package baekjoon.피보나치함수;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] memo = new int[40];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2; i<memo.length; i++) {
			memo[i] = memo[i-2]+memo[i-1];
		}
		
		while(T-->0) {
			int number = Integer.parseInt(br.readLine());
			if(number==0) {
				System.out.println("1 0");
			} else if(number==1) {
				System.out.println("0 1");
			} else 
				System.out.println(memo[number-1]+" "+memo[number]);
		}
		
	}
}
