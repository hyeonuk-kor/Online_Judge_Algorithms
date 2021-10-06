package baekjoon.고냥이;
import java.io.*;
public class Main {
	static int N, alpha[], count;
	static char[] str;
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		alpha = new int[26];
		int answer = 0;
		for(int R=1, L=1; R<str.length; R++) {
			// 알파벳 추가하기
			add(str[R]);
			// 고양이가 인식할 수 있는 곳 까지 L 옮기기
			while(count > N) {
				del(str[L++]);
			}
			answer = Math.max(answer, R-L+1);
		}
		System.out.println(answer);
	}
	static void add(char x) {
		alpha[x-'a']++;
		if(alpha[x-'a']==1)
			count++;
	}
	static void del(char x) {
		alpha[x-'a']--;
		if(alpha[x-'a']==0)
			count--;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			str = new char[input.length()+1];
			for(int i=1; i<=input.length(); i++) {
				str[i] = input.charAt(i-1);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}