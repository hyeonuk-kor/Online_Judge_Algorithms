package baekjoon.랜선자르기;
import java.io.*;
import java.util.*;
public class Main2 {
	static int K, N, lan[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		long L = 0, R = Integer.MAX_VALUE;
		long answer = 0;
		while(L<=R) {
			long mid = (L+R)/2;
			if(determination(mid)) { // N개 이상 만들 수 있다면, 최소 길이를 늘려본다.
				answer = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(answer);
	}
	static boolean determination(long mid) {
		int count = 0; // 총 잘린 랜선의 개수
		for(int i=1; i<=K; i++) {
			count += (lan[i]/mid);
		}
		return count>=N;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			lan = new int[K+1];
			for(int i=1; i<=K; i++) {
				lan[i] = Integer.parseInt(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}