package baekjoon.배;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.valueOf(br.readLine());
		ArrayList<Integer> cranes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int number = Integer.valueOf(st.nextToken());
			cranes.add(number);
		}
		int M = Integer.valueOf(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int number = Integer.valueOf(st.nextToken());
			boxes.add(number);
		}
		Collections.sort(cranes, Comparator.reverseOrder());
		Collections.sort(boxes, Comparator.reverseOrder());
		int time = 0;
		if(boxes.get(0)>cranes.get(0)) {
			time = -1;
		} else {
			while(!boxes.isEmpty()) {
				int crane_index = 0;
				int box_index = 0;
				while(crane_index<N) {
					if(boxes.isEmpty()) {
						break;
					}
					if(boxes.get(box_index) <= cranes.get(crane_index)) {
						boxes.remove(box_index);
						crane_index++;
					} else {
						box_index++;
					}
				}
				time++;
			}
		}
		System.out.println(time);
	}
}
