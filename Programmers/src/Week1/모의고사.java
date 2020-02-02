package Week1;

import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
	}

	private static int[] solution(int[] answers) {
		int[] answer = {};
		int[][] nomath = new int[3][];
		nomath[0] = new int[] {1,2,3,4,5};
		nomath[1] = new int[] {2,1,2,3,2,4,2,5};
		nomath[2] = new int[] {3,3,1,1,2,2,4,4,5,5};

		int[] p = new int[3];
		int[] a = new int[3];

		for(int i=0; i<answers.length; i++) {
			if(p[0]==nomath[0].length) p[0]=0;
			if(nomath[0][p[0]++]==answers[i]) a[0]++;
			
			if(p[1]==nomath[1].length) p[1]=0;
			if(nomath[1][p[1]++]==answers[i]) a[1]++;
			
			if(p[2]==nomath[2].length) p[2]=0;
			if(nomath[2][p[2]++]==answers[i]) a[2]++;
		}
		
		if(a[0]==a[1] && a[1]==a[2]) answer = new int[] {1,2,3};
		else if(a[0]==a[1] && a[2]<a[0]) answer = new int[] {1,2};
		else if(a[1]==a[2] && a[0]<a[1]) answer = new int[] {2,3};
		else if(a[0]==a[2] && a[1]<a[0]) answer = new int[] {1,3};
		else {
			if(a[0]>a[1] && a[0]>a[2]) answer = new int[] {1};			
			if(a[1]>a[0] && a[1]>a[2]) answer = new int[] {2};			
			if(a[2]>a[0] && a[2]>a[1]) answer = new int[] {3};			
		}
		
		return answer;
	}

}
