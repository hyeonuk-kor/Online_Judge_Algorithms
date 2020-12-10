package baekjoon.가운데를말해요;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			if(i%2==0) maxHeap.add(number);
			else minHeap.add(number);

			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int temp = minHeap.poll();
					minHeap.add(maxHeap.poll());
					maxHeap.add(temp);
				}
			}

			bw.append(maxHeap.peek()+"\n");
		}
		bw.flush();
	}
}
