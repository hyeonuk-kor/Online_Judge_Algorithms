package test;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {

		int[] arr = {100,200,300,400,500};

		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length;j++) { 
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));

		
	}

}


