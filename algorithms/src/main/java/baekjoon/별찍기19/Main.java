package baekjoon.별찍기19;
import java.util.*;
public class Main {

	static int N;
	static char map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[4*N-3][4*N-3];
		for(int i=0; i<map.length; i++) {
			Arrays.fill(map[i],' ');
		}
		fillArray(0,0,N);
	}

	static void fillArray(int y, int x, int size) {
		if(size==0) 
			return;
		
		for(int i=0; i<size; i++) {
			if(i==0 || i==y-1)
		}
	}

}
