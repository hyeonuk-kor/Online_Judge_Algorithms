package baekjoon.트럭;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int time = 0;
		Queue<Integer> truck = new ArrayDeque<>();
		Queue<Integer> bridge = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		while(!truck.isEmpty()) {
			if(bridge.size()<w) {
				if(L>=truck.peek()) {
					L -= truck.peek();
					bridge.add(truck.poll());
				} else {
					bridge.add(0);
				}
				time++;
			} else {
				L += bridge.poll();
			}
		}
		System.out.println(time+w);
	}
}
