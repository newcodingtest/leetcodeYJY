package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2798_블랙잭v1 {
    static int MAX = Integer.MIN_VALUE;
    static boolean[] isVisited;
    static int cardCnt;
    static int[] cardList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cardCnt = Integer.parseInt(st.nextToken());
        int limitSum = Integer.parseInt(st.nextToken());
        isVisited = new boolean[cardCnt];

        st = new StringTokenizer(br.readLine());
        cardList = new int[cardCnt];
        for (int i=0; i<cardCnt; i++){
            cardList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardList);

       bfs(0,0,0,limitSum);

        System.out.println("MAX = " + MAX);

    }

    public static void bfs(int start ,int sum,int cnt,int target){
        if (cnt==3) {
            MAX = Math.max(sum,MAX);
            return;
        }
            
        for (int i=start; i<cardCnt; i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                int temp = cardList[i]+sum;
                if(temp<=target){
                    bfs(start+1,temp,cnt+1,target);
                }
                isVisited[i]=false;
            }
        }

    }
}
