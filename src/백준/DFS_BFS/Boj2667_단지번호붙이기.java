package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2667_단지번호붙이기 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int CNT = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++){
            String input = br.readLine();
            for (int j=0; j<N; j++){
                arr[i][j] = input.charAt(j)-48;
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(arr[i][j]!=0&&!visited[i][j]) {
                    int cnt = DFS(i, j);
                    list.add(cnt);
                }
                CNT = 0;

            }
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(x -> {
            System.out.println(x);
        });
    }

    public static int DFS(int row, int col){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row,col));

        while (!q.isEmpty()){
            Node n = q.poll();
            visited[n.x][n.y] = true;
            CNT++;
            for (int i=0; i<4; i++){
                int x = n.x+rows[i];
                int y = n.y+cols[i];

                if(x<N && y<N && 0<=x && 0<=y){
                    if(!visited[x][y] && arr[x][y]!=0) {
                        visited[x][y] = true;
                        q.add(new Node(x, y));
                    }
                }
            }
        }
        return CNT;

    }

    public static boolean isValid(int row, int col){
        for (int i=0; i<4; i++){
            int x = row+rows[i];
            int y = col+cols[i];

            if(x<N && y<N && 0<=x && 0<=y){
                return true;
            }
        }

        return false;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
