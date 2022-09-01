package 프로그래머스.level2;
import java.util.LinkedHashMap;
import java.util.Map;

public class 캐시 {
    public static int solution(int cacheSize, String[] cities) {
        Cache<String,Integer>cache = new Cache<>(cacheSize);
        int exeuteTime = 0 ;
        for(String cacheKey : cities) {
            String key = cacheKey.toLowerCase();
            //캐시검사
            if(cache.containsKey(key)) {
                exeuteTime+=1;
            }else {
                exeuteTime+=5;
            }
            cache.put(key, 0);
        }
        System.out.println(cache.keySet());
        return exeuteTime;
    }

    static class Cache<String, Integer> extends LinkedHashMap<String, Integer>{
        int capacity = 0;

        public Cache(int capacity) {
            super(capacity, 0.75f, true);//순서모드로 사용
            this.capacity = capacity;
        }

        //가장 오랫동안 안쓴데이터 제거
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            //최대 수용량을 넘는경우 가장 오래된 요소를 삭제
            return size()>capacity;
        }

    }
}
