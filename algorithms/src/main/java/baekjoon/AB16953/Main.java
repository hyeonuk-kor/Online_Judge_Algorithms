package baekjoon.AB16953;
import java.io.*;
import java.util.*;
public class Main {
	static int A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		System.out.println(solve());
	}
	static long solve() {
		long answer = -1;
		Queue<long[]> q = new ArrayDeque<>();
		q.add(new long[] {A, 1});
		while(!q.isEmpty()) {
			long[] info = q.poll();
			long result = info[0];
			long count = info[1];
			if(result==B) {
				answer = count;
				break;
			} else if(result<B) {
				count++;
				q.add(new long[] {result*2, count});
				q.add(new long[] {result*10+1, count});
			}
		}
		return answer;
	}
}