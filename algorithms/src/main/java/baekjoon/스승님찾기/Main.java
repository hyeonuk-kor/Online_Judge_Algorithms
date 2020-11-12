package baekjoon.스승님찾기;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger M = new BigInteger(sc.next());
		BigInteger N = new BigInteger(sc.next());
		
		BigInteger gcdCalc = M.gcd(N);
		if(gcdCalc.equals(BigInteger.ZERO))
			System.out.println(0);
		else if(gcdCalc.equals(BigInteger.ONE))
			System.out.println(1);
		else
			System.out.println(2);
	}
}
