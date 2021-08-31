package baekjoon.타일링;
import java.util.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger d[] = new BigInteger[251];
		d[0] = BigInteger.ONE;
		d[1] = BigInteger.ONE;
		for(int i=2; i<=250; i++) {
			d[i] = BigInteger.ZERO;
			d[i] = d[i].add(d[i-1]).add(d[i-2]).add(d[i-2]);
		}
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
	}
}