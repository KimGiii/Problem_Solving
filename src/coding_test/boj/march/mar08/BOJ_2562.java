package coding_test.boj.march.mar08;

import java.io.*;
import java.util.*;

/*
* 백준 2562 : 최댓값
*
* 알고리즘 : 구현
 */

public class BOJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[9];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 9; i++) {
            int current = Integer.parseInt(br.readLine());
            numbers[i] = current;
            if (current > max) {
                max = current;
                maxIndex = i + 1;
            }
        }

        System.out.println(max);
        System.out.print(maxIndex);
    }
}
