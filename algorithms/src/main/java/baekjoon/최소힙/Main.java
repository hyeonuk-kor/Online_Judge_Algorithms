package baekjoon.최소힙;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			int number = sc.nextInt();
			if(number==0) {
				if(pq.size()==0)
					sb.append(0).append('\n');
				else
					sb.append(pq.poll()).append('\n');
			} else {
				pq.add(number);
			}
		}
		System.out.println(sb.toString());
	}

}
