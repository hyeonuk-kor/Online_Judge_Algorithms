package baekjoon.농구경기;
import java.io.*;
import java.util.*;
public class Main {
	static class P1159 {
		BufferedReader br;
		int N;
		TreeMap<Character, Integer> map;
		P1159() {
			map = new TreeMap<>();
			input();
			StringBuilder sb = new StringBuilder();
			for(char c: map.keySet()) {
				if(map.get(c)>=5) {
					sb.append(c);
				}
			}
			if(sb.length()==0) {
				sb.append("PREDAJA");
			}
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					String name = br.readLine();
					map.put(name.charAt(0), map.getOrDefault(name.charAt(0), 0)+1);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1159();
	}
}