package baekjoon.가장긴증가하는부분수열2;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> lis = new ArrayList<>();
		for(int i=0; i<N; i++) 
			arr.add(Integer.parseInt(st.nextToken()));
		lis.add(arr.get(0));
		int idx = 1;
		int temp = 0;
		for(int i=1; i<N; i++) {
			if(lis.get(idx-1)<arr.get(i)) {
				lis.add(idx++, arr.get(i));
			} else if(lis.get(0)>arr.get(i)) {
				lis.set(0, arr.get(i));
			} else {
				temp = Collections.binarySearch(lis, arr.get(i));
				if(temp>=0) {
					lis.set(temp, arr.get(i));
				} else {
					lis.set(-temp-1, arr.get(i));
				}
			}
		}
		
		bw.append(idx+"\n");
		bw.flush();
	}
}