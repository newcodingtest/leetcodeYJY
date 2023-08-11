import java.util.*;
class Solution {
    	//가로(왼 오 위 아래)
	static int[] dx = {-1,1,0,0} ;
	//세로(왼 오 위 아래)
	static int[] dy = {0,0,-1,1};
	static String[][] maps;

	static int answer = Integer.MAX_VALUE;
	static boolean[][] isVisited;
	public static int solution(String[] board) {
		int start_x = 0;
		int start_y = 0;
		maps = new String[board.length][board[0].length()];
		isVisited = new boolean[board.length][board[0].length()];

	
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length(); j++){
					String str = String.valueOf(board[i].charAt(j));
					if(str.equals("R")){
						start_x = j;
						start_y = i;
					} 
					maps[i][j] = str;
			}
		}
		int answer = bfs(start_y,start_x);
		return answer;
	}

	static int bfs(int start_y, int start_x){
		Queue<Point>q = new LinkedList<>();
		q.add(new Point(start_y,start_x,0));
		isVisited[start_y][start_x]=true;

		while (!q.isEmpty()){
			Point p = q.poll();
			int py = p.y;
			int px = p.x;
			int pcnt = p.cnt;
			if (maps[py][px].equals("G")){
				answer = Math.min(answer,pcnt);
			}

			if(isValid(py,px)){
				for (int i=0; i<4; i++){
					int next_y = py + dy[i];
					int next_x = px + dx[i];
					while(isValid(next_y,next_x)){
						next_y+=dy[i];
						next_x+=dx[i];
					}
					next_y-=dy[i];
					next_x-=dx[i];

					if (!isVisited[next_y][next_x]){
						isVisited[next_y][next_x]=true;
						q.add(new Point(next_y,next_x,pcnt+1));
					}
				}
			}
		}
		return answer==Integer.MAX_VALUE?-1:answer;
	}

	static boolean isValid(int y, int x){
		if (x<0 || x>maps[0].length-1 ||
			y<0 || y>maps.length-1){
			return false;
		}
		if(maps[y][x].equals("D")){
			return false;
		}
		return true;
	}

	static class Point {
		int y;
		int x;
		int cnt;
		public Point(int y, int x, int cnt){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

}