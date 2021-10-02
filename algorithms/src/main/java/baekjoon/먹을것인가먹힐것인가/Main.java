package baekjoon.먹을것인가먹힐것인가;
import java.io.*;
import java.util.*;
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i] = scan.nextInt();
        }
    }
    static int lower_bound(int[] list, int value) {
    	int left = 0;
    	int right = list.length-1;
    	while(left<=right) {
    		int mid = (left+right)/2;
    		if(list[mid]<value) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	return left;
    }
    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
        	int index = lower_bound(B, A[i]);
        	ans += index;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int TT;
        TT = scan.nextInt();
        for (int tt = 1; tt <= TT; tt++) {
            input();
            pro();
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}