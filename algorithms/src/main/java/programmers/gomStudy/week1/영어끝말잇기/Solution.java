package programmers.gomStudy.week1.영어끝말잇기;

import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        HashSet<String> hashSet = new HashSet<String>(); //중복 단어 검사를 위한 해시셋
        char end = words[0].charAt(words[0].length()-1); //끝 문자
        char start;
        hashSet.add(words[0]); //해시셋 추가
              
        for(int i=1; i<words.length; i++) {
        	start = words[i].charAt(0);
        	hashSet.add(words[i]);
        	
        	if(end!=start || hashSet.size()!=i+1) {
        		answer[0] = (i%n)+1;
        		answer[1] = (i/n)+1;
        		break;
        	}
        	end = words[i].charAt(words[i].length()-1);        	
        }

        return answer;
    }
}