package baekjoon.마법사상어와파이어볼;
import java.io.*;
import java.util.*;
public class Main {
	static class Fireball {
		int m, s, d;
		public Fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	static int N, M, K;
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static List<ArrayList<Fireball>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i=0; i<N*N; i++)
			list.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int m = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int index = y*N+x%N;
				list.get(index).add(new Fireball(m,s,d));
			}
		}
		System.out.println(simulation());
	}
	static int simulation() {
		for(int i=0; i<K; i++) {
			movement();
			mergeQuarter();
		}
		int sum = 0;
		for(int i=0; i<list.size(); i++)
			for(Fireball f: list.get(i)) 
				sum += f.m;
		return sum;
	}
	static void movement() {
		List<ArrayList<Fireball>> next_list = new ArrayList<>();
		for(int i=0; i<N*N; i++)
			next_list.add(new ArrayList<>());
		for(int i=0; i<list.size(); i++) {
			for(Fireball f: list.get(i)) {
				int ny = i/N, nx = i%N;
				ny = range(ny+dy[f.d]*f.s%N);
				nx = range(nx+dx[f.d]*f.s%N);
				int next_index = ny*N + nx%N;
				next_list.get(next_index).add(new Fireball(f.m, f.s, f.d));
			}
		}
		list = next_list;
	}
	static void mergeQuarter() {
		for(int i=0; i<list.size(); i++) {
			List<Fireball> fireball_list = list.get(i);
			if(fireball_list.size()>=2) {
				int m=0, s=0, dir = 0;
				for(Fireball f: fireball_list) {
					m += f.m;
					s += f.s;
					dir += (f.d%2);
				}
				m /= 5;
				s /= fireball_list.size();
				dir = (dir>0 && dir<fireball_list.size())?1:0;
				list.get(i).clear();
				if(m==0) continue;
				for(int q=0; q<4; q++) {
					fireball_list.add(new Fireball(m, s, dir));
					dir = dir +2;
				}
			}
		}
	}
	static int range(int point) {
		if(point<0) return point+N;
		if(point>=N) return point-N;
		return point;
	}
}