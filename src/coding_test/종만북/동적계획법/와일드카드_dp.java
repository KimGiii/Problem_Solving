package coding_test.종만북.동적계획법;

public class 와일드카드_dp {
    private boolean match(String w, String s) {
        // w[pos]와 s[pos]를 맞춰 나간다.
        int pos = 0;
        while(pos < s.length() && pos < w.length() &&
                (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
            pos++;
        }

        // 더 이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
        // 패턴 끝에 도달해서 끝난 경우는 문자열도 끝났어야 대응된다.
        if (pos == w.length()) {
            return pos == s.length();
        }

        // '*'를 만난 경우
        if (w.charAt(pos) == '*') {
            // '*'가 몇 개의 글자에 대응될지 재귀적으로 확인
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (match(w.substring(pos + 1), s.substring(pos + skip))) {
                    return true;
                }
            }
        }

        return false;
    }

    // -1 : 계산되지 않는다, 1 : 해당 입력들이 서로 대응된다, 0 : 해당 입력들이 서로 대응되지 않는다.
    private int[][] cache;
    // 패턴과 문자열
    String W, S;

    // 와일드카드 패턴 W[w...]가 문자열 S[s...]에 대응되는지 여부를 반환한다.
    private boolean matchMemoized(int w, int s) {
        if (cache[w][s] != -1) {
            return cache[w][s] == 1;
        }

        // W[w]와 S[s]를 맞춰 나간다.
        while (s < S.length() && w < W.length() &&
                (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            w++;
            s++;
        }

        // 더 이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
        // 패턴 끝에 도달한 경우에는 문자열도 끝났어야 대응된다.
        if (w == W.length()) {
            cache[w][s] = (s == S.length()) ? 1 : 0;
            return cache[w][s] == 1;
        }

        // *를 만나서 끝난경우에는 *에 몇 글자를 대응해야 할 지 재귀호출하며 확인한다.
        if (W.charAt(w) == '*') {
            for (int skip = 0; s + skip <= S.length(); skip++) {
                if (matchMemoized(w+1, s + skip)) {
                    cache[w][s] = 1;
                    return true;
                }
            }
        }

        // 이 외의 모든 경우에는 false를 반환한다.
        cache[w][s] = 0;
        return false;
    }
}
