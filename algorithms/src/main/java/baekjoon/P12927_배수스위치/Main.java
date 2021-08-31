package baekjoon.P12927_배수스위치;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int answer = 0;
		for(int i=1; i<=str.length; i++) {
			if(str[i-1]=='Y') {
				for(int j=i; j<=str.length; j=j+i)
					str[j-1]=(str[j-1]=='Y'?'N':'Y');
				answer++;
			}
		}
		System.out.println(answer);
	}
}