package baekjoon.소트인사이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드 {

	public static void main(String[] args) throws Exception {
		char[] number = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		Arrays.sort(number);
		System.out.println(new StringBuilder(new String(number)).reverse());
	}

}
