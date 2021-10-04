package baekjoon.용돈관리;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, money[], min_value, max_value;
	public static void main(String[] args) {
		input();
		parametric_search();
	}
	static void parametric_search() {
		int L = min_value, R = max_value, answer = 0;
		while(L<=R) {
			int mid = (L+R)/2;
			if(determination(mid)) { // M번안에 돈을 뺄 수 있는 경우, 금액을 줄여본다.
				answer = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(answer);
	}
	static boolean determination(int mid) {
		int sum = 0, count = 1;
		for(int i=1; i<=N; i++) {
			if(sum + money[i] <= mid) {
				sum += money[i];
			} else {
				count++;
				sum = money[i];
			}
		}
		return count<=M;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			money = new int[N+1];
			for(int i=1; i<=N; i++) {
				money[i] = Integer.parseInt(br.readLine());
				min_value = Math.max(min_value, money[i]);	// 적어도 최대 금액만큼 한번에 뺄 수 있어야 M번안에 돈을 뺄 수 있게된다.
				max_value += money[i];	// 총 합은 한 번에 필요한 돈을 다 뺀 경우
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}