package baekjoon.가장긴증가하는부분수열4;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int index = 0, lisIndex[] = new int[N];
		ArrayList<Integer> seq = new ArrayList<>();
		ArrayList<Integer> subSeq = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) 
			seq.add(Integer.parseInt(st.nextToken()));
		subSeq.add(seq.get(0));
		for(int i=1; i<N; i++) {
			if(subSeq.get(index)<seq.get(i)) {
				subSeq.add(seq.get(i));
				index++;
				lisIndex[i] = index;
			} else {
				int right = Collections.binarySearch(subSeq, seq.get(i));
				if(right<0) 
					right = -right-1;
				subSeq.set(right, seq.get(i));
				lisIndex[i] = right;
			}
		}
		bw.append((subSeq.size())+"\n");
		for(int i=N-1; i>=0; i--) {
			if(lisIndex[i]==index) {
				answer.add(seq.get(i));
				index--;
			}
		}
		for(int i=answer.size()-1; i>=0; i--) 
			bw.append(answer.get(i)+" ");
		bw.flush();
	}
}