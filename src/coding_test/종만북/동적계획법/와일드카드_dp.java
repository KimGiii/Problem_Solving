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
}
