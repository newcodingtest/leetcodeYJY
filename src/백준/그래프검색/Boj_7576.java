package 백준.그래프검색;


class Tomato{
    int w;
    int h;
    public Tomato(int h, int w) {
        this.w = w;
        this.h = h;
    }
}

public class Boj_7576{
    static int w; //가로
    static int h; //세로
    static int cnt;
    //상하좌우
    static int[] dh = {-1,1,0,0};// 세로
    static int[] dw = {0,0,-1,1};// 가로

    static int[][] map;
    static Queue<Tomato>queue;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        queue= new LinkedList<Tomato>();


        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            Tomato t = queue.remove();
            int tw =  t.w; //가로
            int th =  t.h; //세로

            for (int i = 0; i < 4; i++) {
                int nw = tw+dw[i];
                int nh = th+dh[i];

                if(nw>=0 && nh>=0 && nw<w && nh<h) {
                    if(map[nh][nw]==0) {
                        queue.add(new Tomato(nh, nw));
                        map[nh][nw]=map[th][tw]+1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(map[i][j]==0) {
                    return -1;
                }

                result = Math.max(result, map[i][j]);
            }
        }

        if(result==1) {
            return 0;
        }
        else
            return result-1;
    }

}