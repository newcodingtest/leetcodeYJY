import java.io.*;
import java.util.*;
import java.util.List;

class Main {
    static int[][] map;
    //동-남-서-북
    static int[] moveRow = {1,0,-1,0};
    static int[] moveCol = {0,1,0,-1};
    static Map<Integer, String> direct = new HashMap<>();
   static List<Point> snake = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<cnt; i++){
                 st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken())-1;
            int row = Integer.parseInt(st.nextToken())-1;
            //apple
            map[col][row] = 1;
        }

        int moveCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<moveCnt; i++){
                 st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            direct.put(time, direction);
        }
   solution();

    }

    static void solution(){
        int now_col = 0;
        int now_row = 0;
        int time = 0;
        int direction = 0;
        snake.add(new Point(0,0));

        while (true){
          time++;

            //동 남 서 북 순서대로 이동
            int next_col = now_col+moveCol[direction];
            int next_row = now_row+moveRow[direction];

            if (!isValid(next_col, next_row)){
                break;
            }

            //사과가 있을때
            if (map[next_col][next_row]==1){
                map[next_col][next_row]=0;

                snake.add(new Point(next_col,next_row));
            }
            //사과가 있을때
            else {
                snake.add(new Point(next_col,next_row));
                snake.remove(0);
            }

            //방향 변경
            if (direct.containsKey(time)){
                //오른쪽
                if (direct.get(time).equals("D")){
                    direction+=1;
                    if (direction==4){
                        direction=0;
                    }
                } 
                //왼쪽
                else {
                    direction-=1;
                    if (direction==-1){
                        direction=3;
                    }
                }
            }
                  
            now_col = next_col;
            now_row = next_row;
        }
        System.out.println(time);
    }

    static boolean isValid(int col, int row){
        if (col<0 || row<0 || col>=map.length || row>=map.length){
            return false;
        }

        for (int i=0; i<snake.size(); i++){
            Point p = snake.get(i);
            //자신의 몸과 부딫힌다면
            if (p.col == col && p.row == row){
                return false;
            }
        }
        return true;
    }

    static class Point {
        int col;
        int row;

        public Point(int col, int row){
            this.col = col;
            this.row = row;
        }
    }
}