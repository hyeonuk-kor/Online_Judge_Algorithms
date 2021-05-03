package swexperts.반반;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			char[] S = br.readLine().toCharArray();
			String answer = "No";
			if(S[0]==S[1] && S[2]==S[3] && S[1]!=S[2])
				answer = "Yes";
			else if(S[0]==S[2] && S[1]==S[3] && S[2]!=S[1])
				answer = "Yes";			
			else if(S[0]==S[3] && S[1]==S[2] && S[3]!=S[1])
				answer = "Yes";
			System.out.println("#"+tc+" "+answer);
		}
	}
}