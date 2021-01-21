package baekjoon.링;
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger B = new BigInteger(st.nextToken());
		for(int i=0; i<N-1; i++) {
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger gcd = A.gcd(B);
			bw.append(B.divide(gcd)+"/"+A.divide(gcd)+"\n");
		}
		bw.flush();
	}
}