package baekjoon.카드;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new TreeMap<>();
		int max = 0;
		for(int i=0; i<N; i++) {
			Long number = Long.parseLong(br.readLine());
			map.put(number, map.getOrDefault(number, 0)+1);
			max = Math.max(map.get(number), max);
		}
		for(Map.Entry<Long, Integer> n: map.entrySet()) {
			if(n.getValue()==max) {
				pw.println(n.getKey());
				break;
			}
		}
		pw.flush();
	}
}