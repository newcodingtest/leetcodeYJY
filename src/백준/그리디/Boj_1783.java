package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://lotuslee.tistory.com/73 참고
public class Boj_1783 {
    static int [][] arr;
    static boolean [][] visited;
    static int height,width;
    static int[] moveWidth = {1,2,2,1};
    static int[] moveHeight = {-2,-1,1,2};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        arr = new int[height][width];
        visited = new boolean[height][width];
        search();
        System.out.println(cnt);

    }

    public static void search(){
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++){
                check(i,j);
            }
        }
    }

    public static boolean check(int mHeight, int mWidth){
        for (int i=0; i<moveHeight.length; i++){
            if(mWidth+moveWidth[i]<width && mHeight+moveHeight[i]<height && !visited[mWidth][mHeight] ){
                visited[mWidth+moveWidth[i]][mHeight+moveHeight[i]]=true;
                cnt++;
                return true;
            }
        }
        return false;
    }
}
