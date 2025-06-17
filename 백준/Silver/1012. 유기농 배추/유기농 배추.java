import java.io.*;
import java.util.*;

public class Main {
    //왼,오,위,아래
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
    static int[][] map;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int colSize = Integer.parseInt(st.nextToken());
            int rowSize = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            map = new int[colSize][rowSize];
            isVisited = new boolean[colSize][rowSize];
            for (int j=0; j<cnt; j++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[col][row] = 1;
            }
            int sum = 0;
            for (int k=0; k<map.length; k++){
                for (int l=0; l<map[0].length; l++){
                    if (map[k][l]==1 && !isVisited[k][l]){
                        sum++;
                        bfs(k,l);
                    }

                }
            }
            sb.append(sum+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int col, int row){
      Queue<int[]>q = new LinkedList<>();
      q.add(new int[]{col,row});
      isVisited[col][row] = true;

      while (!q.isEmpty()){
          int[] now = q.poll();

          for (int i=0; i<4; i++){
              int nextCol = now[0]+moveCol[i];
              int nextRow = now[1]+moveRow[i];

              if (isValid(nextCol, nextRow)){
                  isVisited[nextCol][nextRow] = true;
                  q.add(new int[]{nextCol, nextRow});
              }
          }
      }
    }

    private static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (map[col][row]==0 || isVisited[col][row]){
            return false;
        }
        return true;
    }


}
