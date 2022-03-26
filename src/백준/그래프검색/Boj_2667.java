package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2667 {
    static int N;
    static int[] x = {-1,1,0,0}; //상하좌우
    static int[] y = {-0,0,-1,1}; //상하좌우
    static int [][] map;
    static boolean [][] visit;
    static List<Integer> list;
    static int count = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j]=input.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    count=1;
                    search(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }


    }

    public static void search(int start, int end) {
        visit[start][end]=true;

        for(int i=0; i<4; i++) {
            int cX = x[i]+start;
            int cY = y[i]+end;

            if(cX < N && cY < N && cX>=0 && cY>=0) {
                if(map[cX][cY]==1 && !visit[cX][cY]) {
                    search(cX,cY);
                    count++;
                }
            }

        }


    }
}
