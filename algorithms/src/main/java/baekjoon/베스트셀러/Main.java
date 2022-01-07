package baekjoon.베스트셀러;
import java.io.*;
import java.util.*;
public class Main {
	static class P1302 {
		BufferedReader br;
		int N;
		Map<String, Integer> map;
		P1302() {
			map = new TreeMap<>();
			input();
			pro();
		}
		void pro() {
			List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
			list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
			System.out.println(list.get(0).getKey());
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int i=0; i<N; i++) {
					String key = br.readLine();
					int value = map.getOrDefault(key, 0);
					map.put(key, value+1);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1302();
	}
}