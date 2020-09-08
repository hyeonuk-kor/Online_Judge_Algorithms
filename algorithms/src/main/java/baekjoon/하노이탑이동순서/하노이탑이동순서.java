package baekjoon.하노이탑이동순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		sb.append((1<<N)-1).append('\n'); 
		move(N, 1, 3); // N개의 원판을 1번 기둥에서 3번 기둥으로
		System.out.println(sb);
	}

	private static void move(int count, int start, int end) {

		if(count==1) {
			sb.append(start+" "+end).append('\n');
			return;
		} else {
			int sub = 6 - end - start; // 이동을 도와주는 기둥의 번호
			move(count-1, start, sub); //맨 마지막 원반을 제외한 기둥을 sub로 옮긴다.
			move(1, start, end); // 맨 마지막 원반을 end(3번 기둥)으로 옮긴다.
			move(count-1, sub, end); // sub 기둥에 있던 나머지를 end(3번 기둥)으로 옮긴다.
		}

	}
}
