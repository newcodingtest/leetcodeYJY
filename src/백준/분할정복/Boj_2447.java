package 백준.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2447 {

    static char[][] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(arr[i],' ');
        }
        star(0,0,n);
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }

    }

    public static void star(int start, int end, int size){

        if(size==1){
            arr[start][end]='*';
            return;
        }

        int div = size/3;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(i==1 && j==1){
                    continue;
                }else{
                    star(start+(div*i), end+(div*j),div);
                }
            }
        }
    }
}
