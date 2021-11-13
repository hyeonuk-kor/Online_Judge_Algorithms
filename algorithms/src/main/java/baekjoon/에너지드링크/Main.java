package baekjoon.에너지드링크;
import java.io.*;
import java.util.*;
public class Main {
	static class P20115 {
		BufferedReader br;
		StringTokenizer st;
		int N;
		PriorityQueue<Integer> energy_drink;
		P20115() {
			input();
			solve();
		}
		void solve() {
			double sum = energy_drink.poll();
			while(!energy_drink.isEmpty()) {
				sum += energy_drink.poll()/2.0;
			}
			System.out.println(sum);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				energy_drink = new PriorityQueue<>(Collections.reverseOrder());
				st = new StringTokenizer(br.readLine().trim());
				for(int i=0; i<N; i++) {
					energy_drink.add(Integer.parseInt(st.nextToken()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P20115();
	}
}
