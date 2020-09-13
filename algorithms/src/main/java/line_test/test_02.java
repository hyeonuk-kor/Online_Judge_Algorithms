package line_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class test_02 {

	public static void main(String[] args) throws Exception {

		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] order = {6, 2, 5, 1, 4, 3};
		
		List<Integer> list = Arrays.stream(ball).boxed().collect(Collectors.toList());
		List<Integer> olist = Arrays.stream(order).boxed().collect(Collectors.toList());
		int[] answer = new int[list.size()];
		int idx = 0;
		int aidx = 0;
		while(!olist.isEmpty()) {

			
			if(idx==olist.size())
				idx = 0;
			
			if(list.get(0)==olist.get(idx)) {
				answer[aidx++]=list.get(0);
				list.remove(0);
				olist.remove(idx);
				idx=0;
			} else if(list.get(list.size()-1)==olist.get(idx)) {
				answer[aidx++]=list.get(list.size()-1);
				list.remove(list.size()-1);
				olist.remove(idx);
				idx=0;
			} else {
				idx++;
			}

		}
		
		System.out.println(Arrays.toString(answer));


	}

}
