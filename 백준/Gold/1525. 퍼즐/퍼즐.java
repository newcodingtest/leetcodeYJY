import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //왼, 오, 위, 아래
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};

    static final String TARGET = "123456780";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] map = new int[3][3];
        int startCol = 0;
        int startRow = 0;

        for (int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                int elem = Integer.parseInt(st.nextToken());
                if (elem==0){
                    startCol = i;
                    startRow = j;
                }
                map[i][j] = elem;
            }
        }
        System.out.print(bfs(map, startCol, startRow, 0));
    }

    private static int bfs(int[][] map, int startCol, int startRow, int cnt) {
        Set<String> visited = new HashSet<>();
        Queue<Info> q = new ArrayDeque<>();

        q.add(new Info(startCol, startRow, cnt, map));
        visited.add(toString(map));

        while (!q.isEmpty()){
            Info info = q.poll();
            int col = info.col;
            int row = info.row;
            int[][] nowMap = info.map;
            int nowCnt = info.cnt;

            String str = toString(nowMap);
            if (str.equals(TARGET)){
                return nowCnt;
            }

            for (int i=0; i<4; i++){
                int ncol = col+moveCol[i];
                int nrow = row+moveRow[i];
                if (isBoundary(ncol, nrow)){

                    int[][] nextMap = copy(nowMap);
                    swap(col, row, ncol, nrow, nextMap);

                    String nextStr = toString(nextMap);
                    if (!visited.contains(nextStr)) {
                        visited.add(nextStr);
                        q.add(new Info(ncol, nrow, nowCnt + 1, nextMap));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isSimilar(int[][] map){
        int idx = 1;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i==2 && j==2){
                    if (map[i][j]!=0){
                        return false;
                    }
                } else {
                    if (map[i][j]!=idx){
                        return false;
                    }
                }
                idx++;
            }
        }
        return true;
    }

    public static void swap(int col1, int row1, int col2, int row2, int[][] map){
        int temp = map[col1][row1];
        map[col1][row1] = map[col2][row2];
        map[col2][row2] = temp;
    }

    public static boolean isBoundary(int col, int row){
        if (col<0 || row<0 || col>2 || row>2){
            return false;
        }
        return true;
    }

    static class Info {
        private int col;
        private int row;
        private int cnt;
        private int[][] map;

        public Info(int col, int row, int cnt, int[][] map) {
            this.col = col;
            this.row = row;
            this.cnt = cnt;
            this.map = map;
        }
    }

    public static String toString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int val : row) {
                sb.append(val);
            }
        }
        return sb.toString();
    }

    public static int[][] copy(int[][] src) {
        int[][] dest = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, 3);
        }
        return dest;
    }
}
