package test.SV;
import java.util.*;
public class P3 {
	static long solution(long[] wave1, long[] wave2) {
		long answer = Long.MAX_VALUE;
		List<Long> set_wave = new ArrayList<>();
		for(int i=0; i<wave1.length; i++) {
			set_wave.add(wave2[i%wave2.length]);
		}
		List<Long> min_wave = null;
		for(int i=0; i<wave1.length; i++) {
			List<Long> calc_wave = new ArrayList<>();
			Collections.rotate(set_wave, 1);
			boolean check = false;
			for(int j=0; j<wave1.length; j++) {
				long sum = wave1[j]+set_wave.get(j);
				calc_wave.add(sum);
				if(j!=0 && sum!=calc_wave.get(j-1)) {
					check = true;
				}
			}
			if(!check) {
				return 0;
			} else {
				long sum = 0;
				for(long l: calc_wave) {
					sum += (l*l);
				}
				if(answer>sum) {
					answer = sum;
					min_wave = calc_wave;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		long[] wave1 = {2,0,1,1,1,0};
		long[] wave2 = {0,0,-1};
		System.out.println(solution(wave1, wave2));
	}
}