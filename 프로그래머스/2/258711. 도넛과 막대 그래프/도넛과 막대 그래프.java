import java.util.Arrays;
class Solution {
    static int 도넛Cnt = 0;
    static int 막대Cnt = 0;
    static int 팔자Cnt = 0;
    static int otherCnt = 0;
    static int 정점 = 0;
    static int[] in = new int[1_000_000];
    static int[] out = new int[1_000_000];
    static int maxValue = 0;
    public static int[] solution(int[][] edges){
        for (int i=0; i<edges.length; i++){
            out[edges[i][0]]++;
            in[edges[i][1]]++;

            maxValue = Math.max(maxValue, Math.max(edges[i][0],edges[i][1]));
        }

        for (int i=1; i<=maxValue; i++){
            if (in[i]==0 && out[i]>1){
                정점 = i;
                break;
            }
        }

        otherCnt = out[정점];

        for (int i=1; i<=maxValue; i++){
            //막대
            if (in[i]>0 && out[i]==0){
                막대Cnt++;
            }
            //8자
            if (in[i]>=2 && out[i]>=2){
                팔자Cnt++;
            }
        }

        도넛Cnt = otherCnt-막대Cnt-팔자Cnt;

        int[] answer = {정점, 도넛Cnt, 막대Cnt, 팔자Cnt};
        return answer;
    }
}   