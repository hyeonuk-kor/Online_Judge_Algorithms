package baekjoon.음계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음계 {
	public static void main(String[] args) throws IOException {
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		if(str.equals("1 2 3 4 5 6 7 8"))
			System.out.println("ascending");
		else if(str.equals("8 7 6 5 4 3 2 1"))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
