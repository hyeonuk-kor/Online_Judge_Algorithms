package IIst;
import java.util.*;
public class Main {
	static class Solution {
		Solution() {
			String[] phone_numbers = {"234-567-890", "444-444-443", "321-543-234"};
			String[] phone_owners = {"Harry","Nick","Michael"};
			String number = "444-444-444";
			System.out.println(solution(phone_numbers, phone_owners, number));
		}
		public String solution(String[] phone_numbers, String[] phone_owners, String number) {
			// N 1이상 1000 이하
			// 각 배열크기 1이상 100이하
			// 폰번호는 nnn-nnn-nnn 형식
			Map<String, String> map = new HashMap<String, String>();
			int length = phone_numbers.length;
			for(int i=0; i<length; i++) {
				map.put(phone_numbers[i], phone_owners[i]);
			}
			String answer = map.get(number);
			if(answer==null)
				return number;
			return answer;
	    }
	}
	public static void main(String[] args) {
		new Solution();
	}
}
