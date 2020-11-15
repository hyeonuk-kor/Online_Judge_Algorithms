package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		
		int[] array = {-93, -5, -3, 10, 11, 12, 15, 20, 22, 33, 55, 86};
		int target = 12;
		int findIndex1 = Arrays.binarySearch(array, target);
		int findIndex2 = binarySearch(array, target, 0, array.length-1);
		int findIndex3 = binarySearch2(array, target, 0, array.length-1);
		System.out.println(findIndex1);
		System.out.println(findIndex2);
		System.out.println(findIndex3);
	}

	static int binarySearch(int[] array, int target, int start, int end) {
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(array[mid]==target)
			return mid;
		else if(array[mid]>target)
			return binarySearch(array, target, start, mid-1);
		else
			return binarySearch(array, target, mid+1, end);
	}
	
	static int binarySearch2(int[] array, int target, int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2;
			if(array[mid]==target)
				return mid;
			else if(array[mid]>target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

}
