package swexperts.사탕가방;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			Integer N = Integer.valueOf(st.nextToken());
			Long M = Long.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			Long candy[] = new Long[N];
			Long max = Long.MIN_VALUE;
			for(int i=0; i<N; i++) {
				candy[i] = Long.valueOf(st.nextToken());
				max = Math.max(max, candy[i]);
			}
			Long low = 1L;
			Long high = max;
			while(low<=high) {
				Long mid = (low+high)/2;
				Long sum = 0L;
				for(int i=0; i<N; i++) 
					sum += (candy[i]/mid);
				if(sum<M) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
			bw.append("#"+tc+" "+high+"\n");
		}
		bw.flush();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
