package baekjoon.가장긴감소하는부분수열;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int index = 0;
		ArrayList<Integer> seq = new ArrayList<>();
		ArrayList<Integer> subSeq = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) 
			seq.add(Integer.parseInt(st.nextToken()));
		subSeq.add(seq.get(N-1));
		for(int i=N-2; i>=0; i--) {
			if(subSeq.get(index)<seq.get(i)) {
				subSeq.add(seq.get(i));
				index++;
			} else {
				int right = Collections.binarySearch(subSeq, seq.get(i));
				if(right<0) 
					right = -right-1;
				subSeq.set(right, seq.get(i));
			}
		}
		bw.append((subSeq.size())+"\n");
		bw.flush();
	}
}