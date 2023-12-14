
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int WIDTH; //세로
    static int M; //가로
    static int HEIGHT;
    static int[][] isVisited;
    static BufferedReader br;
    static StringTokenizer st;
    static int answer;
    static int MAX = 3;

    static boolean isFinish = false;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        WIDTH = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HEIGHT = Integer.parseInt(st.nextToken());

        isVisited = new int[HEIGHT+1][WIDTH+1];

        addLadder();

        //사다리 1개씩 추가할때마다 bfs 돌기
        for (int i=0; i<=MAX; i++){
            answer = i;
            bfs(1,1,0);
            if (isFinish)
                break;

        }

        System.out.println((isFinish ? answer : -1));
        br.close();


    }

    //가로 사다리 추가
    //1 이면 오른쪽 사다리, 2이면 왼쪽 사다리
    public static void addLadder() throws IOException {
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            isVisited[x][y] = 1;
            isVisited[x][y+1] = 2;
        }
    }

    public static void bfs(int col, int row, int now){
        //사다리를 모두 두기 전에 검사해서 통과했을때
        if (isFinish){
            return;
        }

        //사다리를 모두 두었을때
        if (answer==now){
            if (isValid()){
                isFinish=true;
            }
            return;
        }

        //사다리 추가
        for (int i=col; i<=HEIGHT; i++){
            for (int j=row; j<WIDTH; j++){

                if (isVisited[i][j]==0 && isVisited[i][j+1]==0){
                    isVisited[i][j]=1;
                    isVisited[i][j+1]=2;

                    bfs(1,1, now+1);

                    isVisited[i][j]=0;
                    isVisited[i][j+1]=0;
                }
            }
        }

    }

    public static boolean isValid(){
        for (int i=1; i<=WIDTH; i++){
            int row = i;
            int col = 1;
            while (col<=HEIGHT){
                if (isVisited[col][row] == 1){
                    row++;
                }else if(isVisited[col][row] == 2){
                    row--;
                }
                col++;
            }

            if (row!=i){
                return false;
            }
        }
        return true;
    }
}
