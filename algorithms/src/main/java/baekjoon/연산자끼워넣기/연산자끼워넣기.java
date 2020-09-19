package baekjoon.연산자끼워넣기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연산자끼워넣기 {

	static List<Integer> list;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int N;
	static int[] number;
	static String sign = "";
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		number = new int[N];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt();
		}
		
		int add = sc.nextInt();
		int odd = sc.nextInt();
		int mul = sc.nextInt();
		int div = sc.nextInt();
		
		for(int i=0; i<add; i++)
			sign+="+";
		for(int i=0; i<odd; i++)
			sign+="-";
		for(int i=0; i<mul; i++)
			sign+="*";
		for(int i=0; i<div; i++)
			sign+="/";
		
		list = new ArrayList<>();
		calc(number[0], 0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void calc(int sum, int idx) {
		if(list.size()==N-1) {
			if(sum>max)
				max = sum;
			if(sum<min)
				min = sum;
			return;
		}
		
		for (int i = 0; i < sign.length(); i++) {
			if(list.contains(i))
				continue;
			list.add(i);
			
			if(sign.charAt(i)=='+') {
				calc(sum+number[idx+1], idx+1);
			} else if(sign.charAt(i)=='-') {
				calc(sum-number[idx+1], idx+1);
			} else if(sign.charAt(i)=='*') {
				calc(sum*number[idx+1], idx+1);
			} else if(sign.charAt(i)=='/') {
				calc(sum/number[idx+1], idx+1);
			}
			list.remove(list.size()-1);
		}
		
	}

}
