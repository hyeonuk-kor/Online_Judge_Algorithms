package baekjoon.문자열분석;
import java.io.*;
import java.util.*;
class P10820 {
	StringBuilder sb;
	P10820() {
		sb = new StringBuilder();
		input();
		System.out.println(sb);
	}
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = "";
			while((input=br.readLine())!=null) {
				solve(input);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void solve(String str) {
		int lc=0, uc=0, nc=0, bc=0;
		for(char c: str.toCharArray()) {
			if(c>='a' && c<='z') {
				lc++;
			} else if(c>='A' && c<='Z') {
				uc++;
			} else if(c>='0' && c<='9') {
				nc++;
			} else if(c==' ') {
				bc++;
			}
		}
		sb.append(lc+" "+uc+" "+nc+" "+bc).append('\n');
	}
}
public class Main {
	public static void main(String[] args) {
		new P10820();
	}
}