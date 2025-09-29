import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static int max = 0;
    static int[][] map;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        for (int i=0; i<col; i++){
            String[] num = br.readLine().split("");
            for (int j=0; j<num.length; j++){
                map[i][j] = Integer.parseInt(num[j]);
            }
        }
        max = Math.min(col, row);
        int len = max-1;
        while (len>0){
            for (int i=0; i<col; i++){
                for (int j=0; j<row; j++){
                    bfs(i,j,len);
                }
            }
            if (answer>1){
                break;
            }
            len--;
        }
        System.out.print(answer*answer);
    }

    private static void bfs(int col, int row, int len) {
        if (isValid(col, row, len)){
            if (isSame(col, row, len)){
                answer = Math.max(answer, len+1);
            }
        }
    }

    public static boolean isValid(int col, int row, int len){
        if (col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (col+len>map.length-1 || row+len>map[0].length-1){
            return false;
        }
        return true;
    }

    public static boolean isSame(int col, int row, int len){
        if (map[col][row]==map[col+len][row] &&
            map[col][row]==map[col][row+len] &&
            map[col][row]==map[col+len][row+len]
        ){
            return true;
        }
        return false;
    }

}

