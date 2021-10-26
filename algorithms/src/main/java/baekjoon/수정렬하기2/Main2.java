package baekjoon.수정렬하기2;
import java.util.*;
import java.io.*;
public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrNum = new ArrayList<>();
		
		for(int i =0; i<N; i++) {
			arrNum.add(Integer.parseInt(br.readLine()));
			
		}
		Collections.sort(arrNum);
		for(int i: arrNum)
            sb.append(i).append('\n');
        System.out.println(sb.toString());
            
	}
}