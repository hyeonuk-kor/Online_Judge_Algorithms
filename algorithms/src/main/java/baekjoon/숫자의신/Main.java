package baekjoon.숫자의신;
import java.util.*;
public class Main {
	static int K, N;
	static String number[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		number = new String[N];
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<K; i++) {
			number[i] = sc.next();
			if(Integer.parseInt(number[i])>max) 
				max = Integer.parseInt(number[i]);
		}
		
		for(int i=K; i<N; i++)
			number[i] = max+"";
		
		Arrays.sort(number, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.concat(o2).compareTo(o2.concat(o1));
			}
		});
		
		for(String i: number)
			System.out.print(i);
		System.out.println();
		
	}
}
