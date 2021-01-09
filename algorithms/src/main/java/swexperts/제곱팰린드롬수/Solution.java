package swexperts.제곱팰린드롬수;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int i=start; i<=end; i++) {
				boolean check = isPalindrome(String.valueOf(i));
				if(check) {
					double sroot = Math.sqrt(i);
					if(i%sroot==0) {
						if(isPalindrome(String.valueOf((int)sroot)))
							answer++;
					}
				}
			}
			bw.append("#"+tc+" "+answer+"\n");
		}
		bw.flush();
	}
	static boolean isPalindrome(String number) {
		int size = number.length();
		for(int i=0; i<size/2; i++) {
			if(number.charAt(i)!=number.charAt(size-i-1))
				return false;
		}
		return true;
	}
}