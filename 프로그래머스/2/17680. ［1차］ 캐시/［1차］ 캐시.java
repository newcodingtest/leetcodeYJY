import java.util.*;


class Solution {
    private static Map<String, Integer> cache;
   public static int solution(int cacheSize, String[] cities) {
        cache = new LinkedHashMap<>(cacheSize, 0.75f, true){
          @Override
          protected boolean removeEldestEntry(Map.Entry eldest) {
              return size() > cacheSize;
          }
        };

        int answer = 0;
        for (String city : cities){
            String elem = city.toLowerCase();
            if (cache.containsKey(elem)){
                answer+=1;
            } else {
                answer+=5;
            }
            cache.put(elem, 0);
        }

        return answer;
    }
}