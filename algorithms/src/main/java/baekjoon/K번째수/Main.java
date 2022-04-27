package baekjoon.K번째수;
import java.io.*;
public class Main {
	static BufferedReader br;
	static int N, K, answer;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		binary_search();
	}
	static void binary_search() {
		int left = 1, right = K;
		while(left<=right) {
			int mid = (left+right)/2;
			if(det(mid)) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
	static boolean det(int mid) {
		int count = 0;
		for(int i=1; i<=N; i++) {
			count += Math.min(mid/i, N);
		}
		return count<K;
	}
}