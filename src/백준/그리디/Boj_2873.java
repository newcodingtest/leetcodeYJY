package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2873 {
    static int [] height = {-1,1}; //위, 아래
    static int [] width = {-1,1}; //왼, 오
    static int [][] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        arr = new int[height][width];

        for (int i=0; i<height; i++){
            String input = br.readLine();
            for (int j=0; j<width; j++){
                arr[i][j]=input.charAt(j)-'0';
            }
        }
        
        if(height<=2 && width<=2){
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++){
                    //arr[i][j]
                }
            }
        }

    }
}
