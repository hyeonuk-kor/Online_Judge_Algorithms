package baekjoon.홀수;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = 0;
		for(int i=0; i<7; i++) {
			Integer number = Integer.parseInt(br.readLine());
			if(number%2==0) {
				count++;
				continue;
			}
			else pq.add(number);
		}
		
		if(count==7) {
			bw.append("-1\n");
		} else {
			Integer sum = pq.poll();
			Integer min = sum;
			while(!pq.isEmpty()) {
				sum += pq.poll();
			}
			bw.append(sum+"\n");
			bw.append(min+"\n");
		}
		bw.flush();
	}

}
