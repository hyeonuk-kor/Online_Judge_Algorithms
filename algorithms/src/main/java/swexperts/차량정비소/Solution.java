package swexperts.차량정비소;
import java.io.*;
import java.util.*;
public class Solution {
	static class Carcenter {
		int cusNumber;
		int arrive;
		int recNumber;
		int repNumber;
		int recStart;
		int recEnd;
		int repStart;
		public Carcenter(int cusNumber, int arrive) { // 고객번호와  시작시간을 생성자로 받고, 대기 상황에 따라 나머지 멤버 변수 세팅
			this.cusNumber = cusNumber;
			this.arrive = arrive;
		}
		public int getCusNumber() {	// 접수 창구 우선순위
			return cusNumber;
		}
		public int getRecEnd() { // 정비 창구 우선순위 - 1
			return recEnd;
		}
		public int getRecNumber() { // 정비 창구 우선순위 - 2
			return recNumber;
		}
	}
	static int N, M, K, A, B; // 접수 창구, 정비 창구, 고객 수, 지갑찾을 접수 창구번호, 지갑찾을 정비 창구 번호, -> A와 B를 동시에 이용한 사람의 고객번호 합을 찾아야함 
	static int rec[] = new int[10], rep[] = new int[10];	//접수 정비 창구의 걸리는 시간
	static Carcenter rec_count[] = new Carcenter[11], rep_count[] = new Carcenter[11]; // 접수 정비 창구
	static PriorityQueue<Carcenter> reception, repair; // 접수 정비 창구의 대기열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=N; i++) {
				rec[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=M; i++) {
				rep[i] = Integer.parseInt(st.nextToken());
			}
			reception = new PriorityQueue<>(Comparator.comparing(Carcenter::getCusNumber));
			repair = new PriorityQueue<>(Comparator.comparing(Carcenter::getRecEnd).thenComparing(Carcenter::getRecNumber));
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=K; i++) {
				reception.add(new Carcenter(i, Integer.parseInt(st.nextToken())));
			}

			int time = 0;
			int answer = 0;
			int index = 0;
			while(index<K) { // K명이 수리될 때 까지
				// 접수 창구 관련
				for(int i=1; i<=N; i++) {
					if(rec_count[i]!=null) { // 접수 창구에 사람이 있다면
						Carcenter c = rec_count[i];
						if(c.recStart+rec[i]<=time) { // ==는 하면 안됨, 정비창구가 꽉차서 기다렸을 수도 있음, 접수처리가 다됐다면
							c.recEnd = time;		 // 시간 기록
							repair.add(c);			// 정비 창구 대기열로 이동
							rec_count[i] = null;	// 해당 창구는 비었다.
						}
					}
				}
				for(int i=1; i<=N; i++) {
					if(rec_count[i]==null) { // 접수 창구가 비었다면
						if(!reception.isEmpty() && reception.peek().arrive<=time) { // ==는 하면 안됨, 꽉차서 기다렸을 수도 있음
							rec_count[i] = reception.poll(); // 접수 창구의 대기열에서 접수창구로 이동
							rec_count[i].recNumber = i;    // 접수 창구 번호
							rec_count[i].recStart = time; //접수 시작 시간
						}
					}
				}
				// 정비 창구 관련
				for(int i=1; i<=M; i++) {
					if(rep_count[i]!=null) { // 정비 창구에 사람이 있다면
						Carcenter c = rep_count[i];
						if(c.repStart+rep[i]<=time) { // 수리 완료
							if(c.recNumber==A && c.repNumber==B) {
								answer += c.cusNumber;
							} 
							index++; // 수리된 인원 수
							rep_count[i] = null; // 해당 창구는 비었다.
						}
					}
				}
				for(int i=1; i<=M; i++) {
					if(rep_count[i]==null) { // 정비 창구가 비었다면
						if(!repair.isEmpty()) {
							rep_count[i] = repair.poll();
							rep_count[i].repNumber = i;
							rep_count[i].repStart = time;
						}
					}
				}
				time++; //이상 1초간 일어나는 행위 구현 끝
			}
			System.out.println("#"+tc+" "+(answer==0?-1:answer));
		}
	}
}