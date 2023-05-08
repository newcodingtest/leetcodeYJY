package 프로그래머스.dfs_bfs;
import java.util.*;
public class 아이템줍기 {
    static int[] moveCols = {0,0,-1,1};
    static int[] moveRows = {-1,1,0,0};
    static int[][] map = new int[102][102];
    static boolean[][][] isBoundary = new boolean[102][102][2];
    static boolean[][] isVisited = new boolean[102][102];
    static int answer = 0;

    //캐릭터가 아이템을 줍기위해 이동하는 최소 짧은 거리
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for (int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;

            //그리기
            for (int j=x1; j<=x2; j++){
                for (int k=y1; k<=y2; k++){
                    //그리기
                    isBoundary[j][k][0] = true;
                }
            }

        }

        for (int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;

            //내부 비우기
            for (int j=x1+1; j<=x2-1; j++){
                for (int k=y1+1; k<=y2-1; k++){
                    isBoundary[j][k][0]=false;
                }
            }

        }

        bfs(characterX*2,characterY*2,itemX*2,itemY*2);
        return answer/2;

    }

    public static void bfs(int x, int y, int tx, int ty){
        Queue<Node> q = new LinkedList<>();
        isVisited[x][y]=true;
        q.add(new Node(x,y,0));

        while(!q.isEmpty()){
            Node n = q.poll();

            int nx = n.col;
            int ny = n.row;
            int nCnt = n.cnt;

            if(nx==tx && ny==ty){
                answer = nCnt;
            }

            for (int i=0; i<4; i++){
                int col = nx+moveCols[i];
                int row = ny+moveRows[i];


                if(isBoundary[col][row][0]){
                    if(!isVisited[col][row]){
                        isVisited[col][row]=true;
                        q.add(new Node(col,row,nCnt+1));
                    }
                }

            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x>100 || y>100 || x<1 || y<1){
            return false;
        }
        return true;
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
