package baekjoon.이천칠년;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int i=0; i<m-1; i++) {
			sum += months[i];
		}
		sum += d;
		sum%=7;
		
		switch (sum) {
		case 0:
			bw.append("SUN");
			break;
		case 1:
			bw.append("MON");
			break;
		case 2:
			bw.append("TUE");
			break;
		case 3:
			bw.append("WED");
			break;
		case 4:
			bw.append("THU");
			break;
		case 5:
			bw.append("FRI");
			break;
		case 6:
			bw.append("SAT");
			break;
		}
		bw.flush();
		bw.close();
	}
}
