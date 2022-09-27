package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16918_봄버맨 {
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static char[][] bomb;
    static int[][] timeBomb;
    static boolean[][] visited;
    static int R,C,N,TIME;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bomb = new char[R][C];
        timeBomb = new int[R][C];
        visited = new boolean[R][C];


        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                bomb[i][j] = input.charAt(j);
                //3초뒤 폭발하는 폭탄 설치
                if(bomb[i][j]=='O'){
                    timeBomb[i][j]=3;
                }
            }
        }

        TIME = 0;
        DFS();

        for (int i=0; i<R; i++){
            System.out.println(bomb[i]);
        }

    }
    //빈칸(.) 폭탄(0)
    //1초: 아무것도 하지않음
    //2초: 폭탄설치
    //3초: 폭탄 폭발
    public static void DFS(){
      while(TIME++<N){
          //폭탄 설치
          if(TIME%2==0) {
              for (int i = 0; i < R; i++) {
                  for (int j = 0; j < C; j++) {
                        if(bomb[i][j]=='.'){
                            bomb[i][j]='O';
                            timeBomb[i][j]=TIME+3;
                        }
                  }
              }
          }
          //폭탄 폭발
          else if(TIME%2==1){
              for (int i = 0; i < R; i++) {
                  for (int j = 0; j < C; j++) {
                      //폭발 시간이 된 폭탄은 폭발
                      if(timeBomb[i][j]==TIME){
                          bomb[i][j]='.';
                          isValid(i,j);
                      }
                  }
              }
          }
      }
    }

    static void isValid(int row, int col){
        for (int i=0; i<4; i++){
            int tempRow = rows[i]+row;
            int tempCol = cols[i]+col;
            if(tempRow>=0 && tempCol>=0 && tempRow<R && tempCol<C){
              //폭탄은 설치되어 있으나, 폭탄 터질 시간이 다른 시간이라면, 조건에 따라 폭발 없이 파괴되며 연쇄반응은 없다.
                if(bomb[tempRow][tempCol]=='O' && timeBomb[tempRow][tempCol]!=TIME){
                    bomb[tempRow][tempCol]='.';
                    timeBomb[tempRow][tempCol]=0;
                }
            }
        }

    }


}
