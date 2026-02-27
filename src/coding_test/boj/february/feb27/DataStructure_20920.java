package coding_test.boj.february.feb27;

import java.io.*;
import java.util.*;

/*
 * 백준 20920 - 영단어 암기는 괴로워
 *
 * 알고리즘 : Data Structure / Sort
 */

public class DataStructure_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCount = Integer.parseInt(st.nextToken());
        int wordLength = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            if (word.length() >= wordLength) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        createWordNote(wordCountMap);

    }

    private static void createWordNote(Map<String, Integer> dictionary) {
        List<String> wordList = new ArrayList<>(dictionary.keySet());
        wordList.sort((w1, w2) -> {
            int frequency1 = dictionary.get(w1);
            int frequency2 = dictionary.get(w2);

            if (frequency1 != frequency2) {
                return frequency2 - frequency1;
            }

            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }

            return w1.compareTo(w2);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
