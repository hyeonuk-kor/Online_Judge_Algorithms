package baekjoon.등차수열변환;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		if (n == 1) {
			System.out.println(0);
			return;
		}
		int ans = -1;
		for (int d1 = -1; d1 <= 1; d1++) {
			for (int d2 = -1; d2 <= 1; d2++) {
				int c = 0;
				if (d1 != 0)
					c++;
				if (d2 != 0)
					c++;
				int a0 = a[0] + d1;
				int d = (a[1] + d2) - a0;
				boolean ok = true;
				int an = a0 + d;
				for (int i = 2; i < n; i++) {
					an += d;
					if (a[i] == an)
						continue;
					if (a[i] - 1 == an) {
						c++;
					} else if (a[i] + 1 == an) {
						c++;
					} else {
						ok = false;
						break;
					}
				}
				if (ok) {
					if (ans == -1 || ans > c)
						ans = c;
				}
			}
		}
		System.out.println(ans);
	}

}
