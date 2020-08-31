package baekjoon.평균은넘겠지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<C; tc++) {
			st = new StringTokenizer(br.readLine());
			int studentNum = Integer.parseInt(st.nextToken());
			int[] student = new int[studentNum];
			
			int sum = 0;
			for (int i = 0; i < student.length; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				sum += student[i];
			}
			
			double avg = (double)sum/studentNum;
			int count = 0;
			for (int i : student) {
				if(i>avg)
					count++;
			}
			
			sb.append((String.format("%.3f", (double)count/studentNum*100.0)+"%\n"));
		}
		
		System.out.println(sb);
		
	}
	
}
