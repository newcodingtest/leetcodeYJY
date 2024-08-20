class Solution {
  public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<food.length; i++){
            for (int j=0; j<food[i]/2; j++){
                sb.append(i);
            }
        }
        String prefix = sb.toString();
        String suffix = sb.reverse().toString();
        return prefix+"0"+suffix;
    }
}