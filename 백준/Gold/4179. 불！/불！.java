import java.io.*;
import java.util.*;

public class Main {
    //왼,오,위,아래
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
    static char[][] map;
    static int[][] fireTime;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        map = new char[col][row];
        isVisited = new boolean[col][row];
        fireTime = new int[col][row];
        for (int i=0; i<col; i++){
            Arrays.fill(fireTime[i], -1);
        }

        int startCol = 0;
        int startRow = 0;

        Queue<Fire> fire = new ArrayDeque<>();

        for (int i=0; i<col; i++){
            String str = br.readLine();
            for (int j=0; j<str.length(); j++){
                char elem = str.charAt(j);
                map[i][j] = elem;
                if (elem=='J'){
                    startCol = i;
                    startRow = j;
                } else if(elem=='F'){
                    fire.add(new Fire(i,j,0));
                    isVisited[i][j] = true;
                }
            }
        }
        int answer = bfs(fire, startCol, startRow);
        System.out.print(answer==0?"IMPOSSIBLE": answer);
    }

    private static int bfs(Queue<Fire> fire, int col, int row){
      //불
      while (!fire.isEmpty()){
          Fire now = fire.poll();
          int nowCol = now.col;
          int nowRow = now.row;

          for (int i=0; i<4; i++){
              int nextCol = nowCol+moveCol[i];
              int nextRow = nowRow+moveRow[i];

              if (isValid(nextCol, nextRow)){
                  isVisited[nextCol][nextRow] = true;
                  fire.add(new Fire(nextCol, nextRow, now.cnt+1));
                  fireTime[nextCol][nextRow] = now.cnt+1;
              }
          }
      }
        isVisited = new boolean[isVisited.length][isVisited[0].length];

        Queue<int[]>q = new ArrayDeque<>();
        q.add(new int[]{col,row,0});
        isVisited[col][row] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowCol = now[0];
            int nowRow = now[1];

            if (isEdge(nowCol, nowRow)){
                return now[2]+1;
            }
            for (int i=0; i<4; i++){
                int nextCol = nowCol+moveCol[i];
                int nextRow = nowRow+moveRow[i];

                if (isValid(nextCol, nextRow)) {
                    if (fireTime[nextCol][nextRow]>now[2]+1 || fireTime[nextCol][nextRow]==-1){
                        isVisited[nextCol][nextRow] = true;
                        q.add(new int[]{nextCol, nextRow, now[2]+1});
                    }
                }
            }
        }

      return 0;
    }

    private static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (map[col][row]=='#' || map[col][row]=='F' || isVisited[col][row]){
            return false;
        }
        return true;
    }

    private static boolean isEdge(int col, int row){
        if (col==0 || row==0 || col == map.length-1 || row == map[0].length-1){
            return true;
        }
        return false;
    }

    static class Fire {
        int col;
        int row;
        int cnt;

        public Fire(int col, int row, int cnt){
            this.col = col;
            this.row = row;
            this.cnt = cnt;
        }
    }
}
