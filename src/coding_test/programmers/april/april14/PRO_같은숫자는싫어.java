package coding_test.programmers.april.april14;

import java.util.ArrayDeque;

public class PRO_같은숫자는싫어 {
    class Solution {
        public ArrayDeque<Integer> solution(int []arr) {
            ArrayDeque<Integer> answer = new ArrayDeque<>();

            answer.add(arr[0]);
            for (int element : arr) {
                if (answer.getLast() == element) {
                    continue;
                } else {
                    answer.add(element);
                }
            }

            return answer;
        }
}
