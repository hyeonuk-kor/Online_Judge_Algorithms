package baekjoon.차량번호판1;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int answer = go(s, 0, ' ');
		answer = go1(s);
		System.out.println(answer);
	}
	static int go(String s, int index, char last) {
		if(index==s.length())
			return 1;
		char start = (s.charAt(index)=='c'?'a':'0');
		char end = (s.charAt(index)=='c'?'z':'9');
		int ans = 0;
		for(char i=start; i<=end; i++) {
			if(i!=last)
				ans += go(s, index+1, i);
		}
		return ans;
	}
	static int go1(String s) {
		int ans = 1;
		for(int i=0; i<s.length(); i++) {
			int cnt = (s.charAt(i) == 'c' ? 26 : 10);
			if(i>0 && s.charAt(i) == s.charAt(i-1)) {
				cnt -= 1;
			}
			ans = ans * cnt;
		}
		return ans;
	}
}