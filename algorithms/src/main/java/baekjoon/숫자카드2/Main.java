package baekjoon.숫자카드2;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else
				map.put(key, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				bw.append(map.get(key)+" ");
			} else {
				bw.append("0 ");
			}
		}
		
		bw.flush();
	}
}
