package baekjoon.시리얼번호;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int N =  Integer.parseInt(br.readLine());
		String[] serialNumber = new String[N];
		for(int i=0; i<N; i++) 
			serialNumber[i] = br.readLine();
		Arrays.sort(serialNumber, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					int o1_sum = 0, o2_sum = 0;
					for(int i=0; i<o1.length(); i++) {
						if(o1.charAt(i)>='1' && o1.charAt(i)<='9') 
							o1_sum += (o1.charAt(i)-'0');
						if(o2.charAt(i)>='1' && o2.charAt(i)<='9') 
							o2_sum += (o2.charAt(i)-'0');
					}
					if(o1_sum==o2_sum)
						return o1.compareTo(o2);
					return Integer.compare(o1_sum, o2_sum);
				} 
				return Integer.compare(o1.length(), o2.length());
			}
		});
		for(String s: serialNumber)
			pw.println(s);
		pw.flush();
	}
}