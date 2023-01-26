package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2615_오목 {
    //가로,세로
    static int[] dx = {0,1,1,1};
    static int[] dy = {1,1,0,-1};

    static int[][] omok = new int[21][21];
    static int[][][] dp = new int[21][21][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i=1; i<=19; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=19; j++){
                omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(judgement());
    }

    //검은색:1 흰색:2
    public static String judgement(){
        for (int i=1; i<=19; i++){
            for (int j=1; j<=19; j++){
                //왼쪽 4가지 방향 검사
                if(omok[j][i]!=0) {
                    for (int k = 0; k < 4; k++) {
                        if (dp[j][i][k] == 0 && valid(j, i, k, omok[j][i]) == 5) {
                            return omok[j][i] + "\n" + j + " " + i;
                        }
                    }
                }
            }
        }
        return "0";
    }

    public static int valid(int y, int x, int direction, int color ){
        int tx = x+dx[direction];
        int ty = y+dy[direction];

        if( omok[ty][tx]==color){
            return dp[ty][tx][direction] = valid(ty,tx,direction,color)+1;
        }
        return 1;
    }

}
