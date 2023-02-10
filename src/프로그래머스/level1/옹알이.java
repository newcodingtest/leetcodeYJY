package 프로그래머스.level1;

import java.util.HashSet;

public class 옹알이 {
    static String[] test = {"aya", "ye", "woo", "ma"};
    static HashSet<String> set = new HashSet<>();
    static boolean[] visited = new boolean[test.length];
    public int solution(String[] babbling) {
        String[] temp= new String[test.length];
        StringBuilder sb = new StringBuilder();
        //조합
        //각 단어들은 1번씩만 등장한다.
        for (int i = 0; i < test.length; i++) {
            combi(test, sb, temp,visited, 0, test.length, i+1);
        }
        int answer = 0;
        for (int i=0; i<babbling.length; i++){
            if(set.contains(babbling[i])){
                answer++;
            }
        }
        return answer;
    }

    public static void combi (String[]str, StringBuilder sb, String[]out,boolean[] visited, int depth, int n, int cnt){
        if (depth == cnt) {
            //등록
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = str[i];
                sb.append(str[i]);
                combi(str, sb, out, visited, depth + 1, n, cnt);
                visited[i] = false;
                sb.delete(sb.length()-str[i].length(),sb.length());
            }
        }
    }
}
