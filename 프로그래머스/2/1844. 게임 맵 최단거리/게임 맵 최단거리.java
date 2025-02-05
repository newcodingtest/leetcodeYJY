import java.util.LinkedList;
import java.util.Queue;
class Solution {
        //가로
    static int[] rows = {-1,1,0,0}; //왼오위아래
    //세로
    static int[] cols = {0,0,-1,1}; //왼오위아래
    static final int WALL = 0;
    static final int CAN_NOT_ARRIVE = -1;
    static boolean[][] isVisited;

   //1: 길, 0: 벽
    public static int solution(int[][] maps){
        isVisited = new boolean[maps.length][maps[0].length];
        return bfs(maps);
    }

    public static int bfs(int[][] maps){
        Queue<Location> q = new LinkedList<>();

        q.add(new Location(0,0,1));
        while (!q.isEmpty()){
            Location location = q.poll();
            int col = location.col;
            int row = location.row;
            int cnt = location.cnt;

            if(isArrived(col, row, maps)){
                return cnt;
            }

            for (int i=0; i<4; i++){
                int nCol = col+cols[i];
                int nRow = row+rows[i];
                if (isValid(nCol, nRow, maps)){
                    isVisited[nCol][nRow] = true;
                    q.add(new Location(nCol, nRow, cnt+1));
                }
            }
        }
        return CAN_NOT_ARRIVE;
    }

    static boolean isValid(int col, int row, int[][] maps){
        if (col<0 || row<0 || col>maps.length-1 || row>maps[0].length-1){
            return false;
        }
        if (maps[col][row] == WALL){
            return false;
        }
        if (isVisited[col][row]){
            return false;
        }
        return true;
    }

    static boolean isArrived(int col, int row, int[][] maps){
        if (col==maps.length-1 && row== maps[0].length-1){
            return true;
        }
        return false;
    }


    static class Location {
        private int col;
        private int row;
        private int cnt;

        public Location(int col, int row, int cnt){
            this.col = col;
            this.row = row;
            this.cnt = cnt;
        }
    }
}