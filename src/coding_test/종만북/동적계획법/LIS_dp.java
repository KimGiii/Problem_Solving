package coding_test.종만북.동적계획법;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS_dp {
    // 수열 A를 입력받아 LIS의 길이를 반환하는 완전 탐색 함수
    private int lis(int[] A) {
        // 기저 사례: A가 비어있을 때
        if (A == null || A.length == 0) {
            return 0;
        }

        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> B = new ArrayList<Integer>();
            for (int j = i+1; j < A.length; j++) {
                if (A[i] < A[j]) {
                    B.add(A[j]);
                }
            }
            int[] bArray = B.stream().mapToInt(Integer::intValue).toArray();
            ret = Math.max(ret, 1 + lis(bArray));
        }

        return ret;
    }

    private int n;
    private int[] cache = new int[100];
    private int[] S = new int[100];

    private void initCache() {
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache, -1);
        }
    }

    // S[start]에서 시작하는 증가 부분 수열 중 최대 길이를 반환한다.
    private int lis2(int start) {
        int ret = cache[start];
        if (ret != -1) {
            return ret;
        }

        // 항상 S[start]는 있기 때문에 길이는 최소 1이다.
        ret = 1;
        for (int next = start + 1; next < n; next++) {
            if (S[start] < S[next]) {
                ret = Math.max(ret, lis2(next) + 1);
            }
        }

        cache[start] = ret;
        return ret;
    }

    // 전체 시간 복잡도  O(n^2)의 최대 부분 증가 수열을 찾는 알고리즘
    private int lis3(int start) {
        int ret = cache[start+1];
        if (ret != -1) {
            return ret;
        }

        ret = 1;
        for (int next = start + 1; next < n; next++) {
            if (start == -1 || S[start] < S[next]) {
                ret = Math.max(ret, lis3(next) + 1);
            }
        }

        cache[start+1] = ret;
        return ret;
    }

    // 전체 시간 복잡도 O(nlogn)의 최대 부분 증가 수열을 찾는 알고리즘
    private int lis4(int[] S) {
        int n = S.length;
        if (n == 0) return 0;

        int[] C = new int[n];
        int ret = 0;

        for (int x : S) {
            // lower_bound : C에서 x의 첫 삽입 위치
            int pos = Arrays.binarySearch(C, 0, ret, x);
            if (pos < 0) {
                pos = -pos - 1;
            }

            C[pos] = x;
            if (pos == ret) ret++;
        }

        return ret;
    }
}
