package baekjoon.좌표정렬하기;

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
		if(this.x == o.x)
			return Integer.compare(this.y, o.y);
		return Integer.compare(this.x, o.x);
	}

	@Override
	public String toString() {
		return x + " " + y + "\n";
	}
	
}