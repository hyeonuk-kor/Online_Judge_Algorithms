package baekjoon.셀프넘버;

public class 셀프넘버 {
		
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] numberCheck = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			int idx = d(i);
			if(idx <= 10000)
				numberCheck[idx]=true;
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(!numberCheck[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
		
	}

	private static int d(int i) {
		int sum = i;
		while(i>0) {
			sum += i%10;
			i/=10;
		}
		return sum;
	}

}
