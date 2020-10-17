package baekjoon.행성터널;
import java.util.*;
import java.io.*;
class Planet implements Comparable<Planet>{
	private int pivot;
	private int number,x,y,z;
	public Planet(int number, int x, int y, int z) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getNumber() {
		return number;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	public void setPivot(int pivot) {
		this.pivot = pivot;
	}
	@Override
	public int compareTo(Planet o1) {
		if(pivot==0) {
			return Integer.compare(o1.x, this.x);
		} else if(pivot==1) {
			return Integer.compare(o1.y, this.y);
		}
		return Integer.compare(o1.z, this.z);
	}
}
public class Main {
	static int N;
	static int[] parent;
	static Planet[] planet;
	static ArrayList<ArrayList<Integer>> tunnel;
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getCost());
	} // end main

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		planet = new Planet[N+1];
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(i, x, y, z);
			parent[i] = i;
		}
	} //end input
	static int getCost() {
		int cost=0;
		tunnel = new ArrayList<>();
		for(int k=0; k<3; k++) {
			for(int i=1; i<=N; i++) 
				planet[i].setPivot(k); 
			Arrays.sort(planet, 1, planet.length);
			for(int i=1; i<N; i++) {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(planet[i].getNumber());
				arr.add(planet[i+1].getNumber());
				if(k==0) arr.add(Math.abs(planet[i].getX()-planet[i+1].getX()));
				else if(k==1) arr.add(Math.abs(planet[i].getY()-planet[i+1].getY()));
				else arr.add(Math.abs(planet[i].getZ()-planet[i+1].getZ()));
				tunnel.add(arr);
			}
		}
		Collections.sort(tunnel, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(2).compareTo(o2.get(2));
			}
		});
		for(ArrayList<Integer> t: tunnel) {
			int a = findParent(t.get(0));
			int b = findParent(t.get(1));
			if(a!=b) {
				if(a<b) parent[b]=a;
				else	parent[a]=b;
				cost += t.get(2);
			}
		}
		return cost;
	} //end getCost

	static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	} 
	
}
