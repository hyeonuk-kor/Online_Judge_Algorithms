package baekjoon.부녀회장이될테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			System.out.println(getNum(K, N));
		}
	}

	private static int getNum(int k, int n) {
		if(n==1) 
			return 1; // 1호에는 한명만 살고 있다.
		if(k==0)
			return n; // 0층에는 n명만 살고 있다.
		
		return getNum(k-1, n) + getNum(k,n-1);
	}
	
}
