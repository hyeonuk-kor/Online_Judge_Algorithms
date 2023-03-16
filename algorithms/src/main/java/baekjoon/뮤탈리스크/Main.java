package baekjoon.뮤탈리스크;
import java.io.*;
import java.util.*;
public class Main {
	static int K[] = {0, 0, 0};
	static int[][][] atcount = {
		{{1, 2, 3}},
		{{1, 2, 3},{2, 1, 3}},
		{{1, 2, 3}, 
		 {1, 3, 2}, 
		 {2, 1, 3}, 
		 {2, 3, 1}, 
		 {3, 1, 2}, 
		 {3, 2, 1}}
	};
	static boolean check[][][];
	static class Info {
	    int n;
	    int[] hp;
	    boolean[] alive;
	    
	    public Info(int n, int[] hp, boolean[] alive) {
	        this.n = n;
	        this.hp = hp.clone();
	        this.alive = alive.clone();
	    }
	    
	    public Info copy() {
	        return new Info(n, hp, alive);
	    }
	    
	    public static boolean isAlive(Info info) {
	        for (int i = 0; i < info.n; i++) {
	            if (info.alive[i]) {
	                return true;
	            }
	        }
	        return false;
	    }
	}

	static class State {
	    Info info;
	    int count;
	    
	    public State(Info info, int count) {
	        this.info = info.copy();
	        this.count = count;
	    }
	    
	    public State copy() {
	        return new State(info.copy(), count);
	    }
	    
	    public State attack(int[] cmd) {
	        int attack = 9;
	        Info temp = info.copy();
	        for (int i = 0; i < 3; i++) {
	            int num = cmd[i] - 1;
	            if (!temp.alive[num]) {
	                continue;
	            }
	            if (temp.hp[num] - attack > 0) {
	                temp.hp[num] -= attack;
	            } else {
	                temp.hp[num] = 0;
	                temp.alive[num] = false;
	            }
	            attack /= 3;
	        }
	        return new State(temp, count + 1);
	    }
	}
	static class P12869 {
		int N, scv[], answer;
		P12869() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			Queue<State> q = new ArrayDeque<>();
			Info info = new Info(N, scv, new boolean[] {true,true,true});
			q.add(new State(info, 0));
			while(!q.isEmpty()) {
				State now = q.poll();
				if(Info.isAlive(now.info)) {
					for(int i=0; i<now.info.n; i++) {
						K[i] = now.info.hp[i];
					}
					check[K[0]][K[1]][K[2]] = true;
					for(int j=0; j<atcount[now.info.n-1].length; j++) {
						State copy = new State(now.info, now.count);
						now.attack(atcount[now.info.n-1][j]);
						for(int k=0; k<now.info.n; k++) {
							K[k] = now.info.hp[k];
						}
						if(!check[K[0]][K[1]][K[2]]) {
							check[K[0]][K[1]][K[2]] = true;
							q.add(now);
							now.count++;
						}
						now = copy;
					}
					
				} else {
					answer = now.count;
					return;
				}
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			try {
				N = Integer.parseInt(br.readLine());
				scv = new int[3];
				st = new StringTokenizer(br.readLine());
				for(int n=0; n<N; n++) {
					scv[n] = Integer.parseInt(st.nextToken());
				}
				check = new boolean[61][61][61];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P12869();
	}
}
