import java.util.*;
class Solution {
        //왼,오,위,아래
        static int[] move_rows = {-1,1,0,0};
        static int[] move_cols = {0,0,-1,1};
        static int max_row = 0;
        static int max_col = 0;
           static char[][] mirrors;
        static boolean[][] isVisited;
          /**
     *  S : 시작 지점
        E : 출구
        L : 레버
        O : 통로
        X : 벽
     */
       public static int solution(String[] maps) {
        max_col = maps.length;
        max_row = maps[0].length();

        isVisited = new boolean[max_col][max_row];
        mirrors = new char[max_col][max_row];

        int start_col = 0;
        int start_row = 0;

        int lever_col = 0;
        int lever_row = 0;

        int end_col = 0;
        int end_row = 0;

        for (int i=0; i<max_col; i++){
            for (int j=0; j<maps[i].length(); j++){
                if (maps[i].charAt(j)=='S'){
                    start_col = i;
                    start_row = j;
                } else if(maps[i].charAt(j)=='L'){
                    lever_col = i;
                    lever_row = j;
                } else if(maps[i].charAt(j)=='E'){
                    end_col = i;
                    end_row = j;
                }
                mirrors[i][j] = maps[i].charAt(j);
            }
        }


        //시작 지점 ~ 레버, 레버 ~ 출구 의 최소 횟수 구하기
        //
        int answer = dfs(start_col, start_row, lever_col, lever_row);
        if (answer>-1){
            isVisited = new boolean[max_col][max_row];
            int tmp = dfs(lever_col, lever_row, end_col, end_row);
            if (tmp == -1){
                return -1;
            }
            answer += tmp;
        }else{
            return -1;
        }

        return answer;
    }

    public static int dfs(int col, int row, int target_col, int target_row){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(col, row, 0));

        while (!q.isEmpty()){
            Node n = q.poll();

            if(n.x == target_col && n.y == target_row){
                return n.cost;
            }

            for (int i=0; i<4; i++){
                int x = n.x + move_cols[i];
                int y = n.y + move_rows[i];

                if (isBoundary(x,y)){
                    if (!isVisited[x][y]){
                        isVisited[x][y] = true;
                        q.add(new Node(x,y, n.cost+1));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isBoundary(int col, int row){
        if (col>max_col-1 || row>max_row-1 || col<0 || row<0){
            return false;
        }
        if (mirrors[col][row]=='X'){
            return false;
        }
        return true;
    }

    static class Node {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}