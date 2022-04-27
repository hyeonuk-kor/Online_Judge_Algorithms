package baekjoon.제곱근;
import java.io.*;
import java.math.BigInteger;
public class Main {
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		BigInteger N = new BigInteger(br.readLine());
		pw.print(sqrt(N));
		pw.flush();
	}
	static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
}
