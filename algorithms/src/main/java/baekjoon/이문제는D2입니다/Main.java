package baekjoon.이문제는D2입니다;
import java.io.*;
import java.util.*;
public class Main {
	static class P23303 {
		BufferedReader br;
		StringTokenizer st;
		P23303() {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(input());
		}
		String input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				while(st.hasMoreTokens()) {
					if(st.nextToken().toUpperCase().contains("D2")) {
						return "D2";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "unrated";
		}
	}
	public static void main(String[] args) {
		new P23303();
	}
}
