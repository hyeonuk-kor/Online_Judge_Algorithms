package baekjoon.IQTest;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		
		int coef = 0;
		int exp = 0;
		
		if(num.length==1)
			sb.append("A");
		else if(num.length==2)
			sb.append(num[0]==num[1] ? num[0] : "A");
		else if(num.length>=3) {
			boolean check=true;
			for(int i=0; i<num.length-1; i++) {
				if(i==0) {
					int fx = num[i];
					int nfx = num[i+1];
					int nnfx = num[i+2];
					
					try {						
						coef = (nnfx - nfx) / (nfx - fx);
					} catch (Exception e) {
						coef = 0;
					}
					exp = nfx - (fx*coef);
				}
				
				int checkNum = num[i]*coef + exp;
				int equalNum = num[i+1];
				
				if(checkNum!=equalNum)
					check = false;
			}
			
			sb.append(check ? num[num.length-1]*coef+exp : "B");
			
		}
		
		System.out.println(sb);
	}
	
}