package baekjoon.화살을쏘자;
import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
	static Map<Double, Integer> q1, q2, q3, q4;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		q1 = new HashMap<Double, Integer>();
		q2 = new HashMap<Double, Integer>();
		q3 = new HashMap<Double, Integer>();
		q4 = new HashMap<Double, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Double x = Double.parseDouble(st.nextToken());
			Double y = Double.parseDouble(st.nextToken());
			Double key = (x==0) ? x : (y/x);
			check(x, y, key);
		}
		System.out.println(getMax());
	}
	
	private static int getMax() {
		List<Entry<Double, Integer>> entries = new LinkedList<>();
		entries.addAll(q1.entrySet());
		entries.addAll(q2.entrySet());
		entries.addAll(q3.entrySet());
		entries.addAll(q4.entrySet());
		Collections.sort(entries, new Comparator<Entry<Double, Integer>>() {
			@Override
			public int compare(Entry<Double, Integer> o1, Entry<Double, Integer> o2) {
				return Integer.compare(o2.getValue(), o1.getValue());
			}
		});
		return entries.get(0).getValue();
		
	}

	static void check(Double x, Double y, Double key) {
		if(x<=0 && y>0) {
			if(q1.containsKey(key)) {
				q1.put(key, q1.get(key)+1);
			} else {
				q1.put(key, 1);
			}
		} else if(x>0 && y>=0) {
			if(q2.containsKey(key)) {
				q2.put(key, q2.get(key)+1);
			} else {
				q2.put(key, 1);
			}
		} else if(x>0 && y<0) {
			if(q3.containsKey(key)) {
				q3.put(key, q3.get(key)+1);
			} else {
				q3.put(key, 1);
			}
		} else {
			if(q4.containsKey(key)) {
				q4.put(key, q4.get(key)+1);
			} else {
				q4.put(key, 1);
			}
		}
		
	}

}