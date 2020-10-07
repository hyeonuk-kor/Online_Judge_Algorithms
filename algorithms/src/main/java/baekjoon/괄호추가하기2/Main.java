package baekjoon.괄호추가하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	private static int answer;
	private static int N;
	private static String exp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = br.readLine();
		answer = Integer.MIN_VALUE;
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int idx, int sum) {
		if(idx>N-1) {
			answer = Math.max(answer, sum);
			return;
		}
		
		char oper = (idx==0) ? '+' : exp.charAt(idx-1);
		if(idx+2<N) {
			int bracket = calculate(exp.charAt(idx)-'0', exp.charAt(idx+2)-'0', exp.charAt(idx+1));
			dfs(idx+4, calculate(sum, bracket, oper));
		}
		
		dfs(idx+2, calculate(sum, exp.charAt(idx)-'0', oper));
		
	}

	private static int calculate(int pre, int post, char oper) {
		int sum = pre;
		
		switch (oper) {
			case '+': sum += post;	break;
			case '-': sum -= post;	break;
			case '*': sum *= post;	break;
		}
		
		return sum;
	}


	
	
}