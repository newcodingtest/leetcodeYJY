package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj7576_토마토 {
    static int[][] tomato;
    static boolean[][] visited;
    static int row, col;
    static int cnt = 0;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static Queue<Node> list = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        tomato = new int[row][col];

        for (int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<col; j++){
                tomato[i][j] =Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1){
                    list.add(new Node(i,j));
                }
            }
        }


        System.out.println(DFS());

    }

    public static int DFS(){
        while (!list.isEmpty()){
            Node n = list.poll();
            isValid(n.row,n.col);
        }

        int max = Integer.MIN_VALUE;

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(tomato[i][j]==0){
                    return -1;
                }
                max = Math.max(max, tomato[i][j]);
            }
        }
        
        return max-1;
    }

    public static void isValid(int x, int y){
        for (int i=0; i<4; i++){
            int tempX = rows[i]+x;
            int tempY = cols[i]+y;

            if(tempX>=0 && tempY>=0 && tempX<row && tempY<col){
                if(tomato[tempX][tempY]==0){
                    list.add(new Node(tempX, tempY));
                    tomato[tempX][tempY] = tomato[x][y]+1;
                }
            }
        }
    }

    static class Node{
        private int row;
        private int col;

        public Node(int x, int y){
            row = x;
            col = y;
        }
    }
}
