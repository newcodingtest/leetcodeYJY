package 백준.DFS_BFS;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj16234_인구이동 {
    static int[][] populate;
    static boolean[][] visited;
    static int N,L,R;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int move = 0;
    static ArrayList<Node> list;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //이상
        R = Integer.parseInt(st.nextToken()); //이하

        populate = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                populate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    public static int move(){
        int result = 0;
        while(true){
            boolean isMove = false;  
            visited = new boolean[N][N];
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(!visited[i][j]){
                        int sum = bfs(i,j);
                        if(list.size()>1){
                            updatePopulation(sum);
                            isMove=true;
                        }
                    }
                }
            }
            if (!isMove)return result;
            result++;
        }
    }

    public static int bfs(int x, int y){
       Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Node(x,y));
        list.add(new Node(x,y));
        visited[x][y]=true;

        int sum = populate[x][y];
        while (!q.isEmpty()){
            Node current = q.poll();

            for (int i=0; i<4; i++){
                int nx = current.row + rows[i];
                int ny = current.col + cols[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]){
                    int diff = Math.abs(populate[current.row][current.col]-populate[nx][ny]);
                    if(L<=diff && diff<=R){
                        q.offer(new Node(nx,ny));
                        list.add(new Node(nx,ny));
                        sum += populate[nx][ny];
                        visited[nx][ny]=true;
                    }
                }
            }
        }

        return sum;

    }

    public static void updatePopulation(int sum){
        int avg = sum / list.size();
        for(Node n : list){
            populate[n.row][n.col] = avg;
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
