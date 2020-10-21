package baekjoon.별찍기17;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][2*N];
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-i-1; j++) {
				map[i][j]=' ';
			}
			map[i][N-i-1]='*';
			for(int j=N-i; j<N+i; j++) {
				map[i][j]=' ';
			}
			map[i][N+i-1] = '*';
			map[i][N+i]='a';
		}
		for(int i=0; i<2*N-1; i++) {
			map[N-1][i]='*';
		}
		map[N-1][2*N-1]='a';
		
		for(int i=0; i<N; i++) {
			for(int j=0; map[i][j]!='a'; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
