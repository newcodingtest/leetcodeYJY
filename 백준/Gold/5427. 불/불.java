import java.io.*;
import java.util.*;

public class Main {
    static int[] moveCol = {0,0,-1,1};
    static int[] moveRow = {-1,1,0,0};
    static char[][] map;
    static boolean[][][] isVisited;
    static int[][] visitedCnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map = new char[col][row];
            isVisited = new boolean[col][row][2];
            visitedCnt = new int[col][row];

            for (int f=0; f<col; f++){
                Arrays.fill(visitedCnt[f],-1);
            }
            int startCol = 0;
            int startRow = 0;
            Queue<int[]> fire = new ArrayDeque<>();

            for (int j=0; j<col; j++){
                String elem = br.readLine();
                for (int k=0; k<elem.length(); k++){
                    map[j][k] = elem.charAt(k);
                    //불
                    if (map[j][k]=='*'){
                        fire.add(new int[]{j,k});
                        visitedCnt[j][k]=0;
                        isVisited[j][k][0]=true;
                        isVisited[j][k][1]=true;
                    }
                    //시작
                    else if(map[j][k]=='@'){
                        startCol = j;
                        startRow = k;
                        isVisited[j][k][1]=true;
                    }
                    //벽
                    else if(map[j][k]=='#'){
                        isVisited[j][k][0]=true;
                        isVisited[j][k][1]=true;
                    }
                }
            }
        int answer = bfs(startCol, startRow, fire);
        sb.append(answer==0?"IMPOSSIBLE":answer)
          .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int startCol, int startRow, Queue<int[]> fire){
        Queue<int[]> move = new ArrayDeque<>();
        move.add(new int[]{startCol, startRow, 0});

        //불
        while (!fire.isEmpty()){
            int[] now = fire.poll();
            int col = now[0];
            int row = now[1];

            for (int i=0; i<4; i++){
                int nCol = col+moveCol[i];
                int nRow = row+moveRow[i];
                if (isValid(nCol, nRow, 0)){
                    isVisited[nCol][nRow][0]=true;
                    visitedCnt[nCol][nRow] = visitedCnt[col][row]+1;
                    fire.add(new int[]{nCol, nRow});
                }
            }
        }
        //이동
        while (!move.isEmpty()){
            int[] now = move.poll();
            int col = now[0];
            int row = now[1];
            int cnt = now[2];

            if (col==0 || col== map.length-1 || row==0 || row==map[0].length-1){
                return cnt+1;
            }
            for (int i=0; i<4; i++){
                int nCol = col+moveCol[i];
                int nRow = row+moveRow[i];
                if (isValid(nCol, nRow, 1)){
                    if (visitedCnt[nCol][nRow]>cnt+1 || visitedCnt[nCol][nRow]==-1){
                        isVisited[nCol][nRow][1]=true;
                        move.add(new int[]{nCol, nRow, cnt+1});
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isValid(int col, int row, int fireOrMove){
        if (col<0 || row<0 || col>map.length-1 || row>map[0].length-1){
            return false;
        }
        if (isVisited[col][row][fireOrMove]){
            return false;
        }
        return true;
    }
}
