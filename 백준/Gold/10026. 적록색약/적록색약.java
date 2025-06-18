import java.io.*;
import java.util.*;

public class Main {
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
    static char[][] map;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i=0; i<N; i++){
            String elem = br.readLine();
            for (int j=0; j<elem.length(); j++){
                map[i][j] = elem.charAt(j);
            }
        }
        int sum = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!isVisited[i][j]){
                    bfs(i,j, false);
                    sum++;
                }
            }
        }

        sb.append(sum+" ");
        sum = 0;
        isVisited = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!isVisited[i][j]){
                    bfs(i,j, true);
                    sum++;
                }
            }
        }
        sb.append(sum+" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int startCol, int startRow, boolean rg){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startCol, startRow});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int col = now[0];
            int row = now[1];

            for (int i=0; i<4; i++){
                int nextCol = col + moveCol[i];
                int nextRow = row + moveRow[i];

                if (isValid(nextCol, nextRow)){
                    if (rg){
                        if (map[col][row]=='R' || map[col][row]=='G'){
                            if (map[nextCol][nextRow]!='B'){
                                q.add(new int[]{nextCol, nextRow});
                                isVisited[nextCol][nextRow] = true;
                            }
                        } else {
                            if (map[col][row]==map[nextCol][nextRow]){
                                q.add(new int[]{nextCol, nextRow});
                                isVisited[nextCol][nextRow] = true;
                            }
                        }
                    } else {
                        if (map[col][row]==map[nextCol][nextRow]){
                            q.add(new int[]{nextCol, nextRow});
                            isVisited[nextCol][nextRow] = true;
                        }
                    }

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
