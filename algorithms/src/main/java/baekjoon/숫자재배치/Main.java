package baekjoon.숫자재배치;
import java.util.*;
public class Main {
    static int a[], b, n;
    static boolean[] check;
    static int go(int index, int num) {
        if (index == n) {
            return num;
        }
        int ans = -1;
        for (int i=0; i<n; i++) {
            if (check[i] == true) continue;
            if (index == 0 && a[i] == 0) continue;
            check[i] = true;
            int temp = go(index+1, num*10+a[i]);
            if (temp < b) {
                if (ans == -1 || ans < temp) {
                    ans = Math.max(ans, temp);
                }
            }
            check[i] = false;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        n = num.length();
        a = new int[n];
        check = new boolean[n];
        for (int i=0; i<n; i++) {
            a[i] = num.charAt(i) - '0';
        }
        b = sc.nextInt();
        System.out.println(go(0,0));
    }
}