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
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                sb.append(st.nextToken());
            }
        }
        System.out.print(bfs(sb.toString()));
    }

    private static int bfs(String str) {
        if (str.equals(TARGET)){
            return 0;
        }

        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(str, 0);

        Queue<String> q = new ArrayDeque<>();
        q.add(str);
        while (!q.isEmpty()){
            String cur = q.poll();
            int idx = cur.indexOf('0');
            int col = idx/3;
            int row = idx%3;

            for (int i=0; i<4; i++){
                int ncol = col+moveCol[i];
                int nrow = row+moveRow[i];
                if (isBoundary(ncol, nrow)){
                    String newStr = swap(cur, ncol, nrow, idx);

                    if (cur.equals(TARGET)){
                        return visited.get(cur);
                    }

                    if (!visited.containsKey(newStr)){
                        visited.put(newStr, visited.get(cur)+1);
                        q.add(newStr);
                    }
                }
            }
        }
        return -1;
    }



    public static boolean isBoundary(int col, int row){
        if (col<0 || row<0 || col>2 || row>2){
            return false;
        }
        return true;
    }

    public static String swap(String str, int col, int row, int idx1){
        StringBuilder sb = new StringBuilder(str);
        int idx2 = (col*3)+row;
        char temp1 = sb.charAt(idx1);
        char temp2 = sb.charAt(idx2);
        sb.setCharAt(idx1, temp2);
        sb.setCharAt(idx2, temp1);
        return sb.toString();
    }

}
