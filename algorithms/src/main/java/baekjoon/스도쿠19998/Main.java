package baekjoon.스도쿠19998;
import java.util.*;
import java.io.*;
import java.math.*;

class FastIO {

	public static final int DEFAULT_BUFFER_SIZE = 65536;
	public static final int DEFAULT_INTEGER_SIZE = 11;
	public static final int DEFAULT_LONG_SIZE = 20;
	public static final int DEFAULT_WORD_SIZE = 256;
	public static final int DEFAULT_LINE_SIZE = 8192;
	public static final int EOF = -1;

	private final InputStream in;
	private final OutputStream out;

	private byte[] inBuffer;
	private int nextIn, inLength;
	private byte[] outBuffer;
	private int nextOut;

	private char[] charBuffer;
	private byte[] byteBuffer;

	public FastIO(InputStream in, OutputStream out, int inBufferSize, int outBufferSize) {
		this.in = in;
		this.inBuffer = new byte[inBufferSize];
		this.nextIn = 0;
		this.inLength = 0;

		this.out = out;
		this.outBuffer = new byte[outBufferSize];
		this.nextOut = 0;

		this.charBuffer = new char[DEFAULT_LINE_SIZE];
		this.byteBuffer = new byte[DEFAULT_LONG_SIZE];
	}

	public FastIO(InputStream in, OutputStream out) {
		this(in, out, DEFAULT_BUFFER_SIZE, DEFAULT_BUFFER_SIZE);
	}

	public FastIO(InputStream in, OutputStream out, int bufferSize) {
		this(in, out, bufferSize, bufferSize);
	}

	public char nextChar() {
		byte b;
		while (isSpace(b = read()))
			;

		return (char) b;
	}

	public String next() {
		byte b;
		while (isSpace(b = read()))
			;

		int pos = 0;
		do {
			charBuffer[pos++] = (char) b;
			ensureCapacity(pos);
		} while (!isSpace(b = read()));

		return new String(charBuffer, 0, pos);
	}

	public String nextLine() {
		byte b;
		int pos = 0;

		while (!isLine(b = read())) {
			charBuffer[pos++] = (char) b;
			ensureCapacity(pos);
		}

		return new String(charBuffer, 0, pos);
	}

	public int nextInt() {
		byte b;
		while (isSpace(b = read()))
			;

		boolean negative = false;
		int result = b - '0';
		if (b == '-') {
			negative = true;
			result = 0;
		}

		while (isDigit(b = read()))
			result = (result * 10) + (b - '0');

		return negative ? -result : result;
	}

	public long nextLong() {
		byte b;
		while (isSpace(b = read()))
			;

		boolean negative = false;
		long result = b - '0';
		if (b == '-') {
			negative = true;
			result = 0;
		}

		while (isDigit(b = read()))
			result = (result * 10) + (b - '0');

		return negative ? -result : result;
	}

	public float nextFloat() {
		byte b;
		while (isSpace(b = read()))
			;

		int pos = 0;
		do {
			charBuffer[pos++] = (char) b;
		} while (!isSpace(b = read()));

		return Float.parseFloat(new String(charBuffer, 0, pos));
	}

	public float nextFloat2() {
		byte b;
		while (isSpace(b = read()))
			;

		boolean negative = false;
		float result = b - '0';
		if (b == '-') {
			negative = true;
			result = 0;
		}

		while (isDigit(b = read()))
			result = (result * 10) + (b - '0');

		float d = 1;
		if (b == '.') {
			while (isDigit(b = read()))
				result += (b - '0') / (d *= 10);
		}

		return negative ? -result : result;
	}

	public double nextDouble() {
		byte b;
		while (isSpace(b = read()))
			;

		int pos = 0;
		do {
			charBuffer[pos++] = (char) b;
		} while (!isSpace(b = read()));

		return Double.parseDouble(new String(charBuffer, 0, pos));
	}

	public double nextDouble2() {
		byte b;
		while (isSpace(b = read()))
			;

		boolean negative = false;
		double result = b - '0';
		if (b == '-') {
			negative = true;
			result = 0;
		}

		while (isDigit(b = read()))
			result = (result * 10) + (b - '0');

		double d = 1;
		if (b == '.') {
			while (isDigit(b = read()))
				result += (b - '0') / (d *= 10);
		}

		return negative ? -result : result;
	}

