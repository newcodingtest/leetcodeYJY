package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9079_동전게임{
    static List<int[][]> coins = new ArrayList<>();
    static int N;
    static int min;
    public static void main(String[] args)throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        while(N-->0){
            min = Integer.MAX_VALUE;
            int[][] temp = new int[3][3];
            //INPUT
            for (int x=0; x<3; x++){
                st = new StringTokenizer(br.readLine());
                for (int y=0; y<3; y++){
                    String str = st.nextToken();
                    temp[x][y] = str.equals("H")?1:0;
                }
            }

            //BFS
            search(temp, 0, 0);
            if(min==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min);
            }
        }

    }

    public static void search(int[][] map,int cnt,int idx){
        if(valid(map)){
            min = Math.min(min, cnt);
            return;
        }
        if (idx == 8) {
            return;
        }
        search(map,0,idx+1);

        if (idx<3){
            for (int i=0; i<3; i++){
                map[idx][i] = (map[idx][i]==1?0:1);
            }
            search(map,cnt+1,idx+1);
            for (int i=0; i<3; i++){
                map[idx][i] = (map[idx][i]==1?0:1);
            }
        }else if(idx<6){
            for (int i=0; i<3; i++){
                map[i][idx-3] = (map[i][idx-3]==1?0:1);
            }
            search(map,cnt+1,idx+1);
            for (int i=0; i<3; i++){
                map[i][idx-3] = (map[i][idx-3]==1?0:1);
            }
        }else if(idx==6){
            for (int i=0; i<3; i++){
                map[i][i] = (map[i][i]==1?0:1);
            }
            search(map,cnt+1,idx+1);
            for (int i=0; i<3; i++){
                map[i][i] = (map[i][i]==1?0:1);
            }
        }else if(idx==7){
            for (int i=0; i<3; i++){
                map[i][2-i] = (map[i][2-i]==1?0:1);
            }
            search(map,cnt+1,idx+1);
            for (int i=0; i<3; i++){
                map[i][2-i] = (map[i][2-i]==1?0:1);
            }
        }


    }

    public static boolean valid(int[][] map){
        int compared = map[0][0];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(map[i][j]!=compared){
                    return false;
                }
            }
        }
        return true;
    }


}


