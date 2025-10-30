package coding_test.종만북.분할정복;

public class 팬미팅_분할정복 {
    public static int hugs(String members, String[] fans) {
        int N = members.length();
        int M = fans.length;
        int[] A = new int[N];
        int[] B = new int[M];

        for (int i = 0; i < N; i++) {
            if (members.charAt(i) == 'M') {
                A[i] = 1;
            } else {
                A[i] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            if (members.charAt(i) == 'M') {
                B[M - i - 1] = 1;
            } else {
                B[i] = 0;
            }
        }

        // karatsuba 알고리즘에서 자리올림은 생략한다.
        int[] C = karatsuba(A, B);
        int result = 0;
        for (int i = N-1; i < M; i++) {
            if (C[i] == 0) {
                result++;
            }
        }
        return result;
    }

    private static int[] karatsuba(int[] a, int[] b) {
        // 카라츠바 알고리즘은 기존 구현되어 생략
        return new int[a.length + b.length];
    }
}
