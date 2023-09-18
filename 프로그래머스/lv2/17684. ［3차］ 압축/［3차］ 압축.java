import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
      static Map<String,Integer> directory = new HashMap<>();
    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        init();

        int cnt = 27;
        for (int i=0; i<msg.length(); i++){
            int idx = i+1;
            String str = String.valueOf(msg.charAt(i));
            while (idx<msg.length()){
                if (!directory.containsKey(str+msg.charAt(idx))){
                    directory.put(str+msg.charAt(idx),cnt++);
                    break;
                }else{
                   str+=msg.charAt(idx);
                   idx++;
                   i++;
                }
            }
            answer.add(directory.get(str));
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
    public static boolean isValid(String msg){
        if (!directory.containsKey(msg)){
            return false;
        }
        return true;
    }

    public static void init(){
        for (int i=0; i<26; i++){
            directory.put(String.valueOf((char)(65+i)),i+1);
        }
    }
}