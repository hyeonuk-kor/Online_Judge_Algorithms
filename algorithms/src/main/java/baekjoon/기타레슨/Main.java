package baekjoon.기타레슨;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, time[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() { // 이진 탐색을 통해 블루레이의 최소크기를 찾는다.
		int L = 1, R = (int)1e9, answer = 0; // 블루레이 최대 크기 : 100,000*10,000
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
	static boolean determination(int D) { // D : 녹화가능한 블루레이의 시간
		int blueray = 1, sum = 0;
		for(int i=1; i<=N; i++) {
			if(time[i]>D)	// 녹화가능한 블루레이의 시간보다 강의가 길 경우 대혼란에 빠진다.
				return false;
			sum += time[i];
			if(sum>D) {
				blueray++;
				sum = time[i];
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
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}