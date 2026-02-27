package coding_test.boj.february.feb28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * 백준 2512 - 예산
 *
 * 알고리즘 : Binary Search (매개 변수 탐색)
 */

public class BinarySearch_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 처리
        int n = parseInt(br.readLine());
        int[] budgets = new int[n];

        long totalRequest = 0;
        int maxBudget = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budgets[i] = parseInt(st.nextToken());
            totalRequest += budgets[i];
            maxBudget = Math.max(maxBudget, budgets[i]);
        }

        int m = parseInt(br.readLine());

        // 2. 예외 처리: 모든 요청을 들어줄 수 있는 경우
        if (totalRequest <= m) {
            System.out.println(maxBudget);
            return;
        }

        // 3. 이분 탐색 (상한액 찾기)
        int answer = calculateOptimalBudget(maxBudget, budgets, m);

        System.out.println(answer);
    }

    private static int calculateOptimalBudget(int maxBudget, int[] budgets, int m) {
        int low = 0;
        int high = maxBudget;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long currentSum = 0;

            // 정해진 상한액(mid)으로 예산 배정 시 총합 계산
            for (int b : budgets) {
                currentSum += Math.min(b, mid);
            }

            if (currentSum <= m) {
                // 예산 총액 이하라면 상한액을 더 높임
                answer = mid;
                low = mid + 1;
            } else {
                // 예산 총액을 초과한다면 상한액을 낮춤
                high = mid - 1;
            }
        }
        return answer;
    }
}
