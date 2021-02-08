package baekjoon.맥주마시면서걸어가기;
import java.io.*;
import java.util.*;
class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point store[] = new Point[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			Point festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			Set<Point> set = new HashSet<>();
			q.add(new int[] {home.getX(), home.getY()});
			set.add(home);
			boolean check = false;
			while(!q.isEmpty()) {
				int info[] = q.poll();
				Point c = new Point(info[0], info[1]);
				if(getManhattanDistance(c.getX(), c.getY(), festival.getX(), festival.getY())<=1000) {
					check = true;
					break;
				}
				for(int i=0; i<n; i++) {
					if(!set.contains(store[i]) && getManhattanDistance(store[i].getX(), store[i].getY(), c.getX(), c.getY())<=1000) {
						q.add(new int[] {store[i].getX(), store[i].getY()});
						set.add(store[i]);
					}
				}
			}
			pw.println(check?"happy":"sad");
		}
		pw.flush();
	}
	static int getManhattanDistance(int x, int y, int x2, int y2) {
		return Math.abs(x-x2)+Math.abs(y-y2);
	}
}