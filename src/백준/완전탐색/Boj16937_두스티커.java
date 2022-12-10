package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj16937_두스티커 {
    static int H;
    static int W;
    static int N;
    static int[][] sticker;
    static int MAX = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        sticker = new int[N][3];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sticker[i][0] = Integer.parseInt(st.nextToken());
            sticker[i][1] = Integer.parseInt(st.nextToken());
            sticker[i][2] = sticker[i][0]*sticker[i][1];
        }


        for (int i=0; i<N-1; i++){
            for (int j=i+1; j<N; j++){
                if(i!=j){
                    if (isValid(sticker[i],sticker[j])){
                        MAX = Math.max(MAX,sticker[i][2]+sticker[j][2]);
                    }
                }
            }
        }

        System.out.println(MAX);
    }

    public static boolean isValid(int[] a, int[] b){
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                if(a[i]+b[j]<=H && Math.max(a[(i+1)%2],b[(j+1)%2])<=W){
                    return true;
                }
                if(a[i]+b[j]<=W && Math.max(a[(i+1)%2],b[(j+1)%2])<=H){
                    return true;
                }
            }
        }

        return false;
    }
}
