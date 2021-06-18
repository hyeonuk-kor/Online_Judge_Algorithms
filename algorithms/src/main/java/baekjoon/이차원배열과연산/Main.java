package baekjoon.이차원배열과연산;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.valueOf(st.nextToken())-1;
		int c = Integer.valueOf(st.nextToken())-1;
		int k = Integer.valueOf(st.nextToken());
		int arr[][] = new int[100][100];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		int time = 0;
		int maxr = 2, maxc = 2;
		int count[] = new int[101];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1])
					return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for(time=0; time<=100; time++) {
			if(arr[r][c]==k)
				break;
			if(maxr>=maxc) {
				maxc = 2;
				for(int i=0; i<100; i++) {
					Arrays.fill(count, 0);
					for(int j=0; j<100; j++) 
						if(arr[i][j]!=0) 
							count[arr[i][j]]++;
					for(int n=1; n<=100; n++) 
						if(count[n]>0) 
							q.add(new int[] {n, count[n]});
					int cnt = 0;
					while(!q.isEmpty()) {
						int info[] = q.poll();
						arr[i][cnt++] = info[0];
						arr[i][cnt++] = info[1];
						if(cnt==100)
							break;
					}
					for(int f=cnt; f<100; f++) 
						arr[i][f] = 0;
					maxc = Math.max(maxc, cnt);
				}
			} else {
				maxr = 2;
				for(int i=0; i<100; i++) {
					Arrays.fill(count, 0);
					for(int j=0; j<100; j++) 
						if(arr[j][i]!=0) 
							count[arr[j][i]]++;
					for(int n=1; n<=100; n++) 
						if(count[n]>0) 
							q.add(new int[] {n, count[n]});
					int cnt = 0;
					while(!q.isEmpty()) {
						int info[] = q.poll();
						arr[cnt++][i] = info[0];
						arr[cnt++][i] = info[1];
						if(cnt==100)
							break;
					}
					for(int f=cnt; f<100; f++) 
						arr[f][i] = 0;
					maxr = Math.max(maxr, cnt);
				}
			}
			q.clear();
		}
		if(time>100) 
			time = -1;
		bw.append(time+"\n");
		bw.flush();
	}
}