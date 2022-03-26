package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_4963 {
    static int n,m;
    static int[] y = {-1,1,-1,1,0,-1,0,1};
    static int[] x = {-1,1,1,-1,-1,0,1,0};
    static int[][] map;
    static boolean[][] visit;
    static List<Integer> list;
    static int count = 0;
    static String[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());//너비
            m=Integer.parseInt(st.nextToken());//높이
            if(n==0 && m==0) {
                break;
            }

            map = new int[m][n];
            visit = new boolean[m][n];
            list = new ArrayList<>();

            for(int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for(int i = 0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    if(map[i][j]==1 && !visit[i][j]) {
                        search(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

    }

    public static void search(int start, int end) {
        visit[start][end]=true;

        for(int i = 0; i<8; i++) {
            int cX = x[i]+start;
            int cY = y[i]+end;

            if (0 <= cX && cX < m && 0 <= cY && cY < n) {
                if (map[cX][cY] == 1 && visit[cX][cY]==false) {
                    search(cX, cY);
                }
            }

        }

    }

}
