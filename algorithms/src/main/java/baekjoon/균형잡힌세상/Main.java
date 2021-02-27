package baekjoon.균형잡힌세상;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String input = br.readLine();
			if(input.equals("."))
				break;
			String str = ""; // 여러 문자괄호만 추가
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)=='(' || input.charAt(i)==')' || 
						input.charAt(i)=='{' || input.charAt(i)=='}' ||
						input.charAt(i)=='[' || input.charAt(i)==']') {
					str += input.charAt(i);
				}
			}
			String bracket = "\\(\\)|\\{\\}|\\[\\]"; //() 또는 {} 또는 [] 인 문자열 제거
			while(str.length() != (str = str.replaceAll(bracket, "")).length());
			if(str.length()==0) {
				bw.append("yes\n");
			} else {
				bw.append("no\n");
			}
		}
		bw.flush();
	}
}