	public BigInteger nextBigInteger() {
		return new BigInteger(next());
	}

	public BigDecimal nextBigDecimal() {
		return new BigDecimal(next());
	}

	public char[] nextToCharArray() {
		byte b;
		while (isSpace(b = read()))
			;

		int pos = 0;
		do {
			charBuffer[pos++] = (char) b;
			ensureCapacity(pos);
		} while (!isSpace(b = read()));

		char[] array = new char[pos];
		System.arraycopy(charBuffer, 0, array, 0, pos);
		return array;
	}

	public int[] nextIntArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = nextInt();

		return array;
	}

	public long[] nextLongArray(int size) {
		long[] array = new long[size];
		for (int i = 0; i < size; i++)
			array[i] = nextLong();

		return array;
	}

	public int[][] nextInt2DArray(int Y, int X) {
		int[][] array = new int[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				array[y][x] = nextInt();

		return array;
	}

	public void print(char c) {
		write((byte) c);
	}

	public void print(char[] chars) {
		print(chars, 0, chars.length);
	}

	public void print(char[] chars, int start) {
		print(chars, start, chars.length);
	}

	public void print(char[] chars, int start, int end) {
		for (int i = start; i < end; i++)
			write((byte) chars[i]);
	}

	public void print(String s) {
		for (int i = 0; i < s.length(); i++)
			write((byte) s.charAt(i));
	}

	public void print(int i) {
		if (i == 0) {
			write((byte) '0');
			return;
		}
		if (i == Integer.MIN_VALUE) {
			write((byte) '-');
			write((byte) '2');
			write((byte) '1');
			write((byte) '4');
			write((byte) '7');
			write((byte) '4');
			write((byte) '8');
			write((byte) '3');
			write((byte) '6');
			write((byte) '4');
			write((byte) '8');
			return;
		}

		if (i < 0) {
			write((byte) '-');
			i = -i;
		}

		int pos = 0;
		while (i > 0) {
			byteBuffer[pos++] = (byte) ((i % 10) + '0');
			i /= 10;
		}

		while (pos-- > 0)
			write(byteBuffer[pos]);
	}

	public void print(long l) {
		if (l == 0) {
			write((byte) '0');
			return;
		}
		if (l == Long.MIN_VALUE) {
			write((byte) '-');
			write((byte) '9');
			write((byte) '2');
			write((byte) '2');
			write((byte) '3');
			write((byte) '3');
			write((byte) '7');
			write((byte) '2');
			write((byte) '0');
			write((byte) '3');
			write((byte) '6');
			write((byte) '8');
			write((byte) '5');
			write((byte) '4');
			write((byte) '7');
			write((byte) '7');
			write((byte) '5');
			write((byte) '8');
			write((byte) '0');
			write((byte) '8');
			return;
		}

		if (l < 0) {
			write((byte) '-');
			l = -l;
		}

		int pos = 0;
		while (l > 0) {
			byteBuffer[pos++] = (byte) ((l % 10) + '0');
			l /= 10;
		}

		while (pos-- > 0)
			write(byteBuffer[pos]);
	}

	public void print(float f) {
		String sf = Float.toString(f);
		for (int i = 0; i < sf.length(); i++)
			write((byte) sf.charAt(i));
	}

	public void print(double d) {
		String sd = Double.toString(d);
		for (int i = 0; i < sd.length(); i++)
			write((byte) sd.charAt(i));
	}

	public void printls(char c) {
		print(c);
		write((byte) ' ');
	}

	public void printls(String s) {
		print(s);
		write((byte) ' ');
	}

	public void printls(int i) {
		print(i);
		write((byte) ' ');
	}

	public void printls(long l) {
		print(l);
		write((byte) ' ');
	}

	public void printls(float f) {
		print(f);
		write((byte) ' ');
	}

	public void printls(double d) {
		print(d);
		write((byte) ' ');
	}

	public void printls() {
		write((byte) ' ');
	}

	public void println(char c) {
		print(c);
		write((byte) '\n');
	}

	public void println(char[] chars) {
		print(chars, 0, chars.length);
		write((byte) '\n');
	}

	public void println(String s) {
		print(s);
		write((byte) '\n');
	}

	public void println(int i) {
		print(i);
		write((byte) '\n');
	}

	public void println(long l) {
		print(l);
		write((byte) '\n');
	}

	public void println(float f) {
		print(f);
		write((byte) '\n');
	}

	public void println(double d) {
		print(d);
		write((byte) '\n');
	}

	public void println() {
		write((byte) '\n');
	}

	public void printf(String format, Object... args) {
		String s = String.format(format, args);
		for (int i = 0; i < s.length(); i++)
			write((byte) s.charAt(i));
	}

	public void fprint(char c) {
		print(c);
		flushBuffer();
	}

	public void fprint(String s) {
		print(s);
		flushBuffer();
	}

	public void fprint(int i) {
		print(i);
		flushBuffer();
	}

	public void fprint(long l) {
		print(l);
		flushBuffer();
	}

	public void fprint(float f) {
		print(f);
		flushBuffer();
	}

	public void fprint(double d) {
		print(d);
		flushBuffer();
	}

	public void fprintf(String format, Object... args) {
		printf(format, args);
		flushBuffer();
	}

	private byte read() {
		if (nextIn >= inLength) {
			if ((inLength = fill()) == EOF)
				return EOF;
			nextIn = 0;
		}

		return inBuffer[nextIn++];
	}

	private void write(byte b) {
		if (nextOut >= outBuffer.length)
			flushBuffer();

		outBuffer[nextOut++] = b;
	}

	private int fill() {
		try {
			return in.read(inBuffer, 0, inBuffer.length);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void flush() {
		flushBuffer();
	}

	private void flushBuffer() {
		if (nextOut == 0)
			return;

		try {
			out.write(outBuffer, 0, nextOut);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		nextOut = 0;
	}

	public void close() {
		flush();
	}
	
	public void exit(char c) {
		fprint(c);
		System.exit(0);
	}
	
	public void exit(String s) {
		fprint(s);
		System.exit(0);
	}

	public void exit(int i) {
		fprint(i);
		System.exit(0);
	}

	public void exit(long l) {
		fprint(l);
		System.exit(0);
	}

	public void exit(float f) {
		fprint(f);
		System.exit(0);
	}

	public void exit(double d) {
		fprint(d);
		System.exit(0);
	}

	public void exit(String format, Object... args) {
		fprintf(format, args);
		System.exit(0);
	}

	public void exit() {
		flushBuffer();
		System.exit(0);
	}
	
	private void ensureCapacity(int size) {
		if (size < charBuffer.length)
			return;

		char[] array = new char[size * 2];
		System.arraycopy(charBuffer, 0, array, 0, size);
		charBuffer = array;
	}

	private boolean isDigit(byte b) {
		return b >= '0' && b <= '9';
	}

	private boolean isLine(byte b) {
		return b == '\n' || b == '\r' || b == EOF;
	}

	private boolean isSpace(byte b) {
		return b == ' ' || b == '\t' || b == '\n' || b == '\r' || b == '\f' || b == EOF;
	}
}

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

		FastIO io = new FastIO(System.in, System.out);
		int resultCounter=0;
		for (int r=0; r<N; r++)
		{
			for (int c=0; c<N; c++) 
			{
				io.fprint(result[resultCounter]+" ");
				//System.out.print(result[resultCounter] + " ");
				//Grid[r][c]=result[resultCounter];
				resultCounter++;
			}
			io.fprint('\n');
		}  
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
		FastIO io = new FastIO(System.in, System.out);
		
		int[][] Grid = new int[9][9];
		for( int i = 0; i < 9; i++ ) {
			for( int j = 0; j < 9; j++ ) {
				Grid[i][j] = io.nextInt();
			}
		}
		
		solver.run(Grid);
	}


	public static void main(String args[]) throws IOException {
		Main s = new Main();
		s.solve();
	}

}