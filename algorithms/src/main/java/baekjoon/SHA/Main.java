package baekjoon.SHA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
	
	public static int leftrotate(int x, int y) {
		return (x << y) | (x >>> (32 - y));
	}

	public static String hash(String str) {
		int[] h = { 0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0 };

		long ml = 8 * str.length();
		str += (char)0x80;
		while (str.length() < 56) {
			str += (char)0x00;
		}
		for (int i = 7; i >= 0; i--) {
			str += (char)((ml >> (8 * i)) & 0xFF);
		}

		char[] m = str.toCharArray();
		int[] w = new int[80];
		for (int i = 0; i < 16; i++) {
			w[i] = (m[4 * i] << 24) | (m[4 * i + 1] << 16) | (m[4 * i + 2] << 8) | m[4 * i + 3];
		}
		for (int i = 16; i < 80; i++) {
			w[i] = w[i - 3] ^ w[i - 8] ^ w[i - 14] ^ w[i - 16];
		}

		int a = h[0];
		int b = h[1];
		int c = h[2];
		int d = h[3];
		int e = h[4];
		int f, k;

		for (int i = 0; i < 80; i++) {
			if (i < 20) {
				f = (b & c) | ((~b) & d);
				k = 0x5A827999;
			} else if (i < 40) {
				f = b ^ c ^ d;
				k = 0x6ED9EBA1;
			} else if (i < 60) {
				f = (b & c) | (b & d) | (c & d);
				k = 0x8F1BBCDC;
			} else {
				f = b ^ c ^ d;
				k = 0xCA62C1D6;
			}

			int tmp = leftrotate(a, 5) + f + e + k + w[i];
			e = d;
			d = c;
			c = leftrotate(b, 30);
			b = a;
			a = tmp;
		}

		h[0] += a;
		h[1] += b;
		h[2] += c;
		h[3] += d;
		h[4] += e;

		BigInteger bi = new BigInteger(Integer.toBinaryString(h[0]), 2);
		bi = bi.shiftLeft(32).or(new BigInteger(Integer.toBinaryString(h[1]), 2));
		bi = bi.shiftLeft(32).or(new BigInteger(Integer.toBinaryString(h[2]), 2));
		bi = bi.shiftLeft(32).or(new BigInteger(Integer.toBinaryString(h[3]), 2));
		bi = bi.shiftLeft(32).or(new BigInteger(Integer.toBinaryString(h[4]), 2));

		StringBuilder sb = new StringBuilder(bi.toString(16));
		while (sb.length() < 40) {
			sb.insert(0, "0");
		}

		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		System.out.println(hash(s));
		
	}

}