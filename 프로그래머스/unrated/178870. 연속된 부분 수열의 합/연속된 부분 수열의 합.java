import java.io.IOException;
import java.util.*;

class Solution {
	public static int[] solution(int[] sequence, int k) {
		PriorityQueue<Node> po = new PriorityQueue<>();
		
		int start = 0;
		int end = 0;
		int len = sequence.length;
		int sum = sequence[0];

		while (end<=len-1 && start<=len-1){
			if (sum==k){
				po.add(new Node(start,end));
			}
			//만약 값을 찾았지만 end<len 으로 범위가 남아있는 경우 더 찾자.
			if (sum<=k && end<len){
				end++;
				if(end<len){
					sum+=sequence[end];
				}
			}else {
				//기존 start 위치 값 제거 하고 앞으로 나아간다.
				if (start<len){
					sum-=sequence[start];
				}
				start++;
			}
		}
		Node n = po.poll();
		
		return new int[]{n.start,n.end};
	}
	static class Node implements Comparable<Node> {
		int start;
		int end;
		int len;
		public Node(int start,
					int end){
			this.start = start;
			this.end = end;
			this.len = end-start;

		}

		@Override
		public int compareTo(Node o) {
			if (this.len == o.len){
				return this.start-o.start;
			}
			return this.len - o.len;
		}
	}
    
}