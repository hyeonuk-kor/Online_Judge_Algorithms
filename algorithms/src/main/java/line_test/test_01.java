package line_test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class test_01 {

	public static void main(String[] args) throws Exception {
		
		int[][] boxes = {{1,2},{2,1},{3,3}};
		int boxCnt = boxes.length;
		
		int max = 0;
		for(int i=0; i<boxCnt; i++) {
			for(int j : boxes[i])
				if(max<j)
					max = j;
		}
		
		int[] number = new int[max+1];

		for(int i=0; i<boxCnt; i++) {
			for(int j: boxes[i]) {
				number[j]++;
			}
		}
		
		int answer = 0;
		int jc = 0;
		for(int i=1; i<number.length; i++) {
			if(answer==boxCnt)
				break;
			if(number[i]%2==0 && number[i]>1) {
				jc++;
			}
		}
		
		boxCnt -= jc;
		
		for(int i=1; i<number.length; i++) {
			if(answer==boxCnt)
				break;
			if(number[i]%2==1 && number[i]!=-1) {
				answer++;
			}
		}
		
		
		System.out.println(answer);
		
	}

}
