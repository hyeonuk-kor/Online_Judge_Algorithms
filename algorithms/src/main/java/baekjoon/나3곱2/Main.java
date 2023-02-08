package baekjoon.나3곱2;
import java.io.*;
import java.util.*;
public class Main {
	static class Pair implements Comparable<Pair> {
		int three;
		long num;
		public Pair(int three, long num) {
			this.three = three;
			this.num = num;
		}
		@Override
		public int compareTo(Pair o) {
			if(o.three==this.three)
				return Long.compare(this.num, o.num);
			return Integer.compare(o.three, this.three);
		}
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Pair[] a = new Pair[N];
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(st.nextToken());
			int three = 0;
			for(long j=num; j%3==0; j/=3) {
				three++;
			}
			a[i]= new Pair(three, num); 
		}
		Arrays.sort(a);
		for(int i=0; i<N; i++) {
			System.out.print(a[i].num+" ");
		}
	}
}