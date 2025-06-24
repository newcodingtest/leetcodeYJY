import java.io.*;
import java.util.*;

public class Main {
    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited = new boolean[25];
    static char[][] map;
    static int[] seven = new int[7];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for (int i=0; i<5; i++){
            String str = br.readLine();
            for (int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }


        comb(0,0,0);

        System.out.print(answer);
    }

    private static void comb(int idx, int count, int s){
        if (count==7){
            if(s>=4){
                if (isLinked()){
                    answer++;
                }
            }
            return;
        }

        for (int i=idx; i<25; i++){
            isVisited[i]=true;

            seven[count]=i;

            char elem = map[i/5][i%5];
            if (elem=='S'){
                comb(i+1, count+1, s+1);
            } else {
                comb(i+1, count+1, s);
            }

            isVisited[i]=false;
        }


    }

    private static boolean isLinked() {
        Queue<Integer>q = new ArrayDeque<>();
        q.add(seven[0]);
        boolean[] check = new boolean[25];
        check[seven[0]] = true;

        int cnt = 1;
        while (!q.isEmpty()){
            int location = q.poll();

            for (int i=0; i<4; i++){
                int col = (location/5)+moveCol[i];
                int row = (location%5)+moveRow[i];

                if (col<0 || row<0 || col>=5 || row>=5) continue;
                int newLocation = 5*col+row;
                if (!isVisited[newLocation] || check[newLocation]) continue;
                check[newLocation]=true;
                q.add(newLocation);
                cnt++;
            }
        }

        return cnt==7;
    }
}