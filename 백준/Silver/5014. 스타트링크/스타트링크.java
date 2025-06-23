import java.io.*;
import java.util.*;

public class Main {
    static int[] move = new int[2];
    static int[] stairs;
    static boolean[] isVisited;
    static int start, end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        stairs = new int[Integer.parseInt(st.nextToken())+1];
        isVisited = new boolean[stairs.length+1];
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = -Integer.parseInt(st.nextToken());

        if (start==end){
             System.out.print("0");
        } else {
            int answer = bfs(start, end);
            System.out.print(answer==0?"use the stairs":answer);
        }
    }

    private static int bfs(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        isVisited[start]=true;

        while (!q.isEmpty()){
            int[] info = q.poll();
            int now = info[0];
            int cnt = info[1];
            if (now==end){
                return cnt;
            }
            if (now>stairs.length-1 || now<1) continue;

            for (int i=0; i<2; i++){
                int next = now+move[i];
                if (next<1 || next>stairs.length-1) continue;
                if (isVisited[next]) continue;
                isVisited[next]=true;
                q.add(new int[]{next, cnt+1});
            }
        }
        return 0;
    }
}


