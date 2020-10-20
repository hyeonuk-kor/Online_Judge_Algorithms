package baekjoon.달팽이;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][N];
		int number = N*N;
		int colIndex=0, rowIndex=0;
		int fi=0, fj=0;
		for(int i=0; i<N; i++) {
			while(rowIndex<N-i) {
				if(number==find)  { fi = rowIndex+1; fj = colIndex+1; }
				arr[rowIndex++][colIndex] = number--; 
			}
			rowIndex--; colIndex++;
			while(colIndex<N-i) {
				if(number==find)  { fi = rowIndex+1; fj = colIndex+1; }
				arr[rowIndex][colIndex++] = number--;
			}
			rowIndex--; colIndex--;
			while(rowIndex>=i) {
				if(number==find)  { fi = rowIndex+1; fj = colIndex+1; }
				arr[rowIndex--][colIndex] = number--;
			}
			rowIndex++; colIndex--;
			while(colIndex>i) {
				if(number==find)  { fi = rowIndex+1; fj = colIndex+1; }
				arr[rowIndex][colIndex--] = number--;
			}
			rowIndex++; colIndex++;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(fi+" "+fj);
		
	}
}
