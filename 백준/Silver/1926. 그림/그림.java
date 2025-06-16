import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //왼,오,위,아래
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
    static int[][] pic;
    static boolean[][] isVisited;
    static int count = 0;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        pic = new int[col][row];
        isVisited = new boolean[col][row];

        for (int i=0; i<col; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<row; j++){
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<col; i++){
            for (int j=0; j<row; j++){
                if (pic[i][j]==1 && !isVisited[i][j]){
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        System.out.print(MAX);
    }

    private static void bfs(int col, int row) {
        count++;
        Queue<int[][]> q = new LinkedList<>();
        q.add(new int[][]{{col,row}});
        isVisited[col][row]=true;

        int sum = 0;
        while (!q.isEmpty()){
            int[][] now = q.poll();
            int nowCol = now[0][0];
            int nowRow = now[0][1];
            sum++;

            for (int i=0; i<4; i++){
                int nextCol = nowCol + moveCol[i];
                int nextRow = nowRow + moveRow[i];

                if (isValid(nextCol, nextRow)){
                    isVisited[nextCol][nextRow] = true;
                    q.add(new int[][]{{nextCol,nextRow}});
                }
            }
        }
        MAX = Math.max(MAX, sum);
    }

    private static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>pic.length-1 || row>pic[0].length-1 ){
            return false;
        }
        if (pic[col][row]==0){
            return false;
        }
        if (isVisited[col][row]){
            return false;
        }
        return true;
    }


}
