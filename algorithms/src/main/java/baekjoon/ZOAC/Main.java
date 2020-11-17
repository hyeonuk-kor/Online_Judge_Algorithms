package baekjoon.ZOAC;
import java.util.*;
import java.io.*;
class Str implements Comparable<Str>{
	String s;
	int index;
	
	public Str(String s, int index) {
		this.s = s;
		this.index = index;
	}

	@Override
	public int compareTo(Str o) {
		return this.s.compareTo(o.s);
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		boolean[] check = new boolean[input.length()];
		PriorityQueue<Str> pq = new PriorityQueue<Str>();
		for(int i=0; i<input.length(); i++) {
			pq.add(new Str(input.charAt(i)+"", i));
		}
		
		int step = 0;
		while(step!=input.length()) {
			Str t = pq.poll();
			check[t.index] = true;
			bw.append(t.s);
			pq.clear();
			for(int i=0; i<input.length(); i++) {
				String add = "";
				if(!check[i]) {
					for(int j=0; j<input.length(); j++) {
						if(i==j || check[j])
							add+=input.charAt(j);
					}
					pq.add(new Str(add, i));
				}
			}
			bw.append("\n");
			step++;
		}
		bw.flush();
	}
}
