package baekjoon.암호코드;
import java.io.*;
public class Main {
	static class P2011 {
		BufferedReader br;
		int dp[];
		String number;
		P2011() {
			br = new BufferedReader(new InputStreamReader(System.in));
			dp = new int[5001];
			input();
			solve();
		}
		void solve() {
			if(number.startsWith("0")) { // 0으로 시작할 경우
				System.out.println(0);
				return;
			}
			dp[0] = dp[1] = 1;
			for(int i=2; i<=number.length(); i++) {
				// i 번째에 한 자리 알파벳(A~I)이 경우의 수
				int makeNumber = number.charAt(i-1) - '0';
				if(makeNumber>=1 && makeNumber<=9) {
					dp[i] = dp[i-1]; // i-1의 경우를 그대로 이어감
				}
				// k번째에 두 자리 알파벳(J~Z)가 올 수 있는 경우
				makeNumber = 10*(number.charAt(i-2)-'0') + (number.charAt(i-1)-'0');
				if(makeNumber>=10 && makeNumber<=26) {
					dp[i] += dp[i-2]; // i-2번째의 경우를 더해준다.
				}
				dp[i]%=1000000;
			}
			System.out.println(dp[number.length()]);
		}
		void input() {
			try {
				number = br.readLine();
				dp = new int[number.length()+1];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2011();
	}
}