package baekjoon.문명;
import java.io.*;
import java.util.*;
class DisjointSet {
	private int parent[];
	public DisjointSet(int v) {
		parent = new int[v];
		Arrays.fill(parent, -1);
	}
	public int find(int x) {
		if(parent[x]==-1)
			return x;
		return parent[x] = find(parent[x]);
	}
	public void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a] = b;
	}
}
public class Test {
	// Define constants for the four directions
	private final int[] DY = {-1, 0, 1, 0};
	private final int[] DX = {0, 1, 0, -1};

	/**
	 * Finds the number of iterations needed to merge all the connected
	 * components in the given 2D grid.
	 *
	 * @param grid the 2D grid to search for connected components
	 * @return the number of iterations needed to merge all the components
	 */
	public int findNumIterationsToMerge(int[][] grid) {
	    int n = grid.length;
	    DisjointSet dsu = new DisjointSet(n * n); // create a disjoint set

	    Queue<int[]> frontier = new LinkedList<>();
	    for (int y = 0; y < n; y++) {
	        for (int x = 0; x < n; x++) {
	            if (grid[y][x] == 1) {
	                int id = y * n + x; // convert coordinates to ID
	                frontier.add(new int[]{y, x, id});
	            }
	        }
	    }

	    int numComponents = frontier.size();
	    int numIterations = 0;
	    while (numComponents > 1) {
	        int size = frontier.size();
	        while (size-- > 0) {
	            int[] curr = frontier.poll();
	            int y = curr[0];
	            int x = curr[1];
	            int id = curr[2];

	            for (int d = 0; d < 4; d++) {
	                int ny = y + DY[d];
	                int nx = x + DX[d];
	                if (ny < 0 || ny >= n || nx < 0 || nx >= n || grid[ny][nx] != 1) {
	                    continue;
	                }

	                int nid = ny * n + nx;
	                if (!dsu.find(id, nid)) {
	                    dsu.union(id, nid);
	                    numComponents--;
	                }
	            }

	            for (int d = 0; d < 4; d++) {
	                int ny = y + DY[d];
	                int nx = x + DX[d];
	                if (ny < 0 || ny >= n || nx < 0 || nx >= n || grid[ny][nx] != 0) {
	                    continue;
	                }

	                grid[ny][nx] = 1;
	                int nid = ny * n + nx;
	                frontier.add(new int[]{ny, nx, id});
	            }
	        }
	        numIterations++;
	    }

	    return numIterations;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int map[][] = new int[N][N];
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.valueOf(st.nextToken()) - 1;
			int x = Integer.valueOf(st.nextToken()) - 1;
			map[y][x] = i;
			q1.add(new int[] {y, x});
		}
	}

}
