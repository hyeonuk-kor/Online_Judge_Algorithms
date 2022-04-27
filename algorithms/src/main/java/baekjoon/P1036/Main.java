package baekjoon.P1036;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	static BufferedReader br;
	static int N;
	static String str[], base36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		for(int n=0; n<N; n++) {
			str[n] = br.readLine();
		}
	}
	static BigInteger conv10to36(String s) {
		BigInteger result = BigInteger.ZERO;
		BigInteger check = new BigInteger(s);
		if(check.equals(check)) {
			
		}
		return result;
	}
}
