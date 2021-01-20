package baekjoon.최소공배수;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			BigInteger lcm = A.multiply(B).divide(A.gcd(B));
			bw.append(lcm+"\n");
		}
		bw.flush();
	}
}
