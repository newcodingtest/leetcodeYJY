package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj15649_N과M {
    static int[] arr;
    static boolean[] visited;
    static int deep;
    static int range;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        range = Integer.parseInt(st.nextToken());
        deep = Integer.parseInt(st.nextToken());

        arr = new int[range];
        visited = new boolean[range];
        
        for(int i=0; i<range; i++){
            arr[i]=i+1;
        }

        backTracking(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void backTracking(int value) {
        if(deep == value){
            for (int i=0; i<deep; i++) {
              sb.append(arr[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<range; i++){
            // 방문을 안했으면
            if(!visited[i]){
                //방문 표시
                visited[i]=true;
                arr[value]=i+1;
                backTracking(value+1);
                //방문 초기화
                visited[i]=false;
            }
        }
    }
}
