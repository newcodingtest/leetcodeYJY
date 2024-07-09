import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        String target = br.readLine();

        int answer = 0;
        for (int i=0; i<cnt-1; i++){
            String compare = br.readLine();
            if (solution(target, compare)){
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static boolean solution(String target, String compare){

        int[] ascii = new int[26];

        //두 단어가 같은 구성을 갖는 경우, 또는 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우에 이들 두 단어를 서로 비슷한 단어라고 한다.
        int answer = 0;
        for (int i=0; i<target.length(); i++){
            ascii[target.charAt(i)-'A']++;
        }

        for (int i=0; i<compare.length(); i++){
            if (ascii[compare.charAt(i)-'A']>0){
                answer++;
                ascii[compare.charAt(i)-'A']--;
            }
        }
        //길이가 같을때, 카운팅이 같거나 -1
        if (target.length()==compare.length() && (target.length()==answer || target.length()-1==answer)){
            return true;
        }

        //길이가 +1 길때, 카운팅이 같을때
        if (target.length()+1==compare.length() && target.length()==answer ){
            return true;
        }

        //길이가 -1일때 카운팅이 -1
        if (target.length()-1==compare.length() && target.length()-1==answer){
            return true;
        }
        return false;
    }
}