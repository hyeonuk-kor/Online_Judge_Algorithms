package baekjoon.상수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		String Ar = new StringBuffer(A).reverse().toString();
		String Br = new StringBuffer(B).reverse().toString();
		if(Ar.compareTo(Br)>0)
			System.out.println(Ar);
		else
			System.out.println(Br);
	}
}
