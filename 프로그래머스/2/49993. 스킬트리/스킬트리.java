class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            String result = "";

            for (int j = 0; j < str.length(); j++) {
                String s = String.valueOf(str.charAt(j));
                if (skill.contains(s)){
                    result+=s;
                }
            }
            if (skill.startsWith(result)){
                answer++;
            }
        }
        return answer;
    }
}