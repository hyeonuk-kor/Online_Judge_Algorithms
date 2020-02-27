package programmers.gomStudy.week3.네트워크;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    
	static int[] union;
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        union = new int[n+1]; 
        for(int i=0; i<n+1; i++) {
        	union[i] = i;
        }
        
        ArrayList<int[]> network = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(computers[i][j]==1) {
        			network.add(new int[] {i+1, j+1});
        		}
        	}
        }
        
        Collections.sort(network, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[0], o2[0]);
        	}
        });
        
        for(int i=0; i<network.size(); i++) {
        	
        }
        
        return answer;
    }
    
	private void unionSet(int firstValue, int secondValue) {
		firstValue = findSet(firstValue);
		secondValue = findSet(secondValue);
		if(firstValue > secondValue) union[firstValue] = secondValue;
		else union[secondValue] = firstValue;
	}

	private int findSet(int secondValue) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
