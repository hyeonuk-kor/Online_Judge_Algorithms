package baekjoon.수열정렬;
import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static class Elem {
		int a, b;
		public Elem(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int getA() {
			return a;
		}
		public int getB() {
			return b;
		}
	}
	static int N, P[];
	static Elem A[];
	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sb.toString());
	}
	static void pro() {
		sb = new StringBuilder();
		Arrays.sort(A, Comparator.comparing(Elem::getA));
		for(int i=0; i<A.length; i++)
			P[A[i].getB()] = i;
		for(int i=0; i<P.length; i++)
			sb.append(P[i]).append(' ');
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			A = new Elem[N];
			P = new int[N];
			for(int i=0; i<N; i++) {
				int a = Integer.parseInt(st.nextToken());
				A[i] = new Elem(a, i);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}