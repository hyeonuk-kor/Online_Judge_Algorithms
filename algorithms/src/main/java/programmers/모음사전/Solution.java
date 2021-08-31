package programmers.모음사전;
import java.util.*;
public class Solution {
    static char[] vowel = {'A','E','I','O','U'};
    static TreeSet<String> set;
    static void making(int index, int depth, String result) {
    	if(index==depth) {
    		set.add(result);
    		return;
    	}
    	for(int i=0; i<5; i++)
    		making(index+1, depth, result+vowel[i]);
    }
    static public int solution(String word) {
    	set = new TreeSet<String>();
    	for(int i=1; i<=5; i++) {
    		making(0, i, "");
    	}
    	List<String> list = new ArrayList<>(set);
    	return list.indexOf(word)+1;
    }
	public static void main(String[] args) {
		System.out.println(solution("EIO"));
	}
}
