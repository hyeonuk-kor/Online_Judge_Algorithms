package line_test;

public class test_3 {

	static int min = Integer.MAX_VALUE;
	static int count = 0;
	static int sum = 0;
	public static void main(String[] args) throws Exception {

		int n = 112211;
		
		for(int i=0; i<=(n+"").length()-1; i++)
			solve(n+"", i+1);
		System.out.println(min+" "+sum);
			
	}

	private static void solve(String num, int idx) {
		
		if(num.length()==1) {
			if(min>count) {
				min = count;
			}
			sum = Integer.parseInt(num);
			return;
		}
		if(idx==num.length()) {
			idx=1;
		}
		
		int s = Integer.parseInt(num.substring(0, idx));
		String temp = num.substring(idx, num.length());
		if(temp.charAt(0)=='0') {
			solve(num, idx+1);
			idx=0;
		} else {
			count++;
			if(min<count)
				return;
		}
		
		s += Integer.parseInt(temp);
		
		if(idx==(s+"").length()) {
			idx=0;
		}
		solve(s+"", idx+1);

	}

}
