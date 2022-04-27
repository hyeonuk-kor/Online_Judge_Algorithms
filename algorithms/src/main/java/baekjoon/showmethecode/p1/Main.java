package baekjoon.showmethecode.p1;
import java.io.*;
import java.util.*;
public class Main {
	static int N, coin[], answer=1000*1000;
	static int selected[], used[];
	static List<List<int[]>> discoin;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		discoin = new ArrayList<>();
		for(int i=0; i<N; i++) {
			discoin.add(new ArrayList<>());
			int info = Integer.parseInt(br.readLine());
			for(int j=0; j<info; j++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				discoin.get(i).add(new int[] {num, dis});
			}
		}
		selected = new int[N+1];
		used = new int[N+1];
		rec_func(0);
		System.out.println(answer);
	}
	static void rec_func(int k) {
		if(k==N) {
			int ccoin[] = new int[N];
			for(int i=0; i<coin.length; i++) {
				ccoin[i] = coin[i];
			}
			int sum = ccoin[selected[0]-1];
			boolean visit[] = new boolean[N];
			for(int i=0; i<N; i++) {
				int index = selected[i]-1;
				visit[index] = true;
				for(int j=0; j<discoin.get(index).size(); j++) {
					int info[] = discoin.get(index).get(j);
					int num = info[0]-1;
					int dis = info[1];
					if(visit[num]) continue;
					ccoin[num] -= dis;
					if(ccoin[num]<=0)
						ccoin[num] = 1;
				}
			}
			for(int i=0; i<ccoin.length; i++) {
				if(i==selected[0]-1) continue;
				sum += ccoin[i];
			}
			answer = Math.min(answer, sum);
			return;
		} else {
			for(int i=1; i<=N; i++) {
				if(used[i]==0) {
					selected[k] = i;
					used[i] = 1;
					rec_func(k+1);
					used[i] = 0;
					selected[k] = 0;
				}
			}
		}
	}
}
