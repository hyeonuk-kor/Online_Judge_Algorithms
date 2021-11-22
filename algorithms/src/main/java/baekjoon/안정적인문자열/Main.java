package baekjoon.안정적인문자열;
import java.io.*;
import java.util.*;
public class Main {
	static class P4889 {
		BufferedReader br;
		StringBuilder sb;
		Stack<Character> stack;
		P4889() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				char[] str = br.readLine().toCharArray();
				int testcase = 1;
				while(str[0]!='-') {
					stack = new Stack<>();
					for(char c: str) {
						if(!stack.isEmpty() && stack.peek()=='{' && c=='}') {
							stack.pop();
						} else {
							stack.push(c);
						}
					}
					int answer = 0;
					while(!stack.isEmpty()) {
						char c = stack.pop();
						if(c==stack.peek()) {
							answer++;
						} else {
							answer+=2;
						}
						stack.pop();
					}
					sb.append(testcase++).append(". ").append(answer).append('\n');
					str = br.readLine().toCharArray();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P4889();
	}
}
