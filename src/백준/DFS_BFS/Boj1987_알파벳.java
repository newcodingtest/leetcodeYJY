package 백준.DFS_BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1987_알파벳 {
    static char[][] alpabets;
    static boolean[] visited;
    static int[] rows= {-1,1,0,0}; //위아래왼오
    static int[] cols= {0,0,-1,1}; //위아래왼오
    static int N, M;
    static int MAX = Integer.MIN_VALUE;
    static Queue<Node>q = new LinkedList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        alpabets = new char[N][M];

        visited = new boolean[26];


        for(int i=0; i<N; i++) {
            String[] charArr = br.readLine().split("");
            for(int j=0; j<charArr.length; j++) {
                char temp=charArr[j].charAt(0);
                alpabets[i][j]=temp;
            }
        }
        search(0,0,1);
        System.out.println(MAX);
    }
    static class Node{
        int x;
        int y;
        public Node(int row, int col) {
            x = row;
            y = col;
        }
    }
    public static void search(int i, int j, int cnt) {
        if(visited[alpabets[i][j]-65]) {
            return;
        }

        MAX = Math.max(MAX, cnt);
        q.add(new Node(i, j));

        Node n = q.remove();
        char value = alpabets[n.x][n.y];

        int temp = ((int)value)-65;
        //방문검사
        if(!visited[temp]) {

            visited[temp]=true;

            for(int k=0; k<4; k++) {
                int nx = n.x + rows[k];
                int ny = n.y + cols[k];
                if(isValid(nx, ny)) {
                    search(nx, ny,cnt+1);
                }
            }
            visited[temp]=false;
        }
    }

    public static boolean isValid(int row, int col) {
        if(row>=0 && col>=0 && row<=N-1 && col<=M-1) {
            return true;
        }
        return false;
    }
}
