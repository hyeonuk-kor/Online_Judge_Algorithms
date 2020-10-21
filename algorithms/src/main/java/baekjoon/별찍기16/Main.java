package baekjoon.별찍기16;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][2*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				map[i][j]=' ';
			}
			boolean check = false;
			for(int j=N-i-1; j<N+i; j++) {
				if(!check) {
					map[i][j]='*';
					check=true;
				} else {
					map[i][j]=' ';
					check=false;
				}
			}
			map[i][N+i]='a';
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; map[i][j]!='a'; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
}
