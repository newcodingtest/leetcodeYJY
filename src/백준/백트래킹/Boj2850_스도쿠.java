package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2850_스도쿠 {
    static boolean isEnd;
    static int size = 9;
    static int[][] arr = new int[size][size];
    static List<int[]> zeroPoint = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        for (int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<size; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]==0){
                        zeroPoint.add(new int[]{i,j});
                    }
            }
        }

        backTracking(0,0);

    }

    private static void backTracking(int zeroLocation, int idx)throws Exception {
        if(isEnd){
            return;
        }
        if(idx==zeroPoint.size()){
            isEnd=true;
            print();
            return;
        }

        int x = zeroPoint.get(zeroLocation)[0];
        int y = zeroPoint.get(zeroLocation)[1];

        //0 0 좌표 순회회
        for(int i=1; i<=size; i++){
            if(isPossibility(x,y,i)){
                arr[x][y]=i;
                backTracking(zeroLocation+1,idx+1);
                //백트래킹 초기화
                arr[x][y]=0;
            }
        }
    }
    //검사
    private static boolean isPossibility(int x, int y, int element) {
        //1. 가로 2. 세로 검사
        for(int i=0; i<size; i++){
            if(arr[x][i]==element){
                return false;
            }
            if(arr[i][y]==element){
                return false;
            }
        }
        //3x3 검사
        int tempX = x/3*3;
        int tempY = y/3*3;
        for(int i=tempX; i<tempX+3; i++){
            for(int j=tempY; j<tempY+3; j++){
                if(arr[i][j]==element){
                    return false;
                }
            }
        }
        return true;
    }

    //최종 만들어진 배열 출력
    public static void print()throws Exception{
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
