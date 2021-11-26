package codeforces.MakeEven;
import java.io.*;
import java.util.*;
public class Main {
	static class MakeEven {
		BufferedReader br;
		StringBuilder sb;
		int T;
		MakeEven() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				T = Integer.parseInt(br.readLine());
				for(int tc=0; tc<T; tc++) {
					String input = br.readLine();
					sb.append(solution(input)).append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int solution(String input) {
			int left = 0;
			int right = input.length()-1;
			int check = input.charAt(right)-'0';
			if(check%2==0)
				return 0;
			check = input.charAt(left) - '0';
			if(check%2==0)
				return 1;
			for(int i=left; i<=right; i++) {
				check = input.charAt(i) - '0';
				if(check%2==0) {
					return 2;
				}
			}
			return -1;
		}
	}
	public static void main(String[] args) {
		new MakeEven();
	}
}
