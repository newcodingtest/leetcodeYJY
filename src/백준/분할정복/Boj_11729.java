package 백준.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        hanoi(n,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);

    }

    public static void hanoi(int size, int start, int mid, int end){
        cnt++;
        if(size==1){
            sb.append(start+" ").append(end+"\n");
            return;
        }

        //A->B
        hanoi(size-1, start,end,mid);
        sb.append(start+" ").append(end+"\n");
        //B->C
        hanoi(size-1, mid,start,end);

    }
}
