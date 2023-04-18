class Solution {
        static boolean[] isVisietd;
    static int MIN = Integer.MAX_VALUE;
    static String end;
    public static int solution(String begin, String target, String[] words) {
        int answer = -1;
        isVisietd = new boolean[words.length];
        end = target;

        bfs(0,begin,words);

        if(MIN==Integer.MAX_VALUE){
            answer=0;
        }else{
            answer=MIN;
        }
        return answer;
    }

    public static void bfs(int cnt, String start,String[] words){
        if(start.equals(end)){
            MIN = Math.min(MIN,cnt);
            return;
        }
        if(cnt==words.length){
            return;
        }

        for (int i=0; i<words.length; i++){
            if(!isVisietd[i]){
                isVisietd[i]=true;
                if(isValid(start,words[i])){
                    bfs(cnt+1,words[i],words);
                }
                isVisietd[i]=false;
            }
        }//for
    }
    
    //글자중 같은 자리의 한글자가 같은지 여부
    public static boolean isValid(String s1, String s2){
       int result = 0;
        for (int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                ++result;
                if(result>1){
                    return false;
                }
            }
        }
        return true;
    }
}