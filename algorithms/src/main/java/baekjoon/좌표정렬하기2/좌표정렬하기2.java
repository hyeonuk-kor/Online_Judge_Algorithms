package baekjoon.좌표정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.y == o.y)
			return Integer.compare(this.x, o.x);
		return Integer.compare(this.y, o.y);
	}

	@Override
	public String toString() {
		return x + " " + y + "\n";
	}
	
}

public class 좌표정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pq.add(p);
		}
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			bw.write(p.toString());
		}
		bw.close();
	}
}
