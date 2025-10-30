package coding_test.종만북.분할정복;

public class 울타리잘라내기_분할정복 {
    // 각 판자의 높이를 저장하는 배열
     static int[] h;

     public static int solve(int left, int right) {
         // 기저 사례: 판자가 하나밖에 없는 경우
         if (left == right){
             return h[left];
         }
         // [left, mid], [mid+1, right]두 구간으로 문제를 분할
         int mid = (left + right) / 2;
         // 분할한 문제를 각각 해결
         int result = Math.max(solve(left, mid), solve(mid + 1, right));
         // 부분 문제3: 두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾음
         int lo = mid, hi = mid + 1;
         int height = Math.min(h[lo], h[hi]);
         // [mid, mid+1]만 포함하는 너비 2인 사각형을 고려
         result = Math.max(result, height * 2);
         // 사각형이 입력 전체를 덮을 때까지 확장
         while (left < lo || hi < right) {
             // 항상 높이가 더 높은 쪽으로 확장
             if (hi < right && (lo == left || h[lo-1] < h[hi+1])) {
                 hi++;
                 height = Math.min(height, h[hi]);
             } else {
                 lo--;
                 height = Math.min(height, h[lo]);
             }
             result = Math.max(result, height * (hi - lo + 1));
         }
         return result;
     }
}
