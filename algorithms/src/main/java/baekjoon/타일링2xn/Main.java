package baekjoon.타일링2xn;
import java.util.*;
public class Main {
	static int[] tile;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tile = new int[1001];
		tile[0] = 0; tile[1]=1; tile[2]=3;
//		for(int i=3; i<=n; i++) {
//			tile[i] = tile[i-1] + 2*tile[i-2];
//			tile[i]%=10007;
//		}
//		System.out.println(tile[n]);
		System.out.println(fill(n));
	}
	
	private static int fill(int N) {
		if(tile[N]!=0)
			return tile[N];
		tile[N]= fill(N-1) + 2*fill(N-2);
//		tile[N]%=10007;
		return tile[N]%10007;
	}
}
