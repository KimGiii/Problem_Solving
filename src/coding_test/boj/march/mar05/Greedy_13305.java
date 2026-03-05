package coding_test.boj.march.mar05;

import java.util.*;
import java.io.*;

public class Greedy_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //도시의 개수
        int citiesCount = Integer.parseInt(br.readLine());

        // 두 도시 사이 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distances = new int[citiesCount - 1];
        int totalDistance = 0;
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
            totalDistance += distances[i];
        }

        // 도시별 리터 당 가격
        st = new StringTokenizer(br.readLine());
        int[] prices = new int[citiesCount];
        for (int i = 0; i < citiesCount; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minCost = distances[0] * prices[0];
        for (int i = 1; i < distances.length; i++) {
            minCost += Math.min(distances[i] * prices[i], distances[i] * prices[i-1]);
        }

        System.out.println(minCost);
    }
}
