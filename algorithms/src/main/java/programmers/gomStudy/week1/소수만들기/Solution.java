package programmers.gomStudy.week1.소수만들기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
	
	class Eratosthenes {
		private int size;
		private int[] sieve;
		
		public Eratosthenes(int size, int[] sieve) {
			this.size = size;
			this.sieve = sieve;
			
			for(int i=2; i<=size; i++) {
	        	sieve[i] = i;
	        }
			
			isPrime();
		}
		
		public int[] getSieve() {
			return sieve;
		}

		private void isPrime() {
			for(int i=2; i<=size; i++) {
	        	for(int j=2; j<=size; j++) {
	        		if(sieve[j]!=i && sieve[j]%i==0) { //자신과 같지 않고 0으로 떨어진다면
	        			sieve[j]=0; //소수가 아니므로 0으로 마킹함
	        		}
	        	}
	        }
		}
	}
	
    public int solution(int[] nums) {
        int answer = 0;
        int sumOfNums = 3*Arrays.stream(nums).max().getAsInt()-3; //worst case
        
        //에라토스테네스의 체
        Eratosthenes e = new Eratosthenes(sumOfNums, new int[sumOfNums+1]);
        
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1;k<nums.length; k++) {
        			int sum = nums[i]+nums[j]+nums[k];
        			if(e.getSieve()[sum]!=0) {
        				answer++;
        			}
        		}
        	}
        }

        return answer;
    }
}