package baekjoon.이전순열;
import java.util.*;
public class Main {
	static int N, a[];
	static void next_permutation() {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
    }
	static boolean prev_permutation() {
        int i = a.length-1;
        while (i > 0 && a[i-1] <= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = i-1;
        while (j+1 <= a.length-1 && a[j+1] <= a[i-1]) {
            j += 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		if(prev_permutation()) {
			for(int i=0; i<N; i++)
				System.out.print(a[i]+" ");
		} else {
			System.out.println(-1);
		}
	}
}