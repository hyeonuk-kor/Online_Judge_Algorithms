package baekjoon.분수찾기;

import java.util.Scanner;

public class 분수찾기 {
	
	public static void main(String[] args) {
		
		int X = new Scanner(System.in).nextInt();
		
		int count = 0;
		loop:for(int i=1; i<=X;i++) {
			for(int j=1,k=i; j<=i && k>=1; j++,k--) {
				count++;
				if(count==X) {
					if(i%2==1)
						System.out.println(k+"/"+j);
					else
						System.out.println(j+"/"+k);
					break loop;
				}
			}
		}
		
		
	}
	
}
