package baekjoon.나무자르기;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int H = 1;
        int tree[] = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            tree[i] = Integer.valueOf(st.nextToken());
            H = Math.max(H, tree[i]);
        } // end input
        
        long low = 0;
        long high = H;
        while(low<=high) {
            long mid = (low+high)/2;
            long calc = 0;
            for(int i=0; i<N; i++) {
            	if(tree[i]>mid) 
            		calc += (tree[i] - mid);
            }
            if(calc<M) {
            	high = mid-1;
            } else {
            	low = mid+1;
            }
        }
        bw.append(high+"\n");
        bw.flush();
    }
}