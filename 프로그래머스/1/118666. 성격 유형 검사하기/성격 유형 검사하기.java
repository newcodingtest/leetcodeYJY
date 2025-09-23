import java.util.*;
import java.io.IOException;

class Solution {
    static Map<Integer, String[]> score = new LinkedHashMap<>();
    static Map<String, Integer> counting = new HashMap<>();
    
      public static void setUp(){
        score.put(0,new String[]{"R","T"});
        score.put(1,new String[]{"C","F"});
        score.put(2,new String[]{"J","M"});
        score.put(3,new String[]{"A","N"});

        counting.put("R", 0);
        counting.put("T", 0);
        counting.put("C", 0);
        counting.put("F", 0);
        counting.put("J", 0);
        counting.put("M", 0);
        counting.put("A", 0);
        counting.put("N", 0);
    }
    
    public static int score(int num, boolean isAgree){
        if (isAgree){
            return switch (num) {
                case 1, 7 -> 3;
                case 2, 6 -> 2;
                case 3, 5 -> 1;
                default -> 0;
            };
        } else {
            return switch (num) {
                case 1, 7 -> -3;
                case 2, 6 -> -2;
                case 3, 5 -> -1;
                default -> 0;
            };
        }
    }
    
    
    public static String solution(String[] survey, int[] choices) {
        setUp();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<survey.length; i++){
            String[] cur = survey[i].split("");
            String x1 = cur[0];
            String x2 = cur[1];

            boolean isAgree = false;
            if (choices[i]<4){
                isAgree=true;
            } else if (choices[i]>4){
                isAgree=false;
            }
            counting.put(x1, counting.get(x1)+score(choices[i], isAgree));
            counting.put(x2, counting.get(x2)+score(choices[i], !isAgree));
        }

        for (int i=0; i<score.size(); i++){
            String[] cur = score.get(i);
            String x1 = cur[0];
            String x2 = cur[1];

            String alpabet = counting.get(x1)>=counting.get(x2)?x1:x2;

            sb.append(alpabet);
        }

        return sb.toString();
    }
}