package coding_test.boj.march.mar06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ptr = 0; // 입력 문자열의 현재 위치 포인터
        int n = 0;   // 1부터 증가시킬 숫자

        while (true) {
            n++;
            String s = String.valueOf(n);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == input.charAt(ptr)) {
                    ptr++;
                    if (ptr == input.length()) {
                        System.out.println(n);
                        return;
                    }
                }
            }
        }
    }
}