import java.io.*;
import java.util.*;

public class Main {
    //퀸 이동
    static int[] moveCol = {-1,1,-1,1,2,-2,2,-2};
    static int[] moveRow = {-2,-2,2,2,-1,-1,1,1};
    static int[][] map;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            isVisited = new boolean[size][size];
            st = new StringTokenizer(br.readLine());
            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());

            sb.append(bfs(startCol, startRow, endCol, endRow)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    private static int bfs(int startCol, int startRow, int targetCol, int targetRow){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startCol, startRow, 0});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int col = now[0];
            int row = now[1];
            int cnt = now[2];

            if (col==targetCol && row==targetRow){
                return cnt;
            }

            for (int i=0; i<8; i++){
                int nextCol = col + moveCol[i];
                int nextRow = row + moveRow[i];

                if (isValid(nextCol, nextRow)){
                    isVisited[nextCol][nextRow] = true;
                    q.add(new int[]{nextCol, nextRow, cnt+1});
                }
            }
        }
        return 0;
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
