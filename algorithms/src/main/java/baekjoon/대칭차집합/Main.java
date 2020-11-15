package baekjoon.대칭차집합;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int ac = Integer.parseInt(st.nextToken());
		int bc = Integer.parseInt(st.nextToken());
		TreeSet<Integer> A = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<ac; i++) 
			A.add(Integer.parseInt(st.nextToken()));
		
		TreeSet<Integer> B = new TreeSet<>();
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<bc; i++) 
			B.add(Integer.parseInt(st.nextToken()));
	
		int ab = 0;
		Iterator<Integer> iter = B.iterator();
		while(iter.hasNext()) {
			if(!A.contains(iter.next()))
				ab++;
		}
		
		int ba = 0;
		iter = A.iterator();
		while(iter.hasNext()) {
			if(!B.contains(iter.next()))
				ba++;
		}
		
		System.out.println(ab+ba);
	}
}
