import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] moveMonkey = {
            {-1,0},{1,0},{0,-1},{0,1}
    };
    static int[][] moveHourse = {
            {-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}
    };

    static int[][] map;
    static int counting = Integer.MAX_VALUE;
    static int chance  = 0;
    static boolean[][][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chance = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        isVisited = new boolean[col][row][chance+1];

        //0:길, 1:벽
        for (int i=0; i<col; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<row; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisited[0][0][chance]=true;
        bfs(0,0);
        System.out.println(counting==Integer.MAX_VALUE?-1:counting);
    }

    public static void bfs(int col, int row){
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(col, row, 0, chance));

        while (!q.isEmpty()){
            Monkey monkey = q.poll();

            int mcol = monkey.col;
            int mrow = monkey.row;
            int mcnt = monkey.cnt;

            int mchance = monkey.chance;

            if (mcol==map.length-1 && mrow==map[0].length-1){
                counting = Math.min(counting, mcnt);
               // return;
            }

            for (int i=0; i<4; i++){
                int ncol = mcol+moveMonkey[i][0];
                int nrow = mrow+moveMonkey[i][1];
                if (isBoundary(ncol, nrow)){
                    if (!isVisited[ncol][nrow][mchance]){
                        isVisited[ncol][nrow][mchance]=true;
                        q.add(new Monkey(ncol, nrow, mcnt+1, mchance));
                    }
                }
            }

            if (mchance>0){
                for (int i=0; i<moveHourse.length; i++){
                    int ncol = mcol+moveHourse[i][0];
                    int nrow = mrow+moveHourse[i][1];
                    if (isBoundary(ncol, nrow)){
                        if (!isVisited[ncol][nrow][mchance-1]){
                            isVisited[ncol][nrow][mchance-1]=true;
                            q.add(new Monkey(ncol, nrow,mcnt+1, mchance-1));
                        }
                    }
                }
            }

        }
    }

    public static boolean isBoundary(int col, int row){
        if (col<0 || row<0 || col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (map[col][row]==1){
            return false;
        }

        return true;
    }


    static class Monkey {
        private int col;
        private int row;
        private int cnt;
        private int chance;

        public Monkey(int col, int row, int cnt, int change){
            this.col = col;
            this.row = row;
            this.cnt = cnt;
            this.chance = change;
        }

    }

}
