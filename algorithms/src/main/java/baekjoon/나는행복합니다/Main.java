package baekjoon.나는행복합니다;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int f = sc.nextInt();
		
		int num = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(num++==f) {
					System.out.println(i+" "+j);
					System.exit(0);
				}
			}
		}
	}
}
