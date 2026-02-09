package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PermutationBitmask {

    private static char[] elements; // 순열을 만들 요소들
    private static List<String> result; // 생성된 모든 순열을 저장할 리스트

    /**
     * @param mask                 현재까지 사용한 요소들의 상태를 나타내는 비트마스크 정수
     *                             i번째 비트가 1이면 i번째 요소를 사용했다는 의미입니다.
     * @param currentPermutation   현재까지 만들어진 순열을 저장하는 문자열 빌더
     */
    private static void generatePermutation(int mask, StringBuilder currentPermutation) {
        // 1. 재귀 종료 조건: 모든 요소를 다 사용했을 경우
        if (currentPermutation.length() == elements.length) {
            result.add(currentPermutation.toString()); // 완성된 순열을 결과 리스트에 추가
            return; // 재귀 호출 종료
        }

        // 2. 재귀 호출: 0부터 N-1까지 모든 요소를 순회
        for (int i = 0; i < elements.length; i++) {
            // 현재 i번째 요소를 아직 사용하지 않았는지 확인
            if ((mask & (1 << i)) == 0) {
                // 2-1. i번째 요소를 사용
                currentPermutation.append(elements[i]);

                // 2-2. 새로운 마스크를 생성하여 i번째 비트를 1로 설정
                int nextMask = mask | (1 << i);

                // 2-3. 다음 단계로 재귀 호출
                generatePermutation(nextMask, currentPermutation);

                // 2-4. 백트래킹(Backtracking): 다음 경우의 수를 위해 마지막에 추가했던 요소를 제거
                currentPermutation.deleteCharAt(currentPermutation.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        elements = new char[]{'1', '2', '3', '4', '5'};
        result = new ArrayList<>();
        int n = elements.length;

        System.out.println(n + "개의 요소로 만들 수 있는 모든 순열:");

        // 초기 호출: 사용한 요소가 없으므로 mask는 0, 현재 순열은 비어있음
        generatePermutation(0, new StringBuilder());

        // 결과 출력
        for (String p : result) {
            System.out.println(p);
        }

        System.out.println(result.size() + "개의 순열이 생성되었습니다.");
    }
}
