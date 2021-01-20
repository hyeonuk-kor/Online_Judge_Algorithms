package baekjoon.검문;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		BigInteger number[] = new BigInteger[N];
		number[0] = new BigInteger(br.readLine());
		number[1] = new BigInteger(br.readLine());
		BigInteger diffGCD = number[1].subtract(number[0]).abs();
		for(int i=2; i<N; i++) {
			number[i] = new BigInteger(br.readLine());
			diffGCD = diffGCD.gcd(number[i].subtract(number[i-1]).abs());
		}
		int gcd = diffGCD.intValue();
		for(int i=2; i<=gcd; i++) 
			if(gcd%i==0)
				bw.append(i+" ");
		bw.flush();
	}
}