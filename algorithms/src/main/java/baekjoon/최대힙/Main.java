package baekjoon.최대힙;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int number = sc.nextInt();
			if(number==0) {
				if(pq.size()==0) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}
			} else {
				pq.add(number);
			}
		}
		System.out.println(sb.toString());
	}
}
