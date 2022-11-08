package 프로그래머스.level2;

public class 모음사전 {
    static String[] words = {"A","E","I","O","U"};
    static int cnt = 0;
    static boolean isEqual = false;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

    solution("AAAAE");

        System.out.println(cnt);
    }

    public static int solution(String word) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        bfs(word,sb);
        return cnt;
    }

    public static void bfs(String word, StringBuilder sb){
        if (word.equals(sb.toString())){
            isEqual = true;
            return;
        }
        if(sb.length()==5){
            return;
        }

        for (int i=0; i<words.length; i++){
            sb.append(words[i]);
            cnt++;
            bfs(word,sb);
            if(isEqual) return;
            sb.delete(sb.length()-1,sb.length());
        }

    }
}
