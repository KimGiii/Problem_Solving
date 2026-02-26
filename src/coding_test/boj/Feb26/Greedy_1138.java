package coding_test.boj.Feb26;

import java.util.Scanner;

public class Greedy_1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 사람의 수 N (1 <= N <= 10)
        int n = sc.nextInt();
        int[] result = new int[n];

        // 키가 1인 사람부터 N인 사람까지 차례대로 입력받음
        for (int i = 1; i <= n; i++) {
            int leftCount = sc.nextInt(); // 왼쪽에 있는 자신보다 키 큰 사람의 수
            
            int count = 0;
            for (int j = 0; j < n; j++) {
                // 아직 자리가 채워지지 않은 곳(result[j] == 0)은 
                // 나중에 들어올(키가 더 큰) 사람들을 위한 공간
                if (result[j] == 0) {
                    if (count == leftCount) {
                        result[j] = i;
                        break;
                    }
                    count++;
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + (i == n - 1 ? "" : " "));
        }
    }
}
