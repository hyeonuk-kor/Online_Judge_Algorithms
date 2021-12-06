package baekjoon.저항;
import java.io.*;
import java.util.*;
public class Main {
	static class P1076 {
		BufferedReader br;
		class Info {
			int index;
			int value;
			public Info(int index, int value) {
				this.index = index;
				this.value = value;
			}
		}
		Map<String, Info> map = new HashMap<>();
		P1076() {
			Info[] info = new Info[10];
			String[] color = {
				"black", "brown", "red", "orange", "yellow",
				"green", "blue", "violet", "grey", "white"
			};
			for(int i=0; i<10; i++) {
				info[i] = new Info(i, (int)Math.pow(10, i));
				map.put(color[i], info[i]);
			}
			input();
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int first_index = map.get(br.readLine()).index;
				int second_index = map.get(br.readLine()).index;
				long resistance = Long.parseLong(first_index+""+second_index);
				int mul = map.get(br.readLine()).value;
				System.out.println(resistance*mul);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1076();
	}
}