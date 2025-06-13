import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //왼,오,위,아래
    static int[] moveCols = {0,0,-1,1};
    static int[] moveRows = {-1,1,0,0};
    static boolean[][] isVisited;
    static int[][] dp;
    static int[][] map;

    static int startCol = 0;
    static int startRow = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        isVisited = new boolean[col][row];
        map = new int[col][row];
        dp = new int[col][row];

        for (int i=0; i<map.length; i++){
            Arrays.fill(dp[i], -1);
        }

        for (int i=0; i<col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                int elem = Integer.parseInt(st.nextToken());
                map[i][j] = elem;
                if (elem==2){
                    startCol = i;
                    startRow = j;
                    isVisited[i][j] = true;
                    dp[i][j] = 0;
                } else if(elem==0){
                    isVisited[i][j] = true;
                    dp[i][j] = 0;
                }
            }
        }

      bfs(startCol, startRow);

      StringBuilder sb = new StringBuilder();
      for (int i=0; i<map.length; i++){
          for (int j=0; j<map[0].length; j++){
              if (j==map[0].length-1){
                  sb.append(dp[i][j]);
              }else {
                  sb.append(dp[i][j]+" ");
              }
          }
          sb.append("\n");
      }

        System.out.print(sb);
    }

    private static void bfs(int startCol, int startRow) {
        Queue<int[][]> q = new LinkedList<>();

        q.add(new int[][]{{startCol, startRow}});

        while (!q.isEmpty()){
            int[][] position = q.poll();
            int col = position[0][0];
            int row = position[0][1];

            for (int i=0; i<4; i++){
                int n_col = col+moveCols[i];
                int n_row = row+moveRows[i];

                if (isValid(n_col,n_row)){
                    dp[n_col][n_row] = dp[col][row]+1;
                    isVisited[n_col][n_row] = true;
                    q.add(new int[][]{{n_col, n_row}});
                }
            }
        }
    }

    private static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (isVisited[col][row]){
            return false;
        }
        return true;
    }

}
