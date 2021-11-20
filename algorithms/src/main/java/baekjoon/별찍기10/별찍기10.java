package baekjoon.별찍기10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 별찍기10 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				draw(i, j, N);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void draw(int y, int x, int size) {
		if((y/size)%3==1 && (x/size)%3==1) {
			System.out.println(y+" "+x+" "+size);
			sb.append(' ');
		} else {
			if(size/3==0) {
				sb.append('*');
			} else {
				draw(y, x, size/3);
			}
		}
		
	}

}
