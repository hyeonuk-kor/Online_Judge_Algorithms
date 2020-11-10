package test;

import java.util.PriorityQueue;

public class 프로그램시간측정 {

	public static void main(String[] args) {
		
		long beforeTime = System.currentTimeMillis();
		
		//이 곳에 수행 할 문장 입력
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(100);
		pq.add(5);
		pq.add(2223);
		pq.add(424);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		long afterTime = System.currentTimeMillis();
		
		long exesec = (afterTime-beforeTime);
		System.out.println("시간 "+exesec+"ms");
		System.out.println("시간 "+exesec/1000.0+"초");
		
	}

}
