package Programmers.GomStudy.Week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point moved(int dx, int dy) {
		return new Point(x+dx, y+dy);
	}

	public boolean isAvailable() {
		return -5<=x && x<= 5 && -5 <= y && y <= 5;
	}

	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x && y==point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	
	

}

class Path {
	
	Point start, end;
	
	public Path(Point start, Point end) {
		this.start =start;
		this.end = end;
	}


	@Override
	public int hashCode() {
		return start.hashCode()+end.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false; //getClass : 객체가 속한 정보
		Path path = (Path) o;
		return (start.equals(path.start) && end.equals(path.end)) || 
				(start.equals(path.end) && end.equals(path.start)); 
	}
	


}

public class 방문길이풀이 {


	public static void main(String[] args) {
		System.out.println(Solution("LLRRRRDDS"));
	}

	private static int Solution(String dirs) {
		Set<Path> routes = new HashSet<>();
		
		Point start = new Point(0, 0 );

		for(char d: dirs.toCharArray()) {
			Point end = null;
			switch(d) {
				case 'U':
					end = start.moved(0,-1);
					break;
				case 'D':
					end = start.moved(0,1);
					break;
				case 'L':
					end = start.moved(-1,0);
					break;
				case 'R':
					end = start.moved(1,0);
					break;
			}

			if(end==null) continue;
			if(!end.isAvailable()) continue;
			
			routes.add(new Path(start, end));
			start = end;
		}
		

		return routes.size();		
	}

}
