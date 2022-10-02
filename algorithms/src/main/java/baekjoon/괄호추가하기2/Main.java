package baekjoon.괄호추가하기2;
import java.io.*;
import java.util.*;
public class Main {
	static final int none = 0, open = 1, close = -1;
	static class P16638 {
		BufferedReader br;
		int N, answer, p[];
		String exp, in;
		ArrayDeque<Character> operator_stack;
		ArrayDeque<Integer> number_stack;
		P16638() {
			answer = Integer.MIN_VALUE;
			input();
			go(0);
			System.out.println(answer);
		}
		void go(int x) {
			if(x==N+1) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<N; i++) {
					if(p[i]==open) 		 sb.append('(');
					else if(p[i]==close) sb.append(')');
					sb.append(exp.charAt(i));
				} 
				if(p[N]==close)	sb.append(')');
				in = sb.toString();
				calc();
			} else if(x<N+1) {
				p[x] = open; p[x+3] = close;
				go(x+4);
				p[x] = p[x+3] = none;
				go(x+2);
			}
		}
		void calc() {
			first(); // 괄호 먼저 계산
			second(); // 곱하기 먼저 계산
			last(); // 나머지 계산
		}
		void last() {
			int result = number_stack.pop();
			while(!operator_stack.isEmpty()) {
				Character operator = operator_stack.pop();
				result = getResult(result, number_stack.pop(), operator);
			}
			answer = Math.max(answer, result);
		}
		void second() {
			ArrayDeque<Integer> next_num = new ArrayDeque<>();
			ArrayDeque<Character> next_oper = new ArrayDeque<>();
			next_num.push(number_stack.pop());
			while(!operator_stack.isEmpty()) {
				Character op = operator_stack.pop();
				if(op=='*') {
					next_num.push(next_num.pop()*number_stack.pop());
				} else {
					next_oper.push(op);
					next_num.push(number_stack.pop());
				}
			}
			number_stack = next_num;
			operator_stack = next_oper;
		}
		void first() {
			operator_stack = new ArrayDeque<>();
			number_stack = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(in, "+-*()", true);
			while(st.hasMoreTokens()) {
				char c = st.nextToken().charAt(0);
				if(c=='(') {
					continue;
				} else if(isOper(c)) {
					operator_stack.push(c);
				} else if(c==')') {
					char operator = operator_stack.pop();
					int number = number_stack.pop();
					int result = getResult(number_stack.pop(), number, operator);
					number_stack.push(result);
				} else {
					number_stack.push(c-'0');
				}
			}
		}
		boolean isOper(char c) {
			return c=='+' || c=='-' || c=='*';
		}
		int getResult(int pre, int post, char oper) {
			int sum = pre;
			switch (oper) {
			case '+': sum += post ;	break;
			case '-': sum -= post ;	break;
			case '*': sum *= post ;	break;
			}
			return sum;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				exp = br.readLine();
				p = new int[N+3];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P16638();
	}
}