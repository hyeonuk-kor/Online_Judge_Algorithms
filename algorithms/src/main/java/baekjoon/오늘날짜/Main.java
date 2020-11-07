package baekjoon.오늘날짜;

import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws Exception{
		SimpleDateFormat get = new SimpleDateFormat("YYYY-MM-dd");
		String today = get.format(System.currentTimeMillis());
		System.out.println(today);
	}
}
