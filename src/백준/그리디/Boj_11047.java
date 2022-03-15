package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];

        for(int i =0; i<cnt; i++){   
            arr[i] = Integer.parseInt(br.readLine());
        }

        int coin = 0;

            for(int i =cnt-1; i>=0; i--){
                if(cost>=arr[i]){
                    coin += cost / arr[i];
                    cost = cost % arr[i];
                }
            }

        System.out.println(coin);
    }
}
