package coding_test.boj.march.mar08;

import java.io.*;
import java.util.*;

/*
* 백준 2675 : 문자열 반복
*
* 알고리즘 : Implementation / String
 */

public class Impl_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new  StringBuilder();

            int repeatCount = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (int j =0; j < s.length(); j++) {
                for (int k = 0; k < repeatCount; k++) {
                    sb.append(s.charAt(j));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
