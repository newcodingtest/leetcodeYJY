import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,-1,1};
    static boolean[][] isVisited = new boolean[12][6];
    static String[][] map = new String[12][6];
    static int[] rainCnt = new int[6];
    static int answer = 0;
    static boolean isFind = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i=0; i<12; i++){
            String[] str = br.readLine().split("");
            for (int j=0; j<str.length; j++){
               String elem = str[j];
               if (elem.equals(".")){
                   rainCnt[j]++;
               }
               map[i][j]=elem;
            }
        }

        //R,G,B,P,Y
        while (true){
            isFind = false;
            for (int i=0; i<12; i++){
                for (int j=0; j<6; j++){
                    if (!map[i][j].equals(".")){
                        if (!isVisited[i][j]){
                            bfs(i,j);
                        }
                    }
                }
            }

            if (!isFind){
                break;
            } else {
                answer++;
                down();

            }
        }

        System.out.println(answer);
    }

    private static void bfs(int col, int row) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{col,row});
        isVisited[col][row] = true;

        int cnt = 1;
        boolean over4 = false;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int ccol = cur[0];
            int crow = cur[1];

            if (cnt>=4){
                over4=true;
            }
            for (int i=0; i<4; i++){
                int ncol = ccol+moveCol[i];
                int nrow = crow+moveRow[i];
                if (isBoundary(ncol, nrow)){
                    if (map[ncol][nrow].equals(map[ccol][crow])){
                        if (!isVisited[ncol][nrow]){
                            isVisited[ncol][nrow]=true;
                            cnt++;
                            q.add(new int[]{ncol, nrow});
                        }
                    }
                }
            }
        }
        if (over4){
            remove(isVisited);
            isFind = true;
        }
        isVisited = new boolean[12][6];
    }

    public static boolean isBoundary(int col, int row){
        if (col<0 || row<0 || col>11 || row>5){
            return false;
        }
        return true;
    }

    public static void remove(boolean[][] isVisited){
        for (int i=0; i<12; i++){
            for (int j=0; j<6; j++){
                if (isVisited[i][j]){
                    map[i][j]=".";
                    rainCnt[j]--;
                }
            }
        }
    }

    public static void down(){
        // 숫자만 추출
        List<String> numbers = new ArrayList<>();

        for (int i=0; i<rainCnt.length; i++){
            for (int j=11; j>=0; j--){
                String str = map[j][i];
                if (!str.equals(".")){
                    numbers.add(map[j][i]);
                }
            }
            int idx = 0;
            int dotCnt = 12-numbers.size();

            // 먼저 "." 채우기
            for (int k = 0; k < dotCnt; k++) {
                map[idx++][i] = ".";
            }
            // 숫자 채우기
            for (int k=numbers.size()-1; k>=0; k--){
                map[idx++][i] = numbers.get(k);
            }
            numbers.clear();
        }

//        Arrays.stream(map).forEach(x -> {
//            Arrays.stream(x).forEach(y -> {
//                System.out.print(y);
//                    }
//
//            );
//            System.out.println();
//        });
//        System.out.println();
    }
}
