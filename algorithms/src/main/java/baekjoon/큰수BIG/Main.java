package baekjoon.큰수BIG;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger MOD = new BigInteger("20000303");
		BigInteger N = new BigInteger(br.readLine());
		BigInteger temp = new BigInteger(Math.pow(10, 1000000)+"");
		System.out.println(temp.mod(MOD));
	}
	
}
