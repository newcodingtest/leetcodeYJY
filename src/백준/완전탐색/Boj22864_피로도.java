package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22864_피로도 {
    static int A,B,C,D;
    static int HOURS = 24;
    static int fatigue,workTime = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        if(D<A){
            System.out.println(0);
        }else {
            bruteSearch();
        }
    }

    public static void bruteSearch(){
        while(HOURS>0){
            //피로도 검사
            if(healthCheck(fatigue+A)){
                doWork();
            }else{
                doRest();
            }
            HOURS--;
        }

        System.out.println(workTime);
    }
    
    public static boolean healthCheck(int fatigue){
        return fatigue<=D?true:false;
    }

    public static void doWork(){
        workTime+=B;
        fatigue+=A;

    }

    public static void doRest(){
        fatigue-=C;
        if(fatigue<0){
            fatigue=0;
        }
    }
}
