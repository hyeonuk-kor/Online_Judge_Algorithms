package baekjoon.통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 통계학 {

	public static void main(String[] args) throws Exception {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		Arrays.sort(number);

		//1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
		double sum = 0;
		for(int i=0; i<number.length; i++)
			sum+=number[i];
		int avg = (int) Math.round((double)sum/N);

		//2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		int mid = number[number.length/2];

		//3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
		int[] signNumber = new int[8001]; //4000미만의 수는 음수, 4000=0, 4000초과 수는 양수 
		for(int i=0; i<number.length; i++) //카운팅 정렬
			signNumber[number[i]+4000]++;

		int mode = 0; 	//구하고자 하는 최빈 값
		int modeMax = 0; //최빈 값에 해당하는 개수 [여러개가 존재할 수도 있음]

		for(int i=0; i<signNumber.length; i++) { //반복문을 통해 최빈 값에 해당하는 개수를 구한다. 
			if(modeMax < signNumber[i]) { 
				modeMax = signNumber[i];	// 카운팅 정렬 된 인덱스를 modeMax에 넣어준다.
				mode = i;	//그 인덱스가 최빈 값 후보다.
			}
		}

		int count = 0; //최빈 값 후보의 개수
		int getNumber[] = new int[8001]; //최빈 값의 후보들을 저장하는 배열
		getNumber[0] = mode; // 최빈 값이 하나일 수도 있다.
		
		for(int i=0; i<signNumber.length; i++) {
			if(signNumber[i]==modeMax) { // 카운팅 정렬 된 최빈 값 후보의 값이 최빈값에 해당하는 개수라면
				getNumber[count++]=i; // 후보에 넣어준다.
			}
		}
		
		if(count==0) {
			mode = getNumber[0]; //최빈 값의 후보가 하나라면 바로 mode를 구할 수 있다.
		} else if(count>1) { //최빈 값의 후보가 여러개라면
			int[] preSet = new int[count]; //후보들을 정렬하기 위해 배열을 만든다.
			for (int i = 0; i < preSet.length; i++) { // 값을 넣어주고
				preSet[i] = getNumber[i];
			}
			Arrays.sort(preSet); //정렬 한다.
			Set<Integer> set = new LinkedHashSet<Integer>(); //순서를 유지하고 중복을 제거하기 위해 링크드해시셋을 사용, 그냥 해시셋은 순서를 보장해주지 않는다.
			for(int i=0; i<count; i++) {
				set.add(preSet[i]);
			}
			
			int i = 0;
			for (Integer integer : set) {
				if(i==1) {
					mode = integer; // 두번째 값이라면
					break; // 종료한다.
				} else {
					i++;
				}
			}
		}
		mode = mode - 4000; //다시 원래의 수로 돌린다.
		
		//4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
		int max = number[number.length-1];
		int min = number[0];
		int range = max - min;

		System.out.println(avg);
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(range);
		/*
		 * line 1 [소수 첫째 자리에서 반올림]
		 * line 2 [중앙값 출력]
		 * line 3 [최빈값이 여러개라면 두번째로 작은 값 출력]
		 * line 4 [범위를 출력 ]
		 */

	}

}
