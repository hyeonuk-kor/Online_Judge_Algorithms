package baekjoon.팰린드롬인지확인하기;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());
		String A = input.toString();
		String B = input.reverse().toString();
		if(A.equals(B))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
