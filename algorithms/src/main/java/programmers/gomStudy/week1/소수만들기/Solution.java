package programmers.gomStudy.week1.소수만들기;

import java.util.Arrays;

public class Solution {

    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int sumOfNums = nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]; //worst case
        int[] primeMap = new int[sumOfNums+1]; 
        
        for(int i=2; i<=sumOfNums; i++) {
        	primeMap[i] = i;
        }
        
        //에라토스테네스의 체
        for(int i=2; i<=sumOfNums; i++) {
        	for(int j=2; j<=sumOfNums; j++) {
        		if(primeMap[j]!=i && primeMap[j]%i==0) { //자신과 같지 않고 0으로 떨어진다면
        			primeMap[j]=0; //소수가 아니므로 0으로 마킹함
        		}
        	}
        }
        
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1;k<nums.length; k++) {
        			if(primeMap[nums[i]+nums[j]+nums[k]]!=0) {
        				answer++;
        			}
        		}
        	}
        }

        return answer;
    }
}