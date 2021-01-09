package baekjoon.잃어버린괄호;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int sum = 0;
		String[] splitMinus = input.split("[-]");
		for(int i=0; i<splitMinus.length; i++) {
			int calc = 0;
			String[] splitPlus = splitMinus[i].split("[+]");
			for(String number: splitPlus) 
				calc += Integer.parseInt(number);
			if(i==0) calc*=-1;
			sum-=calc;
		}
		System.out.println(sum);
	}
}
