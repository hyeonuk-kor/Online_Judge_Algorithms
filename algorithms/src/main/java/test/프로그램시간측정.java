package test;

public class 프로그램시간측정 {

	public static void main(String[] args) {
		
		long beforeTime = System.currentTimeMillis();
		
		//이 곳에 수행 할 문장 입력
		long sum = 0;
		for(int i=1; i<=100000000; i++) 
			sum = sum + i;
		System.out.println(sum);
		// 종료
		
		long afterTime = System.currentTimeMillis();
		
		long exesec = (afterTime-beforeTime);
		System.out.println("시간 "+exesec+"ms");
		System.out.println("시간 "+exesec/1000.0+"초");
		
	}

}
