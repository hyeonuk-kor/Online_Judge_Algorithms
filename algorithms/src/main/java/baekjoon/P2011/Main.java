package baekjoon.P2011;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int[] dp = new int[5001];
		dp[0] = dp[1] = 1;
		for(int i=2; i<=number.length(); i++) {
			int makeNumber = number.charAt(i-1) - '0';
			if(makeNumber>=1 && makeNumber<=9) {
				dp[i] = dp[i-1];
			}

			makeNumber = 10*(number.charAt(i-2)-'0') + (number.charAt(i-1)-'0');
			if(makeNumber>=10 && makeNumber<=26) {
				dp[i] += dp[i-2]; 
			}
			dp[i]%=1000000;
		}
		System.out.println(dp[number.length()]);
	}
	static boolean check(char a, char b) {
		if(a=='0') return false;
		if(a=='1') return true;
		if(a>='3') return false;
		return b<='6';
	}	
}
