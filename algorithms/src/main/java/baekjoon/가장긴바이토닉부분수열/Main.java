package baekjoon.가장긴바이토닉부분수열;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int index = 0;
		int lisIndex[] = new int[N];
		int ldsIndex[] = new int[N];
		ArrayList<Integer> seq = new ArrayList<>();
		ArrayList<Integer> incSeq = new ArrayList<>();
		ArrayList<Integer> decSeq = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) 
			seq.add(Integer.parseInt(st.nextToken()));
		incSeq.add(seq.get(0));
		for(int i=1; i<N; i++) {
			if(incSeq.get(index)<seq.get(i)) {
				incSeq.add(seq.get(i));
				index++;
				lisIndex[i] = index;
			} else {
				int right = Collections.binarySearch(incSeq, seq.get(i));
				if(right<0) 
					right = -right-1;
				incSeq.set(right, seq.get(i));
				lisIndex[i] = right;
			}
		}
		
		decSeq.add(seq.get(N-1));
		index = 0;
		for(int i=N-2; i>=0; i--) {
			if(decSeq.get(index)<seq.get(i)) {
				decSeq.add(seq.get(i));
				index++;
				ldsIndex[i] = index;
			} else {
				int right = Collections.binarySearch(decSeq, seq.get(i));
				if(right<0) 
					right = -right-1;
				decSeq.set(right, seq.get(i));
				ldsIndex[i] = right;
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			if(lisIndex[i]!=0 && ldsIndex[i]!=0)
				max = Math.max(max, lisIndex[i] + ldsIndex[i]);
		}
		bw.append(max+1+"\n");
		bw.flush();
	}
}