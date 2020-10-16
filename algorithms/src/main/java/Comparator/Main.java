package Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//기본
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> arr = new ArrayList<int[]>();
		ArrayList<int[]> arr2 = new ArrayList<int[]>();
		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]<o2[2])
					return Integer.compare(o1[2], o2[2]);
				else if(o1[2]==o2[2]) {
					if(o1[0]==o2[0])
						return Integer.compare(o1[1], o2[1]);
					else
						return Integer.compare(o1[0], o2[0]);
				} else {
					if(o1[0]==o2[0])
						return Integer.compare(o1[1], o2[1]);
					else
						return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
		        int out = compareUsingIndex (2, o1, o2);
		        if (out !=0){
		            return out;
		        }
		        out = compareUsingIndex (0, o1, o2);
		        if (out !=0){
		            return out;
		        }
		        return compareUsingIndex (1, o1, o2);
		    }
		    
		    private int compareUsingIndex(int index, int[] o1, int[] o2){
		        if (o1[index]==o2[index]){
		           return 0;
		         }
		        else if (o1[index]>o2[index]){
		           return 1;
		         }
		        return -1;
		    }
		});
		
		q.add(new int[] {2, 2, 2});
		q.add(new int[] {2, 4, 2});
		q.add(new int[] {3, 3, 2});
		q.add(new int[] {3, 1, 2});
		q.add(new int[] {2, 7, 1});
		q.add(new int[] {4, 7, 1});
		
		pq.add(new int[] {2, 2, 2});
		pq.add(new int[] {2, 4, 2});
		pq.add(new int[] {3, 3, 2});
		pq.add(new int[] {3, 1, 2});
		pq.add(new int[] {2, 7, 1});
		pq.add(new int[] {4, 7, 1});

		arr.add(new int[] {2, 2, 2});
		arr.add(new int[] {2, 4, 2});
		arr.add(new int[] {3, 3, 2});
		arr.add(new int[] {3, 1, 2});
		arr.add(new int[] {2, 7, 1});
		arr.add(new int[] {4, 7, 1});
		
		arr2.add(new int[] {2, 2, 2});
		arr2.add(new int[] {2, 4, 2});
		arr2.add(new int[] {3, 3, 2});
		arr2.add(new int[] {3, 1, 2});
		arr2.add(new int[] {2, 7, 1});
		arr2.add(new int[] {4, 7, 1});
		
		arr.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]<o2[2])
					return Integer.compare(o1[2], o2[2]);
				else if(o1[2]==o2[2]) {
					if(o1[0]==o2[0])
						return Integer.compare(o1[1], o2[1]);
					else
						return Integer.compare(o1[0], o2[0]);
				} else {
					if(o1[0]==o2[0])
						return Integer.compare(o1[1], o2[1]);
					else
						return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		
		arr2.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
		        int out = compareUsingIndex (2, o1, o2);
		        if (out !=0){
		            return out;
		        }
		        out = compareUsingIndex (0, o1, o2);
		        if (out !=0){
		            return out;
		        }
		        return compareUsingIndex (1, o1, o2);
		    }
		    
		    private int compareUsingIndex(int index, int[] o1, int[] o2){
		        if (o1[index]==o2[index]){
		           return 0;
		         }
		        else if (o1[index]>o2[index]){
		           return 1;
		         }
		        return -1;
		    }
		});
		
		System.out.println("우선순위 큐를 이용한 정렬[잘못된 결과]");
		while(!q.isEmpty()) {
			System.out.println(Arrays.toString(q.poll()));
		}
		System.out.println();
		
		System.out.println("ArrayList를 이용한 정렬");
		for(int i=0; i<arr.size(); i++) {
			System.out.println(Arrays.toString(arr.get(i)));
		}
		
		System.out.println();
		System.out.println("우선순위 큐를 이용한 정렬[올바른 결과]");
		while(!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}
		
		System.out.println();
		System.out.println("test : ArrayList를 이용한 정렬");
		for(int i=0; i<arr2.size(); i++) {
			System.out.println(Arrays.toString(arr2.get(i)));
		}
	}

}

/*
우선순위 큐를 이용한 정렬[잘못된 결과]
[2, 7, 1]
[2, 2, 2]
[2, 4, 2]
[3, 1, 2]
[4, 7, 1]
[3, 3, 2]

ArrayList를 이용한 정렬
[2, 7, 1]
[4, 7, 1]
[2, 2, 2]
[2, 4, 2]
[3, 1, 2]
[3, 3, 2]

우선순위 큐를 이용한 정렬[올바른 결과]
[2, 7, 1]
[4, 7, 1]
[2, 2, 2]
[2, 4, 2]
[3, 1, 2]
[3, 3, 2]

test : ArrayList를 이용한 정렬
[2, 7, 1]
[4, 7, 1]
[2, 2, 2]
[2, 4, 2]
[3, 1, 2]
[3, 3, 2]
*/
