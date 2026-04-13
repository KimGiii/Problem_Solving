package coding_test.programmers.april.april13;

public class PRO_모음사전 {
    class Solution {
        public int solution(String word) {
            String s = "AEIOU";
            int[] weights = {781, 156, 31, 6, 1};
            int answer = 0;

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (word.charAt(i) == s.charAt(j)) {
                        answer += weights[i] * j + 1;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
