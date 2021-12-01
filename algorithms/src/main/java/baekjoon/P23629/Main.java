package baekjoon.P23629;
import java.io.*;
import java.util.*;
public class Main {
	static class P23629 {
		BufferedReader br;
		StringTokenizer st;
		String input;
		String[] words = {
			"ZERO", "ONE", "TWO", "THREE", "FOUR",
			"FIVE", "SIX", "SEVEN", "EIGHT", "NINE"	
		};
		Queue<Character> operator;
		P23629() {
			input();
			StringTokenizer number_str = new StringTokenizer(input, "+-x/=");
			long sum = Long.parseLong(number_str.nextToken());
			while(number_str.hasMoreTokens()) {
				switch (operator.poll()) {
				case '+':
					sum += Long.parseLong(number_str.nextToken());
					break;
				case '-':
					sum -= Long.parseLong(number_str.nextToken());
					break;
				case 'x':
					sum *= Long.parseLong(number_str.nextToken());
					break;
				case '/':
					sum /= Long.parseLong(number_str.nextToken());
					break;
				}
			}
			String result = String.valueOf(sum);
			for(int i=0; i<words.length; i++)
				result = result.replaceAll(i+"", words[i]);
			System.out.println(result);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine();
				for(int i=0; i<words.length; i++)
					input = input.replaceAll(words[i], i+"");
				System.out.println(input);
				operator = new ArrayDeque<>();
				for(int i=0; i<input.length(); i++) {
					if(!(input.charAt(i)>='0' && input.charAt(i)<='9')) {
						operator.add(input.charAt(i));
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23629();
	}
}