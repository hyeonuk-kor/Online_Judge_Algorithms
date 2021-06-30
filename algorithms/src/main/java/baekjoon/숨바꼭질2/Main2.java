package baekjoon.숨바꼭질2;
import java.io.*;
import java.util.*;
public class Main2 {
	static final int min_len = 0, max_len = 100000;
	static int N, K, count=1;
	static boolean visit[] = new boolean[max_len+1];
	static Queue<int[]> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue.add(new int[] {N, 0});
		System.out.println(simulate());
        System.out.println(count);
    }
	static int simulate() {
		int answer = 0;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int position = info[0];
			int time = info[1];
            visit[position] = true;
			if(position==K) {
				answer = time;
				break;
			} else {
				for(int i=0; i<3; i++) {
					int next_position = position;
					switch (i) {
						case 0:
							next_position-=1;
							break;
						case 1:
							next_position+=1;
							break;
						case 2:
							next_position*=2;
							break;
					}
					if(next_position<min_len || next_position>max_len || visit[next_position])
						continue;
					queue.add(new int[] {next_position, time+1});
				}
			}
		}
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int position = info[0];
            int time = info[1];
            if(time==answer && position==K)
                count++;
        }
		return answer;
	}
}