package coding_test.boj.march.mar05;

import java.util.*;
import java.io.*;

/*
* 백준 13305 : 주유소
*
* 알고리즘 : Greedy
 */

public class Greedy_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //도시의 개수
        int citiesCount = Integer.parseInt(br.readLine());
        // 두 도시 사이 거리
        long[] distances = new long[citiesCount - 1];
        // 도시별 리터 당 가격
        long[] prices = new long[citiesCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < citiesCount; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long totalPrice = 0;
        long minPrice = prices[0];

        for (int i = 0; i < distances.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            totalPrice += distances[i] * minPrice;
        }

        System.out.println(totalPrice);

    }
}
