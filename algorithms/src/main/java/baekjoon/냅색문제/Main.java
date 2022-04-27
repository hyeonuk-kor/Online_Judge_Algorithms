package baekjoon.냅색문제;
import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;
	static int N, C, W[];
	static long answer;
	static List<Long> list;
 	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++)
			W[n] = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		powerSet(0, true, 0);
		Collections.sort(list);
		powerSet(N/2, false, 0);
		pw.println(answer);
		pw.flush();
	}
 	static long parametricSearch(long sum) {
		int left = 0, right = list.size()-1;
		long result = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			if(det(mid, sum)) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}
 	static boolean det(int mid, long sum) {
		return list.get(mid)+sum <= C;
	}
	static void powerSet(int index, boolean dir, long sum) {
		if(sum>C)
			return;
		if(dir && index==N/2) {
			list.add(sum);
		} else if(!dir && index==N) {
			long result = parametricSearch(sum);
			answer += (result+1);
		} else {
			powerSet(index+1, dir, sum);
			powerSet(index+1, dir, sum+W[index]);
		}
	}
}
