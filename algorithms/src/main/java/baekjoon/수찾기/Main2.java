package baekjoon.수찾기;
import java.io.*;
import java.util.*;

public class Main2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean bin_search(int[] A, int L,int R, int X){
        // A[L...R] 에서 X가 있으면 true, 없으면 false를 return 하는 함수
        /* TODO */
    	while(L<=R) {
    		int mid = (L+R)/2;
    		if(A[mid]<X) {
    			L = mid + 1;
    		} else if(A[mid]>X) {
    			R = mid - 1;
    		} else {
    			return true;
    		}
    	}
    	return false;
    }

    static void pro() {
        int M = scan.nextInt();
        // 정렬 해주기!
        /* TODO */
        Arrays.sort(A, 1, N+1);
        
        for (int i = 1; i <= M; i++) {
            int X = scan.nextInt();
            /* TODO*/
            if(bin_search(A, 1, N, X))
            	sb.append(1+"\n");
            else
            	sb.append(0+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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