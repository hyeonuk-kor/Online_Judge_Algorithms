package coupang.test4;

import java.util.*;
public class test4 {
	
	static boolean d[];
	static ArrayList<String> arr;
	static ArrayList<ArrayList<Integer>> graph;
	static int count;
	public static void main(String[] args) {
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = {
				{"SEOUL","DAEJEON"},
				{"ULSAN","BUSAN"},
				{"DAEJEON","ULSAN"},
				{"DAEJEON","GWANGJU"},
				{"SEOUL","ULSAN"},
				{"DAEJEON","BUSAN"},
				{"GWANGJU","BUSAN"},
		};
		int answer = solution(depar, hub, dest, roads);
		System.out.println(answer);
	}

	static int solution(String depar, String hub, String dest, String[][] roads) {
		arr = new ArrayList<>(); // 도시 넘버링
		arr.add("");
		for (int i = 0; i < roads.length; i++) {
			for (int j = 0; j < 2; j++) {
				if(!arr.contains(roads[i][j]))
					arr.add(roads[i][j]);
			}
		}

		graph = new ArrayList<>();
		for (int i = 0; i <= arr.size(); i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < roads.length; i++) {
			graph.get(arr.indexOf(roads[i][0])).add(arr.indexOf(roads[i][1]));
		}

		d = new boolean[arr.size()];
		dfs(arr.indexOf(depar), arr.indexOf(hub), arr.indexOf(dest));
		
		return count%10007;
	}

	static void dfs(int depar, int hub, int dest) {
		
		if(d[hub] && d[dest]) {
			count++;
			return;
		}
		
		if(d[dest]) {
			return;
		}
		
		for (int i = 0; i < graph.get(depar).size(); i++) {
			if(!d[graph.get(depar).get(i)]) {
				d[graph.get(depar).get(i)] = true;
				dfs(graph.get(depar).get(i), hub, dest);
				d[graph.get(depar).get(i)] = false;
			}
		}
		
	}
}

/*
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = {
				{"SEOUL","DAEJEON"},
				{"ULSAN","BUSAN"},
				{"DAEJEON","ULSAN"},
				{"DAEJEON","GWANGJU"},
				{"SEOUL","ULSAN"},
				{"DAEJEON","BUSAN"},
				{"GWANGJU","BUSAN"},
		};


		String depar = "SEOUL";
		String hub = "DAEGU";
		String dest = "YEOSU";
		String[][] roads = {
				{"ULSAN","BUSAN"},
				{"DAEJEON","ULSAN"},
				{"DAEJEON","GWANGJU"},
				{"SEOUL","DAEJEON"},
				{"SEOUL","ULSAN"},
				{"DAEJEON","DAEGU"},
				{"GWANGJU","BUSAN"},
				{"DAEGU","GWANGJU"},
				{"DAEGU","BUSAN"},
				{"ULSAN","DAEGU"},
				{"GWANGJU","YEOSU"},
				{"BUSAN","YEOSU"}
		}; 
 */
