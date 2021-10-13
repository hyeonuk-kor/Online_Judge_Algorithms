package baekjoon.피보나치수6;

import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main {
	static final BigInteger MOD = new BigInteger("1000000007");
	static Map<BigInteger, BigInteger> memo = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo.put(BigInteger.ZERO, BigInteger.ZERO);
		memo.put(BigInteger.ONE, BigInteger.ONE);
		System.out.println(fibo(new BigInteger(br.readLine())));
	}
	static BigInteger fibo(BigInteger n) {
		if(!memo.containsKey(n)) {
			if(n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
				BigInteger v1 = fibo(n.divide(BigInteger.TWO).subtract(BigInteger.ONE));
				BigInteger v2 = fibo(n.divide(BigInteger.TWO));
				memo.put(n, v2.multiply(BigInteger.TWO.multiply(v1).add(v2)).mod(MOD));
			} else {
				BigInteger v1 = fibo(n.divide(BigInteger.TWO).add(BigInteger.ONE));
				BigInteger v2 = fibo(n.divide(BigInteger.TWO));
				memo.put(n, (v2.multiply(v2)).add(v1.multiply(v1)).mod(MOD));
			}
		}
		return memo.get(n);
	}
}