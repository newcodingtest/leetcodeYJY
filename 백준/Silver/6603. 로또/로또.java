import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static int[] result;
    static boolean[] isVisited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N==0){
                break;
            }
            map = new int[N];
            result = new int[6];
            isVisited = new boolean[N];

            for (int i=0; i<N; i++){
                map[i]=Integer.parseInt(st.nextToken());
            }

            bfs(0,0);
            System.out.println();
        }
    }

    private static void bfs(int start, int depth){
        if (depth==6){
            for (int elem : result){
                System.out.print(elem+" ");
            }
            System.out.println();
            return;
        }

        for (int i=start; i<map.length; i++){
            result[depth] = map[i];
            bfs(i+1, depth+1);
        }
    }

}




