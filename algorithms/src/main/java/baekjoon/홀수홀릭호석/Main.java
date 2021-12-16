package baekjoon.홀수홀릭호석;
import java.io.*;
import java.util.*;
public class Main {
	static class P20164 {
		BufferedReader br;
		String str;
		int min, max;
		P20164() {
			input();
			solve();
			System.out.println(min+" "+max);
		}
		void solve() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(str, oddCount(str));
		}
		int oddCount(String string) {
			int count = 0;
			for(int i=0; i<string.length(); i++) {
				int number = string.charAt(i) - '0';
				if(number%2==1) {
					count++;
				}
			}
			return count;
		}
		void dfs(String number, int odd_count) {
			StringBuilder sb = new StringBuilder();
			if(number.length()==1) {
				min = Math.min(min, odd_count);
				max = Math.max(max, odd_count);
			} else if(number.length()==2) {
				int sum = (number.charAt(0)-'0') + (number.charAt(1)-'0');
				sb.append(sum);
				dfs(sb.toString(), oddCount(sb.toString())+odd_count);
			} else {
				StringBuilder first = new StringBuilder();
				StringBuilder second = new StringBuilder();
				StringBuilder third = new StringBuilder();
				for(int i=0; i<number.length()-2; i++) {
					for(int j=i+1; j<number.length()-1; j++) {
						for(int k=0; k<=i; k++)
							first.append(number.charAt(k));
						for(int k=i+1; k<=j; k++)
							second.append(number.charAt(k));
						for(int k=j+1; k<number.length(); k++)
							third.append(number.charAt(k));
						int sum = Integer.parseInt(first.toString()) + Integer.parseInt(second.toString()) + Integer.parseInt(third.toString());
						sb.append(sum);
						dfs(sb.toString(), oddCount(sb.toString())+odd_count);
						first.delete(0, first.length());
						second.delete(0, second.length());
						third.delete(0, third.length());
						sb.delete(0, sb.length());
					}
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P20164();
	}
}