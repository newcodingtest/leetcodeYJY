import java.util.*;


class Solution {
        private static List<String> cache = new ArrayList<>();
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0){
            return cities.length * 5;
        }

        for (String city : cities){
            String elem = city.toLowerCase();
            
            if (cache.contains(elem)){
                answer++;
                cache.remove(elem);
                cache.add(elem);
            } else {
                answer+=5;
                if (cache.size() == cacheSize){
                    cache.remove(0);
                }
                cache.add(elem);
            }
        }
        return answer;
    }
}