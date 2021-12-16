package baekjoon.유레카이론;
import java.io.*;
import java.util.*;
public class Main {
	static class P10448 {
		BufferedReader br;
		StringBuilder sb;
		List<Integer> triangle;
		P10448() {
			sb = new StringBuilder();
			makeTriangle();
			input();
			System.out.println(sb);
		}
		void makeTriangle() {
			triangle = new ArrayList<>();
			int number = 0;
			int index = 1;
			while(number<=1000) {
				triangle.add(number);
				number = index*(index+1)/2;
				index++;
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=0; t<T; t++) {
					int number = Integer.parseInt(br.readLine());
					if(isTriple(number)) sb.append(1);
					else sb.append(0);
					sb.append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean isTriple(int number) {
			for(int i=1; i<triangle.size(); i++) {
				for(int j=1; j<triangle.size(); j++) {
					for(int k=1; k<triangle.size(); k++) {
						int first = triangle.get(i);
						int second = triangle.get(j);
						int third = triangle.get(k);
						if(first+second+third==number)
							return true;
					}
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		new P10448();
	}
}