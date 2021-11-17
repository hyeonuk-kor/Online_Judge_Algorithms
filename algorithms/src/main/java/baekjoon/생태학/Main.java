package baekjoon.생태학;
import java.io.*;
import java.util.*;
public class Main {
	static class P4358 {
		BufferedReader br;
		StringBuilder sb;
		TreeMap<String, Integer> map;
		double count;
		P4358() {
			map = new TreeMap<>();
			input();
			sb = new StringBuilder();
			for(String name: map.keySet()) {
				double p = map.get(name)/count*1e6/1e4;
				sb.append(name).append(' ').append(String.format("%.4f", p)).append('\n');
			}
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String tree = br.readLine();
				while(tree!=null && !tree.isEmpty()) {
					count++;
					map.put(tree, map.getOrDefault(tree, 0)+1);
					tree = br.readLine();
				}
				br.close();
 			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P4358();
	}
}