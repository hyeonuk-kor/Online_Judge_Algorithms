package baekjoon.이진탐색트리;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet<Integer> set = new TreeSet<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			bw.append(iter.next()+"\n");
		}
		bw.flush();
	}
}
