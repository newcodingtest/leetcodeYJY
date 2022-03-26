package 백준.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {
    static int[][] arr;
    static int minus,zero,one;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int cnt = Integer.parseInt(br.readLine());
        minus = 0 ;
        zero = 0;
        one = 0;

        arr = new int[cnt][cnt];

        for (int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<cnt; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,cnt);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);


    }

    private static void partition(int row, int col, int size) {
        if (checkSameColor(row, col, size)){
            if(arr[row][col]==0){
                zero++;
            }else if(arr[row][col]==1){
                one++;
            }else if(arr[row][col]==-1){
                minus++;
            }
            return;
        }

        int diviedSize = size / 3;

        partition(row, col, diviedSize);
        partition(row, col+diviedSize, diviedSize);
        partition(row, col+2*diviedSize,diviedSize);

        partition(row+diviedSize, col, diviedSize);
        partition(row+diviedSize, col+diviedSize, diviedSize);
        partition(row+diviedSize, col+2*diviedSize, diviedSize);

        partition(row+2*diviedSize, col, diviedSize);
        partition(row+2*diviedSize, col+diviedSize, diviedSize);
        partition(row+2*diviedSize, col+2*diviedSize, diviedSize);
    }

    //같은 수 인지 판단
    private static boolean checkSameColor(int row, int col, int size){
        int color = arr[row][col];

        for (int i = row; i<row+size; i++){
            for (int j=col; j<col+size; j++){
                if(arr[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}

