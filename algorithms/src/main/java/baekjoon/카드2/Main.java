package baekjoon.카드2;
import java.io.*;
import java.util.*;
public class Main {
	static class P2164 {
		BufferedReader br;
		int N;
		P2164() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			solve();
		}
		void solve() {
			Deque<Integer> card = new ArrayDeque<>();
			for(int i=1; i<=N; i++) {
				card.add(i);
			}
			while(card.size()>1) {
				// step 1 카드 버리기
				card.poll();
				// step 2 카드 맨 밑으로 옮기기
				card.addLast(card.poll());
			}
			System.out.println(card.poll());
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2164();
	}
}
