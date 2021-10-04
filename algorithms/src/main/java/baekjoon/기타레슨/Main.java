package baekjoon.기타레슨;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, time[], max_time;
	public static void main(String[] args) {
		input();
		parametric_search();
	}
	static void parametric_search() { // 이진 탐색을 통해 [parametric - "블루레이의 크기"]의 최소를 찾는다.
		int L = max_time, R = (int)1e9, answer = 0; // 블루레이 최소 크기 : 강의에서 가장 길었던 시간, 최대 크기 : 100,000*10,000
		while(L<=R) {
			int mid = (L+R)/2;
			if(determination(mid)) { // 블루레이에 나눠서 담을 수 있다면, 최대 크기를 줄여나간다.
				answer = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(answer);
	}
	static boolean determination(int D) { // D : 녹화가능한 블루레이의 시간, 의사결정: Y/N 여부
		int blueray = 1, sum = 0;
		for(int i=1; i<=N; i++) {
			if(sum+time[i]>D) { // 더 이상 담을 수 없다면, 새로운 블루레이에 저장한다.
				blueray++;
				sum = time[i];
			} else {
				sum += time[i];
			}
		}
		return blueray<=M; //blueray의 개수가 M개 이하이면 녹화가 가능하다.
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 강의의 수
			M = Integer.parseInt(st.nextToken()); // 블루레이 개수
			time = new int[N+1];				  // 강의 시간
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				max_time = Math.max(time[i], max_time);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}