package 분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2448 {
    static char[][] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] map = new String[n];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int i=1; 3*(int)Math.pow(2,i)<=n; i++){
            makeBigStar(i,map);
        }

        for (int i=0; i<n; i++){
            System.out.println(map[i]);
        }
    }

    private static void makeBigStar(int k, String[] map){
        int bottom = 3*(int)Math.pow(2,k);
        int middle = bottom/2;

        for (int i = middle; i<bottom; i++){
            map[i]=map[i-middle]+" "+map[i-middle];
        }

        String space ="";
        while(space.length()<middle){
            space+=" ";
        }

        for (int i=0; i<middle; i++){
            map[i]=space+map[i]+space;
        }


    }
}
