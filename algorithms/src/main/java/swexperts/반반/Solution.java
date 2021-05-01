package swexperts.반반;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			String S = br.readLine();
			String ptc = "#"+tc+" ";
			boolean check = true;
			int[] alpha = new int[26];
			for(int i=0; i<4; i++) { 
				int index = S.charAt(i)-'A';
				alpha[index] += 1;
			}
			for(int i=0; i<26; i++)
				if(alpha[i]%2==1 || alpha[i]>2)
					check = false;
			if(check)
				System.out.println(ptc+"Yes");
			else
				System.out.println(ptc+"No");
		}
	}
}