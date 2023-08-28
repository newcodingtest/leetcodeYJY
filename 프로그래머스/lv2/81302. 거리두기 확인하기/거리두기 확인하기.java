import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] rows = {-1,1,0,0};
	static int[] cols = {0,0,-1,1};
	static boolean[][] isVisited;
	static Queue<Node> q = new LinkedList<>();
	static int[] answer;
	public static int[] solution(String[][] places) {
		answer = new int[places.length];
		int len = places.length;
Arrays.fill(answer,1);

		for (int i=0; i<places.length; i++){
			isVisited = new boolean[5][5];
			for (int j=0; j<5; j++){
				for (int k=0; k<5; k++){
					if (places[i][j].charAt(k) == 'P'){
                        isVisited[j][k]=true;
						bfs(i,j,k,0,places[i]);
					}
				}
			}
		}
		return answer;
	}

	private static void bfs(int num, int col, int row, int cnt, String[] places) {
		if (cnt>2){
			return;
		}
		if (0<cnt && cnt<=2 && places[col].charAt(row)=='P'){
			answer[num] = 0;
			return;
		}

		for (int i=0; i<4; i++){
			int dy = col+cols[i];
			int dx = row+rows[i];

			if (dx<0 || dy<0 || dx>4 || dy>4 || places[dy].charAt(dx)=='X') continue;

			if (!isVisited[dy][dx]){
				isVisited[dy][dx]=true;
				bfs(num,dy,dx,cnt+1,places);
				isVisited[dy][dx]=false;
			}
		}
	}

	static class Node {
		int col;
		int row;
		int cnt;
		public Node(int col, int row, int cnt){
			this.col = col;
			this.row = row;
			this.cnt = cnt;
		}
	}
}