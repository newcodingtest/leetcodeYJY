package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18808_스티커붙이기 {
    static int N,M,CNT,RESULT;
    static int[][] notebook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CNT = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];
        RESULT = 0;
        for (int i=0; i<CNT; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[][] temp = new int[x][y];
            for (int j=0; j<x; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<y; k++){
                    temp[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            //0도 90도 180도 270도 4가지 회전 검증
            for (int r=0; r<4; r++){
                if(isAttach(temp))break;
                //검증 실패시 회전
                temp = rotate(temp);
            }
        }
        System.out.println(RESULT);
    }

    //회전 메소드
    public static int[][] rotate(int[][] sticker){
        int[][] rotateSticker = new int[sticker[0].length][sticker.length];

        //원문 좌표에서 90도 돌린 좌표로 생성해줘야 한다.
        for (int i=0; i<sticker.length; i++){
            for (int j=0; j<sticker[0].length; j++){
                rotateSticker[j][sticker.length-i-1]=sticker[i][j];
            }
        }
        return rotateSticker;
    }

    //노트북에 스티커 대입해보기
    public static boolean isAttach(int[][] sticker){
        for (int i=0; i<N-sticker.length+1; i++){
            for (int j=0; j<M-sticker[0].length+1; j++){
                if (isValid(sticker,i,j)){
                    fill(sticker,i,j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void fill(int[][] sticker,int row,int col){
        for (int i=0; i<sticker.length; i++){
            for (int j=0; j<sticker[0].length; j++){
                if(sticker[i][j]==1){
                    notebook[row+i][col+j]=1;
                    RESULT++;
                }

            }
        }
    }

    public static boolean isValid(int[][] sticker,int row,int col){
        for (int i=0; i<sticker.length; i++){
            for (int j=0; j<sticker[0].length; j++){
                if(sticker[i][j]==1 && notebook[i+row][j+col]==1){
                    return false;
                }
            }
        }
        return true;
    }
}
