import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] BLOCKS = {
            {{0},{0,0,0,0}},
            {{0,0}},
            {{0,0,1},{1,0}},
            {{1,0,0},{0,1}},
            {{0,0,0},{0,1},{1,0,1},{1,0}},
            {{0,0,0},{2,0},{0,0},{0,1,1}},
            {{0,0,0},{0,2},{1,1,0},{0,0}}
    };
    //왼쪽 아래가 최초 기준점
    //1: 직사각형
    static int[][] I_BLOCKS = {{0},{0,0,0,0}};
    //2: 정사각형
    static int[][] O_BLOCKS = {{0,0}};
    //3: z 반대도형
    static int[][] S_BLOCKS = {{0,0,1},{1,0}};
    //4: z 도형
    static int[][] Z_BLOCKS = {{1,0,0},{0,1}};
    //5: T 도형
    static int[][] T_BLOCKS = {{0,0,0},{0,1},{1,0,1},{1,0}};
    //6: ㄴ 반대도형
    static int[][] J_BLOCKS = {{0,0,0},{2,0},{0,0},{0,1,1}};
    //7: ㄴ 도형
    static int[][] L_BLOCKS = {{0,0,0},{0,2},{1,1,0},{0,0}};

    static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int type = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());

        height = new int[N];
        for (int i=0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i=0; i<BLOCKS[type].length; i++){
            for (int j=0; j<N-BLOCKS[type][i].length+1; j++){
                int diff = height[j] - BLOCKS[type][i][0];
                boolean isSuccess = true;
                
                for (int k=1; k<BLOCKS[type][i].length; k++){
                    if (diff != height[j+k]-BLOCKS[type][i][k]){
                        isSuccess = false;
                        break;
                    }
                }
                if (isSuccess){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}