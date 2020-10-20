package baekjoon.스도쿠19998;
import java.util.*;
import java.io.*;
import java.math.*;

class AlgorithmXSolver {        
	int N = 9;
	int SIZE = 3;
	int[][] Grid = new int[N][N];
	private ColumnNode root = null; 
	private ArrayList<Node> solution = new ArrayList<Node>();

	void run(int[][] initialMatrix) {
		byte[][] matrix = createMatrix(initialMatrix); 
		ColumnNode doubleLinkedList = createDoubleLinkedLists(matrix);
		search(0); 
	}

	class Node  {
		Node left;
		Node right;
		Node up;
		Node down;
		ColumnNode head;
	}

	class ColumnNode extends Node {
		int size = 0;
		ColumnID info;
	}

	class ColumnID {
		int constraint = -1;
		int number = -1;
		int position = -1;
	}

	byte[][] createMatrix(int[][] initialMatrix) {      
		int[][] clues = null;
		ArrayList<int[]> cluesList = new ArrayList<int[]>();
		int counter = 0; 
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(initialMatrix[r][c] > 0) {
					cluesList.add(new int[]{initialMatrix[r][c],r,c});
					counter++;
				}
			}
		}

		clues = new int[counter][]; 
		for(int i = 0; i < counter; i++) 
			clues[i] = (int[])cluesList.get(i); 

		byte[][] matrix = new byte[N*N*N][4*N*N];

		for(int d = 0; d < N; d++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!filled(d,r,c,clues)) {
						int rowIndex = c + (N * r) + (N * N * d);
						int blockIndex = ((c / SIZE) + ((r / SIZE) * SIZE));
						int colIndexRow = 3*N*d+r;
						int colIndexCol = 3*N*d+N+c;
						int colIndexBlock = 3*N*d+2*N+blockIndex;
						int colIndexSimple = 3*N*N+(c+N*r);
						matrix[rowIndex][colIndexRow] = 1;
						matrix[rowIndex][colIndexCol] = 1;
						matrix[rowIndex][colIndexBlock] = 1;
						matrix[rowIndex][colIndexSimple] = 1;
					}
				}
			}
		}
		return matrix;
	}

	boolean filled(int digit, int row, int col, int[][] prefill) {
		boolean filled = false;
		if(prefill != null) {
			for(int i = 0; i < prefill.length; i++) {
				int d = prefill[i][0]-1;
				int r = prefill[i][1];
				int c = prefill[i][2];
				int blockStartIndexCol = (c/SIZE)*SIZE;
				int blockEndIndexCol = blockStartIndexCol + SIZE;
				int blockStartIndexRow = (r/SIZE)*SIZE;
				int blockEndIndexRow = blockStartIndexRow + SIZE;
				if(d != digit && row == r && col == c) {
					filled = true;
				} else if((d == digit) && (row == r || col == c) && !(row == r && col == c)) {
					filled = true;
				} else if((d == digit) && (row > blockStartIndexRow) && (row < blockEndIndexRow) && (col > blockStartIndexCol) && (col < blockEndIndexCol) && !(row == r && col == c)) {
					filled = true;
				}
			}
		}
		return filled;
	}

	ColumnNode createDoubleLinkedLists(byte[][] matrix) {
		root = new ColumnNode(); 
		ColumnNode curColumn = root;
		for(int col = 0; col < matrix[0].length; col++) {
			ColumnID id = new ColumnID();
			if(col < 3*N*N) {
				int digit = (col / (3*N)) + 1;
				id.number = digit;
				int index = col-(digit-1)*3*N;
				if(index < N) {
					id.constraint = 0;
					id.position = index;
				} else if(index < 2*N) {
					id.constraint = 1; 
					id.position = index-N;
				} else {
					id.constraint = 2; 
					id.position = index-2*N;
				}            
			} else {
				id.constraint = 3;
				id.position = col - 3*N*N;
			}
			curColumn.right = new ColumnNode();
			curColumn.right.left = curColumn;
			curColumn = (ColumnNode)curColumn.right;
			curColumn.info = id; 
			curColumn.head = curColumn; 
		}
		curColumn.right = root;
		root.left = curColumn;

		for(int row = 0; row < matrix.length; row++) {
			curColumn = (ColumnNode)root.right;
			Node lastCreatedElement = null;
			Node firstElement = null;
			for(int col = 0; col < matrix[row].length; col++) {
				if(matrix[row][col] == 1) {
					Node colElement = curColumn;
					while(colElement.down != null) {
						colElement = colElement.down;
					}
					colElement.down = new Node();
					if(firstElement == null) {
						firstElement = colElement.down;
					}
					colElement.down.up = colElement;
					colElement.down.left = lastCreatedElement;
					colElement.down.head = curColumn;
					if(lastCreatedElement != null) {
						colElement.down.left.right = colElement.down;
					}
					lastCreatedElement = colElement.down;
					curColumn.size++;
				}
				curColumn = (ColumnNode)curColumn.right;
			}
			if(lastCreatedElement != null) {
				lastCreatedElement.right = firstElement;
				firstElement.left = lastCreatedElement;
			}
		}
		curColumn = (ColumnNode)root.right;
		for(int i = 0; i < matrix[0].length; i++) {
			Node colElement = curColumn;
			while(colElement.down != null) {
				colElement = colElement.down;
			}
			colElement.down = curColumn;
			curColumn.up = colElement;
			curColumn = (ColumnNode)curColumn.right;
		}
		return root; 
	}

	void search(int k) {
		if(root.right == root) {
			mapSolvedToGrid(); 
			return;
		}
		ColumnNode c = choose(); 
		cover(c);
		Node r = c.down;
		while(r != c) {
			if(k < solution.size()) {
				solution.remove(k);
			}         
			solution.add(k,r);
			Node j = r.right;
			while(j != r) {
				cover(j.head);
				j = j.right;
			}
			search(k+1);

			Node r2 = (Node)solution.get(k);
			Node j2 = r2.left;
			while(j2 != r2) {
				uncover(j2.head);
				j2 = j2.left;
			}
			r = r.down;
		}
		uncover(c);
	}

	void mapSolvedToGrid() {
		int[] result = new int[N*N];
		for(Iterator<Node> it = solution.iterator(); it.hasNext();) {
			int number = -1; 
			int cellNo = -1;
			Node element = (Node)it.next();
			Node next = element;
			do {
				if (next.head.info.constraint == 0) {
					number = next.head.info.number; 
				} else if (next.head.info.constraint == 3) {
					cellNo = next.head.info.position;
				}
				next = next.right;
			} while(element != next);
			result[cellNo] = number; 
		}

		StringBuilder sb = new StringBuilder();
		int resultCounter=0;
		for (int r=0; r<N; r++)
		{
			for (int c=0; c<N; c++) 
			{
				sb.append(result[resultCounter]).append(" ");
				resultCounter++;
			}
			sb.append('\n');
		}  
		System.out.println(sb.toString());
		System.exit(0);
	}

	ColumnNode choose() {
		ColumnNode rightOfRoot = (ColumnNode)root.right; 
		ColumnNode smallest = rightOfRoot; 
		while(rightOfRoot.right != root) {
			rightOfRoot = (ColumnNode)rightOfRoot.right;
			if(rightOfRoot.size < smallest.size) {
				smallest = rightOfRoot;
			}         
		}      
		return smallest;
	}

	void cover(Node column) {
		column.right.left = column.left;
		column.left.right = column.right;

		Node curRow = column.down;
		while(curRow != column) {
			Node curNode = curRow.right;
			while(curNode != curRow) {
				curNode.down.up = curNode.up;
				curNode.up.down = curNode.down;
				curNode.head.size--;
				curNode = curNode.right;
			}
			curRow = curRow.down;
		}
	}

	void uncover(Node column) {
		Node curRow = column.up;
		while(curRow != column) {
			Node curNode = curRow.left;
			while(curNode != curRow) {
				curNode.head.size++;
				curNode.down.up = curNode;
				curNode.up.down = curNode;
				curNode = curNode.left;
			}
			curRow = curRow.up;
		}
		column.right.left = column; 
		column.left.right = column;
	}

}


class Main {
	void solve() throws IOException {
		AlgorithmXSolver solver= new AlgorithmXSolver();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] Grid = new int[9][9];
		for( int i = 0; i < 9; i++ ) {
			st = new StringTokenizer(br.readLine()," ");
			for( int j = 0; j < 9; j++ ) {
				Grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solver.run(Grid);
	}


	public static void main(String args[]) throws IOException {
		Main s = new Main();
		s.solve();
	}

}