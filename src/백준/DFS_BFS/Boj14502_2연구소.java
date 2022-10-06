package 백준.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502_2연구소 {
    static int N, M;
    static int[][] lab;
    static int[][] temp;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;
    static int[] rows = {-1, 1, 0, 0};
    static int[] cols = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(input[j]);
            }
        }

//        for (int i=0; i<N; i++){
//            for (int j=0; j<M; j++){
//                System.out.print(lab[i][j]);
//            }
//            System.out.println();
//        }

        DFS(0);
        System.out.println(MAX);

    }

    public static void DFS(int len) {
        if (len == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    DFS(len + 1);
                    lab[i][j] = 0;
                }
            }
        }


    }

    private static void spreadVirus() {
        Queue<Node> q = new LinkedList<>();
        //깊은 복사
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = lab[i][j];
                if (lab[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + rows[i];
                int ny = n.y + cols[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    //감염
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        countSaveArea(temp);
    }

    private static void countSaveArea(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    ++cnt;
                }
            }
        }

        MAX = Math.max(MAX, cnt);
    }

    static class Node{
        int x;
        int y;

        public Node(int row, int col) {
            this.x = row;
            this.y = col;
        }
    }
}
