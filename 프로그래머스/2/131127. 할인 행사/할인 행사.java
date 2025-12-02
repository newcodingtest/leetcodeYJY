import java.util.HashMap;
import java.util.Map;

class Solution {
        static Map<String, Integer> wantMap = new HashMap<>();
    static Map<Integer, Info> discountByDay = new HashMap<>();
    public static int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length-10; i++) {
            Info info = new Info();
            for (int j = i; j <i+10; j++) {
        info.map.put(discount[j], info.map.getOrDefault(discount[j],0)+1);
            }
            discountByDay.put(i+1, info);
        }
        int answer = 0;
        for (int i = 0; i <= discount.length-10; i++) {
            if (isAllDiscount(i+1)){
                answer++;
            }
        }
        return answer;
    }
    
        static class Info {
        private Map<String, Integer> map;

        public Info(){
            this.map = new HashMap<>();
        }
    }

    public static boolean isAllDiscount(int days){
        for (String key : wantMap.keySet()){
            int wantValue = wantMap.get(key);
            if (discountByDay.get(days).map.containsKey(key)){
                int discountValue = discountByDay.get(days).map.get(key);
                if (wantValue>discountValue){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}