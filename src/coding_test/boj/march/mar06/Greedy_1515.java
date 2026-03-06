package coding_test.boj.march.mar06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 백준 1515 : 수 이어 쓰기
*
* 알고리즘 : Greedy
 */

public class Greedy_1515 {
    /*
    * 문제 해결 전략
    * 1부터 숫자를 1씩 증가시키며 입력받은 문자열의 숫자를 지워나가는 시뮬레이션 방식
    * 1부터 N을 하나씩 늘려가며 문자열로 변환
    * 현재 숫자 N의 각 자릿수를 확인하고, 입력받은 문자열에서 다음 찾아야 할 숫자와 일치하면 포인터 이동
    * 입력받은 모든 숫자가 매칭했을 때 N이 가능한 가장 작은 값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ptr = 0; // 입력 문자열의 현재 위치 포인터
        int n = 0;   // 1부터 증가시킬 숫자

        while (true) {
            n++;                                         // 숫자 1씩 증가
            String s = String.valueOf(n);                // 현재 숫자를 문자열로 변환

            for (int i = 0; i < s.length(); i++) {       // 현재 숫자의 각 자릿수 하나씩 확인
                if (s.charAt(i) == input.charAt(ptr)) {  // 현재 자릿수가 찾던 숫자라면
                    ptr++;                               // 다음 목표 숫자로 포인터 옮김
                    if (ptr == input.length()) {         // 모든 숫자를 다 찾았다면
                        System.out.println(n);           // 그때의 n이 정답
                        return;
                    }
                }
            }
        }
    }
}