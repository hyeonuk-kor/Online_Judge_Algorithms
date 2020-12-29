package baekjoon.히스토그램;
import java.io.*;
public class Main {
	static int N, histogram[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		histogram = new int[N];
		for(int i=0; i<N; i++) 
			histogram[i] = Integer.parseInt(br.readLine());
		System.out.println(getRectangle());
	}
	static int getRectangle() {
		int result = 0;
		for(int i=0; i<N; i++) {
			int min = histogram[i];
			for(int j=i; j<N; j++) {
				min = Math.min(min, histogram[j]);
				result = Math.max(result, (j-i+1)*min);
			}
		}
		return result;
	}
}
