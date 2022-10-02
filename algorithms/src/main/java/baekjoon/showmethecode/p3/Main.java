package baekjoon.showmethecode.p3;
import java.io.*;
public class Main {
	static int N, answer, mod = 1000000007;
	static String S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		int w = 0, h = 0, e = 0;
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i)=='W') {
				w++;
			} else if(S.charAt(i)=='H') {
				h+=w;
			} else if(S.charAt(i)=='E') {
				answer = (2*answer%mod + e%mod);
				answer %= mod;
				e+=h;
			}
			w%=mod;
			h%=mod;
			e%=mod;
		}
		System.out.println(answer);
	}
}

