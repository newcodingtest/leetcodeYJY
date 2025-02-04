import java.util.HashMap;
import java.util.Map;

class Solution {
        static final double TARGET = 65536;
      public static int solution(String str1, String str2) {
        double answer = 0;
        double intersection = 0;
        double union = 0;

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        String[] arr1 = str1.toLowerCase().split("");
        for (int i=0; i<=arr1.length-2; i++){
            String key = arr1[i]+arr1[i+1];
            if (!containsNonAlphabet(key)){
                map1.put(key, map1.getOrDefault(key,0)+1);
                union++;
            }
        }

        String[] arr2 = str2.toLowerCase().split("");
        for (int i=0; i<=arr2.length-2; i++){
            String key = arr2[i]+arr2[i+1];
            if (!containsNonAlphabet(key)){
                map2.put(key, map2.getOrDefault(key,0)+1);
                union++;
            }
        }

        if (union==0){
            return (int)TARGET;
        }
        for (String key : map1.keySet()){
            if (map2.containsKey(key)){
                int cnt = Math.min(map1.get(key),map2.get(key));
                intersection+=cnt;
                union-=cnt;
            }
        }
        answer = (intersection/union)*TARGET;
        return (int)answer;
    }

    public static boolean containsNonAlphabet(String str){
        return !str.matches("[a-zA-Z]+");
    }
}