package baekjoon.접미사배열;
import java.io.*;
import java.util.*;
public class Main {
	static class P11656 {
		BufferedReader br;
		StringBuilder sb;
		char[] input;
		ArrayList<String> word;
		P11656() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			word = new ArrayList<>();
			solve();
			sb = new StringBuilder();
			output();
		}
		void output() {
			for(String s: word)
				sb.append(s).append('\n');
			System.out.println(sb);
		}
		void input() {
			try {
				input = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void solve() {
			String substr = "";
			for(int i=input.length-1; i>=0; i--) {
				substr = input[i] + substr;
				word.add(substr);
			}
			Collections.sort(word);
		}
	}
	public static void main(String[] args) {
		new P11656();
	}
}
