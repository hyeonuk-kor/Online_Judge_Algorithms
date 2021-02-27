package swexperts.주스;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.valueOf(br.readLine());
			ArrayList<ArrayList<Integer>> juice = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				ArrayList<Integer> arr = new ArrayList<>();
				for(int j=0; j<3; j++) {
					arr.add(Integer.valueOf(st.nextToken()));
				}
				juice.add(arr);
			}
			Integer left = 0;
			Integer right = 10000;
			Integer max = 0;
			while(left<=right) {
				Integer mid1 = (left*2+right)/3;
				Integer mid2 = (right*2-left)/3;
				Integer apple = mid1;
				Integer banana = mid2-mid1;
				Integer carrot = 10000-mid2;
				Integer count = 0;
				for(int i=0; i<N; i++) {
					
				}
			}
			bw.append("#"+tc+" "+max+"\n");
		}
		bw.flush();
	}
}
