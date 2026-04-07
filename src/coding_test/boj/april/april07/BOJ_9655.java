package coding_test.boj.april.april07;

import java.io.*;
import java.util.*;

public class BOJ_9655 {
    static String sk = "SK";
    static String cy = "CY";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            System.out.println(cy);
        } else {
            System.out.println(sk);
        }
    }
}
