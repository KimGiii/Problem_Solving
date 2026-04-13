package coding_test.programmers.april.april10;

public class PRO_스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String tree : skill_trees) {
                StringBuilder sb = new StringBuilder();
                for (char c : tree.toCharArray()) {
                    if (skill.indexOf(c) != -1) {
                        sb.append(c);
                    }
                }

                if (skill.startsWith(sb.toString())) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
