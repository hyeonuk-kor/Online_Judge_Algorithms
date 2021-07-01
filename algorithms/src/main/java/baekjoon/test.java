package baekjoon;
import java.util.*;
public class test {
	static int[] number = {1, 2, 3};
	static int[] selectNumber;
	/*
	 * i=1 : 1, 2, 3, 4, 5
	 * i=2 : 12, 13, 14, 15, 21, 23, 24, 25, 31, 32, 34, 35, 41, 42, 43, 45, 51, 52, 53, 54
	 * ...
	 * i=5 : 12345, 21345, ...
	 */ // n과 m 시리즈를 모두 푼다.
	static boolean[] check; // 왜 필요할까?
	public static void main(String[] args)  {
		simulation();
	}
	static void simulation() {
		check = new boolean[number.length]; // 중복을 방지하기 위함.
		for(int i=1; i<=number.length; i++) { // i개를 선택할 수 있도록 하는 반복문
			selectNumber = new int[i]; // i개를 담을 배열
			getNumber(0, i);
		}
	}
	static void getNumber(int index, int depth) {
		if(index==depth) { //종료 조건
			System.out.println(Arrays.toString(selectNumber));
			return;
		}
		for(int i=0; i<number.length; i++) {
			if(!check[i]) {
				check[i] = true;
				selectNumber[index] = number[i]; //사용하지 않은 숫자를 selectNumber에 넣어준다.
				getNumber(index+1, depth);
				check[i] = false;
			}
		}
	}
}