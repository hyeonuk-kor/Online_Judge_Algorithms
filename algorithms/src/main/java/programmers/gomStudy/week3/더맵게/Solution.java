package programmers.gomStudy.week3.더맵게;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public int soulution(int[] scoville, int K) {
		int count = 0;
		
		Queue<Integer> list = new PriorityQueue<>();
		for(int s : scoville) list.offer(s);
		//Collections.sort(list);
		
		//효율성 테스트
		// (1) 루프
		// (2) 자료구조
		
		
		while(list.peek()<K) {
			int s = list.poll() + list.poll() * 2;
			list.add(s);
			count++;
			//Collections.sort(list);
		}
		
		if(list.peek()<K) return -1;
		return count;
	}
		
}
