package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
    static int x,y; //세로, 가로
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean [][] visited;
    static Queue<Point> list;
    static int[][] map;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        visited = new boolean[x][y];

        for (int i=0; i<x; i++){
            String input = br.readLine();
            for (int j=0; j<y; j++){
                map[i][j]= input.charAt(j)-'0';
            }
        }
        list = new LinkedList<>();


        BFS(0,0);
        System.out.println(map[x-1][y-1]);

    }

    public static void BFS(int a, int b){
        visited[a][b] = true;
        list.add(new Point(0,0));
        while(!list.isEmpty()){
            Point p = list.poll();

            int cX = p.px;
            int cY = p.py;

            for (int i=0; i<4; i++){
                int nX = cX+dx[i];
                int nY = cY+dy[i];

                if(nX>=0 && nX<x && nY>=0 && nY<y){
                    if(map[nX][nY]!=0 && !visited[nX][nY]){

                        map[nX][nY] = map[cX][cY]+1;
                        visited[nX][nY] = true;
                        list.add(new Point(nX,nY));
                    }

                }
            }
        }

    }
}

class Point{
    int px;
    int py;

    public Point(int a, int b){
        this.px = a;
        this.py = b;
    }
}


