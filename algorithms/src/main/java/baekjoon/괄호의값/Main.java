package baekjoon.괄호의값;
import java.io.*;
import java.util.*;
public class Main {
	static class P2504 {
		BufferedReader br;
		char[] input;
		long answer;
		P2504() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			Stack<Character> stack = new Stack<>();
			long value = 1;
			for(int i=0; i<input.length; i++) {
				switch (input[i]) {
					case '(': 
						stack.push(input[i]); 
						value *= 2;
						break;
					case '[': 
						stack.push(input[i]); 
						value *= 3;
						break;
					case ')':
						if(i==0 || stack.isEmpty() || stack.peek()!='(') {
							answer = 0;
							return;
						}
						if(input[i-1]=='(')
							answer += value;
						stack.pop();
						value /= 2;
						break;
					case ']':
						if(i==0 || stack.isEmpty() || stack.peek()!='[') {
							answer = 0;
							return;
						}
						if(input[i-1]=='[')
							answer += value;
						stack.pop();
						value /= 3;
						break;
				}
			}
			if(!stack.isEmpty())
				answer = 0;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2504();
	}
}