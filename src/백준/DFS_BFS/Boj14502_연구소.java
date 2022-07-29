package 백준.DFS_BFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502_연구소 {
    static int[][] arr;
    static int[] rows = {-1,1,0,0}; //상하왼오
    static int[] cols = {0,0,-1,1}; //상하왼오
    static int N,M;
    static boolean[][] visited;
    static boolean[][] virusVisited;
    static int MAX = Integer.MIN_VALUE;
    private static Object Node;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        virusVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        installWall(0);

        System.out.println(MAX);
    }

    //백트래킹 벽 쌓기
    public static void installWall(int wallCnt) {
        if(wallCnt==3) {
            spreadVirus();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=1;
                    installWall(wallCnt+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    //백트래킹에 의해 만들어지는 배열arr을 받아서 bfs로 바이러스 생성후
    //countSaveArea 메서드 호출로 지속적은 MAX값 반영
    public static void spreadVirus() {
        Queue<Node> q = new LinkedList<Node>();
        //깊은 복사
        int[][] temp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j]=arr[i][j];
                if(arr[i][j]==2) {
                    q.add(new Node(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.remove();

            for(int i=0; i<4; i++) {
                int nx = node.x+rows[i];
                int ny = node.y+cols[i];
                if(isValid(nx, ny)) {
                    if(temp[nx][ny]==0) {
                        temp[nx][ny]=2;
                        q.add(new Node(nx, ny));
                    }
                }
            }

        }

        countSaveArea(temp);
    }

    public static void countSaveArea(int[][] virusMap) {
        int tempCnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virusMap[i][j]==0) {
                    tempCnt++;
                }
            }
        }
        MAX = Math.max(MAX, tempCnt);
    }

    public static boolean isValid(int nx, int ny) {
        if(nx>=0 && ny>=0 && nx<N && ny<M) {
            return true;
        }
        return false;
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
