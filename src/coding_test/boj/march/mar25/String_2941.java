package coding_test.boj.march.mar25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_2941 {
    static String[] croatianAlphabetList = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croatiaString = br.readLine();

        for (String croatianAlphabet : croatianAlphabetList) {
            if (croatiaString.contains(croatianAlphabet)) {
                croatiaString = croatiaString.replace(croatianAlphabet, "*");
            }
        }

        System.out.println(croatiaString.length());
    }
}
