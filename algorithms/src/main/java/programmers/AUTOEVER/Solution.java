package programmers.AUTOEVER;

import java.util.*;
class Node implements Comparable<Node>{
	String name;
	ArrayList<Integer> location;
	int target;
	@Override
	public int compareTo(Node o) {
		int ret = Integer.compare(o.location.size(), this.location.size());
		if(ret==0) ret = getMinDistance(o, this);
		int mino = Math.abs(o.target - o.location.get(0));
		for(int i=1; i<o.location.size(); i++)
			mino = Math.min(Math.abs(o.target - o.location.get(i)), mino);
		int mint = Math.abs(this.target - this.location.get(0));
		for(int i=1; i<this.location.size(); i++)
			mint = Math.min(Math.abs(this.target - this.location.get(i)), mino);
		ret = Integer.compare(mino, mint);
		if(ret==0) ret = o.name.compareTo(this.name);
		return 0;
	}
	private int getMinDistance(Node o, Node node) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Node(String name, ArrayList<Integer> location, int target) {
		this.name = name;
		this.location = location;
		this.target = target;
	}
	
}
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer("[404]james,addd",",[]");
		ArrayList<Node> arr = new ArrayList<Node>();
		int room_number = Integer.parseInt(st.nextToken());
		int index = 0;
		int target = 403;
		while(st.hasMoreTokens()) {
			String name = st.nextToken();
			if(!map.containsKey(name)) {
				ArrayList<Integer> t = new ArrayList<>();
				t.add(room_number);
				Node info = new Node(name, t, target);
				arr.add(index++, info);
				map.put(name, index);
			} else {
				int getIndex = map.get(name);
				arr.get(getIndex).location.add(room_number);
			}
		}
	
		
	}

}
