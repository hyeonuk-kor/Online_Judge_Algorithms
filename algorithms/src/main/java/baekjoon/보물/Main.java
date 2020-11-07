package baekjoon.보물;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> A = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		
		for(int i=0; i<N; i++) {
			A.add(new Integer(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> B = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		
		for(int i=0; i<N; i++) {
			B.add(new Integer(st.nextToken()));
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += A.poll() * B.poll();
		}
		
		System.out.println(sum);
	}

}
