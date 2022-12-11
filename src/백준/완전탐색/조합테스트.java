package 백준.완전탐색;

public class 조합테스트 {
    public static void main(String[] args){

        //misstion: 2글자씩 중복을 제외한 조합 만들기
        String target = "12345";

        int n = target.length();
        boolean[] visited  = new boolean[n];
        for (int i=0; i<n; i++){
            reculsive(target,2,i,n,visited);
        }

        System.out.println();
        backTracking(target,2,0,n,visited);
    }


    public static void reculsive(String 타겟,int 뽑는개수,int 현재단계, int 총길이, boolean[] 방문){
        if(뽑는개수==0){
            print(타겟,방문,총길이);
            return;
        }
        if(총길이 == 현재단계){
            return;
        }

        방문[현재단계]=true;
        reculsive(타겟,뽑는개수-1,현재단계+1,총길이,방문);
        방문[현재단계]=false;
        reculsive(타겟,뽑는개수,현재단계+1,총길이,방문);
    }

    public static void backTracking(String 타겟,int 뽑는개수,int 시작점, int 총길이, boolean[] 방문){
        if(뽑는개수==0){
            print(타겟,방문,총길이);
            return;
        }

        for (int i=시작점; i<총길이; i++){
            방문[i]=true;
            backTracking(타겟,뽑는개수-1,i+1,총길이,방문);
            방문[i]=false;
        }
    }

    public static void print(String str, boolean[] 방문, int 총길이){
        for (int i=0; i<총길이; i++){
            //방문 했으면 조합 출력
            if (방문[i]){
                System.out.print(str.charAt(i)+",");
            }
        }
        System.out.println();
    }
}
